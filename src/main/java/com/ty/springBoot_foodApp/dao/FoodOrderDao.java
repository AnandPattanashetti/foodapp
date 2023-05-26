package com.ty.springBoot_foodApp.dao;

import java.util.Iterator;

import java.util.List;
import java.util.Optional;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springBoot_foodApp.Repo.FoodOrderRepo;
import com.ty.springBoot_foodApp.dto.FoodOrder;
import com.ty.springBoot_foodApp.dto.Items;

@Repository
public class FoodOrderDao {

	@Autowired
	private FoodOrderRepo foodOrderRepo;

	public FoodOrder saveFoodOrder(FoodOrder foodOrder) {
		return foodOrderRepo.save(foodOrder);
	}

	public FoodOrder updateFoodOrder(FoodOrder foodOrder, int fid) {
		Optional<FoodOrder> foodorder2 = foodOrderRepo.findById(fid);
		if (foodorder2.isPresent()) {
			foodOrder.setFid(fid);
			foodOrder.setItems(foodOrder.getItems());
			foodOrderRepo.save(foodOrder);
			return foodorder2.get();
		} else {
			return null;
		}

	}

	public FoodOrder getFoodOrder(int fid) {
		Optional<FoodOrder> foodOrder = foodOrderRepo.findById(fid);
		if (foodOrder.isPresent()) {
			return foodOrder.get();
		}
		return null;
	}

	public FoodOrder deleteFoodOrder(int fid) {
		Optional<FoodOrder> foodOrder = foodOrderRepo.findById(fid);
		if (foodOrder.isPresent()) {
			foodOrderRepo.deleteById(fid);
			return foodOrder.get();

		}
		return null;

	}
	
	
}
