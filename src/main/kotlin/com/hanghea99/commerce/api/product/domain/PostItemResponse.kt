package com.hanghea99.commerce.api.product.domain

import com.hanghea99.commerce.api.common.ResultCodeMsg
import com.hanghea99.commerce.api.common.domain.core.CoreResponse
import com.hanghea99.commerce.api.common.domain.item.ItemVo


data class PostItemResponse(
    var resultCodeMsg: ResultCodeMsg, override var result: ItemVo
) : CoreResponse<ItemVo>(resultCodeMsg.code, resultCodeMsg.msg, result)