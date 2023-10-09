package com.hanghea99.commerce.api.common.comp

abstract class ManagerComponent<EntityClass, EntityIdClass> {
    abstract fun update(entities: List<EntityClass>): Long
    abstract fun delete(entityIds: List<EntityIdClass>)
    abstract fun create(entities: List<EntityClass>): List<EntityClass>
}