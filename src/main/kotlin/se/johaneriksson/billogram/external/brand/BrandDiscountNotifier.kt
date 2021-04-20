package se.johaneriksson.billogram.external.brand

import org.springframework.stereotype.Service
import se.johaneriksson.billogram.api.discount.consumer.DiscountFetchedNotifier
import se.johaneriksson.billogram.domain.discount.Discount
import se.johaneriksson.billogram.external.user.MockUserClient

@Service
class BrandDiscountNotifier(
    private val mockUserClient: MockUserClient,
    private val mockBrandClient: MockBrandClient
): DiscountFetchedNotifier {
    override fun notify(discount: Discount, userId: Long) {
        val userData = mockUserClient.getUserData(userId)
        mockBrandClient.notifyBrandOfDiscountFetched(discount.brandId, discount.id, userData)
    }
}