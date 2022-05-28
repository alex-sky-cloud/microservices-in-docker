package com.counter.counterservice.controller;

import com.counter.counterservice.service.CounterRequestsServer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CounterRequestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getRequestsCount() throws Exception {

        mockMvc.perform(get("/v1/request/count"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("1"));
    }
}