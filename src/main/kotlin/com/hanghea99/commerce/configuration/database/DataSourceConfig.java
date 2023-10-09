package com.hanghea99.commerce.configuration.database;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.sql.DataSource;
import net.ttddyy.dsproxy.listener.QueryExecutionListener;
import net.ttddyy.dsproxy.listener.logging.DefaultQueryLogEntryCreator;
import net.ttddyy.dsproxy.listener.logging.QueryLogEntryCreator;
import net.ttddyy.dsproxy.listener.logging.SystemOutQueryLoggingListener;
import net.ttddyy.dsproxy.support.ProxyDataSourceBuilder;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.engine.jdbc.internal.FormatStyle;
import org.hibernate.engine.jdbc.internal.Formatter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    basePackages = "com.hanghea99.commerce.database.repository",
    entityManagerFactoryRef = "entityManagerFactory",
    transactionManagerRef = "transactionManager"
)
public class DataSourceConfig {

    Environment env;

    public DataSourceConfig(Environment env) {
        this.env = env;
    }


    @Primary
    @Bean(name = "masterDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.write")
    public DataSource masterDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "slaveDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.read")
    public DataSource slaveDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Profile("prd")
    @Bean(name = "routingDataSource")
    public DataSource prdRoutingDataSource(
        @Qualifier("masterDataSource") DataSource masterDataSource,
        @Qualifier("slaveDataSource") DataSource slaveDataSource) {
        return new ReplicationRoutingDataSource(masterDataSource, slaveDataSource);
    }

    private static class PrettyQueryEntryCreator extends DefaultQueryLogEntryCreator {
        private Formatter formatter = FormatStyle.HIGHLIGHT.getFormatter();

        @Override
        protected String formatQuery(String query) {
            return this.formatter.format(query);
        }
    }

    @Profile("local|dev|stg")
    @Bean(name = "routingDataSource")
    public DataSource otherRoutingDataSource(
        @Qualifier("masterDataSource") DataSource masterDataSource,
        @Qualifier("slaveDataSource") DataSource slaveDataSource) {

        PrettyQueryEntryCreator creator = new PrettyQueryEntryCreator();
        creator.setMultiline(true);
        SystemOutQueryLoggingListener listener = new SystemOutQueryLoggingListener();
        listener.setQueryLogEntryCreator(creator);
        return new ReplicationRoutingDataSource(
            ProxyDataSourceBuilder
                .create(masterDataSource)
                .name("masterDataSource")
                .countQuery()
                .multiline()
                .listener(listener)
                .logSlowQueryToSysOut(1, TimeUnit.MINUTES)
                .build(),
            ProxyDataSourceBuilder
                .create(slaveDataSource)
                .name("slaveDataSource")
                .countQuery()
                .multiline()
                .listener(listener)
                .logSlowQueryToSysOut(1, TimeUnit.MINUTES)
                .build()
        );
    }

    @Bean(name = "dataSource")
    public DataSource dataSource(@Qualifier("routingDataSource") DataSource routingDataSource) {
        return new LazyConnectionDataSourceProxy(routingDataSource);
    }

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean pineSurveyEntityManagerFactory(
        @Qualifier("dataSource") DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setDataSource(dataSource);
        em.setPackagesToScan("com.hanghea99.commerce.database.entity");
        em.setPersistenceUnitName("entityManager");
        String jpaBaseHibernate = "spring.jpa.hibernate";
        String jpaBaseProperties = "spring.jpa.properties.hibernate";
        Map<String, Object> properties = new HashMap<>();
        properties.put(AvailableSettings.HBM2DDL_AUTO,
            env.getProperty(String.join(".", jpaBaseHibernate, "ddl-auto")));
        properties.put(AvailableSettings.DEFAULT_BATCH_FETCH_SIZE,
            env.getProperty(String.join(".", jpaBaseHibernate, "default_batch_fetch_size")));
        properties.put(AvailableSettings.STATEMENT_BATCH_SIZE,
            env.getProperty(String.join(".", jpaBaseProperties, "jdbc.batch_size")));
        properties.put(AvailableSettings.ORDER_INSERTS,
            env.getProperty(String.join(".", jpaBaseProperties, "order_inserts")));
        properties.put(AvailableSettings.ORDER_UPDATES,
            env.getProperty(String.join(".", jpaBaseProperties, "order_updates")));

        em.setJpaPropertyMap(properties);

        return em;
    }

    @Bean(name = "jdbcTemplate")
    public JdbcTemplate jdbcTemplate(@Qualifier("dataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(
        @Qualifier("entityManagerFactory") EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);

        return transactionManager;
    }

}
