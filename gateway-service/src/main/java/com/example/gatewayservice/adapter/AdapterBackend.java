package com.example.gatewayservice.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AdapterBackend {

    private static final String REQUESTS_ENDPOINT = "/v1/request/count";

    private final RestTemplate restTemplate;

    @Value("${backend.url}")
    private String backendUrl;

    @Autowired
    public AdapterBackend(RestTemplateBuilder builder) {
        restTemplate = builder.build();
    }

    public String getRequests() {
        ResponseEntity<String> response = restTemplate.getForEntity(backendUrl + REQUESTS_ENDPOINT, String.class);
        return response.getBody();
    }
}
