package com.hanghea99.commerce.api.common.comp.impl

import com.hanghea99.commerce.api.common.comp.ReaderComponent
import com.hanghea99.commerce.database.entity.ManagerEntity
import com.hanghea99.commerce.database.repository.ManagerRepository
import com.querydsl.core.BooleanBuilder
import com.querydsl.core.types.OrderSpecifier
import com.querydsl.jpa.impl.JPAQueryFactory
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class ManagerReader(
    val managerRepository: ManagerRepository,
    val jpaQueryFactory: JPAQueryFactory,
) :
    ReaderComponent<ManagerEntity?, String>(
    ) {
    private val log = LoggerFactory.getLogger("StoreReader")

    val qManagerEntity: QManagerEntity = QManagerEntity("m1")

    override fun read(id: String): ManagerEntity {
        TODO("Not yet implemented")
    }

    override fun readAll(ids: List<String>): List<ManagerEntity> {
        TODO("Not yet implemented")
    }

    override fun readAllCount(ids: List<String>): Long {
        TODO("Not yet implemented")
    }

    override fun read(where: BooleanBuilder): ManagerEntity? {
        val orders: MutableList<OrderSpecifier<*>> = mutableListOf()
        return jpaQueryFactory.selectFrom(qManagerEntity)
            .where(where)
            .fetchFirst()
    }

    override fun readAll(
        where: BooleanBuilder,
        offset: Long,
        count: Long,
        orders: MutableList<OrderSpecifier<*>>,
    ): List<ManagerEntity> {
        val orders: MutableList<OrderSpecifier<*>> = mutableListOf()
        return jpaQueryFactory.selectFrom(qManagerEntity)
            .where(where)
            .orderBy(*orders.toTypedArray())
            .offset(offset)
            .limit(count)
            .fetch()
    }

    override fun readAllCount(
        where: BooleanBuilder,
    ): Long {
        return jpaQueryFactory.selectFrom(qManagerEntity)
            .where(where)
            .fetchCount()
    }

}