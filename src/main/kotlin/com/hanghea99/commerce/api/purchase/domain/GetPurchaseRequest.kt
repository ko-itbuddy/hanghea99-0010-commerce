package com.hanghea99.commerce.api.purchase.domain

import com.hanghea99.commerce.api.common.domain.GetRequest
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Positive
import jakarta.validation.constraints.PositiveOrZero


data class GetPurchaseRequest (
    @Pattern(regexp = "NAME|^$")
    override val types: String?,

    override val values: String?,

    @Positive
    override val page: Long = 1,

    @PositiveOrZero
    override val count: Long = 10,

    @Pattern(regexp = "LATEST|NAME_ASC|NAME_DESC^$")
    override val sort: String = "LATEST",

):GetRequest(types, values, page, count, sort)