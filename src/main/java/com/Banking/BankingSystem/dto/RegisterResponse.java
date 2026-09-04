package com.Banking.BankingSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RegisterResponse {

    private Long userId;
    private String name;
    private String email;
    private String message;
}