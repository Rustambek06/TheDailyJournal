package com.dailyjournal.controller;

import com.dailyjournal.dto.NewsRequest;
import com.dailyjournal.dto.NewsResponse;
import com.dailyjournal.service.NewsService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/news")
@CrossOrigin(origins = "*")
public class NewsController {
    
    @Autowired
    private NewsService newsService;
    
    @GetMapping
    public ResponseEntity<List<NewsResponse>> getAll() {
        return ResponseEntity.ok(newsService.getAll());
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('CREATOR', 'ADMIN')")
    public ResponseEntity<NewsResponse> create(
        @Valid
        @RequestBody
        NewsRequest
        request
    ) {
        return ResponseEntity
        .ok(newsService.save(request));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('CREATOR', 'ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        newsService.delete(id);
        return ResponseEntity.noContent().build();
    }    
}