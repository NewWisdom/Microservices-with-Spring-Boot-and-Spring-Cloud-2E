package se.magnus.microservices.api.core.recommendation

import org.springframework.web.bind.annotation.*

interface RecommendationService {

    /**
     * Sample usage, see below.
     *
     * curl -X POST $HOST:$PORT/recommendation \
     * -H "Content-Type: application/json" --data \
     * '{"productId":123,"recommendationId":456,"author":"me","rate":5,"content":"yada, yada, yada"}'
     *
     * @param body A JSON representation of the new recommendation
     * @return A JSON representation of the newly created recommendation
     */
    @PostMapping("/recommendation")
    fun createRecommendation(@RequestBody body: Recommendation): Recommendation

    /**
     * Sample usage: "curl $HOST:$PORT/recommendation?productId=1".
     *
     * @param productId Id of the product
     * @return the recommendations of the product
     */
    @GetMapping("/recommendation")
    fun getRecommendations(@RequestParam("productId") productId: Int): List<Recommendation>

    /**
     * Sample usage: "curl -X DELETE $HOST:$PORT/recommendation?productId=1".
     *
     * @param productId Id of the product
     */
    @DeleteMapping("/recommendation")
    fun deleteRecommendations(@RequestParam("productId") productId: Int)
}