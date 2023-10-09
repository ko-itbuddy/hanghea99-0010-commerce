package com.hanghea99.commerce.database.repository

import com.hanghea99.commerce.database.entity.PurchaseEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface PurchaseRepository : JpaRepository<PurchaseEntity?, Long?>,
    JpaSpecificationExecutor<PurchaseEntity?>