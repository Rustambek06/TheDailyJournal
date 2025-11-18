package com.dailyjournal.controller;

import com.dailyjournal.dto.CategoryRequest;
import com.dailyjournal.dto.CategoryResponse;
import com.dailyjournal.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "http://localhost:5173")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<CategoryResponse> getAll() {
        return categoryService.getAll();
    }

    @PostMapping
    public CategoryResponse create(@Valid @RequestBody CategoryRequest request) {
        return categoryService.save(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        categoryService.delete(id);
    }
}