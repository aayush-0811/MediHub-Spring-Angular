package com.ecommerce.service.admin.adminorder;


import java.util.List;

import com.ecommerce.dto.AnalyticsResponse;
import com.ecommerce.dto.OrderDto;

public interface AdminOrderService {

    List<OrderDto> getAllPlacedOrders();
    OrderDto changeOrderStatus(Long orderId, String status);

    AnalyticsResponse calculateAnalytics();
}
