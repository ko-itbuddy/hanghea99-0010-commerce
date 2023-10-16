package com.hanghea99.commerce.api.manager

import com.hanghea99.commerce.api.common.domain.PostNullResultResponse
import com.hanghea99.commerce.api.common.domain.TokenResponse
import com.hanghea99.commerce.api.manager.domain.PostManagerLoginRequest
import com.hanghea99.commerce.api.manager.domain.PostManagerSellerPermitRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/manager")
class ManagerController(
    val managerService: ManagerService
) {

    @PostMapping("/login")
    @Throws(Exception::class)
    fun postManagerLogin(@RequestBody postManagerLoginRequest: PostManagerLoginRequest): TokenResponse {
        return managerService.postManagerLogin(postManagerLoginRequest)
    }

    @PostMapping("/seller-permit")
    @Throws(Exception::class)
    fun postManagerSellerPermit(@RequestBody postManagerSellerPermitRequest: PostManagerSellerPermitRequest): PostNullResultResponse {
        return managerService.postManagerSellerPermit(postManagerSellerPermitRequest)
    }
}