package com.hanghea99.commerce.api.purchase.domain

import com.hanghea99.commerce.api.common.domain.core.CoreRequest
import com.hanghea99.commerce.api.common.domain.purchase.PurchaseVo

data class PostPurchaseUpdateRequest(
    val purchase: PurchaseVo
): CoreRequest()