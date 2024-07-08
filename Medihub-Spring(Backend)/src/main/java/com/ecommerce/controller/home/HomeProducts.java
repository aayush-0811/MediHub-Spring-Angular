package com.ecommerce.controller.home;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.dto.CompleteProductDetailDto;
import com.ecommerce.dto.ProductDto;
import com.ecommerce.service.homeproductservice.ProductService;

@RestController
@RequestMapping
public class HomeProducts {
    @Autowired
    private ProductService productService;

    @GetMapping("/home")
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }
    
    @GetMapping("/product/{productId}")
    public ResponseEntity<CompleteProductDetailDto> getProductDetailById(@PathVariable Long productId) {
        CompleteProductDetailDto completeProductDetailDto = productService.getCompleteProductDetailById(productId);
        if (completeProductDetailDto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(completeProductDetailDto);
    }
    @GetMapping("/search/{title}")
    public ResponseEntity<List<ProductDto>> searchProductByTitle(@PathVariable("title") String title) {
        List<ProductDto> productDtos = productService.searchProductByTitle(title);
        return ResponseEntity.ok(productDtos);
    }

//    @GetMapping("/search")
//    public List<ProductDto> getProductsByName(@RequestParam String name) {
//        return productService.getProductsByName(name);
//    }
//
//    @GetMapping("/category/{categoryId}")
//    public List<ProductDto> getProductsByCategoryId(@PathVariable Long categoryId) {
//        return productService.getProductsByCategoryId(categoryId);
//    }
}

