package com.ty.springBoot_foodApp.dao;

import java.security.PublicKey;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springBoot_foodApp.Repo.ProductRepo;
import com.ty.springBoot_foodApp.dto.Product;

import ch.qos.logback.core.joran.conditional.IfAction;

@Repository
public class ProductDao {

	@Autowired
	private ProductRepo repo;

	public Product saveProduct(Product product) {
		return repo.save(product);

	}

	public Product updateProduct(Product product, int pid) {
		Optional<Product> product2 = repo.findById(pid);

		if (product2.isPresent()) {
			product.setPid(pid);
			repo.save(product);
			return product2.get();
		} else {

			return null;

		}

	}

	public Product deleteProduct(int pid) {
		Optional<Product> product = repo.findById(pid);

		if (product.isPresent()) {
			repo.deleteById(pid);
			return product.get();
		} else {
			return null;
		}

	}

	public Product getProductById(int pid) {
		Optional<Product> product = repo.findById(pid);
		if (product.isPresent()) {
			return product.get();

		} else {
			return null;
		}
	}
//	public Product getProductByname(String pname) {
//		Optional<Product> product = repo.findByname(pname);
//		if (product.isPresent()) {
//			return product.get();
//
//		} else {
//			return null;
//		}


	}
	
