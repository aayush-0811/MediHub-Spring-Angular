package com.ecommerce.service.customer.review;


import java.io.IOException;

import com.ecommerce.dto.OrderedProductsResponseDto;
import com.ecommerce.dto.ReviewDto;

public interface ReviewService {


    OrderedProductsResponseDto getOrderedProductsDetailsByOrderId(Long orderId);

    ReviewDto giveReview(ReviewDto reviewDto) throws IOException;
}
