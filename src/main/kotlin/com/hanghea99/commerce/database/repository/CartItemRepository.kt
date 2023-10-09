package com.hanghea99.commerce.database.repository

import com.hanghea99.commerce.database.entity.CartItemEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface CartItemRepository : JpaRepository<CartItemEntity?, Long?>,
    JpaSpecificationExecutor<CartItemEntity?>