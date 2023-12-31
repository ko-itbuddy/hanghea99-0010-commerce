package com.hanghea99.commerce.exception

open class BusinessException:RuntimeException {
    var errorCode: ErrorCode

    private set
    constructor(message: String?, errorCode: ErrorCode) : super(message) {
        this.errorCode = errorCode
    }

    constructor(errorCode: ErrorCode) : super(errorCode.message) {
        this.errorCode = errorCode
    }
}