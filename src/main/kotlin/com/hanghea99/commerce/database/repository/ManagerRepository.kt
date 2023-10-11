package com.hanghea99.commerce.database.repository

import com.hanghea99.commerce.database.entity.ManagerEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface ManagerRepository : JpaRepository<ManagerEntity?, String?>,
    JpaSpecificationExecutor<ManagerEntity?>