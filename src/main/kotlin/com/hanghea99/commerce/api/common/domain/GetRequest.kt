package com.hanghea99.commerce.api.common.domain

import com.hanghea99.commerce.api.common.domain.core.CoreRequest
import org.springframework.util.StringUtils
import java.util.*

open class GetRequest(
    open val types: String?,
    open val values: String?,
    open val page: Long?,
    open val count: Long?,
    open val sort: String?,
):CoreRequest() {
    companion object {
        val TYPES_VALUES_DIVIDER = "@@"

        @Throws(Exception::class)
        fun getTypesValues(getRequest: GetRequest): TypesValues {
            var types = arrayOf<String>()
            var values = arrayOf<String>()
            if (StringUtils.hasText(getRequest.types) && StringUtils.hasText(getRequest.types)) {
                types = getRequest.types!!.split(TYPES_VALUES_DIVIDER)
                    .dropLastWhile { it.isEmpty() }
                    .toTypedArray()
                values = getRequest.values!!.split(TYPES_VALUES_DIVIDER)
                    .dropLastWhile { it.isEmpty() }
                    .toTypedArray()
            }
            if (types.size != values.size) {
                throw Exception()
            }

            return TypesValues(
                values = Arrays.asList(*types),
                types = Arrays.asList(*values),
                length = types.size
            )
        }
    }
}