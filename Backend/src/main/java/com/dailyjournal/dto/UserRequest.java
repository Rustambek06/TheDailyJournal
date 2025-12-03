package com.dailyjournal.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {

    @NotNull(message = "Имя пользователя обязательно")
    private String username;

    @NotNull(message = "Email обязателен")
    private String email;

    @NotBlank(message = "Пароль обязателен")
    @Size(min = 6, message = "Пароль не должен быть меньше 6 символов")
    private String password;
}
