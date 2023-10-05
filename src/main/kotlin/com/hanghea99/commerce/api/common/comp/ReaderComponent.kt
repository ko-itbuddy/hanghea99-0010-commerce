package com.hanghea99.commerce.api.common.comp

abstract class ReaderComponent<EntityClass, EntityIdClass> {
    abstract fun read(id: EntityIdClass): EntityClass
    abstract fun readAll(ids: List<EntityIdClass>): EntityClass
}