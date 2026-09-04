package com.Banking.BankingSystem.controller;

import com.Banking.BankingSystem.dto.AccountResponse;
import com.Banking.BankingSystem.entity.Account;
import com.Banking.BankingSystem.dto.CreateAccountRequest;
import com.Banking.BankingSystem.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountResponse> createAccount(
            @Valid @RequestBody CreateAccountRequest request,
            Authentication authentication) {

        String email = authentication.getName();

        AccountResponse response =
                accountService.createAccount(request, email);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
}