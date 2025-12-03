package com.dailyjournal.service;

import com.dailyjournal.dto.UserRequest;
import com.dailyjournal.dto.UserResponse;
import com.dailyjournal.entity.User;
import com.dailyjournal.mapper.UserMapper;
import com.dailyjournal.repository.UserRepository;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserResponse> getAll() {
        List<User> users = userRepository.findAll();

        return users.stream()
                .map(userMapper::toResponse)
                .collect(Collectors.toList());
    }

    public UserResponse save(UserRequest request) {
        User userToSave = userMapper.toEntity(request);
        User savedUser = userRepository.save(userToSave);
        
        return userMapper.toResponse(savedUser);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}