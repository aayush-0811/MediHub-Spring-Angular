package com.ecommerce.dto;

import java.util.List;

import lombok.Data;

@Data
public class OrderedProductsResponseDto {

    private List<OrderedProductDetails> orderedProductDetailsList;

    private Long orderAmount;

}
