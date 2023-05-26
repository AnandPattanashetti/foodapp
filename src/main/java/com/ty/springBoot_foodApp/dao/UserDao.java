package com.ty.springBoot_foodApp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.ty.springBoot_foodApp.Config.ResponseStructure;
import com.ty.springBoot_foodApp.Repo.UserRepo;
import com.ty.springBoot_foodApp.dto.User;

@Repository
public class UserDao {

	@Autowired
	private UserRepo repo;

	public User saveUser(User user) {

		return repo.save(user);
	}

	public User updatUser(int id, User user) {
		Optional<User> user2 = repo.findById(id);
		if (user2.isPresent()) {
			user.setId(id);
			repo.save(user);
			return user2.get();
		} else {
			return null;
		}
	}
//
//	public User UpdateUser(String email, User user) {
//		Optional<User> user2 = repo.findByemail(email);
//		if (user2.isPresent()) {
//			user.setEmail(email);
//			repo.save(user);
//			return user2.get();
//		}
//		return null;

	//}

	public User deleteUser(int id) {
		Optional<User> user = repo.findById(id);
		if (user.isPresent()) {
			repo.deleteById(id);
			return user.get();
		} else {
			return null;
		}
	}

//	public User deleteuserbyemail(String email) {
//		Optional<User> user = repo.findByemail(email);
//		if (user.isPresent()) {
//			repo.deleteByemail(email);
//			return user.get();
//		}
//
//		return null;
//	}

	public User getUserById(int id) {
		Optional<User> user = repo.findById(id);
		if (user.isPresent()) {
			return user.get();
		} else {
			return null;
		}

	}

//	public User getUserByemail(String email) {
//		Optional<User> user= repo.findByEmail(email);
//		if (user.isPresent()) {
//			return user.get();
//
//		}
//		return null;
//
//	}

}
