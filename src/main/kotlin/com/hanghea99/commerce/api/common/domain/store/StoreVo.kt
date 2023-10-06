package com.hanghea99.commerce.api.common.domain.store

import java.time.Instant

data class StoreVo(
    var storeKey: Long,
    var status: String,
    var name: String,
    var description: String,
    var shippingAndRefundPolicy: String,
    var businessForDistanceSellingNumber: String,
    var informationManagerName: String,
    var informationManagerEmail: String,
    var modDt: Instant,
    var regDt: Instant,
)