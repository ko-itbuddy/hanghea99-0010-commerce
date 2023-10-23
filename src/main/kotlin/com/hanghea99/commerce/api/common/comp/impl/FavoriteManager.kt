package com.hanghea99.commerce.api.common.comp.impl

import com.hanghea99.commerce.api.common.comp.ManagerComponent
import com.hanghea99.commerce.database.entity.FavoriteEntity
import com.hanghea99.commerce.database.repository.FavoriteRepository
import org.springframework.stereotype.Component

@Component
class FavoriteManager(var favoriteRepository: FavoriteRepository) : ManagerComponent<FavoriteEntity, Long>() {
    override fun create(entities: List<FavoriteEntity>): List<FavoriteEntity> {
        TODO("Not yet implemented")
    }

    override fun delete(entityIds: List<Long>) {
        TODO("Not yet implemented")
    }

    override fun update(entities: List<FavoriteEntity>): Long {
        TODO("Not yet implemented")
    }
}