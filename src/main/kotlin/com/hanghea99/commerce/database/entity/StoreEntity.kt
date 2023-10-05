package com.hanghea99.commerce.database.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
open class StoreEntity {
    @Id
    open var id: Long = 0L

}