package com.hanghea99.commerce.database.entity

import com.hanghea99.commerce.api.common.domain.item.ItemVo
import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.math.BigDecimal
import java.time.Instant

@Entity
@TableGenerator(
    name = "STORE_ITEM_SEQ_GENERATOR",
    table = "__SEQ",
    initialValue = 1,
    allocationSize = 50,
)
@Table(name = "STORE_ITEM")
open class StoreItemEntity(
    itemKey: Long? = null,
    storeKey: Long? = null,
    itemId: String? = null,
    status: String? = null,
    category1: String? = null,
    category2: String? = null,
    category3: String? = null,
    name: String? = null,
    desc: String? = null,
    productType: String? = null,
    manufacturer: String? = null,
    origin: String? = null,
    brand: String? = null,
    model: String? = null,
    price: BigDecimal? = null,
    createdAt: Instant? = null,
    updatedAt: Instant? = null,
    deletedAt: Instant? = null,
    favoriteItemEntities: MutableSet<FavoriteItemEntity> = mutableSetOf(),
    storeItemOptionEntities: MutableSet<StoreItemOptionEntity> = mutableSetOf(),
) {
    companion object {
        val STATUS_OPEN = "OPEN"
        val STATUS_CLOSE = "CLOSE"
        val STATUS_PREPARING = "PREPARING"
        val STATUS_BLOCK = "BLOCK"
    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "STORE_ITEM_SEQ_GENERATOR")
    @NotNull
    @Column(name = "ITEM_KEY", nullable = false)
    open var itemKey: Long? = itemKey

    @NotNull
    @Column(name = "STORE_KEY", nullable = false)
    open var storeKey: Long? = storeKey

    @Size(max = 30)
    @Column(name = "ITEM_ID", length = 30)
    open var itemId: String? = itemId

    @Size(max = 10)
    @Column(name = "STATUS", length = 10)
    open var status: String? = status


    @Size(max = 20)
    @Column(name = "CATEGORY1", length = 20)
    open var category1: String? = category1


    @Size(max = 20)
    @Column(name = "CATEGORY2", length = 20)
    open var category2: String? = category2


    @Size(max = 20)
    @Column(name = "CATEGORY3", length = 20)
    open var category3: String? = category3


    @Size(max = 255)
    @Column(name = "NAME")
    open var name: String? = name


    @Column(name = "`DESC`")
    open var desc: String? = desc


    @Size(max = 20)
    @Column(name = "PRODUCT_TYPE")
    open var productType: String? = productType

    @Size(max = 50)
    @Column(name = "MANUFACTURER")
    open var manufacturer: String? = manufacturer

    @Size(max = 50)
    @Column(name = "ORIGIN")
    open var origin: String? = origin

    @Size(max = 50)
    @Column(name = "BRAND")
    open var brand: String? = brand

    @Size(max = 255)
    @Column(name = "MODEL")
    open var model: String? = model


    @Column(name = "PRICE")
    open var price: BigDecimal? = price

    @CreationTimestamp
    @Column(name = "CREATED_AT", updatable = false)
    open var createdAt: Instant? = createdAt

    @UpdateTimestamp
    @Column(name = "UPDATED_AT")
    open var updatedAt: Instant? = updatedAt


    @Column(name = "DELETED_AT")
    open var deletedAt: Instant? = deletedAt


    @OneToMany(mappedBy = "storeItemEntity")
    open var favoriteItemEntities: MutableSet<FavoriteItemEntity> = favoriteItemEntities

    @OneToMany(mappedBy = "itemKey")
    open var storeItemOptionEntities: MutableSet<StoreItemOptionEntity> = storeItemOptionEntities

    fun toItemVo(): ItemVo {

        return ItemVo(
            itemId = itemId,
            status = status ?: STATUS_CLOSE,
            category1 = category1,
            category2 = category2,
            category3 = category3,
            name = name,
            description = desc,
            productType = productType,
            manufacturer = manufacturer,
            origin = origin,
            brand = brand,
            model = model,
            price = price,
            itemOptions = this.storeItemOptionEntities.map { storeItemOptionEntity ->
                storeItemOptionEntity.toItemOptionVo()
            },
            modDt = createdAt,
            regDt = updatedAt,
        )
    }
}