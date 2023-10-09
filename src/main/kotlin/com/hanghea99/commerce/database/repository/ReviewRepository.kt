package com.hanghea99.commerce.database.repository

import com.hanghea99.commerce.database.entity.ReviewEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface ReviewRepository : JpaRepository<ReviewEntity?, Long?>,
    JpaSpecificationExecutor<ReviewEntity?>