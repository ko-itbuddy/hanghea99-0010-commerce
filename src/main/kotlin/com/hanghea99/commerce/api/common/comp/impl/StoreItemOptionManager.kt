package com.hanghea99.commerce.api.common.comp.impl

import com.hanghea99.commerce.api.common.comp.ManagerComponent
import com.hanghea99.commerce.database.entity.StoreItemOptionEntity
import com.hanghea99.commerce.database.repository.StoreItemOptionRepository
import org.springframework.stereotype.Component

@Component
class StoreItemOptionManager(var storeItemOptionRepository: StoreItemOptionRepository) :
    ManagerComponent<StoreItemOptionEntity, Long>() {
    override fun update(entities: List<StoreItemOptionEntity>): Long {
        return storeItemOptionRepository.saveAllAndFlush(entities).count().toLong()
    }

    override fun delete(entityIds: List<Long>) {
        storeItemOptionRepository.deleteAllById(entityIds)
    }

    override fun create(entities: List<StoreItemOptionEntity>): List<StoreItemOptionEntity> {
        return storeItemOptionRepository.saveAllAndFlush(entities)
    }

}