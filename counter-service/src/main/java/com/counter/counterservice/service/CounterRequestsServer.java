package com.counter.counterservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

import static net.logstash.logback.marker.Markers.append;

@Service
@Slf4j
public class CounterRequestsServer {

    public Long increaseCounter(AtomicLong counter) {

        long result = counter.incrementAndGet();

        log.info(append("Request", result), "Request counter - increased.");

        return result;
    }
}
