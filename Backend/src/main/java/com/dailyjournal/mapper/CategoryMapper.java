package com.dailyjournal.mapper;

import com.dailyjournal.dto.CategoryRequest;
import com.dailyjournal.dto.CategoryResponse;
import com.dailyjournal.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    
    public Category toEntity(CategoryRequest request) {
        Category category = new Category();
        category.setName(request.getName());
        return category;
    }

    public CategoryResponse toResponse(Category category) {
        CategoryResponse response = new CategoryResponse();
        response.setId(category.getId());
        response.setName(category.getName());
        response.setNewsList(category.getNewsList());
        
        return response;
    }
}
