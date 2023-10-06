package com.hanghea99.commerce.api.store

import com.hanghea99.commerce.api.store.domain.PostStoreRequest
import com.hanghea99.commerce.api.store.domain.PostStoreResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController("api/store")
class StoreController(var storeService: StoreService) {

    @PostMapping("")
    @ResponseBody
    fun postStore(postStoreRequest: PostStoreRequest): PostStoreResponse {

        return storeService.postStore(postStoreRequest);
    }


}