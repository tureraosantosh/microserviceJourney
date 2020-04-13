package com.santosh.registration.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santosh.registration.entity.Users;

public interface UsersRepo extends JpaRepository<Users, Long> {

	Optional<Users> findUsersByEmail(String username);

}
