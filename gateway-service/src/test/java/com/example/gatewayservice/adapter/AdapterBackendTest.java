package com.example.gatewayservice.adapter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RestClientTest(AdapterBackend.class)
public class AdapterBackendTest {

    @Autowired
    private MockRestServiceServer server;

    @Autowired
    private AdapterBackend adapterBackend;

    @Value("${backend.url}")
    private String backendUrl;

    @Test
    void getRequests() {

        server.expect(requestTo(backendUrl + "/v1/request/count"))
                .andRespond(withSuccess("1", MediaType.APPLICATION_JSON));

        assertThat(adapterBackend.getRequests()).isEqualTo("1");
    }
}