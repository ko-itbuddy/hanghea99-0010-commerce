package com.hanghea99.commerce.api.purchase

import com.hanghea99.commerce.api.common.ResultCodeMsg
import com.hanghea99.commerce.api.common.comp.impl.PurchaseManager
import com.hanghea99.commerce.api.common.comp.impl.PurchaseReader
import com.hanghea99.commerce.api.purchase.domain.GetPurchaseRequest
import com.hanghea99.commerce.api.purchase.domain.GetPurchaseResponse
import com.hanghea99.commerce.api.store.domain.GetStoreResponse
import com.hanghea99.commerce.logger
import org.springframework.stereotype.Service
import org.springframework.validation.annotation.Validated
import kotlin.jvm.Throws

@Service
@Validated
class PurchaseService(
    var purchaseManager: PurchaseManager,
    var purchaseReader: PurchaseReader
){
    private val log = logger()

    @Throws(Exception::class)
    fun getPurchase(getPurchaseRequest: GetPurchaseRequest): GetPurchaseResponse{


        return GetPurchaseResponse(ResultCodeMsg.SUCCESS)
    }
}