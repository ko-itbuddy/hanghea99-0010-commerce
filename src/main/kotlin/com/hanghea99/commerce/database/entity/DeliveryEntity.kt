package com.hanghea99.commerce.database.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

@Entity
@TableGenerator(
    name = "DELIVERY_SEQ_GENERATOR",
    table = "__SEQ",
    initialValue = 1,
    allocationSize = 50,
)
@Table(name = "DELIVERY")
open class DeliveryEntity(
    deliveryKey: Long? = null,
    purchaseItemKey: Long? = null,
    purchaseItemEntity: PurchaseItemEntity? = null,
    status: String? = null,
    shippingNumber: String? = null,
) {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "DELIVERY_SEQ_GENERATOR")
    @NotNull
    @Column(name = "DELIVERY_KEY", nullable = false)
    open var deliveryKey: Long? = deliveryKey

    @NotNull
    @Column(name = "PURCHASE_ITEM_KEY", nullable = false)
    open var purchaseItemKey: Long? = purchaseItemKey

    @MapsId("purchaseItemKey")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
        name = "PURCHASE_ITEM_KEY",
        nullable = false,
        referencedColumnName = "PURCHASE_ITEM_KEY",
        foreignKey = ForeignKey(ConstraintMode.NO_CONSTRAINT),
    )
    open var purchaseItemEntity: PurchaseItemEntity? = purchaseItemEntity

    @Size(max = 10)
    @Column(name = "STATUS", length = 10)
    open var status: String? = status

    
    @Column(name = "SHIPPING_NUMBER")
    open var shippingNumber: String? = shippingNumber
}