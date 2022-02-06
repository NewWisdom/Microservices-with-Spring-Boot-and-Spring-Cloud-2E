package se.magnus.microservices.api.core.product

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import se.magnus.microservices.api.core.product.Product


interface ProductService {

    /**
     * Sample usage: "curl $HOST:$PORT/product/1".
     *
     * @param productId Id of the product
     * @return the product, if found, else null
     */
    @GetMapping("/product/{productId}")
    fun getProduct(@PathVariable productId: Int): Product
}