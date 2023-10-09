package com.hanghea99.commerce.database.repository

import com.hanghea99.commerce.database.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface UserRepository : JpaRepository<UserEntity?, Long?>,
    JpaSpecificationExecutor<UserEntity?>