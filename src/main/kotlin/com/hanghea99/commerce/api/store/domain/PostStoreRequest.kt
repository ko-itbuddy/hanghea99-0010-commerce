package com.hanghea99.commerce.api.store.domain

import com.hanghea99.commerce.api.common.domain.HeaderDomain
import com.hanghea99.commerce.api.common.domain.core.CoreRequest
import com.hanghea99.commerce.api.common.domain.store.StoreVo

data class PostStoreRequest(override var header: HeaderDomain, val store: StoreVo):
    CoreRequest(header)