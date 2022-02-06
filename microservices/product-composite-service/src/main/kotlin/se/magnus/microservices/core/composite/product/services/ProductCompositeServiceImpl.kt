package se.magnus.microservices.core.composite.product.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RestController
import se.magnus.microservices.api.composite.product.*
import se.magnus.microservices.api.core.product.Product
import se.magnus.microservices.api.core.recommendation.Recommendation
import se.magnus.microservices.api.core.review.Review
import se.magnus.util.http.ServiceUtil


@RestController
class ProductCompositeServiceImpl @Autowired constructor(
    private val serviceUtil: ServiceUtil, integration: ProductCompositeIntegration
) : ProductCompositeService {
    private val integration: ProductCompositeIntegration

    init {
        this.integration = integration
    }

    override fun getProduct(productId: Int): ProductAggregate {
        val product: Product = integration.getProduct(productId)
        val recommendations: List<Recommendation> = integration.getRecommendations(productId)
        val reviews: List<Review> = integration.getReviews(productId)
        return createProductAggregate(product, recommendations, reviews, serviceUtil.serviceAddress!!)
    }

    private fun createProductAggregate(
        product: Product,
        recommendations: List<Recommendation>,
        reviews: List<Review>,
        serviceAddress: String
    ): ProductAggregate {

        // 1. Setup product info
        val productId: Int = product.productId
        val name: String = product.name
        val weight: Int = product.weight

        // 2. Copy summary recommendation info, if available
        val recommendationSummaries: List<RecommendationSummary> =
            recommendations.map { RecommendationSummary(it.recommendationId, it.author, it.rate) }

        // 3. Copy summary review info, if available
        val reviewSummaries: List<ReviewSummary> =
            reviews.map{ReviewSummary(it.reviewId, it.author, it.subject)}

        // 4. Create info regarding the involved microservices addresses
        val productAddress: String = product.serviceAddress
        val reviewAddress = if (reviews.isNotEmpty()) reviews[0].serviceAddress else ""
        val recommendationAddress = if (recommendations.isNotEmpty()) recommendations[0].serviceAddress else ""
        val serviceAddresses = ServiceAddresses(serviceAddress, productAddress, reviewAddress, recommendationAddress)
        return ProductAggregate(productId, name, weight, recommendationSummaries, reviewSummaries, serviceAddresses)
    }
}
