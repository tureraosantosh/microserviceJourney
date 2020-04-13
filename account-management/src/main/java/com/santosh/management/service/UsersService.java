package com.santosh.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santosh.management.dto.input.UsersDto;
import com.santosh.management.entity.Account;
import com.santosh.management.mapper.UserMapper;
import com.santosh.management.repo.AccountRepo;

@Service
public class UsersService {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private AccountRepo userRepo;

	public UsersDto createUser(UsersDto user) {
		Account users = userMapper.map(user, Account.class);
		return userMapper.map(userRepo.save(users), UsersDto.class);
	}

}
