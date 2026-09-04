package com.Banking.BankingSystem.service;

import com.Banking.BankingSystem.dto.LoginRequest;
import com.Banking.BankingSystem.dto.LoginResponse;
import com.Banking.BankingSystem.entity.Role;
import com.Banking.BankingSystem.entity.User;
import com.Banking.BankingSystem.dto.RegisterRequest;
import com.Banking.BankingSystem.dto.RegisterResponse;
import com.Banking.BankingSystem.repository.UserRepository;
import com.Banking.BankingSystem.security.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public RegisterResponse register(RegisterRequest request) {

        // 1. Check whether email already exists
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already registered");
        }

        // 2. Create User
        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.CUSTOMER)
                .createdAt(LocalDateTime.now())
                .build();

        // 3. Save user
        User savedUser = userRepository.save(user);

        // 4. Return response
        return new RegisterResponse(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail(),
                "User registered successfully"
        );
    }

    public LoginResponse login(LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        String token = jwtService.generateToken(request.getEmail());

        return new LoginResponse(
                token,
                "Login successful"
        );
    }
}