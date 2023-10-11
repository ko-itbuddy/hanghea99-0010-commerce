package com.hanghea99.commerce.api.store.domain

import com.hanghea99.commerce.api.common.ResultCodeMsg
import com.hanghea99.commerce.api.store.domain.result.GetStoreResult

data class GetStoreResponse (
    var code: String,
    var msg: String,
    val result: GetStoreResult,
){
    constructor(resultCodeMsg: ResultCodeMsg, result: GetStoreResult):this(
        code = resultCodeMsg.code,
        msg = resultCodeMsg.msg,
        result = result,
    )
}