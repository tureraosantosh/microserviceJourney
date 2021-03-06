package com.santosh.registration.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santosh.registration.mapper.UserMapper;
import com.santosh.registration.model.CreateUserRequestModel;
import com.santosh.registration.model.UserDto;
import com.santosh.registration.service.UsersService;

@RestController
@RequestMapping("/users")
public class UsersResource {
	@Autowired
	private UsersService userService;
	@Autowired
	private Environment env;
	@Autowired
	private UserMapper userMapper;

	@GetMapping("/status")
	public String status() {
		return env.getProperty("server.port");
	}

	@PostMapping(value = "/", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CreateUserRequestModel> createUser(@Valid @RequestBody CreateUserRequestModel user) {
		UserDto userDto = userMapper.map(user, UserDto.class);
		return new ResponseEntity<CreateUserRequestModel>(userService.createUser(userDto), HttpStatus.CREATED);
	}

}
