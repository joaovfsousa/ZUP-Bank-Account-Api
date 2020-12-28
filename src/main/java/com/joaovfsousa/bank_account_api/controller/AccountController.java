package com.joaovfsousa.bank_account_api.controller;

import com.joaovfsousa.bank_account_api.exception.InvalidDataException;
import com.joaovfsousa.bank_account_api.exception.ResourceNotFoundException;
import com.joaovfsousa.bank_account_api.model.Account;
import com.joaovfsousa.bank_account_api.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountController {

    @Autowired
    AccountRepository accountRepository;

    @GetMapping("/accounts")
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    @GetMapping("/accounts/{id}")
    public Account getAccountById(@PathVariable(value="id") Long accountId) {
        return accountRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account", "id", accountId));
    }

    @PostMapping("/accounts")
    public Account createAccount(@RequestBody Account account) {
        try {
            return accountRepository.save(account);
        } catch (Exception ex) {
            throw new InvalidDataException();
        }
    }

    @PutMapping("accounts/{id}")
    public Account updateAccount(
            @PathVariable(value = "id") Long accountId,
            @RequestBody Account accountData)
    {
        Account account = accountRepository.findById(accountId).orElseThrow(
                () -> new ResourceNotFoundException("Account", "id", accountId)
        );

        account.setName(accountData.getName());
        account.setCpf(accountData.getCpf());
        account.setEmail(accountData.getEmail());
        account.setBirthDate(accountData.getBirthDate());

        return accountRepository.save(account);
    }

    @DeleteMapping("accounts/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable(value = "id") Long accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow(
                () -> new ResourceNotFoundException("Account", "id", accountId)
        );

        accountRepository.delete(account);

        return ResponseEntity.ok().build();
    }
}