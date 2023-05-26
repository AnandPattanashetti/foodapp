package com.ty.springBoot_foodApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.ty.springBoot_foodApp.dto.FoodOrder;
import com.ty.springBoot_foodApp.service.FoodOrderService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/foodorder")
public class FoodOrderController {
	@Autowired
	private FoodOrderService foodOrderService;
	
	@ApiOperation(value = "save foodorder", notes = "API is used to save foodorder for given foodorder id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfully saved"),
			@ApiResponse(code = 400, message = "id not found for the given foodorder id") })
	@PostMapping
    public ResponseEntity<ResponseStructure<FoodOrder>> saveFoodOrder(@RequestBody FoodOrder foodOrder) {
		return foodOrderService.saveFoodOrder(foodOrder);
	}
	
	@ApiOperation(value = "Update FoodOrder", notes = "Api is used to update the foodorder for given foodorder id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully updated"),
			@ApiResponse(code = 404, message = "id not found for the given foodorder id") })
    @PutMapping
	public ResponseEntity<ResponseStructure<FoodOrder>> updateFoodOrder(@RequestBody FoodOrder foodOrder,@RequestParam int fid) {
		return foodOrderService.updateFoodOrder(foodOrder, fid);
	}
	@ApiOperation(value = "Delete FoodOrder",notes="Api is used to delete the foodorder for the given foodorder")
	@ApiResponses(value = { @ApiResponse (code = 200,message="successfully deleted"),
			@ApiResponse(code=404,message="id not found for the given foodorder id")})
    @DeleteMapping
    public ResponseEntity<ResponseStructure<FoodOrder>> deleteFoodOrder(@RequestParam int fid) {
		return foodOrderService.deleteFoodOrder(fid);
	}

	@ApiOperation(value = "Get FoodOrder",notes="Api is used to get the foodorder for the given foodorder")
	@ApiResponses(value = { @ApiResponse(code = 302,message="foodorder id is found"),
		@ApiResponse(code=404,message="id not found for the given foodorder id")	})
    @GetMapping
    public ResponseEntity<ResponseStructure<FoodOrder>> getFoodOrderById(@RequestParam int fid) {
    	
    	return foodOrderService.getFooodFoodOrderById(fid);
		
	}
	
}
