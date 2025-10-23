package com.dailyjournal.service;

import com.dailyjournal.entity.News;
import com.dailyjournal.repository.NewsRepository;
import com.dailyjournal.entity.Category;
import com.dailyjournal.entity.User;
import com.dailyjournal.repository.CategoryRepository;
import com.dailyjournal.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NewsService {
    private final NewsRepository newsRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    public NewsService(
        NewsRepository newsRepository, 
        CategoryRepository categoryRepository, 
        UserRepository userRepository
        ) {
        this.newsRepository = newsRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
    }

    public List<News> getAll() {
        return newsRepository.findAll();
    }

    public News save(News news) {
        Category category = categoryRepository.findById(news.getCategory().getId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        User user = userRepository.findById(news.getUser().getId())
                .orElseThrow(() -> new RuntimeException("User not found"));   
                
        news.setCategory(category);
        news.setUser(user);

        News savedNews = newsRepository.save(news);
        return savedNews;
    }

    public void delete(Long id) {
        newsRepository.deleteById(id);
    }
}