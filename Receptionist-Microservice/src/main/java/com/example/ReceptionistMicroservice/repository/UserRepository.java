package com.example.ReceptionistMicroservice.repository;




import com.example.ReceptionistMicroservice.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
	  Optional<User> findByUsername(String username);
	  Boolean existsByUsername(String username);
	  Boolean existsByEmail(String email);
	}
