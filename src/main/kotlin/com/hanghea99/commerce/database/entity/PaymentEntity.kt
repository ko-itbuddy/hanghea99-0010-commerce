package com.hanghea99.commerce.database.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

@Entity
@TableGenerator(
    name = "PAYMENT_SEQ_GENERATOR",
    table = "__SEQ",
    initialValue = 1,
    allocationSize = 50,
)
@Table(name = "PAYMENT")
open class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "PAYMENT_SEQ_GENERATOR")
    @NotNull
    @Column(name = "PAYMENT_KEY", nullable = false)
    open var paymentKey: Long? = null

    @NotNull
    @Column(name = "PURCHASE_KEY", nullable = false)
    open var purchaseKey: Long? = null

    @MapsId("purchaseKey")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PURCHASE_KEY", nullable = false, referencedColumnName = "PURCHASE_KEY")
    open var purchaseEntity: PurchaseEntity? = null

    @Size(max = 20)
    @Column(name = "KIND", length = 20)
    open var kind: String? = null
}