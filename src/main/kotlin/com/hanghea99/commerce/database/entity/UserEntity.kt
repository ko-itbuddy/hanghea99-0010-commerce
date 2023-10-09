package com.hanghea99.commerce.database.entity

import jakarta.persistence.*
import jakarta.validation.constraints.Size
import java.time.Instant

@Entity
@Table(name = "USER")
open class UserEntity {
    @Id
    @Column(name = "USER_ID", nullable = false)
    open var id: Long? = null

    @Column(name = "EMAIL")
    open var email: Long? = null

    @Column(name = "PASSWORD")
    open var password: Long? = null

    @Lob
    @Column(name = "ADDRESS")
    open var address: String? = null

    @Size(max = 20)
    @Column(name = "NICKNAME", length = 20)
    open var nickname: String? = null

    @Column(name = "CREATED_AT", updatable = false)
    open var createdAt: Instant? = null

    @Column(name = "UPDATED_AT")
    open var updatedAt: Instant? = null

    @Column(name = "DELETED_AT")
    open var deletedAt: Instant? = null

    @OneToMany(mappedBy = "userEntity")
    open var cartEntities: MutableSet<CartEntity> = mutableSetOf()

    @OneToMany(mappedBy = "userEntity")
    open var deliveryAddressEntities: MutableSet<DeliveryAddressEntity> = mutableSetOf()

    @OneToMany(mappedBy = "userEntity")
    open var favoriteEntities: MutableSet<FavoriteEntity> = mutableSetOf()

    @OneToMany(mappedBy = "userEntity")
    open var purchaseEntities: MutableSet<PurchaseEntity> = mutableSetOf()

    @Column(name = "AGREE_AT")
    open var agreeAt: Instant? = null
}