package com.hanghea99.commerce.api.favorite.domain

import com.hanghea99.commerce.api.common.ResultCodeMsg
import com.hanghea99.commerce.api.favorite.domain.result.GetFavoriteResult

data class GetFavoriteResponse (
    var code: String,
    var msg: String,
    val result: GetFavoriteResult,
){
    constructor(resultCodeMsg: ResultCodeMsg,result: GetFavoriteResult):this(
        code = resultCodeMsg.code,
        msg = resultCodeMsg.msg,
        result = result,
    )
}