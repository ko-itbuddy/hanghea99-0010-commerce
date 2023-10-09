package com.hanghea99.commerce.database.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull

@Entity
@SequenceGenerator(
    name = "FAVORITE_SEQ_GENERATOR",
    sequenceName = "FAVORITE_SEQ",
    initialValue = 1,
    allocationSize = 50,
)
@Table(name = "FAVORITE")
open class FavoriteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FAVORITE_SEQ_GENERATOR")
    @NotNull
    @Column(name = "FAVORITE_KEY", nullable = false)
    open var favoriteKey: Long? = null

    @NotNull
    @Column(name = "USER_ID", nullable = false)
    open var userId: Long? = null

    @MapsId("userId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "USER_ID", nullable = false)
    open var userEntity: UserEntity? = null

    @OneToMany(mappedBy = "favoriteEntity")
    open var favoriteItemEntities: MutableSet<FavoriteItemEntity> = mutableSetOf()
}