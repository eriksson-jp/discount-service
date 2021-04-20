package se.johaneriksson.billogram.domain.discount.db

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class DiscountEntity(
        @Id
        @GeneratedValue
        val id: Long? = null,
        val title: String,
        val description: String,
        val discountPercentage: Long,
        val code: String,
        val brandId: Long
)