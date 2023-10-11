package com.hanghea99.commerce.api.common.domain.item

import com.hanghea99.commerce.database.entity.StoreItemEntity
import java.math.BigDecimal
import java.time.Instant

data class ItemVo(
    var itemId: String? = null,
    var status: String? = null,
    var category1: String?? = null,
    var category2: String? = null,
    var category3: String? = null,
    var name: String? = null,
    var description: String? = null,
    var productType: String? = null,
    var manufacturer: String? = null,
    var origin: String? = null,
    var brand: String? = null,
    var model: String? = null,
    var price: BigDecimal? = null,
    var itemOptions: List<ItemOptionVo> = listOf(),
    var modDt: Instant? = null,
    var regDt: Instant? = null,
) {
    fun toStoreItemEntity(itemKey: Long?): StoreItemEntity {

        return StoreItemEntity(
            itemId = itemId,
            status = status,
            category1 = category1,
            category2 = category2,
            category3 = category3,
            name = name,
            desc = description,
            productType = productType,
            manufacturer = manufacturer,
            origin = origin,
            brand = brand,
            model = model,
            price = price,
            storeItemOptionEntities = this.itemOptions.map { itemOptions ->
                itemOptions.toStoreItemOPtionEntity(itemKey)
            }.toMutableSet(),
            createdAt = modDt,
            updatedAt = regDt,
        )
    }
}