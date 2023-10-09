package com.hanghea99.commerce.database.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull

@Entity
@TableGenerator(
    name = "FAVORITE_ITEM_SEQ_GENERATOR",
    table = "__SEQ",
    initialValue = 1,
    allocationSize = 50,
)
@Table(name = "FAVORITE_ITEM")
open class FavoriteItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "FAVORITE_ITEM_SEQ_GENERATOR")
    @NotNull
    @Column(name = "FAVORITE_ITEM_KEY", nullable = false)
    open var favoriteItemKey: Long? = null

    @NotNull
    @Column(name = "ITEM_KEY", nullable = false)
    open var itemKey: Long? = null

    @NotNull
    @Column(name = "FAVORITE_KEY", nullable = false)
    open var favoriteKey: Long? = null

    @MapsId("itemKey")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ITEM_KEY", nullable = false, referencedColumnName = "ITEM_KEY")
    open var storeItemEntity: StoreItemEntity? = null

    @MapsId("favoriteKey")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "FAVORITE_KEY", nullable = false, referencedColumnName = "FAVORITE_KEY")
    open var favoriteEntity: FavoriteEntity? = null
}