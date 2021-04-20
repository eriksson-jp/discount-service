package se.johaneriksson.billogram.external.user

import org.springframework.stereotype.Service

@Service
class MockUserClient {

    /**
     * This method mocks calling a different micro service handling user information,
     * which would provide the data that gets shared with the brand. In a proper
     * solution this data would be structured, and presumably contain things like
     * contact information, demographics, and whatever else our service provides.
     */
    fun getUserData(userId: Long) = UserData("some data")
}

class UserData(
    val data: String
)