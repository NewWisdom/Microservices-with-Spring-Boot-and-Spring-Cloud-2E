package se.magnus.microservices.api.exceptions

class BadRequestException(
    val errorMessage: String?
) : RuntimeException(errorMessage)