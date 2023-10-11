package com.hanghea99.commerce.database.repository

import com.hanghea99.commerce.database.entity.PurchaseItemEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface PurchaseItemRepository : JpaRepository<PurchaseItemEntity?, Long?>,
    JpaSpecificationExecutor<PurchaseItemEntity?>