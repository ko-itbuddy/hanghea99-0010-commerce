package com.hanghea99.commerce.api.purchase.domain

import com.hanghea99.commerce.api.common.ResultCodeMsg

data class GetPurchaseDetailResponse(
    val code: String,
    val msg: String,
    val result: GetPurchaseDetailVo,
){
    constructor(resultCodeMsg: ResultCodeMsg, result: GetPurchaseDetailVo):this(
        code = resultCodeMsg.code,
        msg = resultCodeMsg.msg,
        result = result,
    )
}