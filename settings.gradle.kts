rootProject.name = "microservice-practice"

include(
    ":api",
    ":util",
    ":microservices:product-composite-service",
    ":microservices:review-service",
    ":microservices:recommendation-service",
    ":microservices:product-service"
)
