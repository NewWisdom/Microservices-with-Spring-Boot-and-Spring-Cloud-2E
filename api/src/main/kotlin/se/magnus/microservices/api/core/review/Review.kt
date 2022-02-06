package se.magnus.microservices.api.core.review

class Review(
    val productId: Int,
    val reviewId: Int,
    val author: String,
    val subject: String,
    val content: String,
    val serviceAddress: String
) {
}