package com.hanghea99.commerce.database.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull

@Entity
@Table(name = "CART")
@TableGenerator(
    name = "CART_SEQ_GENERATOR",
    table = "__SEQ",
    initialValue = 1,
    allocationSize = 50,
)
open class CartEntity {
    constructor(
        cartKey: Long? = null,
        userId: Long? = null,
        userEntity: UserEntity? = null,
        cartItemEntities: MutableSet<CartItemEntity> = mutableSetOf(),
    )

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "CART_SEQ_GENERATOR")
    @NotNull
    @Column(name = "CART_KEY", nullable = false)
    open var cartKey: Long? = null

    @NotNull
    @Column(name = "USER_ID", nullable = false)
    open var userId: Long? = null

    @MapsId("userId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "USER_ID", nullable = false)
    open var userEntity: UserEntity? = null

    @OneToMany(mappedBy = "cartEntity")
    open var cartItemEntities: MutableSet<CartItemEntity> = mutableSetOf()
}