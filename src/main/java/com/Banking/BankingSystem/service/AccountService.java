package com.Banking.BankingSystem.service;

import com.Banking.BankingSystem.dto.AccountResponse;
import com.Banking.BankingSystem.entity.Account;
import com.Banking.BankingSystem.entity.AccountStatus;
import com.Banking.BankingSystem.entity.User;
import com.Banking.BankingSystem.dto.CreateAccountRequest;
import com.Banking.BankingSystem.repository.AccountRepository;
import com.Banking.BankingSystem.repository.UserRepository;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    public AccountService(AccountRepository accountRepository,
                          UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    public AccountResponse createAccount(CreateAccountRequest request,
                                         String email) {

        // 1. Find logged-in user
        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        // 2. Generate unique account number
        String accountNumber = generateAccountNumber();

        // 3. Create account
        Account account = Account.builder()
                .accountNumber(accountNumber)
                .accountType(request.getAccountType())
                .balance(BigDecimal.ZERO)
                .status(AccountStatus.ACTIVE)
                .createdAt(LocalDateTime.now())
                .user(user)
                .build();

        // 4. Save account
        Account savedAccount = accountRepository.save(account);

        return new AccountResponse(
                savedAccount.getId(),
                savedAccount.getAccountNumber(),
                savedAccount.getAccountType(),
                savedAccount.getBalance(),
                savedAccount.getStatus(),
                savedAccount.getCreatedAt()
        );
    }

    private String generateAccountNumber() {

        return "ACC" +
                UUID.randomUUID()
                        .toString()
                        .replace("-", "")
                        .substring(0, 10)
                        .toUpperCase();
    }
}