package com.hanghea99.commerce.api.common.domain.store

import java.time.Instant

data class StoreVo(
    var storeKey: Long? = null,
    var status: String? = null,
    var name: String? = null,
    var description: String? = null,
    var shippingAndRefundPolicy: String? = null,
    var businessForDistanceSellingNumber: String? = null,
    var informationManagerName: String? = null,
    var informationManagerEmail: String? = null,
    var modDt: Instant? = null,
    var regDt: Instant? = null,
)