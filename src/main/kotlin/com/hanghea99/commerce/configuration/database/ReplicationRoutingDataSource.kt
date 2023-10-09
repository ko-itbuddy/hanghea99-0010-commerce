package com.hanghea99.commerce.configuration.database

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource
import org.springframework.transaction.support.TransactionSynchronizationManager
import javax.sql.DataSource

class ReplicationRoutingDataSource(masterDataSource: DataSource, slaveDataSource: Any) :
    AbstractRoutingDataSource() {
    override fun determineCurrentLookupKey(): Any? {
        return if (TransactionSynchronizationManager.isCurrentTransactionReadOnly()) DataSourceType.SLAVE else DataSourceType.MASTER
    }

    init {
        val dataSourceMap: MutableMap<Any, Any> = HashMap()
        dataSourceMap[DataSourceType.MASTER] = masterDataSource
        dataSourceMap[DataSourceType.SLAVE] = slaveDataSource
        setTargetDataSources(dataSourceMap)
        setDefaultTargetDataSource(masterDataSource)
    }
}