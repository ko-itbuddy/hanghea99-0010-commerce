package com.hanghea99.commerce.exception

import org.springframework.http.ResponseEntity
import org.springframework.web.ErrorResponse
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler


@ControllerAdvice
class ControllerExceptionHandler {

    @ExceptionHandler(Exception::class)
    protected fun handleException(ex: Exception?): ResponseEntity<ErrorResponse?>? {
        ex?.printStackTrace()
        return null
    }
}