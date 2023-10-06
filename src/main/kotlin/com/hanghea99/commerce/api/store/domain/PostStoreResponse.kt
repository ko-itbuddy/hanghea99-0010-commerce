package com.hanghea99.commerce.api.store.domain

import com.hanghea99.commerce.api.common.ResultCodeMsg
import com.hanghea99.commerce.api.common.domain.core.CoreResponse
import com.hanghea99.commerce.api.common.domain.store.StoreVo

data class PostStoreResponse(
    var resultCodeMsg: ResultCodeMsg, override var result: StoreVo
) : CoreResponse<StoreVo>(resultCodeMsg.code, resultCodeMsg.msg, result) {

}