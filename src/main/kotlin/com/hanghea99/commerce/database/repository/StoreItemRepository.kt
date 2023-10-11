package com.hanghea99.commerce.database.repository

import com.hanghea99.commerce.database.entity.StoreItemEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface StoreItemRepository : JpaRepository<StoreItemEntity?, Long?>,
    JpaSpecificationExecutor<StoreItemEntity?>