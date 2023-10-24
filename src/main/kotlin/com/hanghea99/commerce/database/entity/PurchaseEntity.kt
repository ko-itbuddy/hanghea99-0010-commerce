package com.hanghea99.commerce.database.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.math.BigDecimal
import java.time.Instant

@Entity
@TableGenerator(
    name = "PURCHASE_SEQ_GENERATOR",
    table = "__SEQ",
    initialValue = 1,
    allocationSize = 50,
)
@Table(name = "PURCHASE")
open class PurchaseEntity(
    purchaseKey: Long? = null,
    userId: Long? = null,
    userEntity: UserEntity? = null,
    totalPrice: BigDecimal? = null,
    purchaseDate: Instant? = null,
    cancleDate: Instant? = null,
    status: String? = null,
    paymentEntities: MutableSet<PaymentEntity> = mutableSetOf(),
    purchaseItemEntities: MutableSet<PurchaseItemEntity> = mutableSetOf(),
) {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "PURCHASE_SEQ_GENERATOR")
    @NotNull
    @Column(name = "PURCHASE_KEY", nullable = false)
    open var purchaseKey: Long? = purchaseKey

    @NotNull
    @Column(name = "USER_ID", nullable = false)
    open var userId: Long? = userId

    @MapsId("userId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "USER_ID", nullable = false, foreignKey = ForeignKey(ConstraintMode.NO_CONSTRAINT))
    open var userEntity: UserEntity? = userEntity

    @Column(name = "TOTAL_PRICE", precision = 20, scale = 2)
    open var totalPrice: BigDecimal? = totalPrice

    @Column(name = "PURCHASE_DATE")
    open var purchaseDate: Instant? = purchaseDate

    @Column(name = "CANCLE_DATE")
    open var cancleDate: Instant? = cancleDate

    @Size(max = 10)
    @Column(name = "STATUS", length = 10)
    open var status: String? = status

    @OneToMany(mappedBy = "purchaseEntity")
    open var paymentEntities: MutableSet<PaymentEntity> = paymentEntities

    @OneToMany(mappedBy = "purchaseEntity")
    open var purchaseItemEntities: MutableSet<PurchaseItemEntity> = purchaseItemEntities
}