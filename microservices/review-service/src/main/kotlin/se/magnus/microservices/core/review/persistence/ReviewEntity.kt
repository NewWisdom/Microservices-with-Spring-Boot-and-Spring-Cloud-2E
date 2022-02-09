package se.magnus.microservices.core.review.persistence

import javax.persistence.*

@Entity
@Table(name = "reviews", indexes = [Index(name = "reviews_unique_idx", unique = true, columnList = "productId,reviewId")])
class ReviewEntity(
    val productId: Long,
    val reviewId: Long,
    val author: String,
    val subject: String,
    var content: String,

    @Version
    var version: Int? = null,

    @Id @GeneratedValue
    val id: Long? = null
) {
    fun changeContent(content: String) {
        this.content = content
    }
}