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
        TODO("Not yet implemented")
    }

    override fun delete(entityIds: List<Long>): Long {
        TODO("Not yet implemented")
    }

    override fun create(entities: List<StoreEntity>): List<StoreEntity> {
        TODO("Not yet implemented")
    }

}