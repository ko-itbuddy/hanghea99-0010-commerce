package com.hanghea99.commerce.api.store.domain

import com.hanghea99.commerce.api.common.domain.GetRequest

data class GetStoreRequest(
    override val types: String?,
    override val values: String?,
    override val page: Long?,
    override val count: Long?,
    override val sort: String?,
):GetRequest(types, values, page, count, sort)