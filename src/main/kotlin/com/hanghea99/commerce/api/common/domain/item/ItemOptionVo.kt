package com.hanghea99.commerce.api.common.domain.item

import com.hanghea99.commerce.database.entity.StoreItemOptionEntity
import java.math.BigDecimal
import java.time.Instant

data class ItemOptionVo(
    var optionKey: Long? = null,
    var status: String? = null,
    var name: String? = null,
    var description: String? = null,
    var price: BigDecimal? = null,
    var inventory: Long? = null,
    var regDt: Instant? = null,
    var modDt: Instant? = null,
) {
    fun toStoreItemOPtionEntity(itemKey: Long?): StoreItemOptionEntity {


        return StoreItemOptionEntity(
            itemKey = itemKey,
            optionKey = optionKey,
            status = status,
            name = name,
            desc = description,
            price = price,
            inventory = inventory,
            createdAt = regDt,
            updatedAt = modDt,
        )
    }
}