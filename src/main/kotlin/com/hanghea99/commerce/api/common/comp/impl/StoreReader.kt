package com.hanghea99.commerce.api.common.comp.impl

import com.hanghea99.commerce.api.common.comp.ReaderComponent
import com.hanghea99.commerce.database.entity.QStoreEntity
import com.hanghea99.commerce.database.entity.StoreEntity
import com.hanghea99.commerce.database.repository.StoreRepository
import com.querydsl.core.BooleanBuilder
import com.querydsl.core.types.Order
import com.querydsl.core.types.OrderSpecifier
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Component

@Component
class StoreReader(
    val storeRepository: StoreRepository,
    val jpaQueryFactory: JPAQueryFactory,
) :
    ReaderComponent<StoreEntity, Long>(
    ) {
    val qStoreEntity: QStoreEntity = QStoreEntity("s1")

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
        orders: MutableList<OrderSpecifier<*>>
    ): List<StoreEntity> {
        val orders: MutableList<OrderSpecifier<*>> = mutableListOf()
        return jpaQueryFactory.selectFrom(qStoreEntity)
            .where(where)
            .orderBy(*orders.toTypedArray())
            .offset(offset)
            .limit(count)
            .fetch()
    }

}