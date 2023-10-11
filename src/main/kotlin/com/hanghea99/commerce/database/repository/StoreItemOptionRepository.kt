package com.hanghea99.commerce.database.repository

import com.hanghea99.commerce.database.entity.StoreItemOptionEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface StoreItemOptionRepository : JpaRepository<StoreItemOptionEntity?, Long?>,
    JpaSpecificationExecutor<StoreItemOptionEntity?>