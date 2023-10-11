package com.hanghea99.commerce.api.common.comp.impl

import com.hanghea99.commerce.api.common.comp.ManagerComponent
import com.hanghea99.commerce.database.entity.StoreItemEntity
import com.hanghea99.commerce.database.repository.StoreItemRepository
import org.springframework.stereotype.Component

@Component
class StoreItemManager(var storeItemRepository: StoreItemRepository) :
    ManagerComponent<StoreItemEntity, Long>() {
    override fun update(entities: List<StoreItemEntity>): Long {
        return storeItemRepository.saveAllAndFlush(entities).count().toLong()
    }

    override fun delete(entityIds: List<Long>) {
        storeItemRepository.deleteAllById(entityIds)
    }

    override fun create(entities: List<StoreItemEntity>): List<StoreItemEntity> {
        return storeItemRepository.saveAllAndFlush(entities)
    }

}