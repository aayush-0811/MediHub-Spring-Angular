package com.ecommerce.service.customer.product;

import java.util.List;

import com.ecommerce.dto.CategoryDto;
import com.ecommerce.dto.CompleteProductDetailDto;
import com.ecommerce.dto.ProductDto;

public interface CustomerProductService {

    List<CategoryDto> getAllCategories();

    List<ProductDto> searchProductByTitle(String title);

    List<ProductDto> getAllProducts();

    List<ProductDto> getProductsByCategory(Long categoryId);

    CompleteProductDetailDto getCompleteProductDetailById(Long productId);
}
