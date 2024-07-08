package com.ecommerce.service.customer.product;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ecommerce.dto.CompleteProductDetailDto;
import com.ecommerce.dto.ProductDto;
import com.ecommerce.entity.Product;
import com.ecommerce.repo.CategoryRepository;
import com.ecommerce.repo.FAQRepository;
import com.ecommerce.repo.ProductRepository;
import com.ecommerce.repo.ReviewRepository;

class CustomerProductServiceImplTest {

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private FAQRepository faqRepository;

    @Mock
    private ReviewRepository reviewRepository;

    @InjectMocks
    private CustomerProductServiceImpl customerProductService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllProducts() {
        // Given
        Product product1 = new Product();
        product1.setId(1L);
        product1.setName("Cetaphil");
        product1.setPrice(300L);
        
        Product product2 = new Product();
        product2.setId(2L);
        product2.setName("Product2");
        product2.setPrice(200L);

        when(productRepository.findAll()).thenReturn(Arrays.asList(product1, product2));

        // When
        List<ProductDto> products = customerProductService.getAllProducts();

        // Then
        assertEquals(2, products.size());
        assertEquals("Product1", products.get(0).getName());
        assertEquals("Product2", products.get(1).getName());
    }

//    @Test
//    void testSearchProductByTitle() {
//        // Given
//        String title = "Product";
//        Product product = new Product();
//        product.setId(1L);
//        product.setName("Product1");
//        product.setPrice(100L);
//
//        when(productRepository.findAllByNameContaining(title)).thenReturn(Arrays.asList(product));
//
//        // When
//        List<ProductDto> products = customerProductService.searchProductByTitle(title);
//
//        // Then
//        assertEquals(1, products.size());
//        assertEquals("Product1", products.get(0).getName());
//    }
//
//    @Test
//    void testGetProductsByCategory() {
//        // Given
//        Long categoryId = 1L;
//        Product product = new Product();
//        product.setId(1L);
//        product.setName("Product1");
//        product.setPrice(100L);
//
//        when(productRepository.findAllByCategoryId(categoryId)).thenReturn(Arrays.asList(product));
//
//        // When
//        List<ProductDto> products = customerProductService.getProductsByCategory(categoryId);
//
//        // Then
//        assertEquals(1, products.size());
//        assertEquals("Product1", products.get(0).getName());
//    }
//
//    @Test
//    void testGetCompleteProductDetailById() {
//        // Given
//        Long productId = 1L;
//        Product product = new Product();
//        product.setId(productId);
//        product.setName("Product1");
//        product.setPrice(100L);
//
//        when(productRepository.findById(productId)).thenReturn(Optional.of(product));
//        when(faqRepository.findAllByProductId(productId)).thenReturn(Arrays.asList());
//        when(reviewRepository.findAllByProductId(productId)).thenReturn(Arrays.asList());
//
//        // When
//        CompleteProductDetailDto completeProductDetail = customerProductService.getCompleteProductDetailById(productId);
//
//        // Then
//        assertEquals(productId, completeProductDetail.getProductDto().getId());
//        assertEquals("Product1", completeProductDetail.getProductDto().getName());
//    }
}
