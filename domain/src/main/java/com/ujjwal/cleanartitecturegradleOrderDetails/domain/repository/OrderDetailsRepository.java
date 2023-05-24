package com.ujjwal.cleanartitecturegradleOrderDetails.domain.repository;

import com.ujjwal.cleanartitecturegradleOrderDetails.domain.entity.OrderResponse;
import reactor.core.publisher.Flux;

public interface OrderDetailsRepository {
    public Flux<OrderResponse> getActivityPlanByOrderId(final String orderId);
}
