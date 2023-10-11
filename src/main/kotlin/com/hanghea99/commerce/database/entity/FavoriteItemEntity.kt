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
open class FavoriteItemEntity(
    favoriteItemKey: Long? = null,
    itemKey: Long? = null,
    favoriteKey: Long? = null,
    storeItemEntity: StoreItemEntity? = null,
    favoriteEntity: FavoriteEntity? = null,
) {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "FAVORITE_ITEM_SEQ_GENERATOR")
    @NotNull
    @Column(name = "FAVORITE_ITEM_KEY", nullable = false)
    open var favoriteItemKey: Long? = favoriteItemKey

    @NotNull
    @Column(name = "ITEM_KEY", nullable = false)
    open var itemKey: Long? = itemKey

    @NotNull
    @Column(name = "FAVORITE_KEY", nullable = false)
    open var favoriteKey: Long? = favoriteKey

    @MapsId("itemKey")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ITEM_KEY", nullable = false, referencedColumnName = "ITEM_KEY", foreignKey = ForeignKey(ConstraintMode.NO_CONSTRAINT))
    open var storeItemEntity: StoreItemEntity? = storeItemEntity

    @MapsId("favoriteKey")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "FAVORITE_KEY", nullable = false, referencedColumnName = "FAVORITE_KEY", foreignKey = ForeignKey(ConstraintMode.NO_CONSTRAINT))
    open var favoriteEntity: FavoriteEntity? = favoriteEntity
}