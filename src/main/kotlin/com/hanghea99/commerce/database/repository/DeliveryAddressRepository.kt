package com.hanghea99.commerce.database.repository

import com.hanghea99.commerce.database.entity.DeliveryAddressEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface DeliveryAddressRepository : JpaRepository<DeliveryAddressEntity?, Long?>,
    JpaSpecificationExecutor<DeliveryAddressEntity?>