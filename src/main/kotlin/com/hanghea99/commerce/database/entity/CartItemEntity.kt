package com.hanghea99.commerce.database.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull

@Entity
@TableGenerator(
    name = "CART_ITEM_SEQ_GENERATOR",
    table = "__SEQ",
    initialValue = 1,
    allocationSize = 50,
)
@Table(name = "CART_ITEM")
open class CartItemEntity {

    constructor(
        cartProductKey: Long? = null,
        cartKey: Long? = null,
        optionKey: Long? = null,
        cartEntity: CartEntity? = null,
        storeItemOptionEntity: StoreItemOptionEntity? = null,
    )

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "CART_ITEM_SEQ_GENERATOR")
    @NotNull
    @Column(name = "CART_PRODUCT_KEY", nullable = false)
    open var cartProductKey: Long? = null

    @NotNull
    @Column(name = "CART_KEY", nullable = false)
    open var cartKey: Long? = null

    @NotNull
    @Column(name = "OPTION_KEY", nullable = false)
    open var optionKey: Long? = null

    @MapsId("cartKey")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CART_KEY", nullable = false, referencedColumnName = "CART_KEY")
    open var cartEntity: CartEntity? = null

    @MapsId("optionKey")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "OPTION_KEY", nullable = false, referencedColumnName = "OPTION_KEY")
    open var storeItemOptionEntity: StoreItemOptionEntity? = null
}