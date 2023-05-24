package com.ujjwal.cleanartitecturegradleOrderDetails.domain.service;

import com.ujjwal.cleanartitecturegradleOrderDetails.domain.entity.OrderResponse;
import reactor.core.publisher.Flux;

public interface OrderDetailsService {

    Flux<OrderResponse> getOrderDetails();
}
