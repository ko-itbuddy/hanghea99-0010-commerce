package com.hanghea99.commerce.database.entity

import jakarta.persistence.*

@Entity
@SequenceGenerator(
    name = "REVIEW_SEQ_GENERATOR",
    sequenceName = "REVIEW_SEQ",
    initialValue = 1,
    allocationSize = 50,
)
@Table(name = "REVIEW")
open class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REVIEW_SEQ_GENERATOR")
    @Column(name = "REVIEW_ID", nullable = false)
    open var id: Long? = null

    @Column(name = "REVIEW_POINT")
    open var reviewPoint: Long? = null

    @Lob
    @Column(name = "CONTENT")
    open var content: String? = null

    @OneToMany(mappedBy = "reviewEntity")
    open var purchaseItemEntities: MutableSet<PurchaseItemEntity> = mutableSetOf()
}