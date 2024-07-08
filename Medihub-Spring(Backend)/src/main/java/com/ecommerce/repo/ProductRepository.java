package com.ecommerce.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findAllByNameContaining(String title);

    List<Product> findAllByCategoryId(Long categoryId);


}
