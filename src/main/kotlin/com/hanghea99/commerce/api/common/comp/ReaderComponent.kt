package com.hanghea99.commerce.api.common.comp

import com.querydsl.core.BooleanBuilder
import com.querydsl.core.types.Order

abstract class ReaderComponent<EntityClass, EntityIdClass> {
    abstract fun read(id: EntityIdClass): EntityClass
    abstract fun read(where: BooleanBuilder): EntityClass
    abstract fun readAll(ids: List<EntityIdClass>): List<EntityClass>
    abstract fun readAll(where: BooleanBuilder, offset: Long, count: Long, order: Order): List<EntityClass>
}