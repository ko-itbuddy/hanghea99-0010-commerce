package com.hanghea99.commerce.api.store

import com.hanghea99.commerce.api.common.ResultCodeMsg
import com.hanghea99.commerce.api.common.domain.store.StoreVo
import com.hanghea99.commerce.api.store.domain.PostStoreRequest
import com.hanghea99.commerce.api.store.domain.PostStoreResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import java.time.Instant

@RestController
@RequestMapping("/api/store")
class StoreController(val storeService: StoreService) {

    @PostMapping("")
    @Throws(Exception::class)
    fun postStore(@RequestBody postStoreRequest: PostStoreRequest): PostStoreResponse {
        println("====================")

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
    fun getStore(): String {
        return "hello"
    }


}