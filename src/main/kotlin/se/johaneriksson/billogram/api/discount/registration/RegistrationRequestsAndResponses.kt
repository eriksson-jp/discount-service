package se.johaneriksson.billogram.api.discount.registration

class DiscountRegistrationRequest(
    val title: String,
    val description: String,
    val discountPercentage: Long
)

class DiscountRegistrationResponse(
    val title: String,
    val description: String,
    val discountPercentage: Long,
    val code: String
)