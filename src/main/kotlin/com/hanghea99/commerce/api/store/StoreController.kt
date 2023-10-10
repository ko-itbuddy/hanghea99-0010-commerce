package com.hanghea99.commerce.api.store

import com.hanghea99.commerce.api.common.domain.PostNullResultResponse
import com.hanghea99.commerce.api.store.domain.*
import com.hanghea99.commerce.logger
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/store")
class StoreController(val storeService: StoreService) {
    private val log = logger()

    @PostMapping("")
    @Throws(Exception::class)
    fun postStore(@RequestBody postStoreRequest: PostStoreRequest): PostStoreResponse {
        return storeService.postStore(postStoreRequest)
    }

    @GetMapping("")
    @Throws(Exception::class)
    fun getStore( getStoreRequest: GetStoreRequest): GetStoreResponse {
        return storeService.getStore(getStoreRequest)
    }

    @PostMapping("/update")
    @Throws(Exception::class)
    fun postStoreUpdate(@RequestBody postStoreUpdateRequest: PostStoreUpdateRequest): PostNullResultResponse {
        return storeService.postStoreUpdate(postStoreUpdateRequest)
    }

    @PostMapping("/delete")
    @Throws(Exception::class)
    fun postStoreDelete(@RequestBody postStoreDeleteRequest: PostStoreDeleteRequest): PostNullResultResponse {
        return storeService.postStoreDelete(postStoreDeleteRequest)
    }


}