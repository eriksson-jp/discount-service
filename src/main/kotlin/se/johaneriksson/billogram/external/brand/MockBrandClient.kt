package se.johaneriksson.billogram.external.brand

import org.springframework.stereotype.Service
import se.johaneriksson.billogram.external.user.UserData

@Service
class MockBrandClient {

    /**
     * While this mocked version does nothing, in a proper solution it would call the
     * Brand micro service, which in turn would notify the brand that a user has fetched
     * one of their discount codes, and also share the user data with them.
     */
    fun notifyBrandOfDiscountFetched(brandId: Long, discountId: Long, userData: UserData) {
    }

}