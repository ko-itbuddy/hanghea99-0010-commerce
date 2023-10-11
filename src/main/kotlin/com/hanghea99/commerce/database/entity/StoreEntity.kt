package com.hanghea99.commerce.database.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant

@Entity
@TableGenerator(
    name = "STORE_SEQ_GENERATOR",
    table = "__SEQ",
    initialValue = 1,
    allocationSize = 50,
)
@Table(name = "STORE")
open class StoreEntity(
    storeKey: Long? = null,
    sellerId: String? = null,
    sellerEntity: SellerEntity? = null,
    status: String? = null,
    name: String? = null,
    desc: String? = null,
    shippingAndRefundPolicy: String? = null,
    businessForDistanceSellingNumber: String? = null,
    informationManagerName: String? = null,
    email: String? = null,
    createdAt: Instant? = null,
    updatedAt: Instant? = null,
    deletedAt: Instant? = null,
    blockedAt: Instant? = null,
    storeItemEntities: MutableSet<StoreItemEntity> = mutableSetOf(),
) {
    companion object{
        val STAUS_READEY: String = "READY"
        val STAUS_OPEN: String = "OPEN"
        val STAUS_CLOSE: String = "CLOSE"
        val STAUS_BLOCK: String = "BLOCK"
    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "STORE_SEQ_GENERATOR")
    @NotNull
    @Column(name = "STORE_KEY", nullable = false)
    open var storeKey: Long? = storeKey

    @Size(max = 30)
    @NotNull
    @Column(name = "SELLER_ID", nullable = false, length = 30)
    open var sellerId: String? = sellerId

    @MapsId("sellerId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SELLER_ID", nullable = false, foreignKey = ForeignKey(ConstraintMode.NO_CONSTRAINT))
    open var sellerEntity: SellerEntity? = sellerEntity

    @Size(max = 10)
    @Column(name = "STATUS", length = 10)
    open var status: String? = status

    @Size(max = 255)
    @Column(name = "NAME")
    open var name: String? = name

    
    @Column(name = "`DESC`")
    open var desc: String? = desc

    
    @Column(name = "SHIPPING_AND_REFUND_POLICY")
    open var shippingAndRefundPolicy: String? = shippingAndRefundPolicy

    @Size(max = 100)
    @Column(name = "BUSINESS_FOR_DISTANCE_SELLING_NUMBER", length = 100)
    open var businessForDistanceSellingNumber: String? = businessForDistanceSellingNumber

    @Size(max = 20)
    @Column(name = "INFORMATION_MANAGER_NAME", length = 20)
    open var informationManagerName: String? = informationManagerName

    @Size(max = 320)
    @Column(name = "EMAIL", length = 320)
    open var email: String? = email

    @CreationTimestamp
    @Column(name = "CREATED_AT", updatable = false)
    open var createdAt: Instant? = createdAt

    @UpdateTimestamp
    @Column(name = "UPDATED_AT")
    open var updatedAt: Instant? = updatedAt

    @Column(name = "DELETED_AT")
    open var deletedAt: Instant? = deletedAt

    @Column(name = "BLOCKED_AT")
    open var blockedAt: Instant? = blockedAt

    @OneToMany(mappedBy = "storeKey")
    open var storeItemEntities: MutableSet<StoreItemEntity> = storeItemEntities
}