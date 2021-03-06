package com.santosh.registration.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1780616558073897337L;
	
	private String  userId;
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String encryptedPassword;

}
