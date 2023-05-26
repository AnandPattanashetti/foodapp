package com.ty.springBoot_foodApp.controller;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
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
import com.ty.springBoot_foodApp.service.ItemsService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/items")
public class ItemsController {
 
	@Autowired
	private ItemsService itemsService;
	

	@ApiOperation(value = "save items", notes = "API is used to save items for given items id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfully saved"),
			@ApiResponse(code = 400, message = "id not found for the given items id") })
	@PostMapping
	public ResponseEntity<ResponseStructure<Items>> saveItems(@RequestBody Items items) {
		return itemsService.saveItems(items);
	}

	@ApiOperation(value = "Update items", notes = "APIis used to Update items for given items id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfully Updated"),
			@ApiResponse(code = 400, message = "id not found for the given items id") })
	@PutMapping
	public ResponseEntity<ResponseStructure<Items>> updateItems(@RequestBody Items items,@RequestParam int item_id) {
		return itemsService.updateItems(items, item_id);
	}

	@ApiOperation(value = "Delete Items",notes="Api is used to delete the items for the given items")
	@ApiResponses(value = { @ApiResponse (code = 200,message="successfully deleted"),
			@ApiResponse(code=404,message="id not found for the given items id")})
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Items>> deleteItems(@RequestParam int item_id) {
		return itemsService.deleteItems(item_id);
	}
	@ApiOperation(value = "Get Items",notes="Api is used to get the items for the given items")
	@ApiResponses(value = { @ApiResponse(code = 302,message="items id is found"),
		@ApiResponse(code=404,message="id not found for the given items id")	})
	@GetMapping
	public ResponseEntity<ResponseStructure<Items>> getItemsByid(int item_id) {
		return itemsService.getItemsById(item_id);
	}
	
}
