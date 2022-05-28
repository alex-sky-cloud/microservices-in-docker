package com.counter.counterservice.controller;

import com.counter.counterservice.service.CounterRequestsServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@Slf4j
public class CounterRequestController {

    private final AtomicLong counter;

    private final CounterRequestsServer counterRequestsServer;

    public CounterRequestController(CounterRequestsServer counterRequestsServer) {
        this.counterRequestsServer = counterRequestsServer;
        this.counter = new AtomicLong();
    }

    @GetMapping("/v1/request/count")
    public Long getRequestsCount() {

        System.out.println("___________________");
        return counterRequestsServer.increaseCounter(counter);
    }
}
