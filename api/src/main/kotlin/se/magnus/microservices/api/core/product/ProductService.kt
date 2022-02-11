package se.magnus.microservices.api.core.product

import org.springframework.web.bind.annotation.*


interface ProductService {

    /**
     * Sample usage, see below.
     *
     * curl -X POST $HOST:$PORT/product \
     * -H "Content-Type: application/json" --data \
     * '{"productId":123,"name":"product 123","weight":123}'
     *
     * @param body A JSON representation of the new product
     * @return A JSON representation of the newly created product
     */
    @PostMapping("/product")
    fun createProduct(@RequestBody body: Product?): Product

    /**
     * Sample usage: "curl $HOST:$PORT/product/1".
     *
     * @param productId Id of the product
     * @return the product, if found, else null
     */
    @GetMapping("/product/{productId}")
    fun getProduct(@PathVariable productId: Int): Product

    /**
     * Sample usage: "curl -X DELETE $HOST:$PORT/product/1".
     *
     * @param productId Id of the product
     */
    @DeleteMapping("/product/{productId}")
    fun deleteProduct(@PathVariable productId: Int)
}