package com.hanghea99.commerce.api.favorite.domain.result

data class GetFavoriteResult (
    val totalCount: Long,
    val favorites:List<FavoriteV>
)