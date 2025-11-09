package com.dailyjournal.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewsRequest {
    
    @NotBlank(message = "Заголовок не должен быть пустым")
    private String title;

    @NotBlank(message = "Контент не должен быть пустым")
    private String content;

    @NotNull(message = "Категроия обязвтельна")
    private Long categoryId;

    @NotNull(message = "Пользоваель обязателен")
    private Long UserId;
}