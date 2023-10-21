package com.hanghea99.commerce.common

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.MDC
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import org.springframework.web.util.ContentCachingRequestWrapper
import org.springframework.web.util.ContentCachingResponseWrapper
import java.util.*

@Component
class ReqResLogginFilter : OncePerRequestFilter() {
    private val log = logger

    companion object {
        const val REQUEST_ID = "request_id"
    }

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val cachingRequestWrapper = ContentCachingRequestWrapper(request)
        val cachingResponseWrapper = ContentCachingResponseWrapper(response)
        val requestId = UUID.randomUUID().toString().substring(0, 8)

        MDC.put(REQUEST_ID, requestId)// -> MCD 저장시 멀티 스레드 스레드가 바뀌면서 MDC가 날아갈수 있다 req id 꼬일수 있음
        // 올바르게 잘 전달 되는지 테스트 및 확인 필요


        val startTime = System.currentTimeMillis()
        filterChain.doFilter(cachingRequestWrapper, cachingResponseWrapper)
        val end = System.currentTimeMillis()

        try {
            log.info(HttpLogMessage.createInstance(
                requestWrapper = cachingRequestWrapper,
                responseWrapper = cachingResponseWrapper,
                elapsedTime = (end - startTime) / 1000.0
            ).toPrettierLog())

            cachingResponseWrapper.copyBodyToResponse()
        } catch (e: Exception) {
            log.error("Logging 실패", e)
        }

        MDC.remove(REQUEST_ID)
    }
}