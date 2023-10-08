package com.hanghea99.commerce.api.store

import com.hanghea99.commerce.api.common.ResultCodeMsg
import com.hanghea99.commerce.api.common.domain.store.StoreVo
import com.hanghea99.commerce.api.store.domain.*
import org.springframework.web.bind.annotation.*
import java.time.Instant

@RestController
@RequestMapping("/api/store")
class StoreController(val storeService: StoreService) {

    @PostMapping("")
    @Throws(Exception::class)
    fun postStore(@RequestBody postStoreRequest: PostStoreRequest): PostStoreResponse {
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

    @GetMapping("")
    @Throws(Exception::class)
    fun getStore( getStoreRequest: GetStoreRequest): GetStoreResponse {
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


}