package com.hanghea99.commerce.api.store

import com.hanghea99.commerce.api.common.ResultCodeMsg
import com.hanghea99.commerce.api.common.comp.impl.StoreManager
import com.hanghea99.commerce.api.common.comp.impl.StoreReader
import com.hanghea99.commerce.api.common.domain.GetRequest
import com.hanghea99.commerce.api.common.domain.PostNullResultResponse
import com.hanghea99.commerce.api.common.domain.store.StoreVo
import com.hanghea99.commerce.api.store.domain.*
import com.hanghea99.commerce.api.store.domain.result.GetStoreResult
import com.hanghea99.commerce.database.entity.QStoreEntity
import com.hanghea99.commerce.database.entity.StoreEntity
import com.hanghea99.commerce.logger
import com.querydsl.core.BooleanBuilder
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
    private val log = logger()

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
                    booleanBuilder.and(
                        qStoreEntity.name.containsIgnoreCase(
                            typesValues.values.get(
                                idx
                            )
                        )
                    )
                }
            }
        }
        booleanBuilder.and(qStoreEntity.deletedAt.isNull)

        val result = storeReader.readAll(
            booleanBuilder,
            offset = if (getStoreRequest.page > 0) getStoreRequest.page * getStoreRequest.count else 0,
            count = getStoreRequest.count,
            orders = when (getStoreRequest.sort) {
                "LATEST" -> mutableListOf(qStoreEntity.createdAt.desc())
                "NAME_ASC" -> mutableListOf(qStoreEntity.name.asc())
                "NAME_DESC" -> mutableListOf(qStoreEntity.createdAt.desc())
                else -> mutableListOf(qStoreEntity.createdAt.desc())
            }
        )

        return GetStoreResponse(
            code = ResultCodeMsg.SUCCESS.code,
            msg = ResultCodeMsg.SUCCESS.msg,
            result = GetStoreResult(
                totalCount = storeReader.readAllCount(booleanBuilder),
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
        val tempSellerId = "seller"

        storeManager.update(
            listOf(
                StoreEntity(
                    sellerId = tempSellerId,
                    name = postStoreUpdateRequest.store.name,
                    desc = postStoreUpdateRequest.store.description,
                    businessForDistanceSellingNumber = postStoreUpdateRequest.store.businessForDistanceSellingNumber,
                    email = postStoreUpdateRequest.store.informationManagerEmail,
                    shippingAndRefundPolicy = postStoreUpdateRequest.store.shippingAndRefundPolicy,
                    status = StoreEntity.STAUS_READEY
                )
            )
        )

        return PostNullResultResponse(
            ResultCodeMsg.SUCCESS
        )
    }

    @Throws(Exception::class)
    fun postStoreDelete(@RequestBody postStoreDeleteRequest: PostStoreDeleteRequest): PostNullResultResponse {


        // if auth 소유자 혹은, 매니저
        val tempSellerId = "seller"

        storeManager.update(
            postStoreDeleteRequest.deleteKeys.map{deleteKey ->
                StoreEntity(
                    sellerId = tempSellerId,
                    storeKey = deleteKey,
                    deletedAt = Instant.now()
                )
            }
        )

        return PostNullResultResponse(
            ResultCodeMsg.SUCCESS
        )
    }
}