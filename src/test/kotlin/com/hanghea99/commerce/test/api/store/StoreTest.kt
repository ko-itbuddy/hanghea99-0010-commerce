package com.hanghea99.commerce.test.api.store

import com.fasterxml.jackson.databind.ObjectMapper
import com.hanghea99.commerce.api.common.comp.impl.StoreManager
import com.hanghea99.commerce.api.common.comp.impl.StoreReader
import com.hanghea99.commerce.api.common.domain.store.StoreVo
import com.hanghea99.commerce.api.store.StoreController
import com.hanghea99.commerce.api.store.StoreService
import com.hanghea99.commerce.api.store.domain.PostStoreRequest
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.http.MediaType
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.transaction.annotation.Transactional
import java.time.Instant


@SpringBootTest
@Disabled
@AutoConfigureMockMvc
@Transactional
class StoreTest{

    @Autowired
    lateinit var mockMvc: MockMvc

    @Autowired
    lateinit var storeController: StoreController

    @Autowired
    lateinit var storeService: StoreService

    @Autowired
    lateinit var storeReader: StoreReader

    @Autowired
    lateinit var storeManager: StoreManager

    @Autowired
    lateinit var objectMapper: ObjectMapper



    @Test
    fun `POST apiStore 정상 요청`() {
        // GIVEN
        val request = PostStoreRequest(
            store = StoreVo(
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
        val jsonBody = objectMapper.writeValueAsString(request)

        //WHEN //THEN
        mockMvc.perform(
            MockMvcRequestBuilders.post("/api/store")
                .content(jsonBody)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        ).andExpect(
            MockMvcResultMatchers.status().isOk
        )
    }
}