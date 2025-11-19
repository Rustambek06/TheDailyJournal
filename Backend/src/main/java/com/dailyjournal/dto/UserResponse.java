package com.dailyjournal.dto;

import com.dailyjournal.entity.News;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class UserResponse {
    private Long id;
    private String username;
    private String email;
    private List<News> newsList;
}
