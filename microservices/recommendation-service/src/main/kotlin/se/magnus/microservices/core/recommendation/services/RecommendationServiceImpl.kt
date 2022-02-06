package se.magnus.microservices.core.recommendation.services

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.RestController
import se.magnus.microservices.api.core.recommendation.Recommendation
import se.magnus.microservices.api.core.recommendation.RecommendationService
import se.magnus.microservices.api.exceptions.InvalidInputException
import se.magnus.util.http.ServiceUtil

@RestController
class RecommendationServiceImpl(
    private val serviceUtil: ServiceUtil
) : RecommendationService {

    override fun getRecommendations(productId: Int): List<Recommendation> {
        if (productId < 1) {
            throw InvalidInputException("Invalid productId: $productId")
        }
        if (productId == 113) {
            LOG.debug("No recommendations found for productId: {}", productId)
            return ArrayList<Recommendation>()
        }
        val list: MutableList<Recommendation> = ArrayList<Recommendation>()
        list.add(Recommendation(productId, 1, "Author 1", 1, "Content 1", serviceUtil.serviceAddress!!))
        list.add(Recommendation(productId, 2, "Author 2", 2, "Content 2", serviceUtil.serviceAddress!!))
        list.add(Recommendation(productId, 3, "Author 3", 3, "Content 3", serviceUtil.serviceAddress!!))
        LOG.debug("/recommendation response size: {}", list.size)
        return list
    }

    companion object {
        private val LOG = LoggerFactory.getLogger(RecommendationServiceImpl::class.java)
    }
}
