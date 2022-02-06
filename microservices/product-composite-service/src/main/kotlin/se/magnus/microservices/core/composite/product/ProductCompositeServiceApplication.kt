package se.magnus.microservices.core.composite.product

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("se.magnus")
class ProductCompositeServiceApplication

fun main(args: Array<String>) {
    runApplication<ProductCompositeServiceApplication>(*args)
}
