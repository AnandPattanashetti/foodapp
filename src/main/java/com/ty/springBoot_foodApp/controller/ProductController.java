package com.ty.springBoot_foodApp.controller;

import java.security.PublicKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springBoot_foodApp.Config.ResponseStructure;
import com.ty.springBoot_foodApp.dto.Product;
import com.ty.springBoot_foodApp.service.ProductService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@ApiOperation(value = "save product", notes = "APIis used to save product for given product id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfully saved"),
			@ApiResponse(code = 400, message = "id not found for the given product id") })
	@PostMapping
	public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}

	@ApiOperation(value = "Update Product", notes = "Api is used to update the product for given product id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully updated"),
			@ApiResponse(code = 404, message = "id not found for the given product id") })
	@PutMapping
	public ResponseEntity<ResponseStructure<Product>> updateProduct(@RequestBody Product product,
			@RequestParam int pid) {
		return productService.updateProduct(product, pid);
	}

	@ApiOperation(value = "Delete Product", notes = "Api is used to delete the product for the given product")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfully deleted"),
			@ApiResponse(code = 404, message = "id not found for the given product id") })
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Product>> deleteProduct(@RequestParam int pid) {
		return productService.deleteProduct(pid);

	}

	@ApiOperation(value = "Get product", notes = "Api is used to get the product for the given product")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "product id is found"),
			@ApiResponse(code = 404, message = "id not found for the given user id") })

	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Product>> getProductById(int pid) {
		return productService.getProductById(pid);
	}
//    @GetMapping("/getProductByname")
//    public ResponseEntity<ResponseStructure<Product>> getProductByname(String pname) {
//		return productService.getProductByname(pname);
//	}

}
