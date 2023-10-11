package com.hanghea99.commerce.api.purchase

import com.hanghea99.commerce.api.purchase.domain.*
import com.hanghea99.commerce.logger
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/purchase")
class PurchaseController(val purchaseService: PurchaseService) {
    private val log = logger()

    /**
     * API명 : PURCHASE_004
     * API용도 : 주문 전체 조회
     * @param GetPurchaseRequest
     * @return GetPurchaseResponse
     */
    @GetMapping("")
    @Throws(Exception::class)
    fun getPurchase(getPurchaseRequest: GetPurchaseRequest): GetPurchaseResponse{
        return purchaseService.getPurchase(getPurchaseRequest)
    }

    /**
     * API명 : PURCHASE_005
     * API용도 : 주문 상세 조회
     * @param GetPurchaseDetailRequest
     * @return GetPurchaseDetailResponse
     */
//    @GetMapping("/purchase-id")
//    @Throws(Exception::class)
//    fun getPurchaseDetail(getPurchaseDetailRequest: GetPurchaseDetailRequest) : GetPurchaseDetailResponse {
//        return purchaseService.getPurchaseDetail(getPurchaseDetailRequest)
//    }
}