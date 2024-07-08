package com.ecommerce.service.customer.cart;

import org.springframework.http.ResponseEntity;

import com.ecommerce.dto.CartItemsDto;
import com.ecommerce.dto.OrderDto;
import com.ecommerce.dto.QuantityChangeProductDto;

public interface CartService {


    ResponseEntity<?> addProductToCart(CartItemsDto cartItemsDto);

    OrderDto getCartByUserId(Long userId);

    OrderDto decreaseProductQuantity(QuantityChangeProductDto quantityChangeProductDto);

    OrderDto increaseProductQuantity(QuantityChangeProductDto quantityChangeProductDto);


}
