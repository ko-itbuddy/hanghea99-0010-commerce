package com.hanghea99.commerce.api.common.domain.core

import com.hanghea99.commerce.api.common.ResultCodeMsg

abstract class CoreResponse<T> (
    var code: String,
    var msg: String,
    open var result: T
){
    constructor(resultCodeMsg: ResultCodeMsg, result: T):this(
        code = resultCodeMsg.code,
        msg = resultCodeMsg.msg,
        result = result
    )
}