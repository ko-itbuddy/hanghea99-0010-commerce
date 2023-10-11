package com.hanghea99.commerce.api.product.domain

import com.hanghea99.commerce.api.common.ResultCodeMsg
import com.hanghea99.commerce.api.product.domain.result.GetItemResult

data class GetItemResponse(
    var code: String,
    var msg: String,
    val result: GetItemResult,
) {
    constructor(resultCodeMsg: ResultCodeMsg, result: GetItemResult) : this(
        code = resultCodeMsg.code,
        msg = resultCodeMsg.msg,
        result = result,
    )
}