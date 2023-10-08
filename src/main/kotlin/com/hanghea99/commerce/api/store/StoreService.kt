package com.hanghea99.commerce.api.store

import com.hanghea99.commerce.api.common.ResultCodeMsg
import com.hanghea99.commerce.api.common.comp.impl.StoreManager
import com.hanghea99.commerce.api.common.comp.impl.StoreReader
import com.hanghea99.commerce.api.common.domain.PostNullResultResponse
import com.hanghea99.commerce.api.common.domain.store.StoreVo
import com.hanghea99.commerce.api.store.domain.*
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody
import java.time.Instant

@Service
class StoreService(
    var storeManager: StoreManager,
    var storeReader: StoreReader
) {
    @Throws(Exception::class)
    fun postStore(postStoreRequest: PostStoreRequest):PostStoreResponse{
        return PostStoreResponse(
            resultCodeMsg = ResultCodeMsg.SUCCESS,
            result = StoreVo(
                storeKey = 0,
                status = "G",
                name = "hello",
                description = "hello description",
                shippingAndRefundPolicy = "",
                businessForDistanceSellingNumber = "",
                informationManagerName = "",
                informationManagerEmail = "",
                modDt = Instant.now(),
                regDt = Instant.now(),
            ),
        )
    }

    @Throws(Exception::class)
    fun getStore(getStoreRequest: GetStoreRequest): GetStoreResponse {
        return GetStoreResponse(
            code = ResultCodeMsg.SUCCESS.code,
            msg = ResultCodeMsg.SUCCESS.msg,
            result = GetStoreResult(
                totalCount = 100,
                stores = listOf(
                    StoreVo(
                        storeKey = 0,
                        status = "G",
                        name = "hello",
                        description = "hello description",
                        shippingAndRefundPolicy = "",
                        businessForDistanceSellingNumber = "",
                        informationManagerName = "",
                        informationManagerEmail = "",
                        modDt = Instant.now(),
                        regDt = Instant.now(),
                    ),
                    StoreVo(
                        storeKey = 0,
                        status = "G",
                        name = "hello",
                        description = "hello description",
                        shippingAndRefundPolicy = "",
                        businessForDistanceSellingNumber = "",
                        informationManagerName = "",
                        informationManagerEmail = "",
                        modDt = Instant.now(),
                        regDt = Instant.now(),
                    )
                )
            )
        )
    }

    @Throws(Exception::class)
    fun postStoreUpdate(@RequestBody postStoreUpdateRequest: PostStoreUpdateRequest): PostNullResultResponse {
        return PostNullResultResponse(ResultCodeMsg.SUCCESS)
    }

    @Throws(Exception::class)
    fun postStoreDelete(@RequestBody postStoreDeleteRequest: PostStoreDeleteRequest): PostNullResultResponse {
        return PostNullResultResponse(ResultCodeMsg.SUCCESS)
    }
}