package se.johaneriksson.billogram.api.discount.consumer

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import se.johaneriksson.billogram.domain.discount.consumer.ConsumerDiscountService

@RestController
class ConsumerDiscountController(
    private val consumerDiscountService: ConsumerDiscountService
) {

    @GetMapping("/discounts")
    fun fetchDiscounts(): ListDiscountsResponse {
        val discounts = consumerDiscountService.getAvailableDiscounts()
            .map { DiscountWithoutCode(
                it.id,
                it.title,
                it.description,
                it.discountPercentage
            ) }
        return ListDiscountsResponse(discounts)
    }

    @GetMapping("/discounts/{discountId}")
    fun fetchDiscountCode(@PathVariable discountId: Long, @RequestParam userId: Long): DiscountCodeResponse {
        val code = consumerDiscountService.fetchDiscountForUser(discountId, userId)
        return DiscountCodeResponse(code)
    }
}