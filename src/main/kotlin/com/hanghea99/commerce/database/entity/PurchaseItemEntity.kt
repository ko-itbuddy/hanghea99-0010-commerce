package com.hanghea99.commerce.database.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull

@Entity
@TableGenerator(
    name = "PURCHASE_ITEM_SEQ_GENERATOR",
    table = "__SEQ",
    initialValue = 1,
    allocationSize = 50,
)
@Table(name = "PURCHASE_ITEM")
open class PurchaseItemEntity(
    purchaseItemKey: Long? = null,
    reviewId: Long? = null,
    purchaseKey: Long? = null,
    optionKey: Long? = null,
    reviewEntity: ReviewEntity? = null,
    purchaseEntity: PurchaseEntity? = null,
    storeItemoptionEntity: StoreItemOptionEntity? = null,
    deliveries: MutableSet<DeliveryEntity> = mutableSetOf(),
) {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "PURCHASE_ITEM_SEQ_GENERATOR")
    @NotNull
    @Column(name = "PURCHASE_ITEM_KEY", nullable = false)
    var purchaseItemKey: Long? = purchaseItemKey

    @NotNull
    @Column(name = "REVIEW_ID", nullable = false)
    var reviewId: Long? = reviewId

    @NotNull
    @Column(name = "PURCHASE_KEY", nullable = false)
    var purchaseKey: Long? = purchaseKey

    @NotNull
    @Column(name = "OPTION_KEY", nullable = false)
    var optionKey: Long? = optionKey

    @MapsId("reviewId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "REVIEW_ID", nullable = false)
    var reviewEntity: ReviewEntity? = reviewEntity

    @MapsId("purchaseKey")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PURCHASE_KEY", nullable = false, referencedColumnName = "PURCHASE_KEY")
    var purchaseEntity: PurchaseEntity? = purchaseEntity

    @MapsId("optionKey")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "OPTION_KEY", nullable = false, referencedColumnName = "OPTION_KEY")
    var storeItemoptionEntity: StoreItemOptionEntity? = storeItemoptionEntity

    @OneToMany(mappedBy = "purchaseItemEntity")
    var deliveries: MutableSet<DeliveryEntity> = deliveries
}