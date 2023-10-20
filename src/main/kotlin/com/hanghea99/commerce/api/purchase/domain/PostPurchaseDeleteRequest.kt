package com.hanghea99.commerce.api.purchase.domain

import com.hanghea99.commerce.api.common.domain.core.CoreRequest

data class PostPurchaseDeleteRequest (
    val deleteKeys: List<Long>
): CoreRequest()