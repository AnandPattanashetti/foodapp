package com.ty.springBoot_foodApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springBoot_foodApp.Config.ResponseStructure;
import com.ty.springBoot_foodApp.dao.ProductDao;
import com.ty.springBoot_foodApp.dto.Product;
import com.ty.springBoot_foodApp.dto.User;
import com.ty.springBoot_foodApp.exception.ProductIdNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductDao dao;
	
	public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product) {
		ResponseStructure<Product> responseStructu=new ResponseStructure<>();
		responseStructu.setStatus(HttpStatus.CREATED.value());
		responseStructu.setMessage("Product Saved Successfully");
		responseStructu.setData(dao.saveProduct(product));
		return new ResponseEntity<ResponseStructure<Product>>(responseStructu,HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure<Product>> updateProduct(Product product,int pid) {
		ResponseStructure<Product> responseStructure=new ResponseStructure<>();
		Product product2=dao.updateProduct(product, pid);
		if (product2!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Product Update Suucessfully");
			responseStructure.setData(product);
			
			return new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.OK);
		}
		else 
		{
			throw new ProductIdNotFoundException("Id is Invalid For Update");
		}
	}
	
	public ResponseEntity<ResponseStructure<Product>> deleteProduct(int pid) {
		ResponseStructure<Product> responseStructure=new ResponseStructure<>();
		Product product=dao.deleteProduct(pid);
		if (product!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Delete Successfully");
			responseStructure.setData(product);
			return new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.OK);
		}
		
		else {
			throw new ProductIdNotFoundException("Given Id Is Not Valid For Delete");
		}
		
		
	}	
	public ResponseEntity<ResponseStructure<Product>> getProductById(int pid) {
		ResponseStructure<Product> responseStructure=new ResponseStructure<>();
		Product product=dao.getProductById(pid);
		if (product!=null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Get Products Successfully");
			responseStructure.setData(product);
			
			return new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			throw new ProductIdNotFoundException("Product Id is Not found") ;
		}	
	}
//	public ResponseEntity<ResponseStructure<Product>> getProductByname(String pname) {
//		ResponseStructure<Product> responseStructure=new ResponseStructure<>();
//		Product product=dao.getProductByname(pname);
//		if (product!=null) {
//			responseStructure.setStatus(HttpStatus.FOUND.value());
//			responseStructure.setMessage("Get Products Successfully");
//			responseStructure.setData(product);
//			
//			return new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.FOUND);
//		}
//		else {
//			throw new ProductIdNotFoundException("Product name is Not found") ;
//		}	
//	}
				
}
