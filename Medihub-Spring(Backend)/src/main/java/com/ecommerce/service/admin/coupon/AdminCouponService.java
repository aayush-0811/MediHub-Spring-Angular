package com.ecommerce.service.admin.coupon;


import java.util.List;

import com.ecommerce.entity.Coupon;

public interface AdminCouponService {

    Coupon createCoupon(Coupon coupon);

    List<Coupon> getAllCoupons();
}
