package com.dailyjournal.repository;

import com.dailyjournal.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NewsRepository extends JpaRepository<News, Long>{
    List<News> findByCategoryName(String category);
}