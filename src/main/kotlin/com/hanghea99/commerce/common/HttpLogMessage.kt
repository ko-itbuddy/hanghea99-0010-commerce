package com.hanghea99.commerce.common

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.HttpStatus
import org.springframework.web.util.ContentCachingRequestWrapper
import org.springframework.web.util.ContentCachingResponseWrapper
import java.lang.StringBuilder
import java.nio.charset.Charset

data class HttpLogMessage(
    val httpMethod: String,
    val requestUri: String,
    val httpStatus: HttpStatus,
    val clientIp: String,
    val elapsedTime: Double,
    val headers: String?,
    val requestParam: String?,
    val requestBody: String?,
    val responseBody: String?,
) {
    companion object {
        val objectMapper = ObjectMapper()

        fun createInstance(
            requestWrapper: ContentCachingRequestWrapper,
            responseWrapper: ContentCachingResponseWrapper,
            elapsedTime: Double
        ): HttpLogMessage {
            val headerMap = mutableMapOf<String,String>()
            val sb = StringBuilder()
           for( headerName in  requestWrapper.headerNames){
               sb.append("${headerName}=${requestWrapper.getHeader(headerName)} ")
//               headerMap[headerName] = requestWrapper.getHeader(headerName)
           }



            return HttpLogMessage(
                httpMethod = requestWrapper.method,
                requestUri = requestWrapper.requestURI,
                httpStatus = HttpStatus.valueOf(responseWrapper.status),
                clientIp = requestWrapper.remoteAddr,
                elapsedTime = elapsedTime,
//                headers = objectMapper.writeValueAsString(headerMap),
                headers = sb.toString(),
                requestParam = objectMapper.writeValueAsString(requestWrapper.parameterMap),
                requestBody = requestWrapper.contentAsByteArray.toString(charset = Charset.defaultCharset()),
                responseBody = responseWrapper.contentAsByteArray.toString(charset = Charset.defaultCharset()),
            )
        }
    }

    // 이부분은 각자 취향대로 포멧 정하는 것으로,,,
    fun toPrettierLog(): String {
        return """
        |
        |[REQUEST] ${this.httpMethod} ${this.requestUri} ${this.httpStatus} (${this.elapsedTime})
        |>> CLIENT_IP: ${this.clientIp}
        |>> HEADERS: ${this.headers}
        |>> REQUEST_PARAM: ${this.requestParam}
        |>> REQUEST_BODY: ${this.requestBody}
        |>> RESPONSE_BODY: ${this.responseBody}
        """.trimMargin()
    }
}