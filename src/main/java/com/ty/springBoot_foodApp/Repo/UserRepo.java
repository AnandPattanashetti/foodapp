package com.ty.springBoot_foodApp.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.springBoot_foodApp.dto.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	public User getUserByEmail(String email);

	public Optional<User> findByEmail(String email);

//	public Optional<User> deleteByemail(String email);

	
//	public User deleteUserEmail(String email);
	

}
