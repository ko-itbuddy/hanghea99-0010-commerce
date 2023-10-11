package com.hanghea99.commerce.api.manager.domain

import com.hanghea99.commerce.api.common.domain.core.CoreRequest
import com.hanghea99.commerce.api.common.domain.seller.SellerVo

data class PostManagerSellerPermitRequest (
    val sellers: List<SellerVo>
): CoreRequest()

