package com.ecommerce.dto;

import java.util.List;

import lombok.Data;

@Data
public class CompleteProductDetailDto {

    private ProductDto productDto;

    private List<FAQDto> faqDtoList;

    private List<ReviewDto> reviewDtoList;

}
