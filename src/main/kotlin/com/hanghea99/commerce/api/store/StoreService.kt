package com.hanghea99.commerce.api.store

import com.hanghea99.commerce.api.common.comp.impl.StoreManager
import com.hanghea99.commerce.api.common.comp.impl.StoreReader
import com.hanghea99.commerce.api.common.domain.store.StoreVo
import com.hanghea99.commerce.api.store.domain.PostStoreRequest
import com.hanghea99.commerce.api.store.domain.PostStoreResponse
import org.springframework.stereotype.Service

@Service
class StoreService(
    var storeManager: StoreManager,
    var storeReader: StoreReader
) {

    fun postStore(postStoreRequest: PostStoreRequest):PostStoreResponse{

        return PostStoreResponse(
            result = StoreVo(

            )
        )

    }
}