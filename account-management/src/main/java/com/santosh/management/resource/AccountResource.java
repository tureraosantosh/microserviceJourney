package com.santosh.management.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santosh.management.dto.input.UsersDto;
import com.santosh.management.service.UsersService;

@RestController
@RequestMapping("/accounts")
public class AccountResource {

	@Autowired
	private UsersService userService;
	@Autowired
	private Environment env;

	@GetMapping("/status")
	public String status() {
		return env.getProperty("server.port");
	}

	@PostMapping("/")
	public UsersDto createUser(@RequestBody UsersDto user) {
		return userService.createUser(user);
	}

}
