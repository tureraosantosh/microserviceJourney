package com.santosh.registration.IT;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.santosh.management.dto.input.UsersDto;
import com.santosh.management.resource.AccountResource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserResourceTest {
	
	@Autowired
	private RestTemplate rest;
	@Autowired
	private AccountResource usersResource;
	
	String baseUrl="http://localhost:7010";


	@Test
	public void testStatusCheck() {
		
		String url="/status";
		
		ResponseEntity<String> status = rest.getForEntity(baseUrl+url, String.class);
		String port = status.getBody();
	
	}
	
	@Test
	public void testCreateUsers()
	{
		UsersDto user=new UsersDto("Santosh","turerao@gmail.com","9967120080");
		UsersDto userDto=usersResource.createUser(user);
	}

}
