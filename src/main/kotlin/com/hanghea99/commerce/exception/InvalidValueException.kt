package com.hanghea99.commerce.exception

class InvalidValueException : BusinessException {
    constructor(value: String?) : super(value, ErrorCode.INVALID_INPUT_VALUE)
    constructor(value: String?, errorCode: ErrorCode?) : super(value, errorCode!!)
}