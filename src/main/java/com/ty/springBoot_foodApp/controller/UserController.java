package com.ty.springBoot_foodApp.controller;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springBoot_foodApp.Config.ResponseStructure;
import com.ty.springBoot_foodApp.dto.User;
import com.ty.springBoot_foodApp.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;

	@ApiOperation(value = "save user", notes = "APIis used to save user for given user id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfully saved"),
			@ApiResponse(code = 400, message = "id not found for the given user id") })
	@PostMapping
	public ResponseEntity<ResponseStructure<User>> saveUser(@Valid @RequestBody User user) {
		return service.saveUser(user);

	}

	@ApiOperation(value = "Update User", notes = "Api is used to update the user for given user id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully updated"),
			@ApiResponse(code = 404, message = "id not found for the given user id") })
	@PutMapping
	public ResponseEntity<ResponseStructure<User>> updateUser(@Valid @PathVariable int id, @RequestBody User user) {
		return service.updateUser(id, user);

	}

	@ApiOperation(value = "Delete User",notes="Api is used to delete the user for the given user")
	@ApiResponses(value = { @ApiResponse (code = 200,message="successfully deleted"),
			@ApiResponse(code=404,message="id not found for the given user id")})
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<User>> deleteUser(@Valid @PathVariable int id) {
		return service.deleteUser(id);
	}

//	@DeleteMapping("/deletebyemail")
//	public ResponseEntity<ResponseStructure<User>> deleteuserbyemail(@RequestParam String email) {
//		return service.deleteUserByEmail(email);
	// }
	
	@ApiOperation(value = "Get User",notes="Api is used to get the user for the given user")
	@ApiResponses(value = { @ApiResponse(code = 302,message="user id is found"),
		@ApiResponse(code=404,message="id not found for the given user id")	})
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<User>> getUserByID(@Valid @PathVariable int id) {
		return service.getUserByID(id);

	}
//	@GetMapping("/getUserByemail")
//	public ResponseEntity<ResponseStructure<User>> getUserByEmail(@Valid @RequestParam String email) {
//		return service.getUserByEmail(email);
//	}
//	@PutMapping("/UpdateUseremail")
//	public ResponseEntity<ResponseStructure<User>> UpdateUser(@RequestParam String email,@RequestBody User user) {
//		return service.UpdateUser(email, user);
//	}
}
