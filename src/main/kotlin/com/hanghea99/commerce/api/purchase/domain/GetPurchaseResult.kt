package com.hanghea99.commerce.api.purchase.domain

import com.hanghea99.commerce.api.common.domain.store.StoreVo

data class GetPurchaseResult(
    val totalCount: Long,
    val stores: List<StoreVo>,
)