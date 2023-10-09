package com.hanghea99.commerce.database.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.math.BigDecimal

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
    name: String? = null,
    price: BigDecimal? = null,
    inventory: Long? = null,
    cartItemEntities: MutableSet<CartItemEntity> = mutableSetOf(),
    purchaseItemEntities: MutableSet<PurchaseItemEntity> = mutableSetOf(),
) {

    @Id
    @GeneratedValue(
        strategy = GenerationType.TABLE, generator = "STORE_ITEM_OPTION_SEQ_GENERATOR"
    )
    @NotNull
    @Column(name = "OPTION_KEY", nullable = false)
    var optionKey: Long? = optionKey

    @NotNull
    @Column(name = "ITEM_KEY", nullable = false)
    var itemKey: Long? = itemKey


    @Size(max = 255)
    @Column(name = "NAME")
    var name: String? = name

    @Column(name = "PRICE", precision = 20, scale = 2)
    var price: BigDecimal? = price

    @Column(name = "INVENTORY")
    var inventory: Long? = inventory

    @OneToMany(mappedBy = "storeItemOptionEntity")
    var cartItemEntities: MutableSet<CartItemEntity> = cartItemEntities

    @OneToMany(mappedBy = "storeItemoptionEntity")
    var purchaseItemEntities: MutableSet<PurchaseItemEntity> = purchaseItemEntities
}