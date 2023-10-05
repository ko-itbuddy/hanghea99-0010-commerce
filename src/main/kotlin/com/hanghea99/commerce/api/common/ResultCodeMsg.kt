package com.hanghea99.commerce.api.common

enum class ResultCodeMsg(
    val code: String,
    var msg: String
) {
    SUCCESS(
        code = "2000000",
        msg = "성공"
    ),
    NOT_FOUND(
        code = "4040000",
        msg = "API 미존재"
    ),
    BAD_REQUEST(
        code = "5000000",
        msg = "잘못된 요청"
    ),
}