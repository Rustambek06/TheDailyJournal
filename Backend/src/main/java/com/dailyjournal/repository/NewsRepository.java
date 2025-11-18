package com.dailyjournal.repository;

import com.dailyjournal.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.EntityGraph;
// import java.util.List;

public interface NewsRepository extends JpaRepository<News, Long>{

    // @EntityGraph(attributePaths = {"category", "name"})
    // List<News> findAll();
}