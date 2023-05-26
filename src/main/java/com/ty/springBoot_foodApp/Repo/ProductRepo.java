package com.ty.springBoot_foodApp.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.springBoot_foodApp.dto.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

//	@Query("select p from Product p where p.pname=?1")
//public Product getProductByName(String pname);
//
//	public Optional<Product> findByname(String pname);
}
