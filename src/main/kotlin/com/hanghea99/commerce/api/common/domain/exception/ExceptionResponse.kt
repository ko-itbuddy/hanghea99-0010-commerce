package com.hanghea99.commerce.api.common.domain.exception

import com.hanghea99.commerce.api.common.domain.core.CoreResponse


class ExceptionResponse(
    code: String,
    msg: String,
    result: String
) : CoreResponse<String>(code, msg, result) {

}