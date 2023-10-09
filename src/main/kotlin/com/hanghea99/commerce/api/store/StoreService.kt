package com.hanghea99.commerce.api.store

import com.hanghea99.commerce.api.common.ResultCodeMsg
import com.hanghea99.commerce.api.common.comp.impl.StoreManager
import com.hanghea99.commerce.api.common.comp.impl.StoreReader
import com.hanghea99.commerce.api.common.domain.GetRequest
import com.hanghea99.commerce.api.common.domain.PostNullResultResponse
import com.hanghea99.commerce.api.common.domain.store.StoreVo
import com.hanghea99.commerce.api.store.domain.*
import com.hanghea99.commerce.database.entity.QStoreEntity
import com.hanghea99.commerce.database.entity.StoreEntity
import com.querydsl.core.BooleanBuilder
import com.querydsl.core.types.OrderSpecifier
import org.springframework.stereotype.Service
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.RequestBody
import java.time.Instant

@Service
@Validated
class StoreService(
    var storeManager: StoreManager,
    var storeReader: StoreReader
) {

    var qStoreEntity: QStoreEntity = QStoreEntity("s1")

    @Throws(Exception::class)
    fun postStore(postStoreRequest: PostStoreRequest): PostStoreResponse {

        val tempSellerId = "seller"
        val createEntities: List<StoreEntity> = listOf(
            StoreEntity(
                sellerId = tempSellerId,
                name = postStoreRequest.store.name,
                desc = postStoreRequest.store.description,
                businessForDistanceSellingNumber = postStoreRequest.store.businessForDistanceSellingNumber,
                email = postStoreRequest.store.informationManagerEmail,
                shippingAndRefundPolicy = postStoreRequest.store.shippingAndRefundPolicy,
                status = StoreEntity.STAUS_READEY
            )
        )

        val resultEntity: StoreEntity = storeManager.create(createEntities).first()

        return PostStoreResponse(
            resultCodeMsg = ResultCodeMsg.SUCCESS,
            result = StoreVo(
                storeKey = resultEntity.storeKey,
                status = resultEntity.status ?: StoreEntity.STAUS_CLOSE,
                name = resultEntity.name ?: "",
                description = resultEntity.desc ?: "",
                shippingAndRefundPolicy = resultEntity.shippingAndRefundPolicy ?: "",
                businessForDistanceSellingNumber = resultEntity.businessForDistanceSellingNumber
                    ?: "",
                informationManagerName = resultEntity.informationManagerName ?: "",
                informationManagerEmail = resultEntity.email ?: "",
                modDt = resultEntity.updatedAt ?: Instant.MIN,
                regDt = resultEntity.createdAt ?: Instant.MIN,
            ),
        )
    }

    @Throws(Exception::class)
    fun getStore(getStoreRequest: GetStoreRequest): GetStoreResponse {

        val booleanBuilder = BooleanBuilder()

        val typesValues = GetRequest.getTypesValues(getStoreRequest)



        for ((idx, type) in typesValues.types.withIndex()) {
            when (type) {
                "NAME" -> {
                    booleanBuilder.and(qStoreEntity.name.eq(typesValues.values.get(idx)))
                }
            }
        }


        val offset: Long = getStoreRequest.page
        val count: Long = getStoreRequest.count
        val orders: MutableList<OrderSpecifier<*>> = when (getStoreRequest.sort) {
            "LATEST" -> mutableListOf(qStoreEntity.createdAt.desc())
            "NAME_ASC" -> mutableListOf(qStoreEntity.name.asc())
            "NAME_DESC" -> mutableListOf(qStoreEntity.createdAt.desc())
            else -> mutableListOf(qStoreEntity.createdAt.desc())
        }


        val result = storeReader.readAll(
            booleanBuilder,
            offset,
            count,
            orders
        )


        return GetStoreResponse(
            code = ResultCodeMsg.SUCCESS.code,
            msg = ResultCodeMsg.SUCCESS.msg,
            result = GetStoreResult(
                totalCount = 100,
                stores = result.map { storeEntity ->
                    StoreVo(
                        storeKey = storeEntity.storeKey,
                        status = storeEntity.status ?: StoreEntity.STAUS_CLOSE,
                        name = storeEntity.name ?: "",
                        description = storeEntity.desc ?: "",
                        shippingAndRefundPolicy = storeEntity.shippingAndRefundPolicy ?: "",
                        businessForDistanceSellingNumber = storeEntity.businessForDistanceSellingNumber
                            ?: "",
                        informationManagerName = storeEntity.informationManagerName ?: "",
                        informationManagerEmail = storeEntity.email ?: "",
                        modDt = storeEntity.updatedAt ?: Instant.MIN,
                        regDt = storeEntity.createdAt ?: Instant.MIN,
                    )
                }
            )
        )
    }

    @Throws(Exception::class)
    fun postStoreUpdate(@RequestBody postStoreUpdateRequest: PostStoreUpdateRequest): PostNullResultResponse {
        return PostNullResultResponse(ResultCodeMsg.SUCCESS)
    }

    @Throws(Exception::class)
    fun postStoreDelete(@RequestBody postStoreDeleteRequest: PostStoreDeleteRequest): PostNullResultResponse {
        return PostNullResultResponse(ResultCodeMsg.SUCCESS)
    }
}