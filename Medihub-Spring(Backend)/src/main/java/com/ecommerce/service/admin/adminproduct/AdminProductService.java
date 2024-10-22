package com.ecommerce.service.admin.adminproduct;


import java.io.IOException;
import java.util.List;

import com.ecommerce.dto.ProductDto;
import com.ecommerce.dto.SecondProductDto;
import com.ecommerce.entity.Product;

public interface AdminProductService {

    Product addProduct(SecondProductDto secondProductDto) throws IOException;

    List<ProductDto> getAllProducts();

    ProductDto getProductById(Long productId);

    ProductDto updateProduct(Long productId, ProductDto productDto) throws IOException;

    boolean deleteProduct(Long productId);

    List<ProductDto> searchProductByTitle(String title);

}
