package com.hanghea99.commerce.database.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.Size
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant

@Entity
@Table(name = "MANAGER")
open class ManagerEntity(
    managerId: String? = null,
    status: String? = null,
    password: String? = null,
    name: String? = null,
    ssn: String? = null,
    telNumber: String? = null,
    zipCode: String? = null,
    adress: String? = null,
    auth: String? = null,
    createdAt: Instant? = null,
    updatedAt: Instant? = null,
    deletedAt: Instant? = null,
) {

    @Id
    @Size(max = 20)
    @Column(name = "MANAGER_ID", nullable = false, length = 20)
    open var managerId: String? = managerId

    @Size(max = 10)
    @Column(name = "STATUS", length = 10)
    open var status: String? = status

    @Size(max = 255)
    @Column(name = "PASSWORD")
    open var password: String? = password

    @Size(max = 20)
    @Column(name = "NAME", length = 20)
    open var name: String? = name

    @Size(max = 100)
    @Column(name = "SSN", length = 100)
    open var ssn: String? = ssn

    @Size(max = 15)
    @Column(name = "TEL_NUMBER", length = 15)
    open var telNumber: String? = telNumber

    @Size(max = 10)
    @Column(name = "ZIP_CODE", length = 10)
    open var zipCode: String? = zipCode

    @Size(max = 255)
    @Column(name = "ADRESS")
    open var adress: String? = adress

    @Size(max = 20)
    @Column(name = "AUTH", length = 20)
    open var auth: String? = auth

    @CreationTimestamp
    @Column(name = "CREATED_AT", updatable = false)
    open var createdAt: Instant? = createdAt

    @UpdateTimestamp
    @Column(name = "UPDATED_AT")
    open var updatedAt: Instant? = updatedAt

    @Column(name = "DELETED_AT")
    open var deletedAt: Instant? = deletedAt
}