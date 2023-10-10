package com.hanghea99.commerce.test.api.store

import com.hanghea99.commerce.api.common.ResultCodeMsg
import com.hanghea99.commerce.api.common.comp.impl.StoreManager
import com.hanghea99.commerce.api.common.comp.impl.StoreReader
import com.hanghea99.commerce.api.common.domain.PostNullResultResponse
import com.hanghea99.commerce.api.common.domain.store.StoreVo
import com.hanghea99.commerce.api.store.StoreService
import com.hanghea99.commerce.api.store.domain.*
import io.mockk.every
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.time.Instant

@ExtendWith(MockKExtension::class)
class StoreEntityServiceTest {

    val storeManager: StoreManager = mockk<StoreManager>()
    val storeReader: StoreReader = mockk<StoreReader>()

    val storeService: StoreService = mockk<StoreService>()


    @Test
    fun `StoreService postStore`() {
        val input = PostStoreRequest(
            store = StoreVo(
                storeKey = 0,
                status = "G",
                name = "hello",
                description = "hello description",
                shippingAndRefundPolicy = "",
                businessForDistanceSellingNumber = "",
                informationManagerName = "",
                informationManagerEmail = "",
                modDt = Instant.now(),
                regDt = Instant.now(),
            )
        )
        this.storeService
        every { storeService.postStore(input) } answers {
            PostStoreResponse(
                resultCodeMsg = ResultCodeMsg.SUCCESS,
                result = StoreVo(
                    storeKey = 0,
                    status = "G",
                    name = "hello",
                    description = "hello description",
                    shippingAndRefundPolicy = "",
                    businessForDistanceSellingNumber = "",
                    informationManagerName = "",
                    informationManagerEmail = "",
                    modDt = Instant.now(),
                    regDt = Instant.now(),
                ),
            )
        }

    }

    @Test
    fun `StoreService getStore`() {

        val input = GetStoreRequest(
            types = "NAME",
            values = "카카오",
            page = 1,
            count = 10,
            sort = "LATEST"
        )

        every { storeService.getStore(input) } answers {
            GetStoreResponse(
                code = ResultCodeMsg.SUCCESS.code,
                msg = ResultCodeMsg.SUCCESS.msg,
                result = GetStoreVo(
                    totalCount = 100,
                    stores = listOf(
                        StoreVo(
                            storeKey = 0,
                            status = "G",
                            name = "hello",
                            description = "hello description",
                            shippingAndRefundPolicy = "",
                            businessForDistanceSellingNumber = "",
                            informationManagerName = "",
                            informationManagerEmail = "",
                            modDt = Instant.now(),
                            regDt = Instant.now(),
                        ),
                        StoreVo(
                            storeKey = 0,
                            status = "G",
                            name = "hello",
                            description = "hello description",
                            shippingAndRefundPolicy = "",
                            businessForDistanceSellingNumber = "",
                            informationManagerName = "",
                            informationManagerEmail = "",
                            modDt = Instant.now(),
                            regDt = Instant.now(),
                        )
                    )
                )
            )
        }
    }

    @Test
    fun `StoreService postStoreUpdate`() {

        val input = PostStoreUpdateRequest(
            store = StoreVo(
                storeKey = 1,
                status = "G",
                name = "hello",
                description = "hello description",
                shippingAndRefundPolicy = "",
                businessForDistanceSellingNumber = "",
                informationManagerName = "",
                informationManagerEmail = "",
                modDt = Instant.now(),
                regDt = Instant.now(),
            )
        )

        every { storeService.postStoreUpdate(input) } answers {
            PostNullResultResponse(ResultCodeMsg.SUCCESS)
        }

    }

    @Test
    fun `StoreService postStoreDelete`() {

        val input = PostStoreDeleteRequest(
            deleteKeys = listOf(1, 2, 3, 4, 5)
        )

        every { storeService.postStoreDelete(input) } answers {
            PostNullResultResponse(ResultCodeMsg.SUCCESS)
        }
    }


}