package se.magnus.microservices.api.composite.product

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

interface ProductCompositeService {

    /**
     * Sample usage: "curl $HOST:$PORT/product-composite/1".
     *
     * @param productId Id of the product
     * @return the composite product info, if found, else null
     */
    @GetMapping("/product-composite/{productId}")
    fun getProduct(@PathVariable productId: Int): ProductAggregate?
}