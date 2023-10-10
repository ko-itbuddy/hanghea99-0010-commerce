package com.hanghea99.commerce.api.common.domain

import com.hanghea99.commerce.api.common.ResultCodeMsg
import com.hanghea99.commerce.api.common.domain.core.CoreResponse

data class TokenResponse(
    override var code: String,
    override var msg: String,
    override var result: TokenVo,
) : CoreResponse<TokenVo>(
    code, msg, result
) {
    constructor(resultCodeMsg: ResultCodeMsg, result: TokenVo) : this(
        code = resultCodeMsg.code,
        msg = resultCodeMsg.msg,
        result = result,
    )
}