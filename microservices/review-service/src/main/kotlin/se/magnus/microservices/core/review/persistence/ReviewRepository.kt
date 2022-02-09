package se.magnus.microservices.core.review.persistence

import org.springframework.data.jpa.repository.JpaRepository

interface ReviewRepository : JpaRepository<ReviewEntity, Long> {
    fun findByProductId(productId: Long): List<ReviewEntity>
}