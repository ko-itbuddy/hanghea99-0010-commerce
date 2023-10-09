package com.hanghea99.commerce.database.entity

import jakarta.persistence.*

@Entity
@TableGenerator(
    name = "REVIEW_SEQ_GENERATOR",
    table = "__SEQ",
    initialValue = 1,
    allocationSize = 50,
)
@Table(name = "REVIEW")
open class ReviewEntity(
    id: Long? = null,
    reviewPoint: Long? = null,
    content: String? = null,
    purchaseItemEntities: MutableSet<PurchaseItemEntity> = mutableSetOf(),
) {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "REVIEW_SEQ_GENERATOR")
    @Column(name = "REVIEW_ID", nullable = false)
    open var id: Long? = id

    @Column(name = "REVIEW_POINT")
    open var reviewPoint: Long? = reviewPoint


    @Column(name = "CONTENT")
    open var content: String? = content

    @OneToMany(mappedBy = "reviewEntity")
    open var purchaseItemEntities: MutableSet<PurchaseItemEntity> = purchaseItemEntities
}