package com.dailyjournal.repository;

import com.dailyjournal.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long>{
}