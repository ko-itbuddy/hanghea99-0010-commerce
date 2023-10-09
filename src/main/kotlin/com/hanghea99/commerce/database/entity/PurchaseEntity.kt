package com.hanghea99.commerce.database.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.math.BigDecimal
import java.time.Instant

@Entity
@SequenceGenerator(
    name = "PURCHASE_SEQ_GENERATOR",
    sequenceName = "PURCHASE_SEQ",
    initialValue = 1,
    allocationSize = 50,
)
@Table(name = "PURCHASE")
open class PurchaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PURCHASE_SEQ_GENERATOR")
    @NotNull
    @Column(name = "PURCHASE_KEY", nullable = false)
    open var purchaseKey: Long? = null

    @NotNull
    @Column(name = "USER_ID", nullable = false)
    open var userId: Long? = null

    @MapsId("userId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "USER_ID", nullable = false)
    open var userEntity: UserEntity? = null

    @Column(name = "TOTAL_PRICE", precision = 20, scale = 2)
    open var totalPrice: BigDecimal? = null

    @Column(name = "PURCHASE_DATE")
    open var purchaseDate: Instant? = null

    @Column(name = "CANCLE_DATE")
    open var cancleDate: Instant? = null

    @Size(max = 10)
    @Column(name = "STATUS", length = 10)
    open var status: String? = null

    @OneToMany(mappedBy = "purchaseEntity")
    open var paymentEntities: MutableSet<PaymentEntity> = mutableSetOf()

    @OneToMany(mappedBy = "purchaseEntity")
    open var purchaseItemEntities: MutableSet<PurchaseItemEntity> = mutableSetOf()
}