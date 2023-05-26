package com.ty.springBoot_foodApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springBoot_foodApp.Config.ResponseStructure;
import com.ty.springBoot_foodApp.dto.Items;
import com.ty.springBoot_foodApp.dto.Menu1;
import com.ty.springBoot_foodApp.service.Menu1Service;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/menu1")
public class Menu1Controller {
	@Autowired
	private Menu1Service menu1Service;

	
	@ApiOperation(value = "save menu1", notes = "APIis used to save menu1 for given menu1 id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfully saved"),
			@ApiResponse(code = 400, message = "id not found for the given menu1 id") })
	@PostMapping
	public ResponseEntity<ResponseStructure<Items>> saveMenu1(@RequestBody Menu1 menu1) {
		return menu1Service.saveMenu1(menu1);
		
	}
	
	@ApiOperation(value = "Update Menu1", notes = "Api is used to update the menu1 for given menu1 id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully updated"),
			@ApiResponse(code = 404, message = "id not found for the given menu1 id") })	
		@PutMapping
		public ResponseEntity<ResponseStructure<Menu1>> updateMenu(@RequestBody Menu1 menu1,@RequestParam int mid) {
			return menu1Service.updateMenu(menu1, mid);
			}
	

	@ApiOperation(value = "Delete Menu1",notes="Api is used to delete the menu1 for the given menu1")
	@ApiResponses(value = { @ApiResponse (code = 200,message="successfully deleted"),
			@ApiResponse(code=404,message="id not found for the given menu1 id")})
		
		@DeleteMapping
		public ResponseEntity<ResponseStructure<Menu1>> deleteMenu(@RequestParam int mid) {
			return menu1Service.deleteMenu(mid);
		}
	

	@ApiOperation(value = "Get Menu1",notes="Api is used to get the menu1 for the given menu1")
	@ApiResponses(value = { @ApiResponse(code = 302,message="menu1 id is found"),
		@ApiResponse(code=404,message="id not found for the given menu id")	})
		@GetMapping
		public ResponseEntity<ResponseStructure<Menu1>> getMenu(@RequestParam int mid) {
			return menu1Service.getMenu1ById(mid);
			
		}
}
