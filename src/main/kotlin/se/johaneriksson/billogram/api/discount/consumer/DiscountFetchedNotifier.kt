package se.johaneriksson.billogram.api.discount.consumer

import se.johaneriksson.billogram.domain.discount.Discount

interface DiscountFetchedNotifier {
    fun notify(discount: Discount, userId: Long)
}