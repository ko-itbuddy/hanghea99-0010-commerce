package com.hanghea99.commerce.test.api.store

import com.hanghea99.commerce.api.common.comp.impl.StoreManager
import com.hanghea99.commerce.api.common.comp.impl.StoreReader
import com.hanghea99.commerce.api.common.domain.store.StoreVo
import com.hanghea99.commerce.api.store.StoreService
import com.hanghea99.commerce.api.store.domain.GetStoreRequest
import com.hanghea99.commerce.api.store.domain.PostStoreDeleteRequest
import com.hanghea99.commerce.api.store.domain.PostStoreRequest
import com.hanghea99.commerce.api.store.domain.PostStoreUpdateRequest
import io.mockk.mockk
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

import org.mockito.junit.jupiter.MockitoExtension
import java.time.Instant

@ExtendWith(MockitoExtension::class)
class StoreServiceTest {

    val storeManager: StoreManager = mockk()
    val storeReader: StoreReader = mockk()
    val storeService: StoreService = StoreService(storeManager, storeReader)

    @Test
    fun `StoreService postStore`() {
        // GIVEN
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
        //WHEN //THEN
    }

    @Test
    fun `StoreService getStore`() {
        // GIVEN
        val input = GetStoreRequest(
            types = "NAME",
            values = "카카오",
            page = 1,
            count = 10,
            sort = "LATEST"
        )
        //WHEN //THEN
    }

    @Test
    fun `StoreService postStoreUpdate`() {
        // GIVEN
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
        //WHEN //THEN

    }

    @Test
    fun `StoreService postStoreDelete`() {
        // GIVEN
        val input = PostStoreDeleteRequest(
            deleteKeys = listOf(1, 2, 3, 4, 5)
        )
        //WHEN //THEN
    }


}