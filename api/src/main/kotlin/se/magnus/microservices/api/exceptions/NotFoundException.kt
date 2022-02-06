package se.magnus.microservices.api.exceptions

class NotFoundException(
    val errorMessage: String?
) : RuntimeException(errorMessage)