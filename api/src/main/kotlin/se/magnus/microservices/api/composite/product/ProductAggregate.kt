package se.magnus.microservices.api.composite.product

class ProductAggregate(
    val productId: Int,
    val name: String,
    val weight: Int,
    val recommendations: List<RecommendationSummary>,
    val reviews: List<ReviewSummary>,
    val serviceAddresses: ServiceAddresses
) {
}