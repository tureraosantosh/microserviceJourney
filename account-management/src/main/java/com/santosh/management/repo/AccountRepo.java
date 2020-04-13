package com.santosh.management.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santosh.management.entity.Account;


public interface AccountRepo extends JpaRepository<Account, Long> {

}
