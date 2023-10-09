package com.hanghea99.commerce.database.entity

import jakarta.persistence.*
import jakarta.validation.constraints.Size
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant

@Entity
@Table(name = "SELLER")
open class SellerEntity(
    sellerId: String? = null,
    status: String? = null,
    password: String? = null,
    name: String? = null,
    ssn: String? = null,
    telecomName: String? = null,
    phoneNumber: String? = null,
    companyName: String? = null,
    businessRegestraionNumber: String? = null,
    representativeName: String? = null,
    representativeTelephoneNumber: String? = null,
    faxNumber: String? = null,
    businessZipCode: String? = null,
    businiessAddress: String? = null,
    createdAt: Instant? = null,
    updatedAt: Instant? = null,
    deletedAt: Instant? = null,
    allowedAt: Instant? = null,
    blockedAt: Instant? = null,
    sellerRequestRegistrationEntities: MutableSet<SellerRequestRegistrationEntity> = mutableSetOf(),
    stores: MutableSet<StoreEntity> = mutableSetOf(),
) {
    companion object {
        val STATUS_SIGN_UP = "SIGN_UP"
        val STATUS_ALLOWED = "ALLOWED"
        val STATUS_BLOCKED = "BLOCKED"
        val STATUS_DENIED = "DENIED"
    }


    @Id
    @Size(max = 20)
    @Column(name = "SELLER_ID", nullable = false, length = 20)
    var sellerId: String? = sellerId

    @Size(max = 10)
    @Column(name = "STATUS", length = 10)
    var status: String? = status

    @Size(max = 255)
    @Column(name = "PASSWORD")
    var password: String? = password

    @Size(max = 20)
    @Column(name = "NAME", length = 20)
    var name: String? = name

    @Size(max = 100)
    @Column(name = "SSN", length = 100)
    var ssn: String? = ssn

    @Size(max = 15)
    @Column(name = "TELECOM_NAME", length = 15)
    var telecomName: String? = telecomName

    @Size(max = 15)
    @Column(name = "PHONE_NUMBER", length = 15)
    var phoneNumber: String? = phoneNumber

    @Size(max = 255)
    @Column(name = "COMPANY_NAME")
    var companyName: String? = companyName

    @Size(max = 100)
    @Column(name = "BUSINESS_REGESTRAION_NUMBER", length = 100)
    var businessRegestraionNumber: String? = businessRegestraionNumber

    @Size(max = 20)
    @Column(name = "REPRESENTATIVE_NAME", length = 20)
    var representativeName: String? = representativeName

    @Size(max = 15)
    @Column(name = "REPRESENTATIVE_TELEPHONE_NUMBER", length = 15)
    var representativeTelephoneNumber: String? = representativeTelephoneNumber

    @Size(max = 15)
    @Column(name = "FAX_NUMBER", length = 15)
    var faxNumber: String? = faxNumber

    @Size(max = 10)
    @Column(name = "BUSINESS_ZIP_CODE", length = 10)
    var businessZipCode: String? = businessZipCode

    @Size(max = 255)
    @Column(name = "BUSINIESS_ADDRESS")
    var businiessAddress: String? = businiessAddress

    @CreationTimestamp
    @Column(name = "CREATED_AT", updatable = false)
    var createdAt: Instant? = createdAt

    @UpdateTimestamp
    @Column(name = "UPDATED_AT")
    var updatedAt: Instant? = updatedAt

    @Column(name = "DELETED_AT")
    var deletedAt: Instant? = deletedAt

    @Column(name = "ALLOWED_AT")
    var allowedAt: Instant? = allowedAt

    @Column(name = "BLOCKED_AT")
    var blockedAt: Instant? = blockedAt

    @OneToMany(mappedBy = "sellerEntity")
    var sellerRequestRegistrationEntities: MutableSet<SellerRequestRegistrationEntity> = sellerRequestRegistrationEntities

    @OneToMany(mappedBy = "sellerEntity")
    var stores: MutableSet<StoreEntity> = stores

}