package com.hanghea99.commerce.database.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull

@Entity
@TableGenerator(
    name = "FAVORITE_SEQ_GENERATOR",
    table = "__SEQ",
    initialValue = 1,
    allocationSize = 50,
)
@Table(name = "FAVORITE")
open class FavoriteEntity(
    favoriteKey: Long? = null,
    userId: Long? = null,
    userEntity: UserEntity? = null,
    favoriteItemEntities: MutableSet<FavoriteItemEntity> = mutableSetOf(),
) {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "FAVORITE_SEQ_GENERATOR")
    @NotNull
    @Column(name = "FAVORITE_KEY", nullable = false)
    open var favoriteKey: Long? = favoriteKey

    @NotNull
    @Column(name = "USER_ID", nullable = false)
    open var userId: Long? = userId

    @MapsId("userId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "USER_ID", nullable = false)
    open var userEntity: UserEntity? = userEntity

    @OneToMany(mappedBy = "favoriteEntity")
    open var favoriteItemEntities: MutableSet<FavoriteItemEntity> = favoriteItemEntities
}