package com.ecommerce.service.customer.customerorder;

import java.util.List;
import java.util.UUID;

import com.ecommerce.dto.OrderDto;
import com.ecommerce.dto.PlaceOrderDto;

public interface CustomerOrderService {

    OrderDto PlaceOrder(PlaceOrderDto placeOrderDto);

    List<OrderDto> getMyPlacedOrders(Long userId);

    OrderDto searchOrderByTrackingId(UUID trackingId);

}
