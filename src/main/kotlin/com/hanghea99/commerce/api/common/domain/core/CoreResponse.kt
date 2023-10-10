package com.hanghea99.commerce.api.common.domain.core

import com.hanghea99.commerce.api.common.ResultCodeMsg

abstract class CoreResponse<T> (
    open var code: String,
    open var msg: String,
    open var result: T
){
    constructor(resultCodeMsg: ResultCodeMsg, result: T):this(
        code = resultCodeMsg.code,
        msg = resultCodeMsg.msg,
        result = result
    )
}