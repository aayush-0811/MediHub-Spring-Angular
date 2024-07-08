package com.ecommerce.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class SecondProductDto {

    private Long id;

    private String name;

    private String rating;

    private Long availableQuantity;

    private Long price;

    private String description;

    private MultipartFile img;

    private byte[] returnedImg;

    private String categoryId;

}
