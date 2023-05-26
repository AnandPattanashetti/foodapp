package com.ty.springBoot_foodApp.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.springBoot_foodApp.dto.FoodOrder;

public interface FoodOrderRepo extends JpaRepository<FoodOrder, Integer>{

}
