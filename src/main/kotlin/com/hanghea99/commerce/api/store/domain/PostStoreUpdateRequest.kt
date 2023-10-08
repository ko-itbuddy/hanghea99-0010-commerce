package com.hanghea99.commerce.api.store.domain

import com.hanghea99.commerce.api.common.domain.core.CoreRequest

data class PostStoreUpdateRequest(
    val updateKeys: List<Long>
): CoreRequest()