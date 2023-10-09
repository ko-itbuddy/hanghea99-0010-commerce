package com.hanghea99.commerce.database.repository

import com.hanghea99.commerce.database.entity.CartEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface CartRepository : JpaRepository<CartEntity?, Long?>,
    JpaSpecificationExecutor<CartEntity?>