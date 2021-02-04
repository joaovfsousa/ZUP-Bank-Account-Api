package com.joaovfsousa.bank_account_api.repository;

import com.joaovfsousa.bank_account_api.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {}

