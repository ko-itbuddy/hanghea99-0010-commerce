package com.hanghea99.commerce.api.common.domain.core

abstract class CoreResponse<T> (
    var code: String,
    var msg: String,
    open var result: T
)