package com.ecommerce.service.admin.category;

import java.util.List;

import com.ecommerce.dto.CategoryDto;
import com.ecommerce.entity.Category;

public interface CategoryService {
    Category createCategory(CategoryDto categoryDto);

    List<CategoryDto> getAllCategories();
}
