package com.santosh.registration.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequestModel {

	@NotNull(message = "first name can not be null ")
	@Size(min = 2, max = 200, message = "first name renge between {min} and {max}")
	private String firstName;
	@NotNull(message = "last name can not be null ")
	@Size(min = 2, max = 200, message = "last name renge between {min} and {max}")
	private String lastName;

	@NotNull(message = "first name can not be null ")
	private String email;

	@NotNull(message = "first name can not be null ")
	@Size(min = 8, max = 16, message = "password renge between {min} and {max}")
	private String password;

}
