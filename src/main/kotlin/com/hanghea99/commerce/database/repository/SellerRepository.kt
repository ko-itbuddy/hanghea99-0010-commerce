package com.hanghea99.commerce.database.repository

import com.hanghea99.commerce.database.entity.SellerEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface SellerRepository : JpaRepository<SellerEntity?, String?>,
    JpaSpecificationExecutor<SellerEntity?>