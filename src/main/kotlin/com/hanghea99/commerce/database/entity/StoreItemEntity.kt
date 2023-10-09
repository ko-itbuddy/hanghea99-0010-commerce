package com.hanghea99.commerce.database.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

@Entity
@TableGenerator(
    name = "STORE_ITEM_SEQ_GENERATOR",
    table = "__SEQ",
    initialValue = 1,
    allocationSize = 50,
)
@Table(name = "STORE_ITEM")
open class StoreItemEntity {

    constructor(
        itemKey: Long? = null,
        storeKey: Long? = null,
        sellerId: String? = null,
        itemId: String? = null,
        name: String? = null,
        desc: String? = null,
        favoriteItemEntities: MutableSet<FavoriteItemEntity> = mutableSetOf(),
        storeItemOptionEntities: MutableSet<StoreItemOptionEntity> = mutableSetOf(),
    )

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "STORE_ITEM_SEQ_GENERATOR")
    @NotNull
    @Column(name = "ITEM_KEY", nullable = false)
    open var itemKey: Long? = null

    @NotNull
    @Column(name = "STORE_KEY", nullable = false)
    open var storeKey: Long? = null

    @Size(max = 20)
    @Column(name = "SELLER_ID", nullable = false, length = 20)
    open var sellerId: String? = null

    @Size(max = 30)
    @Column(name = "ITEM_ID", length = 30)
    open var itemId: String? = null

    @Size(max = 255)
    @Column(name = "NAME")
    open var name: String? = null

    
    @Column(name = "`DESC`")
    open var desc: String? = null


    @OneToMany(mappedBy = "storeItemEntity")
    open var favoriteItemEntities: MutableSet<FavoriteItemEntity> = mutableSetOf()

    @OneToMany(mappedBy = "itemKey")
    open var storeItemOptionEntities: MutableSet<StoreItemOptionEntity> = mutableSetOf()
}