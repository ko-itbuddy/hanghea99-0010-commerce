package com.hanghea99.commerce.api.store.save.pojo

import com.hanghea99.commerce.api.common.ResultCodeMsg
import com.hanghea99.commerce.api.common.domain.core.CoreResponse
import com.hanghea99.commerce.api.common.domain.store.StoreDomain

data class PostStoreResponse(
    var resultCodeMsg: ResultCodeMsg, override var result: StoreDomain
) : CoreResponse<StoreDomain>(resultCodeMsg.code, resultCodeMsg.msg, result) {

}