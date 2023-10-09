package com.hanghea99.commerce.api.common.comp.impl

import com.hanghea99.commerce.api.common.comp.ReaderComponent
import com.hanghea99.commerce.database.entity.QStoreEntity
import com.hanghea99.commerce.database.entity.StoreEntity
import com.hanghea99.commerce.database.repository.StoreRepository
import com.querydsl.core.BooleanBuilder
import com.querydsl.core.types.Order
import com.querydsl.core.types.OrderSpecifier
import com.querydsl.jpa.impl.JPAQueryFactory
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class StoreReader(
    val storeRepository: StoreRepository,
    val jpaQueryFactory: JPAQueryFactory,
) :
    ReaderComponent<StoreEntity, Long>(
    ) {
    private val log = LoggerFactory.getLogger("StoreReader")

    val qStoreEntity: QStoreEntity = QStoreEntity("s1")

    override fun read(id: Long): StoreEntity {
        TODO("Not yet implemented")
    }

    override fun readAll(ids: List<Long>): List<StoreEntity> {
        TODO("Not yet implemented")
    }

    override fun readAllCount(ids: List<Long>): Long {
        TODO("Not yet implemented")
    }

    override fun read(where: BooleanBuilder): StoreEntity {
        TODO("Not yet implemented")
    }

    override fun readAll(
        where: BooleanBuilder,
        offset: Long,
        count: Long,
        orders: MutableList<OrderSpecifier<*>>,
    ): List<StoreEntity> {
        val orders: MutableList<OrderSpecifier<*>> = mutableListOf()
        return jpaQueryFactory.selectFrom(qStoreEntity)
            .where(where)
            .orderBy(*orders.toTypedArray())
            .offset(offset)
            .limit(count)
            .fetch()
    }

    override fun readAllCount(
        where: BooleanBuilder,
    ): Long {
        return jpaQueryFactory.selectFrom(qStoreEntity)
            .where(where)
            .fetchCount()
    }



}