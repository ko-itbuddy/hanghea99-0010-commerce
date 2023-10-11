package com.hanghea99.commerce.api.product

import com.hanghea99.commerce.api.common.ResultCodeMsg
import com.hanghea99.commerce.api.common.comp.impl.StoreItemManager
import com.hanghea99.commerce.api.common.comp.impl.StoreItemOptionManager
import com.hanghea99.commerce.api.common.comp.impl.StoreItemOptionReader
import com.hanghea99.commerce.api.common.comp.impl.StoreItemReader
import com.hanghea99.commerce.api.common.domain.GetRequest
import com.hanghea99.commerce.api.common.domain.PostNullResultResponse
import com.hanghea99.commerce.api.product.domain.*
import com.hanghea99.commerce.api.product.domain.result.GetItemResult
import com.hanghea99.commerce.api.store.domain.*
import com.hanghea99.commerce.database.entity.QStoreItemEntity
import com.hanghea99.commerce.database.entity.StoreItemEntity
import com.hanghea99.commerce.logger
import com.querydsl.core.BooleanBuilder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.RequestBody
import java.time.Instant

@Service
@Validated
class ItemService(
    var storeItemManager: StoreItemManager,
    var storeItemReader: StoreItemReader,
    var storeItemOptionManager: StoreItemOptionManager,
    var storeItemOptionReader: StoreItemOptionReader,
) {
    private val log = logger()

    var qStoreItemEntity: QStoreItemEntity = QStoreItemEntity("si1")

    @Throws(Exception::class)
    fun postItem(postItemRequest: PostItemRequest): PostItemResponse {

        val tempSellerId = "seller"

        val createEntities: List<StoreItemEntity> = listOf(
            postItemRequest.item.toStoreItemEntity(null)
        )

        val resultEntity: StoreItemEntity = storeItemManager.create(createEntities).first()

        return PostItemResponse(
            resultCodeMsg = ResultCodeMsg.SUCCESS,
            result = resultEntity.toItemVo(),
        )
    }

    @Throws(Exception::class)
    fun getItem(getItemRequest: GetItemRequest): GetItemResponse {

        val booleanBuilder = BooleanBuilder()
        val typesValues = GetRequest.getTypesValues(getItemRequest)

        for ((idx, type) in typesValues.types.withIndex()) {
            when (type) {
                "NAME" -> {
                    booleanBuilder.and(
                        qStoreItemEntity.name.containsIgnoreCase(
                            typesValues.values.get(
                                idx
                            )
                        )
                    )
                }
            }
        }
        booleanBuilder.and(qStoreItemEntity.deletedAt.isNull)

        val result = storeItemReader.readAll(
            booleanBuilder,
            offset = if (getItemRequest.page > 0) getItemRequest.page * getItemRequest.count else 0,
            count = getItemRequest.count,
            orders = when (getItemRequest.sort) {
                "LATEST" -> mutableListOf(qStoreItemEntity.createdAt.desc())
                "NAME_ASC" -> mutableListOf(qStoreItemEntity.name.asc())
                "NAME_DESC" -> mutableListOf(qStoreItemEntity.createdAt.desc())
                else -> mutableListOf(qStoreItemEntity.createdAt.desc())
            }
        )



        return GetItemResponse(
            resultCodeMsg = ResultCodeMsg.SUCCESS,
            result = GetItemResult(
                totalCount = storeItemReader.readAllCount(booleanBuilder),
                stores = result.map { storeItemEntity ->
                    storeItemEntity.toItemVo()
                }
            )
        )
    }

    @Throws(Exception::class)
    fun postStoreUpdate(@RequestBody postItemUpdateRequest: PostItemUpdateRequest): PostNullResultResponse {

        val latestStoreItemEntity: StoreItemEntity = storeItemReader.jpaQueryFactory.selectFrom(qStoreItemEntity)
            .where(qStoreItemEntity.itemId.eq(postItemUpdateRequest.item.itemId))
            .orderBy(qStoreItemEntity.createdAt.desc())
            .fetchFirst()

        latestStoreItemEntity.itemKey = null

        storeItemManager.update(
            listOf(
                latestStoreItemEntity
            )
        )

        storeItemOptionManager

        return PostNullResultResponse(
            ResultCodeMsg.SUCCESS
        )
    }

    @Throws(Exception::class)
    @Transactional
    fun postStoreDelete(@RequestBody postItemDeleteRequest: PostItemDeleteRequest): PostNullResultResponse {

        val toDeleteStoreItemEntity: List<StoreItemEntity> =
            storeItemReader.readAll(postItemDeleteRequest.deleteKeys)

        for (storeItemEntity in toDeleteStoreItemEntity) {
            storeItemEntity.deletedAt = Instant.now()
            for (storeItemOptionEntity in storeItemEntity.storeItemOptionEntities) {
                storeItemOptionEntity.deletedAt = Instant.now()
            }
            storeItemOptionManager.update(storeItemEntity.storeItemOptionEntities.toList())
        }

        storeItemManager.update(toDeleteStoreItemEntity)


        return PostNullResultResponse(
            ResultCodeMsg.SUCCESS
        )
    }
}