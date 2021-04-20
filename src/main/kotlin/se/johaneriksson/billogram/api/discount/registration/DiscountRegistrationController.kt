package se.johaneriksson.billogram.api.discount.registration

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import se.johaneriksson.billogram.domain.discount.DiscountService

@RestController()
class DiscountRegistrationController(
    private val discountService: DiscountService
) {

    @PostMapping("/discounts/brands/{brandId}")
    fun registerDiscount(@PathVariable brandId: Long, request: DiscountRegistrationRequest): DiscountRegistrationResponse {
        val discount = discountService.registerDiscount(
            brandId,
            request.title,
            request.description,
            request.discountPercentage
        )
        return DiscountRegistrationResponse(discount.title, discount.description, discount.discountPercentage, discount.code)
    }
}