package com.hanghea99.commerce.database.repository

import com.hanghea99.commerce.database.entity.PaymentEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface PaymentRepository : JpaRepository<PaymentEntity?, Long?>,
    JpaSpecificationExecutor<PaymentEntity?>