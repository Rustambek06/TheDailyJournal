package com.dailyjournal.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryRequest {
    
    @NotNull(message = "Название категория обязательна")
    private String name;
}
