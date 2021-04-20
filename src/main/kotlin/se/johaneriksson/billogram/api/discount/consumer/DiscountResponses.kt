package se.johaneriksson.billogram.api.discount.consumer

class ListDiscountsResponse(discounts: List<DiscountWithoutCode>)

class DiscountCodeResponse(val code: String)

class DiscountWithoutCode(
    val id: Long,
    val title: String,
    val description: String,
    val discountPercentage: Long
)