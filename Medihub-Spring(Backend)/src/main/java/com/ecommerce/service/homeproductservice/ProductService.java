package com.ecommerce.service.homeproductservice;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dto.CompleteProductDetailDto;
import com.ecommerce.dto.ProductDto;
import com.ecommerce.entity.FAQ;
import com.ecommerce.entity.Product;
import com.ecommerce.entity.Reviews;
import com.ecommerce.repo.FAQRepository;
import com.ecommerce.repo.ProductRepository;
import com.ecommerce.repo.ReviewRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private  FAQRepository faqRepository;

    @Autowired
    private  ReviewRepository reviewRepository;

    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream()
            .map(Product::getProductDto)
            .collect(Collectors.toList());
    }
    
    public CompleteProductDetailDto getCompleteProductDetailById(Long productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        List<FAQ> faqList = faqRepository.findAllByProductId(productId);
        List<Reviews> reviewsList = reviewRepository.findAllByProductId(productId);
        if (optionalProduct.isPresent()) {
            CompleteProductDetailDto completeProductDetailDto = new CompleteProductDetailDto();
            completeProductDetailDto.setProductDto(optionalProduct.get().getProductDto());
//            completeProductDetailDto.setFaqDtoList(faqList.stream().map(FAQ::getFAQDto).collect(Collectors.toList()));
//            completeProductDetailDto.setReviewDtoList(reviewsList.stream().map(Reviews::getReviewDto).collect(Collectors.toList()));
            return completeProductDetailDto;
        }
        return null;
    }
    
    public List<ProductDto> searchProductByTitle(String title) {
        return productRepository.findAllByNameContaining(title).stream().map(Product::getProductDto).collect(Collectors.toList());
    }

//    public List<ProductDto> getProductsByName(String name) {
//        return productRepository.findAllByNameContaining(name).stream()
//            .map(Product::getProductDto)
//            .collect(Collectors.toList());
//    }
//
//    public List<ProductDto> getProductsByCategoryId(Long categoryId) {
//        return productRepository.findAllByCategoryId(categoryId).stream()
//            .map(Product::getProductDto)
//            .collect(Collectors.toList());
//    }
}

