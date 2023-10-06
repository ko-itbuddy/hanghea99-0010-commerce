package com.hanghea99.commerce.api.common.comp.impl

import com.hanghea99.commerce.api.common.comp.ReaderComponent
import com.hanghea99.commerce.database.entity.StoreEntity
import com.hanghea99.commerce.database.repository.StoreRepository
import com.querydsl.core.BooleanBuilder
import com.querydsl.core.types.Order
import org.springframework.stereotype.Component
import org.springframework.validation.annotation.Validated

@Component
@Validated
class StoreReader(var storeRepository: StoreRepository) : ReaderComponent<StoreEntity, Long>(
) {
    override fun read(id: Long): StoreEntity {
        TODO("Not yet implemented")
    }

    override fun readAll(ids: List<Long>): List<StoreEntity> {
        TODO("Not yet implemented")
    }

    override fun read(where: BooleanBuilder): StoreEntity {
        TODO("Not yet implemented")
    }

    override fun readAll(
        where: BooleanBuilder,
        offset: Long,
        count: Long,
        order: Order
    ): List<StoreEntity> {
        TODO("Not yet implemented")
    }

}