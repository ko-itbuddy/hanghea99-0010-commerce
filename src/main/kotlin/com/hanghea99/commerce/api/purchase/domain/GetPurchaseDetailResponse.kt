package com.hanghea99.commerce.api.purchase.domain

import com.hanghea99.commerce.api.common.ResultCodeMsg

data class GetPurchaseDetailResponse(
    val code: ResultCodeMsg,
    val msg: String,
    val result: String? = null,
){
    constructor(resultCodeMsg: ResultCodeMsg, result: Nothing?? = null):this(
        code = resultCodeMsg.code,
        msg = resultCodeMsg.msg,
        result = result,
    )
}