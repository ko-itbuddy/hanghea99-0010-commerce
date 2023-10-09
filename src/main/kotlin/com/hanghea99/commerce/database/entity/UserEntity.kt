package com.hanghea99.commerce.database.entity

import jakarta.persistence.*
import jakarta.validation.constraints.Size
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant

@Entity
@Table(name = "USER")
open class UserEntity(
    id: Long? = null,
    email: Long? = null,
    password: Long? = null,
    address: String? = null,
    nickname: String? = null,
    createdAt: Instant? = null,
    updatedAt: Instant? = null,
    deletedAt: Instant? = null,
    cartEntities: MutableSet<CartEntity> = mutableSetOf(),
    deliveryAddressEntities: MutableSet<DeliveryAddressEntity> = mutableSetOf(),
    favoriteEntities: MutableSet<FavoriteEntity> = mutableSetOf(),
    purchaseEntities: MutableSet<PurchaseEntity> = mutableSetOf(),
    agreeAt: Instant? = null,
) {

    @Id
    @Column(name = "USER_ID", nullable = false)
    open var id: Long? = id

    @Column(name = "EMAIL")
    open var email: Long? = email

    @Column(name = "PASSWORD")
    open var password: Long? = password

    @Column(name = "ADDRESS")
    open var address: String? = address

    @Size(max = 20)
    @Column(name = "NICKNAME", length = 20)
    open var nickname: String? = nickname

    @CreationTimestamp
    @Column(name = "CREATED_AT", updatable = false)
    open var createdAt: Instant? = createdAt

    @UpdateTimestamp
    @Column(name = "UPDATED_AT")
    open var updatedAt: Instant? = updatedAt

    @Column(name = "DELETED_AT")
    open var deletedAt: Instant? = deletedAt

    @OneToMany(mappedBy = "userEntity")
    open var cartEntities: MutableSet<CartEntity> = cartEntities

    @OneToMany(mappedBy = "userEntity")
    open var deliveryAddressEntities: MutableSet<DeliveryAddressEntity> = deliveryAddressEntities

    @OneToMany(mappedBy = "userEntity")
    open var favoriteEntities: MutableSet<FavoriteEntity> = favoriteEntities

    @OneToMany(mappedBy = "userEntity")
    open var purchaseEntities: MutableSet<PurchaseEntity> = purchaseEntities

    @Column(name = "AGREE_AT")
    open var agreeAt: Instant? = agreeAt
}