package com.ecommerce.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ResponseOrderDto {

    private float amount;

    private Date date;

    private String OrderDescription;

    private Long orderId;

}
