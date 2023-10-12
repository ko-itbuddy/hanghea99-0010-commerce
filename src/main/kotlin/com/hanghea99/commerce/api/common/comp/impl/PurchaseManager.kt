package com.hanghea99.commerce.api.common.comp.impl

import com.hanghea99.commerce.api.common.comp.ManagerComponent
import com.hanghea99.commerce.database.entity.PurchaseEntity
import com.hanghea99.commerce.database.repository.PurchaseRepository
import org.springframework.stereotype.Component

@Component
class PurchaseManager(var purchaseRepository :PurchaseRepository) : ManagerComponent<PurchaseEntity, Long>() {
    override fun update(entities: List<PurchaseEntity>): Long {
        TODO("Not yet implemented")
    }

    fun delete(entityIds: List<PurchaseEntity>) {
        TODO("Not yet implemented")
    }

    override fun create(entities: List<PurchaseEntity>): List<PurchaseEntity> {
        return purchaseRepository.saveAllAndFlush(entities)
    }
}