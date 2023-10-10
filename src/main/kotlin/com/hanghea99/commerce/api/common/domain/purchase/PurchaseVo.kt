package com.hanghea99.commerce.api.common.domain.purchase

import java.math.BigDecimal
import java.time.Instant

data class PurchaseVo (
    var purchaseKey: Long? = null,
    var userId: Long? = null,
    var totalPrice: BigDecimal,
    var purchaseDate: Instant,
    var cancleDate: Instant,
    var status: String,
)