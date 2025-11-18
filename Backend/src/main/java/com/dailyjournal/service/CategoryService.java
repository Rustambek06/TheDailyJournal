package com.dailyjournal.service;

import com.dailyjournal.dto.CategoryRequest;
import com.dailyjournal.dto.CategoryResponse;
import com.dailyjournal.entity.Category;
import com.dailyjournal.mapper.CategoryMapper;
import com.dailyjournal.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public List<CategoryResponse> getAll() {
        List<Category> categories = categoryRepository.findAll();
        
        return categories.stream()
                .map(categoryMapper::toResponse)
                .collect(Collectors.toList());
    }

    public CategoryResponse save(CategoryRequest request) {
        Category categoryToSave = categoryMapper.toEntity(request);
        Category savedCategory = categoryRepository.save(categoryToSave);

        return categoryMapper.toResponse(savedCategory);
    }

    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
