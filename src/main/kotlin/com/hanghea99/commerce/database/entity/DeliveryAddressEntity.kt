package com.hanghea99.commerce.database.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

@Entity
@TableGenerator(
    name = "DELIVERY_ADDRESS_SEQ_GENERATOR",
    table = "__SEQ",
    initialValue = 1,
    allocationSize = 50,
)
@Table(name = "DELIVERY_ADDRESS")
open class DeliveryAddressEntity(
    deliveryAddressKey: Long? = null,
    userId: Long? = null,
    userEntity: UserEntity? = null,
    name: String? = null,
    address: String? = null,
    ddressDetail: String? = null,
    zipCode: String? = null,
) {

    @Id
    @GeneratedValue(
        strategy = GenerationType.TABLE,
        generator = "DELIVERY_ADDRESS_SEQ_GENERATOR"
    )
    @NotNull
    @Column(name = "DELIVERY_ADDRESS_KEY", nullable = false)
    open var deliveryAddressKey: Long? = deliveryAddressKey

    @NotNull
    @Column(name = "USER_ID", nullable = false)
    open var userId: Long? = userId

    @MapsId("userId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "USER_ID", nullable = false, foreignKey = ForeignKey(ConstraintMode.NO_CONSTRAINT))
    open var userEntity: UserEntity? = userEntity

    @Size(max = 20)
    @Column(name = "NAME", length = 20)
    open var name: String? = name

    
    @Column(name = "ADDRESS")
    open var address: String? = address

    
    @Column(name = "DDRESS_DETAIL")
    open var ddressDetail: String? = ddressDetail

    @Size(max = 10)
    @Column(name = "ZIP_CODE", length = 10)
    open var zipCode: String? = zipCode
}