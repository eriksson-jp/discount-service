package se.johaneriksson.billogram.domain.discount

import org.springframework.stereotype.Service
import se.johaneriksson.billogram.domain.discount.db.DiscountEntity
import se.johaneriksson.billogram.domain.discount.db.DiscountRepository
import java.util.*

@Service
class DiscountService(
        private val discountRepository: DiscountRepository
) {
    fun registerDiscount(
        brandId: Long,
        title: String,
        description: String,
        discountPercentage: Long
    ): Discount {
        discountPercentage.validate()
        val code = UUID.randomUUID().toString()
        val entity = discountRepository.save(DiscountEntity(
            title = title,
            description =  description,
            discountPercentage = discountPercentage,
            code = code,
            brandId = brandId
        ))
        return entity.toDomainObject()
    }

    fun getDiscount(discountId: Long) = discountRepository.findById(discountId)?.toDomainObject()

    fun getAvailableDiscounts() = discountRepository.findAll().map { it.toDomainObject() }
}

private fun DiscountEntity.toDomainObject(): Discount = Discount(this.id!!, this.title, this.description, this.discountPercentage, this.code, this.brandId)

private fun Long.validate() {
    if (this < 1 || this > 100) {
        throw IllegalArgumentException("Invalid discount percentage: $this")
    }
}
