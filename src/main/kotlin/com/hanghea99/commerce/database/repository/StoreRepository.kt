package com.hanghea99.commerce.database.repository

import com.hanghea99.commerce.database.entity.StoreEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface StoreRepository : JpaRepository<StoreEntity?, Long?>,
    JpaSpecificationExecutor<StoreEntity?>