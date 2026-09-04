package com.Banking.BankingSystem.dto;

import com.Banking.BankingSystem.entity.AccountStatus;
import com.Banking.BankingSystem.entity.AccountType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class AccountResponse {

    private Long id;
    private String accountNumber;
    private AccountType accountType;
    private BigDecimal balance;
    private AccountStatus status;
    private LocalDateTime createdAt;
}

