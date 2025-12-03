package com.dailyjournal.dto;

import com.dailyjournal.entity.News;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class UserResponse {
    private Long id;
    private String username;
    private String email;

    private Set<String> roles;

    private List<News> newsList;
}
