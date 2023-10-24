package com.hanghea99.commerce.api.manager.domain

import com.hanghea99.commerce.api.common.domain.core.CoreRequest

data class PostManagerLoginRequest(
    val id: String,
    val password: String
) : CoreRequest()