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
open class PurchaseItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "PURCHASE_ITEM_SEQ_GENERATOR")
    @NotNull
    @Column(name = "PURCHASE_ITEM_KEY", nullable = false)
    open var purchaseItemKey: Long? = null

    @NotNull
    @Column(name = "REVIEW_ID", nullable = false)
    open var reviewId: Long? = null

    @NotNull
    @Column(name = "PURCHASE_KEY", nullable = false)
    open var purchaseKey: Long? = null

    @NotNull
    @Column(name = "OPTION_KEY", nullable = false)
    open var optionKey: Long? = null

    @MapsId("reviewId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "REVIEW_ID", nullable = false)
    open var reviewEntity: ReviewEntity? = null

    @MapsId("purchaseKey")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PURCHASE_KEY", nullable = false, referencedColumnName = "PURCHASE_KEY")
    open var purchaseEntity: PurchaseEntity? = null

    @MapsId("optionKey")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "OPTION_KEY", nullable = false, referencedColumnName = "OPTION_KEY")
    open var storeItemoptionEntity: StoreItemOptionEntity? = null

    @OneToMany(mappedBy = "purchaseItemEntity")
    open var deliveries: MutableSet<DeliveryEntity> = mutableSetOf()
}