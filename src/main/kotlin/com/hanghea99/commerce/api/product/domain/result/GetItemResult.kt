package com.hanghea99.commerce.api.product.domain.result

import com.hanghea99.commerce.api.common.domain.item.ItemVo

data class GetItemResult(
    val totalCount: Long,
    val stores: List<ItemVo>,
)
