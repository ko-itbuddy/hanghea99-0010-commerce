package com.hanghea99.commerce.api.purchase.domain

import com.hanghea99.commerce.api.common.ResultCodeMsg
import com.hanghea99.commerce.api.common.domain.core.CoreResponse
import com.hanghea99.commerce.api.common.domain.purchase.PurchaseVo

data class PostPurchaseResponse (
    var resultCodeMsg: ResultCodeMsg, override var result: PurchaseVo
) : CoreResponse<PurchaseVo>(resultCodeMsg.code, resultCodeMsg.msg, result) {

}
