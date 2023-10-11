package com.hanghea99.commerce.api.product.domain

import com.hanghea99.commerce.api.common.domain.core.CoreRequest
import com.hanghea99.commerce.api.common.domain.item.ItemVo

data class PostItemUpdateRequest(
    val storeKey: Long,
    val status: String,
    val item: ItemVo,
) :
    CoreRequest()