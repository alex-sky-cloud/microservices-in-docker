package com.example.gatewayservice.web;

import com.example.gatewayservice.adapter.AdapterBackend;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class EndpointController {

    private final AdapterBackend adapterBackend;

    @Value("${instance.id}")
    private int instanceId;

    @Value("${secret}")
    private String secret;

    @GetMapping("/")
    public String getRequestsCount() {

        String adapterBackendRequests = adapterBackend.getRequests();

        String result = String.format(
                "Number of requests %s (gateway %d, secret %s)",
                adapterBackendRequests,
                instanceId,
                secret
        );
        log.info("Handling count request. Result {}", result);

        return result;
    }
}
