package com.hanghea99.commerce.api.purchase.domain

import com.hanghea99.commerce.api.common.ResultCodeMsg

data class GetPurchaseResponse(
    val code: String,
    val msg: String,
    val result: Object? = null
){
    constructor(resultCodeMsg:ResultCodeMsg):this(
        code = resultCodeMsg.code,
        msg = resultCodeMsg.msg,
        result = null
    )
}