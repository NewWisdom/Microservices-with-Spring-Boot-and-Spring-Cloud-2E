package se.magnus.microservices.api.core.recommendation

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import se.magnus.microservices.api.core.recommendation.Recommendation

interface RecommendationService {

    /**
     * Sample usage: "curl $HOST:$PORT/recommendation?productId=1".
     *
     * @param productId Id of the product
     * @return the recommendations of the product
     */
    @GetMapping("/recommendation")
    fun getRecommendations(@RequestParam("productId") productId: Int): List<Recommendation>
}