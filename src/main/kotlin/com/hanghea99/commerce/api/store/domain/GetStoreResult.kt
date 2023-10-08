package com.hanghea99.commerce.api.store.domain

import com.hanghea99.commerce.api.common.domain.store.StoreVo

data class GetStoreResult(
    val totalCount: Long,
    val stores: List<StoreVo>,
)
