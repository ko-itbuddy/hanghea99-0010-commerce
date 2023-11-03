package com.hanghea99.commerce.api.manager

import com.hanghea99.commerce.api.common.ResultCodeMsg
import com.hanghea99.commerce.api.common.comp.impl.ManagerReader
import com.hanghea99.commerce.api.common.comp.impl.SellerManager
import com.hanghea99.commerce.api.common.domain.PostNullResultResponse
import com.hanghea99.commerce.api.common.domain.TokenResponse
import com.hanghea99.commerce.api.common.domain.TokenVo
import com.hanghea99.commerce.api.manager.domain.PostManagerLoginRequest
import com.hanghea99.commerce.api.manager.domain.PostManagerSellerPermitRequest
import com.hanghea99.commerce.database.entity.ManagerEntity
import com.hanghea99.commerce.database.entity.QManagerEntity
import com.hanghea99.commerce.database.entity.SellerEntity
import com.querydsl.core.BooleanBuilder
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody

@Service
class ManagerService(
    val managerReader: ManagerReader, val sellerManager: SellerManager
) {
    val qManagerEntity: QManagerEntity = QManagerEntity("m1")

    @Throws(Exception::class)
    fun postManagerLogin(@RequestBody postManagerLoginRequest: PostManagerLoginRequest): TokenResponse {

        val manager: ManagerEntity? = managerReader.read(
            where = BooleanBuilder().and(qManagerEntity.managerId.eq(postManagerLoginRequest.id))
                .and(qManagerEntity.password.eq(postManagerLoginRequest.password))
        )
        val managerId = "seller"


        return TokenResponse(
            ResultCodeMsg.SUCCESS, result = TokenVo(
                accessToken = "TEST_ACCESS_TOKEN@@$managerId",
                refreshToken = "TEST_REFRESH_TOKEN@@$managerId",
            )
        )
    }

    @Throws(Exception::class)
    fun postManagerSellerPermit(@RequestBody postManagerSellerPermitRequest: PostManagerSellerPermitRequest): PostNullResultResponse {

        sellerManager.update(postManagerSellerPermitRequest.sellers.map { sellerVo ->
            SellerEntity(
                sellerId = sellerVo.sellerId,
                status = sellerVo.status,
            )
        })

        return PostNullResultResponse(
            resultCodeMsg = ResultCodeMsg.SUCCESS
        )
    }
}