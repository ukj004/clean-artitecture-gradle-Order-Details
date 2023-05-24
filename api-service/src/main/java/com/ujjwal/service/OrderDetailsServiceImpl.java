package com.ujjwal.service;

import com.ujjwal.cleanartitecturegradleOrderDetails.domain.entity.OrderResponse;
import com.ujjwal.cleanartitecturegradleOrderDetails.domain.exception.OrderDetailsInternalServerException;
import com.ujjwal.cleanartitecturegradleOrderDetails.domain.exception.OrderNotFoundException;
import com.ujjwal.cleanartitecturegradleOrderDetails.domain.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

    @Autowired
    ReactiveMongoTemplate reactiveMongoTemplate;

    @Override
    public Flux<OrderResponse> getOrderDetails() {

        return reactiveMongoTemplate.findAll(OrderResponse.class)
                .onErrorResume(
                        ex -> Mono.error(
                                        new OrderDetailsInternalServerException("Internal server exception while retrieving order details")))
                .switchIfEmpty(
                        Mono.error(
                                new OrderNotFoundException("Order Details Not Found")));
    }
}
