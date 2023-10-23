package com.hanghea99.commerce.api.favorite.domain

import com.hanghea99.commerce.api.common.domain.GetRequest

data class GetFavoriteRequest (

    override val types: String?,
    override val values: String?,
    override val page: Long?,
    override val count: Long?,
    override val sort: String?
):GetRequest(types,values,page,count,sort)