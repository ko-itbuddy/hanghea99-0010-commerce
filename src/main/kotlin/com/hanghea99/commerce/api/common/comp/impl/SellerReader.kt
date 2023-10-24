package com.hanghea99.commerce.api.common.comp.impl

import com.hanghea99.commerce.api.common.comp.ReaderComponent
import com.hanghea99.commerce.database.entity.QSellerEntity
import com.hanghea99.commerce.database.entity.SellerEntity
import com.hanghea99.commerce.database.repository.SellerRepository
import com.querydsl.core.BooleanBuilder
import com.querydsl.core.types.OrderSpecifier
import com.querydsl.jpa.impl.JPAQueryFactory
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class SellerReader(
    val selerRepository: SellerRepository,
    val jpaQueryFactory: JPAQueryFactory,
) :
    ReaderComponent<SellerEntity, Long>(
    ) {
    private val log = LoggerFactory.getLogger("StoreReader")

    val qSellerEntity: QSellerEntity = QSellerEntity("m1")

    override fun read(id: Long): SellerEntity {
        TODO("Not yet implemented")
    }

    override fun readAll(ids: List<Long>): List<SellerEntity> {
        TODO("Not yet implemented")
    }

    override fun readAllCount(ids: List<Long>): Long {
        TODO("Not yet implemented")
    }

    override fun read(where: BooleanBuilder): SellerEntity {
        TODO("Not yet implemented")
    }

    override fun readAll(
        where: BooleanBuilder,
        offset: Long,
        count: Long,
        orders: MutableList<OrderSpecifier<*>>,
    ): List<SellerEntity> {
        val orders: MutableList<OrderSpecifier<*>> = mutableListOf()
        return jpaQueryFactory.selectFrom(qSellerEntity)
            .where(where)
            .orderBy(*orders.toTypedArray())
            .offset(offset)
            .limit(count)
            .fetch()
    }

    override fun readAllCount(
        where: BooleanBuilder,
    ): Long {
        return jpaQueryFactory.selectFrom(qSellerEntity)
            .where(where)
            .fetchCount()
    }

}