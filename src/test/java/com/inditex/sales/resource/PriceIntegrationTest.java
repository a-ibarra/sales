package com.inditex.sales.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PriceIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @ParameterizedTest
    @CsvFileSource(resources = "/prices_tests_cases.csv", numLinesToSkip = 1)
    void testKeyValuePairs(String applyDate, String price) throws Exception {
        PriceFilterRequest filterRequest = new PriceFilterRequest(1L, 35455L, LocalDateTime.parse(applyDate));

        mockMvc.perform(post("/api/v1/prices/search")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(filterRequest)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.price").value(price))
            .andDo(MockMvcResultHandlers.print());
    }
}