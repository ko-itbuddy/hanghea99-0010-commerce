package com.hanghea99.commerce.api.purchase

import com.hanghea99.commerce.api.common.domain.PostNullResultResponse
import com.hanghea99.commerce.api.purchase.domain.*
import com.hanghea99.commerce.logger
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/purchase")
class PurchaseController(val purchaseService: PurchaseService) {
    private val log = logger()

    /**
     * API명 : PURCHASE_001
     * API용도 : 주문 요청
     * @param PostPurchaseRequest
     * @return PostPurchaseResponse
     */
    @PostMapping("")
    @Throws(Exception::class)
    fun postPurchase(postPurchaseRequest: PostPurchaseRequest) : PostPurchaseResponse {
        return purchaseService.postPurchase(postPurchaseRequest)
    }

    /**
     * API명 : PURCHASE_002
     * API용도 : 주문 수정
     * @param PostPurchaseUpdateRequest
     * @return PostPurchaseUpdateResponse
     */
    @PostMapping("/update")
    @Throws(Exception::class)
    fun postPurchaseUpdate(postPurchaseUpdateRequest: PostPurchaseUpdateRequest) : PostNullResultResponse {
        return purchaseService.postPurchaseUpdate(postPurchaseUpdateRequest)
    }

    /**
     * API명 : PURCHASE_003
     * API용도 : 주문 취소
     * @param PostPurchaseDeleteRequest
     * @return PostPurchaseDeleteResponse
     */
    @PostMapping("/delete")
    @Throws(Exception::class)
    fun postPurchaseDelete(postPurchaseDeleteRequest: PostPurchaseDeleteRequest) : PostNullResultResponse {
        return purchaseService.postPurchaseDelete(postPurchaseDeleteRequest)
    }

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