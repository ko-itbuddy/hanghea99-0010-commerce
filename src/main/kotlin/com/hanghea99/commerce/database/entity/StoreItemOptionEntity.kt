package com.hanghea99.commerce.database.entity

import com.hanghea99.commerce.api.common.domain.item.ItemOptionVo
import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.math.BigDecimal
import java.time.Instant

@Entity
@TableGenerator(
    name = "STORE_ITEM_OPTION_SEQ_GENERATOR",
    table = "__SEQ",
    initialValue = 1,
    allocationSize = 50,
)
@Table(name = "STORE_ITEM_OPTION")
open class StoreItemOptionEntity(
    optionKey: Long? = null,
    itemKey: Long? = null,
    status: String? = null,
    name: String? = null,
    desc: String? = null,
    price: BigDecimal? = null,
    inventory: Long? = null,
    createdAt: Instant? = null,
    updatedAt: Instant? = null,
    deletedAt: Instant? = null,
    cartItemEntities: MutableSet<CartItemEntity> = mutableSetOf(),
    purchaseItemEntities: MutableSet<PurchaseItemEntity> = mutableSetOf(),
) {

    @Id
    @GeneratedValue(
        strategy = GenerationType.TABLE, generator = "STORE_ITEM_OPTION_SEQ_GENERATOR"
    )
    @NotNull
    @Column(name = "OPTION_KEY", nullable = false)
    open var optionKey: Long? = optionKey

    @NotNull
    @Column(name = "ITEM_KEY", nullable = false)
    open var itemKey: Long? = itemKey


    @Size(max = 10)
    @Column(name = "STATUS", length = 10)
    open var status: String? = status

    @Size(max = 255)
    @Column(name = "NAME")
    open var name: String? = name

    @Column(name = "`DESC`")
    open var desc: String? = desc

    @Column(name = "PRICE", precision = 20, scale = 2)
    open var price: BigDecimal? = price

    @Column(name = "INVENTORY")
    open var inventory: Long? = inventory

    @CreationTimestamp
    @Column(name = "CREATED_AT", updatable = false)
    open var createdAt: Instant? = createdAt

    @UpdateTimestamp
    @Column(name = "UPDATED_AT")
    open var updatedAt: Instant? = updatedAt

    @UpdateTimestamp
    @Column(name = "DELETED_AT")
    open var deletedAt: Instant? = deletedAt

    @OneToMany(mappedBy = "storeItemOptionEntity")
    open var cartItemEntities: MutableSet<CartItemEntity> = cartItemEntities

    @OneToMany(mappedBy = "storeItemoptionEntity")
    open var purchaseItemEntities: MutableSet<PurchaseItemEntity> = purchaseItemEntities

    fun toItemOptionVo(): ItemOptionVo {
        return ItemOptionVo(
            optionKey = optionKey,
            name = name,
            description = desc,
            price = price,
            inventory = inventory,
            regDt = createdAt,
            modDt = updatedAt,
        )
    }
}