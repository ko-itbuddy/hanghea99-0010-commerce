package com.hanghea99.commerce.api.purchase.domain

import com.hanghea99.commerce.api.common.domain.purchase.PurchaseVo

data class GetPurchaseVo (
    val totalCount: Long,
    val purchases: List<PurchaseVo>,
)