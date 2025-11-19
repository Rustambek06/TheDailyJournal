package com.dailyjournal.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {

    @NotNull(message = "Имя пользователя обязательно")
    private String username;

    @NotNull(message = "Email обязателен")
    private String email;
}
