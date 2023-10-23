package com.hanghea99.commerce.api.common.comp.impl

import com.hanghea99.commerce.api.common.comp.ReaderComponent
import com.hanghea99.commerce.database.entity.FavoriteEntity
import com.hanghea99.commerce.database.repository.FavoriteRepository
import com.querydsl.core.BooleanBuilder
import com.querydsl.core.types.OrderSpecifier
import com.querydsl.jpa.impl.JPAQueryFactory
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class FavoriteReader (
    val favoriteRepository: FavoriteRepository,
    val jpaQueryFactory: JPAQueryFactory,
): ReaderComponent<FavoriteEntity,Long>(){
    private val log = LoggerFactory.getLogger("FavoriteReader")

    override fun read(id: Long): FavoriteEntity {
        TODO("Not yet implemented")
    }

    override fun read(where: BooleanBuilder): FavoriteEntity {
        TODO("Not yet implemented")
    }

    override fun readAllCount(ids: List<Long>): Long {
        TODO("Not yet implemented")
    }

    override fun readAllCount(where: BooleanBuilder): Long {
        TODO("Not yet implemented")
    }

    override fun readAll(ids: List<Long>): List<FavoriteEntity> {
        TODO("Not yet implemented")
    }

    override fun readAll(
        where: BooleanBuilder,
        offset: Long,
        count: Long,
        orders: MutableList<OrderSpecifier<*>>
    ): List<FavoriteEntity> {
        TODO("Not yet implemented")
    }


}