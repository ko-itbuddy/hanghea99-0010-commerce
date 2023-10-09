package com.hanghea99.commerce.configuration.database

import jakarta.persistence.EntityManagerFactory
import net.ttddyy.dsproxy.listener.logging.DefaultQueryLogEntryCreator
import net.ttddyy.dsproxy.listener.logging.SLF4JQueryLoggingListener
import net.ttddyy.dsproxy.listener.logging.SystemOutQueryLoggingListener
import net.ttddyy.dsproxy.support.ProxyDataSourceBuilder
import org.hibernate.cfg.AvailableSettings
import org.hibernate.engine.jdbc.internal.FormatStyle
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.context.annotation.Profile
import org.springframework.core.env.Environment
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import java.util.concurrent.TimeUnit
import javax.sql.DataSource

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    basePackages = ["com.hanghea99.commerce.database.repository"],
    entityManagerFactoryRef = "entityManagerFactory",
    transactionManagerRef = "transactionManager"
)
class DataSourceConfig(var env: Environment) {

    @Primary
    @Bean(name = ["masterDataSource"])
    @ConfigurationProperties(prefix = "spring.datasource.write")
    fun masterDataSource(): DataSource {
        return DataSourceBuilder.create().build()
    }

    @Bean(name = ["slaveDataSource"])
    @ConfigurationProperties(prefix = "spring.datasource.read")
    fun slaveDataSource(): DataSource {
        return DataSourceBuilder.create().build()
    }

    @Profile("prod")
    @Bean(name = ["routingDataSource"])
    fun prdRoutingDataSource(
        @Qualifier("masterDataSource") masterDataSource: DataSource?,
        @Qualifier("slaveDataSource") slaveDataSource: DataSource?
    ): DataSource {
        return ReplicationRoutingDataSource(masterDataSource!!, slaveDataSource!!)
    }

    private class PrettyQueryEntryCreator : DefaultQueryLogEntryCreator() {
        private val formatter = FormatStyle.HIGHLIGHT.formatter
        override fun formatQuery(query: String): String {
            return formatter.format(query)
        }
    }

    @Profile("dev|default")
    @Bean(name = ["routingDataSource"])
    fun otherRoutingDataSource(
        @Qualifier("masterDataSource") masterDataSource: DataSource?,
        @Qualifier("slaveDataSource") slaveDataSource: DataSource?
    ): DataSource {
        val creator = PrettyQueryEntryCreator()
        creator.isMultiline = true
        val listener = SystemOutQueryLoggingListener()
        listener.queryLogEntryCreator = creator
        return ReplicationRoutingDataSource(
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
        )
    }

    @Bean(name = ["dataSource"])
    fun dataSource(@Qualifier("routingDataSource") routingDataSource: DataSource?): DataSource {
        return LazyConnectionDataSourceProxy(routingDataSource!!)
    }

    @Bean(name = ["entityManagerFactory"])
    fun entityManagerFactory(
        @Qualifier("dataSource") dataSource: DataSource?
    ): LocalContainerEntityManagerFactoryBean {
        val em = LocalContainerEntityManagerFactoryBean()
        em.jpaVendorAdapter = HibernateJpaVendorAdapter()
        em.dataSource = dataSource!!
        em.setPackagesToScan("com.hanghea99.commerce.database.entity")
        em.persistenceUnitName = "entityManager"
        val jpaBaseHibernate = "spring.jpa.hibernate"
        val jpaBaseProperties = "spring.jpa.properties.hibernate"
        val properties: MutableMap<String, Any?> = HashMap()
        properties[AvailableSettings.HBM2DDL_AUTO] =
            env.getProperty(java.lang.String.join(".", jpaBaseHibernate, "ddl-auto"))
        properties[AvailableSettings.DEFAULT_BATCH_FETCH_SIZE] = env.getProperty(
            java.lang.String.join(
                ".",
                jpaBaseHibernate,
                "default_batch_fetch_size"
            )
        )
        properties[AvailableSettings.STATEMENT_BATCH_SIZE] =
            env.getProperty(java.lang.String.join(".", jpaBaseProperties, "jdbc.batch_size"))
        properties[AvailableSettings.ORDER_INSERTS] =
            env.getProperty(java.lang.String.join(".", jpaBaseProperties, "order_inserts"))
        properties[AvailableSettings.ORDER_UPDATES] =
            env.getProperty(java.lang.String.join(".", jpaBaseProperties, "order_updates"))
        em.setJpaPropertyMap(properties)
        return em
    }

    @Bean(name = ["jdbcTemplate"])
    fun jdbcTemplate(@Qualifier("dataSource") dataSource: DataSource?): JdbcTemplate {
        return JdbcTemplate(dataSource!!)
    }

    @Bean(name = ["transactionManager"])
    fun transactionManager(
        @Qualifier("entityManagerFactory") emf: EntityManagerFactory?
    ): PlatformTransactionManager {
        val transactionManager = JpaTransactionManager()
        transactionManager.entityManagerFactory = emf
        return transactionManager
    }
}