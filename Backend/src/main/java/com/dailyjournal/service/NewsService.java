package com.dailyjournal.service;

import com.dailyjournal.dto.NewsRequest;
import com.dailyjournal.dto.NewsResponse;
import com.dailyjournal.entity.News;
import com.dailyjournal.entity.Category;
import com.dailyjournal.entity.User;
import com.dailyjournal.repository.NewsRepository;
import com.dailyjournal.repository.CategoryRepository;
import com.dailyjournal.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsService {
    
    @Autowired
    private final NewsRepository newsRepository;

    @Autowired
    private final CategoryRepository categoryRepository;

    @Autowired
    private final UserRepository userRepository;

    public List<NewsResponse> getAll() {
        return newsRepository.findAll()
        .stream().map(this::toResponse)
        .collect(Collectors.toList());
    }

    public NewsService(
        NewsRepository newsRepository, 
        CategoryRepository categoryRepository, 
        UserRepository userRepository
        ) {
        this.newsRepository = newsRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
    }

    public NewsResponse save(NewsRequest request) {
        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));   
                
        News news = new News(
            request.getTitle(),
            request.getContent(),
            category,
            user
        );
        News saved = newsRepository.save(news);
        return toResponse(saved);
    }

    public void delete(Long id) {
        newsRepository.deleteById(id);
    }

    private NewsResponse toResponse(News news) {
        NewsResponse dto = new NewsResponse();
        dto.setId(news.getId());
        dto.setTitle(news.getTitle());
        dto.setContent(news.getContent());
        dto.setCreatedAt(news.getCreatedAt());
        dto.setCategoryName(news.getCategory().getName());
        dto.setUsername(news.getUser().getUsername());
        dto.setEmail(news.getUser().getEmail());
        return dto;
    }
}