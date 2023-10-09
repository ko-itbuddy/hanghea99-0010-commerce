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
    var id: Long? = id

    @Column(name = "EMAIL")
    var email: Long? = email

    @Column(name = "PASSWORD")
    var password: Long? = password

    @Column(name = "ADDRESS")
    var address: String? = address

    @Size(max = 20)
    @Column(name = "NICKNAME", length = 20)
    var nickname: String? = nickname

    @CreationTimestamp
    @Column(name = "CREATED_AT", updatable = false)
    var createdAt: Instant? = createdAt

    @UpdateTimestamp
    @Column(name = "UPDATED_AT")
    var updatedAt: Instant? = updatedAt

    @Column(name = "DELETED_AT")
    var deletedAt: Instant? = deletedAt

    @OneToMany(mappedBy = "userEntity")
    var cartEntities: MutableSet<CartEntity> = cartEntities

    @OneToMany(mappedBy = "userEntity")
    var deliveryAddressEntities: MutableSet<DeliveryAddressEntity> = deliveryAddressEntities

    @OneToMany(mappedBy = "userEntity")
    var favoriteEntities: MutableSet<FavoriteEntity> = favoriteEntities

    @OneToMany(mappedBy = "userEntity")
    var purchaseEntities: MutableSet<PurchaseEntity> = purchaseEntities

    @Column(name = "AGREE_AT")
    var agreeAt: Instant? = agreeAt
}