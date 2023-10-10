package com.hanghea99.commerce.api.common.comp.impl

import com.hanghea99.commerce.api.common.comp.ReaderComponent
import com.hanghea99.commerce.database.entity.PurchaseEntity

import com.hanghea99.commerce.database.repository.PurchaseRepository
import com.querydsl.core.BooleanBuilder
import com.querydsl.core.types.OrderSpecifier
import com.querydsl.jpa.impl.JPAQueryFactory
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class PurchaseReader (
    val purchaseRepository: PurchaseRepository,
    val jpaQueryFactory: JPAQueryFactory,
) : ReaderComponent<PurchaseEntity, Long>(
    ) {
    private val log = LoggerFactory.getLogger("PurchaseReader")

    override fun read(id: Long): PurchaseEntity {
        TODO("Not yet implemented")
    }

    override fun read(where: BooleanBuilder): PurchaseEntity {
        TODO("Not yet implemented")
    }

    override fun readAll(ids: List<Long>): List<PurchaseEntity> {
        TODO("Not yet implemented")
    }

    override fun readAll(
        where: BooleanBuilder,
        offset: Long,
        count: Long,
        orders: MutableList<OrderSpecifier<*>>
    ): List<PurchaseEntity> {
        TODO("Not yet implemented")
    }

    override fun readAllCount(ids: List<Long>): Long {
        TODO("Not yet implemented")
    }

    override fun readAllCount(where: BooleanBuilder): Long {
        TODO("Not yet implemented")
    }
}
