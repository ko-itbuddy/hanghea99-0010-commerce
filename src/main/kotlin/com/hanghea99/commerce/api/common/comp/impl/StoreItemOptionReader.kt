package com.hanghea99.commerce.api.common.comp.impl

import com.hanghea99.commerce.api.common.comp.ReaderComponent
import com.hanghea99.commerce.database.entity.QStoreItemEntity
import com.hanghea99.commerce.database.entity.StoreItemEntity
import com.hanghea99.commerce.database.repository.StoreItemOptionRepository
import com.querydsl.core.BooleanBuilder
import com.querydsl.core.types.OrderSpecifier
import com.querydsl.jpa.impl.JPAQueryFactory
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class StoreItemOptionReader(
    val storeItemOptionRepository: StoreItemOptionRepository,
    val jpaQueryFactory: JPAQueryFactory,
) :
    ReaderComponent<StoreItemEntity, Long>(
    ) {
    private val log = LoggerFactory.getLogger("StoreReader")

    val qStoreItemEntity: QStoreItemEntity = QStoreItemEntity("s1")

    override fun read(id: Long): StoreItemEntity {
        TODO("Not yet implemented")
    }

    override fun readAll(ids: List<Long>): List<StoreItemEntity> {
        TODO("Not yet implemented")
    }

    override fun readAllCount(ids: List<Long>): Long {
        TODO("Not yet implemented")
    }

    override fun read(where: BooleanBuilder): StoreItemEntity {
        TODO("Not yet implemented")
    }

    override fun readAll(
        where: BooleanBuilder,
        offset: Long,
        count: Long,
        orders: MutableList<OrderSpecifier<*>>,
    ): List<StoreItemEntity> {
        val orders: MutableList<OrderSpecifier<*>> = mutableListOf()
        return jpaQueryFactory.selectFrom(qStoreItemEntity)
            .where(where)
            .orderBy(*orders.toTypedArray())
            .offset(offset)
            .limit(count)
            .fetch()
    }

    override fun readAllCount(
        where: BooleanBuilder,
    ): Long {
        return jpaQueryFactory.selectFrom(qStoreItemEntity)
            .where(where)
            .fetchCount()
    }


}