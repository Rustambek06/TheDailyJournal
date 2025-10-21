package com.dailyjournal.controller;

import com.dailyjournal.entity.News;
import com.dailyjournal.service.NewsService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/news")
@CrossOrigin(origins = "http://localhost:5173")
public class NewsController {
    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping
    public List<News> getAll() {
        return newsService.getAll();
    }

    @PostMapping
    public News create(@RequestBody News news) {
        return newsService.save(news);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        newsService.delete(id);
    }
}