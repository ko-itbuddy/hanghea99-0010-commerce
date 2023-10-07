package com.hanghea99.commerce.test.api.store

import com.fasterxml.jackson.databind.ObjectMapper
import com.hanghea99.commerce.api.common.domain.HeaderDomain
import com.hanghea99.commerce.api.common.domain.store.StoreVo
import com.hanghea99.commerce.api.store.StoreController
import com.hanghea99.commerce.api.store.StoreService
import com.hanghea99.commerce.api.store.domain.PostStoreRequest
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import java.time.Instant

@WebMvcTest(StoreController::class)
class StoreControllerTest {
    @Autowired
    lateinit var mockMvc: MockMvc
    @Autowired
    lateinit var objectMapper: ObjectMapper

    @MockBean
    lateinit var storeService: StoreService


    @Test
    fun `POST apiStore 정상 요청`() {
        // GIVEN
        val request = PostStoreRequest(
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
        val jsonBody = objectMapper.writeValueAsString(request)

        //WHEN //THEN
        mockMvc.perform(
            post("/api/store").content(jsonBody).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        ).andExpect(
            MockMvcResultMatchers.status().isOk
        )
    }



    @Test
    fun `GET apiStore 정상 요청`() {
        // GIVEN

        //WHEN //THEN
        mockMvc.perform(
            get("/api/store")
        ).andExpectAll(
            MockMvcResultMatchers.status().isOk
        ).andDo(
            MockMvcResultHandlers.print()
        )
    }


}