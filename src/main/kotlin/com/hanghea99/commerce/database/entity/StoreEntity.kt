package com.hanghea99.commerce.database.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.time.Instant

@Entity
@SequenceGenerator(
    name = "STORE_SEQ_GENERATOR",
    sequenceName = "STORE_SEQ",
    initialValue = 1,
    allocationSize = 50,
)
@Table(name = "STORE")
open class StoreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STORE_SEQ_GENERATOR")
    @NotNull
    @Column(name = "STORE_KEY", nullable = false)
    open var storeKey: Long? = null

    @Size(max = 30)
    @NotNull
    @Column(name = "SELLER_ID", nullable = false, length = 30)
    open var sellerId: String? = null

    @MapsId("sellerId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SELLER_ID", nullable = false)
    open var sellerEntity: SellerEntity? = null

    @Size(max = 10)
    @Column(name = "STATUS", length = 10)
    open var status: String? = null

    @Size(max = 255)
    @Column(name = "NAME")
    open var name: String? = null

    @Lob
    @Column(name = "`DESC`")
    open var desc: String? = null

    @Lob
    @Column(name = "SHIPPING_AND_REFUND_POLICY")
    open var shippingAndRefundPolicy: String? = null

    @Size(max = 100)
    @Column(name = "BUSINESS_FOR_DISTANCE_SELLING_NUMBER", length = 100)
    open var businessForDistanceSellingNumber: String? = null

    @Size(max = 20)
    @Column(name = "INFORMATION_MANAGER_NAME", length = 20)
    open var informationManagerName: String? = null

    @Size(max = 320)
    @Column(name = "EMAIL", length = 320)
    open var email: String? = null

    @Column(name = "CREATED_AT", updatable = false)
    open var createdAt: Instant? = null

    @Column(name = "UPDATED_AT")
    open var updatedAt: Instant? = null

    @Column(name = "DELETED_AT")
    open var deletedAt: Instant? = null

    @Column(name = "BLOCKED_AT")
    open var blockedAt: Instant? = null

    @OneToMany(mappedBy = "storeKey")
    open var storeItemEntities: MutableSet<StoreItemEntity> = mutableSetOf()
}