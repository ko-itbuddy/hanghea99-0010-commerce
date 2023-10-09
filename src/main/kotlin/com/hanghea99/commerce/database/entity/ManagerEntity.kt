package com.hanghea99.commerce.database.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.Size
import java.time.Instant

@Entity
@Table(name = "MANAGER")
open class ManagerEntity {

    @Id
    @Size(max = 20)
    @Column(name = "MANAGER_ID", nullable = false, length = 20)
    open var managerId: String? = null

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
    @Column(name = "TEL_NUMBER", length = 15)
    open var telNumber: String? = null

    @Size(max = 10)
    @Column(name = "ZIP_CODE", length = 10)
    open var zipCode: String? = null

    @Size(max = 255)
    @Column(name = "ADRESS")
    open var adress: String? = null

    @Size(max = 20)
    @Column(name = "AUTH", length = 20)
    open var auth: String? = null

    @Column(name = "CREATED_AT", updatable = false)
    open var createdAt: Instant? = null

    @Column(name = "UPDATED_AT")
    open var updatedAt: Instant? = null

    @Column(name = "DELETED_AT")
    open var deletedAt: Instant? = null
}