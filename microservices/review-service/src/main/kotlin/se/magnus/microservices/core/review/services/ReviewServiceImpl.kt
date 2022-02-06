package se.magnus.microservices.core.review.services

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.RestController
import se.magnus.microservices.api.core.review.Review
import se.magnus.microservices.api.core.review.ReviewService
import se.magnus.microservices.api.exceptions.InvalidInputException
import se.magnus.util.http.ServiceUtil

@RestController
class ReviewServiceImpl(
    private val serviceUtil: ServiceUtil
) : ReviewService {
    override fun getReviews(productId: Int): List<Review> {
        if (productId < 1) {
            throw InvalidInputException("Invalid productId: $productId")
        }
        if (productId == 213) {
            LOG.debug("No reviews found for productId: {}", productId)
            return ArrayList<Review>()
        }
        val list: MutableList<Review> = ArrayList<Review>()
        list.add(Review(productId, 1, "Author 1", "Subject 1", "Content 1", serviceUtil.serviceAddress!!))
        list.add(Review(productId, 2, "Author 2", "Subject 2", "Content 2", serviceUtil.serviceAddress!!))
        list.add(Review(productId, 3, "Author 3", "Subject 3", "Content 3", serviceUtil.serviceAddress!!))
        LOG.debug("/reviews response size: {}", list.size)
        return list
    }

    companion object {
        private val LOG = LoggerFactory.getLogger(ReviewServiceImpl::class.java)
    }
}
