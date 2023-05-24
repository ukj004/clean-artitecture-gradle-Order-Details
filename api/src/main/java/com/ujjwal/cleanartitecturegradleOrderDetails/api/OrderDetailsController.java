package com.ujjwal.cleanartitecturegradleOrderDetails.api;

import com.ujjwal.cleanartitecturegradleOrderDetails.domain.entity.OrderResponse;
import com.ujjwal.cleanartitecturegradleOrderDetails.domain.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class OrderDetailsController {

    @Autowired
    private OrderDetailsService orderDetailsService;

    @GetMapping("/getOrderDetails")
    @ResponseStatus(HttpStatus.OK)
    public Flux<OrderResponse> getOrderDetails() {
        return Flux.just(new OrderResponse()) ;
                //orderDetailsService.getOrderDetails();
        }
}
