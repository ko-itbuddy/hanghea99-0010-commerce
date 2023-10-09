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
    var id: Long? = id

    @Column(name = "REVIEW_POINT")
    var reviewPoint: Long? = reviewPoint


    @Column(name = "CONTENT")
    var content: String? = content

    @OneToMany(mappedBy = "reviewEntity")
    var purchaseItemEntities: MutableSet<PurchaseItemEntity> = purchaseItemEntities
}