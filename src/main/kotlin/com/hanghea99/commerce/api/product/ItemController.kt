package com.hanghea99.commerce.api.product

import com.hanghea99.commerce.api.common.domain.PostNullResultResponse
import com.hanghea99.commerce.api.product.domain.*
import com.hanghea99.commerce.api.store.domain.*
import com.hanghea99.commerce.logger
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/item")
class ItemController(val itemService: ItemService) {
    private val log = logger()

    @PostMapping("")
    @Throws(Exception::class)
    fun postStore(@RequestBody postItemRequest: PostItemRequest): PostItemResponse {
        return itemService.postItem(postItemRequest)
    }

    @GetMapping("")
    @Throws(Exception::class)
    fun getStore(getItemRequest: GetItemRequest): GetItemResponse {
        return itemService.getItem(getItemRequest)
    }

    @PostMapping("/update")
    @Throws(Exception::class)
    fun postStoreUpdate(@RequestBody postItemUpdateRequest: PostItemUpdateRequest): PostNullResultResponse {
        return itemService.postStoreUpdate(postItemUpdateRequest)
    }

    @PostMapping("/delete")
    @Throws(Exception::class)
    fun postStoreDelete(@RequestBody postItemDeleteRequest: PostItemDeleteRequest): PostNullResultResponse {
        return itemService.postStoreDelete(postItemDeleteRequest)
    }


}