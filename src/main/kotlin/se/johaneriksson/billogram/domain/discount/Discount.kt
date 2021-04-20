package se.johaneriksson.billogram.domain.discount

class Discount(
    val id: Long,
    val title: String,
    val description: String,
    val discountPercentage: Long,
    val code: String,
    val brandId: Long
)