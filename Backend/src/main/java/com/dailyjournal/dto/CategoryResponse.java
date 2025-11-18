package com.dailyjournal.dto;

import com.dailyjournal.entity.News;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class CategoryResponse {
    private Long id;
    private String name;
    private List<News> newsList;
}
