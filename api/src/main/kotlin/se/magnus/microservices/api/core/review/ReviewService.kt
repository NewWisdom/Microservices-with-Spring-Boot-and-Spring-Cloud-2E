package se.magnus.microservices.api.core.review

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import se.magnus.microservices.api.core.review.Review

interface ReviewService {

    /**
     * Sample usage: "curl $HOST:$PORT/review?productId=1".
     *
     * @param productId Id of the product
     * @return the reviews of the product
     */
    @GetMapping("/review")
    fun getReviews(@RequestParam("productId") productId: Int): List<Review>
}