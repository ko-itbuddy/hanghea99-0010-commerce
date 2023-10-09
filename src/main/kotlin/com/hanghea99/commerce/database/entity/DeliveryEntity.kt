package com.hanghea99.commerce.database.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

@Entity
@SequenceGenerator(
    name = "DELIVERY_SEQ_GENERATOR",
    sequenceName = "DELIVERY_SEQ",
    initialValue = 1,
    allocationSize = 50,
)
@Table(name = "DELIVERY")
open class DeliveryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DELIVERY_SEQ_GENERATOR")
    @NotNull
    @Column(name = "DELIVERY_KEY", nullable = false)
    open var deliveryKey: Long? = null

    @NotNull
    @Column(name = "PURCHASE_ITEM_KEY", nullable = false)
    open var purchaseItemKey: Long? = null

    @MapsId("purchaseItemKey")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
        name = "PURCHASE_ITEM_KEY",
        nullable = false,
        referencedColumnName = "PURCHASE_ITEM_KEY"
    )
    open var purchaseItemEntity: PurchaseItemEntity? = null

    @Size(max = 10)
    @Column(name = "STATUS", length = 10)
    open var status: String? = null

    @Lob
    @Column(name = "SHIPPING_NUMBER")
    open var shippingNumber: String? = null
}