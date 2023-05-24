package com.ujjwal.cleanartitecturegradleOrderDetails.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderResponse {
    private String orderId;
    private String productName;
    private BigInteger productPrice;
    private String productCompany;
}
