package com.hanghea99.commerce.api.common.domain.seller

import java.time.Instant

data class SellerVo(
    var sellerId: String?,
    var status: String?,
    var password: String?,
    var name: String?,
    var ssn: String?,
    var telecomName: String?,
    var phoneNumber: String?,
    var companyName: String?,
    var businessRegestraionNumber: String?,
    var representativeName: String?,
    var representativeTelephoneNumber: String?,
    var faxNumber: String?,
    var businessZipCode: String?,
    var businiessAddress: String?,
    var createdAt: Instant?,
    var updatedAt: Instant?,
    var deletedAt: Instant?,
    var allowedAt: Instant?,
    var blockedAt: Instant?,
)