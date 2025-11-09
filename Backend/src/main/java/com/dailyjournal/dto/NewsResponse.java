package com.dailyjournal.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class NewsResponse {
    private Long id;
    private String title;
    private String content;
    private String categoryName;
    private String username;
    private String email;
    private LocalDateTime createdAt;
}
