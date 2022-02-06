package se.magnus.microservices.api.exceptions

class InvalidInputException(
    val errorMessage: String?
) : RuntimeException(errorMessage)