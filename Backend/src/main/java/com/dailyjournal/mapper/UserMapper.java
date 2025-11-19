package com.dailyjournal.mapper;

import com.dailyjournal.dto.UserRequest;
import com.dailyjournal.dto.UserResponse;
import com.dailyjournal.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    
    public User toEntity(UserRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        
        return user;
    }

    public UserResponse tResponse(User user) {
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setUsername(user.getUsername());
        response.setEmail(user.getEmail());
        response.setNewsList(user.getNewsList());

        return response;
    }
}
