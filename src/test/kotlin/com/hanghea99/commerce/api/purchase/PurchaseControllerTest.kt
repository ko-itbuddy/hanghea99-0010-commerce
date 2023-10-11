package com.hanghea99.commerce.api.purchase

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.util.LinkedMultiValueMap

@WebMvcTest(PurchaseController::class)
class PurchaseControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Autowired
    lateinit var objectMapper: ObjectMapper

    @MockBean
    lateinit var purchaseService: PurchaseService

    @Test
    fun getPurchase() {

        //GIVEN
        val queryParams = LinkedMultiValueMap<String, String>()

        queryParams.add("types", "NAME")
        queryParams.add("values", "테스트")
        queryParams.add("page", "1")
        queryParams.add("count", "10")
        queryParams.add("sort", "LATEST")

        //WHEN //THEN
        mockMvc.perform(
            get("/api/purchase")
                .queryParams(queryParams)
        ).andExpectAll(
            MockMvcResultMatchers.status().isOk
        ).andDo(
            MockMvcResultHandlers.print()
        )
    }

    @Test
    fun getPurchaseService() {
    }
}