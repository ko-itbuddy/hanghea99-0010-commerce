package com.hanghea99.commerce.database.entity

import jakarta.persistence.*
import jakarta.validation.constraints.Size
import java.time.Instant

@Entity
@Table(name = "SELLER")
open class SellerEntity {
    @Id
    @Size(max = 20)
    @Column(name = "SELLER_ID", nullable = false, length = 20)
    open var sellerId: String? = null

    @Size(max = 10)
    @Column(name = "STATUS", length = 10)
    open var status: String? = null

    @Size(max = 255)
    @Column(name = "PASSWORD")
    open var password: String? = null

    @Size(max = 20)
    @Column(name = "NAME", length = 20)
    open var name: String? = null

    @Size(max = 100)
    @Column(name = "SSN", length = 100)
    open var ssn: String? = null

    @Size(max = 15)
    @Column(name = "TELECOM_NAME", length = 15)
    open var telecomName: String? = null

    @Size(max = 15)
    @Column(name = "PHONE_NUMBER", length = 15)
    open var phoneNumber: String? = null

    @Size(max = 255)
    @Column(name = "COMPANY_NAME")
    open var companyName: String? = null

    @Size(max = 100)
    @Column(name = "BUSINESS_REGESTRAION_NUMBER", length = 100)
    open var businessRegestraionNumber: String? = null

    @Size(max = 20)
    @Column(name = "REPRESENTATIVE_NAME", length = 20)
    open var representativeName: String? = null

    @Size(max = 15)
    @Column(name = "REPRESENTATIVE_TELEPHONE_NUMBER", length = 15)
    open var representativeTelephoneNumber: String? = null

    @Size(max = 15)
    @Column(name = "FAX_NUMBER", length = 15)
    open var faxNumber: String? = null

    @Size(max = 10)
    @Column(name = "BUSINESS_ZIP_CODE", length = 10)
    open var businessZipCode: String? = null

    @Size(max = 255)
    @Column(name = "BUSINIESS_ADDRESS")
    open var businiessAddress: String? = null

    @Column(name = "CREATED_AT", updatable = false)
    open var createdAt: Instant? = null

    @Column(name = "UPDATED_AT")
    open var updatedAt: Instant? = null

    @Column(name = "DELETED_AT")
    open var deletedAt: Instant? = null

    @Column(name = "ALLOWED_AT")
    open var allowedAt: Instant? = null

    @Column(name = "BLOCKED_AT")
    open var blockedAt: Instant? = null

    @OneToMany(mappedBy = "sellerEntity")
    open var sellerRequestRegistrationEntities: MutableSet<SellerRequestRegistrationEntity> = mutableSetOf()

    @OneToMany(mappedBy = "sellerEntity")
    open var stores: MutableSet<StoreEntity> = mutableSetOf()

}