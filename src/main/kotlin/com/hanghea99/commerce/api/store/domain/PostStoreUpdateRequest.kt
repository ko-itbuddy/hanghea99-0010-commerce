package com.hanghea99.commerce.api.store.domain

import com.hanghea99.commerce.api.common.domain.core.CoreRequest
import com.hanghea99.commerce.api.common.domain.store.StoreVo

data class PostStoreUpdateRequest(
    val store: StoreVo
): CoreRequest()