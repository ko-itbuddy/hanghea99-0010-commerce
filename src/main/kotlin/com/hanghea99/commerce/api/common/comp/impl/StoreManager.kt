package com.hanghea99.commerce.api.common.comp.impl

import com.hanghea99.commerce.api.common.comp.ManagerComponent
import com.hanghea99.commerce.database.entity.StoreEntity
import com.hanghea99.commerce.database.repository.StoreRepository
import org.springframework.stereotype.Component
import org.springframework.validation.annotation.Validated

@Component
@Validated
class StoreManager(var storeRepository: StoreRepository) : ManagerComponent<StoreEntity, Long>() {
    override fun update(entities: List<StoreEntity>): Long {
        return storeRepository.saveAllAndFlush(entities).count().toLong()
    }

    override fun delete(entityIds: List<Long>) {
        storeRepository.deleteAllById(entityIds)
    }

    override fun create(entities: List<StoreEntity>): List<StoreEntity> {
        return storeRepository.saveAllAndFlush(entities)
    }

}