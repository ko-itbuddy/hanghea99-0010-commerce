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
open class StoreItemOptionEntity {

    @Id
    @GeneratedValue(
        strategy = GenerationType.TABLE,
        generator = "STORE_ITEM_OPTION_SEQ_GENERATOR"
    )
    @NotNull
    @Column(name = "OPTION_KEY", nullable = false)
    open var optionKey: Long? = null

    @NotNull
    @Column(name = "ITEM_KEY", nullable = false)
    open var itemKey: Long? = null


    @Size(max = 255)
    @Column(name = "NAME")
    open var name: String? = null

    @Column(name = "PRICE", precision = 20, scale = 2)
    open var price: BigDecimal? = null

    @Column(name = "INVENTORY")
    open var inventory: Long? = null

    @OneToMany(mappedBy = "storeItemOptionEntity")
    open var cartItemEntities: MutableSet<CartItemEntity> = mutableSetOf()

    @OneToMany(mappedBy = "storeItemoptionEntity")
    open var purchaseItemEntities: MutableSet<PurchaseItemEntity> = mutableSetOf()
}