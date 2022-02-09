package se.magnus.microservices.core.product.persistence

import org.springframework.data.repository.PagingAndSortingRepository
import java.util.*

interface ProductRepository : PagingAndSortingRepository<ProductEntity, String> {
    fun findByProductId(productId: Int): ProductEntity?
}