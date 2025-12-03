package com.dailyjournal.controller;

import com.dailyjournal.dto.UserRequest;
import com.dailyjournal.dto.UserResponse;
import com.dailyjournal.service.UserService;
import jakarta.validation.Valid;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<UserResponse> getAll() {
        return userService.getAll();
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public UserResponse create(@Valid @RequestBody UserRequest request) {
        return userService.save(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        userService.delete(id);
    }
}