package com.hanghea99.commerce.api.common.domain

import com.hanghea99.commerce.api.common.domain.core.CoreRequest

open class GetRequest(
    open val types: String?,
    open val values: String?,
    open val page: Long?,
    open val count: Long?,
    open val sort: String?,
):CoreRequest() {
}