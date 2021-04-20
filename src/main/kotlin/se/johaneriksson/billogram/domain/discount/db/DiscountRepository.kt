package se.johaneriksson.billogram.domain.discount.db

import org.springframework.data.repository.Repository

interface DiscountRepository: Repository<DiscountEntity, Long> {
    fun save(entity: DiscountEntity): DiscountEntity
    fun findById(id: Long): DiscountEntity?
    fun findAll(): List<DiscountEntity>
}