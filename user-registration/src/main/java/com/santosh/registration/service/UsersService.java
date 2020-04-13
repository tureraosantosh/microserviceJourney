package com.santosh.registration.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.santosh.registration.model.CreateUserRequestModel;
import com.santosh.registration.model.UserDto;

public interface UsersService extends UserDetailsService {

	public CreateUserRequestModel createUser(UserDto user);

	public UserDto getUserByEmaile(String username);

}
