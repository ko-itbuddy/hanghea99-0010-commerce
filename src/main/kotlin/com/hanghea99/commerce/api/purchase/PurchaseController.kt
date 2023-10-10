package com.hanghea99.commerce.api.purchase

import com.hanghea99.commerce.api.purchase.domain.GetPurchaseRequest
import com.hanghea99.commerce.api.purchase.domain.GetPurchaseResponse
import com.hanghea99.commerce.logger
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/purchase")
class PurchaseController(val purchaseService: PurchaseService) {
    private val log = logger()

    @GetMapping("")
    @Throws(Exception::class)
    fun getPurchase(getPurchaseRequest: GetPurchaseRequest): GetPurchaseResponse{
        return purchaseService.getPurchase(getPurchaseRequest)
    }


}