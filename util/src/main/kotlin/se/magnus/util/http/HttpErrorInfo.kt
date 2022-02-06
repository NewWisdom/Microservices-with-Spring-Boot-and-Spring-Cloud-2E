package se.magnus.util.http

import org.springframework.http.HttpStatus
import java.time.ZonedDateTime

class HttpErrorInfo(
    val timestamp: ZonedDateTime = ZonedDateTime.now(),
    val path: String,
    val httpStatus: HttpStatus,
    val message: String?
)