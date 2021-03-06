package com.santosh.registration.service;

import java.util.ArrayList;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.santosh.registration.entity.Users;
import com.santosh.registration.mapper.UserMapper;
import com.santosh.registration.model.CreateUserRequestModel;
import com.santosh.registration.model.UserDto;
import com.santosh.registration.repo.UsersRepo;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UsersRepo userRepo;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public CreateUserRequestModel createUser(UserDto user) {
		Users users = userMapper.map(user, Users.class);
		return userMapper.map(userRepo.save(users), CreateUserRequestModel.class);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Users> usersByEmail = userRepo.findUsersByEmail(username);
		usersByEmail.orElseThrow(() -> new UsernameNotFoundException("user not found : " + username));
		Users user = usersByEmail.get();
		return new User(user.getEmail(), bCryptPasswordEncoder.encode(user.getPassword()), true, true, true, true,
				new ArrayList<>());
	}

	@Override
	public UserDto getUserByEmaile(String username) {
		Optional<Users> findUsersByEmail = userRepo.findUsersByEmail(username);
		findUsersByEmail.orElseThrow(() -> new UsernameNotFoundException("user not found : " + username));
		return new ModelMapper().map(findUsersByEmail.get(), UserDto.class);
	}

}
