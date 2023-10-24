package com.hanghea99.commerce.api.common.comp.impl

import com.hanghea99.commerce.api.common.comp.ManagerComponent
import com.hanghea99.commerce.database.entity.ManagerEntity
import com.hanghea99.commerce.database.entity.StoreEntity
import com.hanghea99.commerce.database.repository.ManagerRepository
import com.hanghea99.commerce.database.repository.StoreRepository
import org.springframework.stereotype.Component

@Component
class ManagerManager(var managerRepository: ManagerRepository) : ManagerComponent<ManagerEntity, String>() {
    override fun update(entities: List<ManagerEntity>): Long {
        return managerRepository.saveAllAndFlush(entities).count().toLong()
    }

    override fun delete(entityIds: List<String>) {
        managerRepository.deleteAllById(entityIds)
    }

    override fun create(entities: List<ManagerEntity>): List<ManagerEntity> {
        return managerRepository.saveAllAndFlush(entities)
    }

}