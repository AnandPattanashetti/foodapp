package com.ty.springBoot_foodApp.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.feed.AbstractAtomFeedView;

import com.ty.springBoot_foodApp.Config.ResponseStructure;
import com.ty.springBoot_foodApp.dao.UserDao;
import com.ty.springBoot_foodApp.dto.User;
import com.ty.springBoot_foodApp.exception.UserNotFoundFoundException;

@Service
public class UserService {

	@Autowired
	private UserDao dao;

	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
           ResponseStructure<User> responseStructure=new ResponseStructure<>();
           responseStructure.setStatus(HttpStatus.CREATED.value());
           responseStructure.setMessage("User Sucessfully Saved");
           responseStructure.setData(dao.saveUser(user));
		   return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<User>> updateUser(int id,User user) {
		User user2 = dao.updatUser(id, user);
		ResponseStructure<User> responseStructure=new ResponseStructure<>();
		if (user2 != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Update Successfully");
			responseStructure.setData(user);
			return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.OK);

		} else {
			throw new UserNotFoundFoundException("id is not valid");
		}

	}

	public ResponseEntity<ResponseStructure<User>> deleteUser(int id) {
		ResponseStructure<User> responseStructure=new ResponseStructure<>();
		User user = dao.deleteUser(id);
		if (user != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Deleted Successfully");
			responseStructure.setData(user);
			return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.OK);

		} else {
			throw new UserNotFoundFoundException("USER id is not valid");
		}

	}

	public ResponseEntity<ResponseStructure<User>> getUserByID(int id) {
		ResponseStructure<User> responseStructure=new ResponseStructure<>();
		User user = dao.getUserById(id);
		if (user != null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("found Successfully");
			responseStructure.setData(user);
			return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.FOUND);
		} else {
			throw new UserNotFoundFoundException("User Id Is Not Present") ;
		}
	}
//	
//	public ResponseEntity<ResponseStructure<User>> UpdateUser(String email,User user) {
//		ResponseStructure<User> responseStructure=new ResponseStructure<>();
//		User user2=dao.UpdateUser(email, user);
//	    if (user2!=null) {
//	    	responseStructure.setStatus(HttpStatus.CREATED.value());
//			responseStructure.setMessage("Updated Successfully");
//			responseStructure.setData(user);
//			return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.CREATED);
//		}
//	    
//	    throw new UserNotFoundFoundException("Give emaial id is not found");
		
	//}
//	public ResponseEntity<ResponseStructure<User>> getUserByEmail(String email) {
//		ResponseStructure<User> responseStructure=new ResponseStructure<>();
//		User user=dao.getUserByemail(email);
//		if (user!=null) {
//			responseStructure.setStatus(HttpStatus.FOUND.value());
//			responseStructure.setMessage("get User is Successful");
//			responseStructure.setData(user);
//			return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.FOUND);
//		}
//		throw new NoSuchElementException();
//	}
//	public ResponseEntity<ResponseStructure<User>> deleteUserByEmail(String email) {
//		ResponseStructure<User> responseStructure=new ResponseStructure<>();
//		User user = dao.deleteuserbyemail(email);
//		if (user != null) {
//			responseStructure.setStatus(HttpStatus.OK.value());
//			responseStructure.setMessage("Deleted Successfully");
//			responseStructure.setData(user);
//			return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.OK);
//
//		} else {
//			throw new UserNotFoundFoundException("USER email is not valid");
//		}
//	}
}
