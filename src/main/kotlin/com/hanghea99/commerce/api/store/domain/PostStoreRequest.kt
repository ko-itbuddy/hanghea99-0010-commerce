package com.hanghea99.commerce.api.store.domain

import com.hanghea99.commerce.api.common.domain.HeaderDomain
import com.hanghea99.commerce.api.common.domain.core.CoreRequest

data class PostStoreRequest(override var header: HeaderDomain): CoreRequest(
    header
)