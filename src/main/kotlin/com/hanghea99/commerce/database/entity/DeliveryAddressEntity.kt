package com.hanghea99.commerce.database.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

@Entity
@SequenceGenerator(
    name = "DELIVERY_ADDRESS_SEQ_GENERATOR",
    sequenceName = "DELIVERY_ADDRESS_SEQ",
    initialValue = 1,
    allocationSize = 50,
)
@Table(name = "DELIVERY_ADDRESS")
open class DeliveryAddressEntity {

    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "DELIVERY_ADDRESS_SEQ_GENERATOR"
    )
    @NotNull
    @Column(name = "DELIVERY_ADDRESS_KEY", nullable = false)
    open var deliveryAddressKey: Long? = null

    @NotNull
    @Column(name = "USER_ID", nullable = false)
    open var userId: Long? = null

    @MapsId("userId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "USER_ID", nullable = false)
    open var userEntity: UserEntity? = null

    @Size(max = 20)
    @Column(name = "NAME", length = 20)
    open var name: String? = null

    @Lob
    @Column(name = "ADDRESS")
    open var address: String? = null

    @Lob
    @Column(name = "DDRESS_DETAIL")
    open var ddressDetail: String? = null

    @Size(max = 10)
    @Column(name = "ZIP_CODE", length = 10)
    open var zipCode: String? = null
}