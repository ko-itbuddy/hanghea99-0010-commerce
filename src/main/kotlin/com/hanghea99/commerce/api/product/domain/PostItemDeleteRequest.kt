package com.hanghea99.commerce.api.product.domain

import com.hanghea99.commerce.api.common.domain.core.CoreRequest

data class PostItemDeleteRequest(
    val deleteKeys: List<Long>
): CoreRequest()