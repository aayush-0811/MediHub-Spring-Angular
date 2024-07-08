package com.ecommerce.service.customer.wishlist;

import java.util.List;

import com.ecommerce.dto.WishlistDto;

public interface WishlistService {

    WishlistDto addProductToWishlist(WishlistDto wishlistDto);

    List<WishlistDto> getWishlistByUserId(Long userId);
}
