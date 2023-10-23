package com.hanghea99.commerce.api.favorite.domain

import com.hanghea99.commerce.api.common.ResultCodeMsg

data class GetFavoriteResponse (
    var code: String,
    var msg: String,
    val result: GetItemResult,
){
    constructor(resultCodeMsg: ResultCodeMsg,result:)
}