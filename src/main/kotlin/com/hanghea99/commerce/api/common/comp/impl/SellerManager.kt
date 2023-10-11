package com.hanghea99.commerce.api.common.comp.impl

import com.hanghea99.commerce.api.common.comp.ManagerComponent
import com.hanghea99.commerce.database.entity.SellerEntity
import com.hanghea99.commerce.database.repository.SellerRepository
import org.springframework.stereotype.Component

@Component
class SellerManager(var sellerRepository: SellerRepository) :
    ManagerComponent<SellerEntity, String>() {
    override fun update(entities: List<SellerEntity>): Long {
        return sellerRepository.saveAllAndFlush(entities).count().toLong()
    }

    override fun delete(entityIds: List<String>) {
        sellerRepository.deleteAllById(entityIds)
    }

    override fun create(entities: List<SellerEntity>): List<SellerEntity> {
        return sellerRepository.saveAllAndFlush(entities)
    }

}