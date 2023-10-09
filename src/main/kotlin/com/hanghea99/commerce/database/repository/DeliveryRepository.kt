package com.hanghea99.commerce.database.repository

import com.hanghea99.commerce.database.entity.DeliveryEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface DeliveryRepository : JpaRepository<DeliveryEntity?, Long?>,
    JpaSpecificationExecutor<DeliveryEntity?>