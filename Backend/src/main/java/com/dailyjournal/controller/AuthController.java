package com.dailyjournal.controller;

import com.dailyjournal.dto.LoginRequest;
import com.dailyjournal.dto.JWTResponse;
import com.dailyjournal.dto.UserRequest;
import com.dailyjournal.entity.User;
import com.dailyjournal.entity.Role;
import com.dailyjournal.repository.RoleRepository;
import com.dailyjournal.repository.UserRepository;
import com.dailyjournal.utils.JwtUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {
    
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(AuthenticationManager authenticationManager, JwtUtils jwtUtils, 
                         UserRepository userRepository, RoleRepository roleRepository,  
                         PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;  
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public JWTResponse authenticateUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );

        String token = jwtUtils.generateJwtToken(loginRequest.getUsername());

        User user = userRepository.findByUsername(loginRequest.getUsername())
            .orElseThrow(() -> new RuntimeException("User not found"));
        
        List<String> roles = user.getRoles() == null ? new ArrayList<>() :
            user.getRoles().stream().map(r -> r.getName()).collect(Collectors.toList());
        
        return new JWTResponse(token, user.getId(), user.getUsername(), user.getEmail(), roles);
    }

    @PostMapping("/register")
    public JWTResponse register(@RequestBody UserRequest req) {
        if (userRepository.findByUsername(req.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }
        
        User user = new User(req.getUsername(), req.getEmail(), passwordEncoder.encode(req.getPassword()));

        Role userRole = roleRepository.findByName("USER")
            .orElseThrow(() -> new RuntimeException("Default USER role not found"));
        user.setRoles(new HashSet<>(new ArrayList<Role>() {{ add(userRole); }}));
        
        User savedUser = userRepository.save(user);
        String token = jwtUtils.generateJwtToken(savedUser.getUsername());
        
        List<String> roleList = new ArrayList<>();
        roleList.add("USER");
        
        return new JWTResponse(token, savedUser.getId(), savedUser.getUsername(), savedUser.getEmail(), roleList);
    }
}
