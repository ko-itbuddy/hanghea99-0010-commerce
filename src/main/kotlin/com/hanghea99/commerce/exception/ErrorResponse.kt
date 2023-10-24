package com.hanghea99.commerce.exception

import org.springframework.validation.BindingResult
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException
import java.util.stream.Collectors
import java.util.ArrayList;

class ErrorResponse {
    private var message: String
    private var status: Int
    private var errors: List<FieldError>
    private var code: String

    private constructor(code: ErrorCode, errors: List<FieldError>) {
        this.message = code.message
        this.status = code.status
        this.errors = errors
        this.code = code.code
    }

    private constructor(code: ErrorCode) {
        this.message = code.message
        this.status = code.status
        this.code = code.code
        this.errors = ArrayList()
    }
    class FieldError private constructor(
        private val field: String,
        private val value: String,
        private val reason: String?
    ) {
        companion object {
            fun of(field: String, value: String, reason: String): List<FieldError> {
                val fieldErrors: MutableList<FieldError> = ArrayList()
                fieldErrors.add(FieldError(field, value, reason))
                return fieldErrors
            }
            fun of(bindingResult: BindingResult): List<FieldError> {
                val fieldErrors: List<org.springframework.validation.FieldError> = bindingResult.getFieldErrors()
                return fieldErrors.stream()
                    .map { error ->
                        FieldError(
                            error.field,
                            if (error.rejectedValue == null) "" else error.rejectedValue.toString(),
                            error.defaultMessage
                        )
                    }
                    .collect(Collectors.toList())
            }
        }
    }

    companion object {
        fun of(code: ErrorCode, bindingResult: BindingResult): ErrorResponse {
            return ErrorResponse(code, FieldError.of(bindingResult))
        }

        fun of(code: ErrorCode): ErrorResponse {
            return ErrorResponse(code)
        }

        fun of(code: ErrorCode, errors: List<FieldError>): ErrorResponse {
            return ErrorResponse(code, errors)
        }

        fun of(e: MethodArgumentTypeMismatchException): ErrorResponse {
            val value = if (e.getValue() == null) "" else e.getValue().toString()
            val errors = FieldError.of(e.getName(), value, e.getErrorCode())
            return ErrorResponse(ErrorCode.INVALID_TYPE_VALUE, errors)
        }
    }
}