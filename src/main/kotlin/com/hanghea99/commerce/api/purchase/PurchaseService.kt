package com.hanghea99.commerce.api.purchase

import com.hanghea99.commerce.api.common.ResultCodeMsg
import com.hanghea99.commerce.api.common.comp.impl.PurchaseManager
import com.hanghea99.commerce.api.common.comp.impl.PurchaseReader
import com.hanghea99.commerce.api.common.domain.purchase.PurchaseVo
import com.hanghea99.commerce.api.purchase.domain.*
import com.hanghea99.commerce.database.entity.PurchaseEntity
import com.hanghea99.commerce.logger
import com.querydsl.core.BooleanBuilder
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

    var qPurchaseEntity: QPurchaseEntity = QPurchaseEntity("s1")

    @Throws(Exception::class)
    fun getPurchase(getPurchaseRequest: GetPurchaseRequest): GetPurchaseResponse{
        val booleanBuilder = BooleanBuilder()

        booleanBuilder.and(qPurchaseEntity.deletedAt.isNull)

        val result = purchaseReader.readAll(
            booleanBuilder,
            offset = if (getPurchaseRequest.page > 0) getPurchaseRequest.page * getPurchaseRequest.count else 0,
            count = getPurchaseRequest.count,
            orders = when (getPurchaseRequest.sort) {
                "LATEST" -> mutableListOf(qPurchaseEntity.purchaseDate.desc())
                else -> mutableListOf(qPurchaseEntity.purchaseDate.desc())
            }
        )

        return GetPurchaseResponse(
            code =  ResultCodeMsg.SUCCESS.code,
            msg = ResultCodeMsg.SUCCESS.msg,
            result = GetPurchaseVo(
                totalCount = purchaseReader.readAllCount(booleanBuilder),
                purchases = result.map { purchaseEntity ->
                    PurchaseVo(
                        purchaseKey = purchaseEntity.purchaseKey,
                        userId = purchaseEntity.userId,
                        totalPrice = purchaseEntity.totalPrice,
                        purchaseDate = purchaseEntity.purchaseDate,
                        cancleDate = purchaseEntity.cancleDate,
                        status = purchaseEntity.status,
                    )
                }
            )
        )
    }

    @Throws(Exception::class)
    fun getPurchaseDetail(getPurchaseDetailRequest: GetPurchaseDetailRequest) : GetPurchaseDetailResponse {
        return GetPurchaseDetailResponse(
            code = ResultCodeMsg.SUCCESS,
            msg = ResultCodeMsg.SUCCESS.msg,
            result = null,
            )
        )
    }
}