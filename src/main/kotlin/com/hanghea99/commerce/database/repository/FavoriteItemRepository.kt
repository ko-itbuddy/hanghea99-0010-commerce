package com.hanghea99.commerce.database.repository

import com.hanghea99.commerce.database.entity.FavoriteItemEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface FavoriteItemRepository : JpaRepository<FavoriteItemEntity?, Long?>,
    JpaSpecificationExecutor<FavoriteItemEntity?>