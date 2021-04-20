package se.johaneriksson.billogram.domain.discount.consumer

import org.springframework.stereotype.Service
import se.johaneriksson.billogram.api.discount.consumer.DiscountFetchedNotifier
import se.johaneriksson.billogram.domain.discount.Discount
import se.johaneriksson.billogram.domain.discount.DiscountService

typealias DiscountCode = String

@Service
class ConsumerDiscountService(
    private val notifiers: List<DiscountFetchedNotifier>,
    private val discountService: DiscountService
) {

    fun fetchDiscountForUser(discountId: Long, userId: Long): DiscountCode {
        val discount = discountService.getDiscount(discountId) ?: throw IllegalArgumentException("No discount found for id: $discountId")
        notifiers.forEach { it.notify(discount, userId) }
        return discount.code
    }

    fun getAvailableDiscounts(): List<Discount> = discountService.getAvailableDiscounts()

}