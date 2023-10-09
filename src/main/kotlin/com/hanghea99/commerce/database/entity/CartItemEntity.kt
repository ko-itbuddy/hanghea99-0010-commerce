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
open class CartItemEntity(
    cartProductKey: Long? = null,
    cartKey: Long? = null,
    optionKey: Long? = null,
    cartEntity: CartEntity? = null,
    storeItemOptionEntity: StoreItemOptionEntity? = null,
) {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "CART_ITEM_SEQ_GENERATOR")
    @NotNull
    @Column(name = "CART_PRODUCT_KEY", nullable = false)
    var cartProductKey: Long? = cartProductKey

    @NotNull
    @Column(name = "CART_KEY", nullable = false)
    var cartKey: Long? = cartKey

    @NotNull
    @Column(name = "OPTION_KEY", nullable = false)
    var optionKey: Long? = optionKey

    @MapsId("cartKey")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CART_KEY", nullable = false, referencedColumnName = "CART_KEY")
    var cartEntity: CartEntity? = cartEntity

    @MapsId("optionKey")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "OPTION_KEY", nullable = false, referencedColumnName = "OPTION_KEY")
    var storeItemOptionEntity: StoreItemOptionEntity? = storeItemOptionEntity
}