package com.ujjwal.cleanartitecturegradleOrderDetails.persistence;


import com.ujjwal.cleanartitecturegradleOrderDetails.domain.entity.OrderResponse;
import com.ujjwal.cleanartitecturegradleOrderDetails.domain.exception.OrderDetailsInternalServerException;
import com.ujjwal.cleanartitecturegradleOrderDetails.domain.repository.OrderDetailsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Criteria;

@Slf4j
@Component
public class OrderDetailsRepositoryImpl implements OrderDetailsRepository {

    @Autowired
    ReactiveMongoTemplate reactiveMongoTemplate;

    @Override
    public Flux<OrderResponse> getActivityPlanByOrderId(String orderId) {
        log.info("Retrieving ActivityPlan from Database with for order Id : {}", orderId);
        Query query = Query.query(Criteria.where("orderId").is(orderId));
        return reactiveMongoTemplate.find(query, OrderResponse.class).onErrorResume(
                ex ->
                        Mono.error(
                                new OrderDetailsInternalServerException(
                                        "Error occurred while retrieving ActivityPlan with order id ::"  + orderId)));
    }

}
