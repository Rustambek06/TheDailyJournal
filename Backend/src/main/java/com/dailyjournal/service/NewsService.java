package com.dailyjournal.service;

import com.dailyjournal.entity.News;
import com.dailyjournal.repository.NewsRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NewsService {
    private final NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public List<News> getAll() {
        return newsRepository.findAll();
    }

    public News save(News news) {
        return newsRepository.save(news);
    }

    public void delete(Long id) {
        newsRepository.deleteById(id);
    }
}