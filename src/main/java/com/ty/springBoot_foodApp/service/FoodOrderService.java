package com.ty.springBoot_foodApp.service;

import java.util.Iterator;
import java.util.Optional;

import org.aspectj.apache.bcel.generic.RET;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springBoot_foodApp.Config.ResponseStructure;
import com.ty.springBoot_foodApp.Repo.FoodOrderRepo;
import com.ty.springBoot_foodApp.dao.FoodOrderDao;
import com.ty.springBoot_foodApp.dto.FoodOrder;
import com.ty.springBoot_foodApp.dto.Items;
import com.ty.springBoot_foodApp.exception.FoodOrderNotFoundException;

import antlr.collections.List;
import ch.qos.logback.core.joran.conditional.ElseAction;
import net.bytebuddy.asm.Advice.Return;

@Service
public class FoodOrderService {

	@Autowired
	private FoodOrderDao dao;

	public ResponseEntity<ResponseStructure<FoodOrder>> saveFoodOrder(FoodOrder foodOrder) {
		ResponseStructure<FoodOrder> responseStructure=new ResponseStructure<>();
		java.util.List<Items> list = foodOrder.getItems();
		
		double totalprice = 0;
		for (Items items : list) {
			totalprice += items.getCost() * items.getQuantity();
			foodOrder.setTotalprice(totalprice);
		}
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Save Food Order Successfully");
		responseStructure.setData(dao.saveFoodOrder(foodOrder));
		
		return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<FoodOrder>> updateFoodOrder(FoodOrder foodOrder, int fid) {

		FoodOrder foodOrder2 = dao.getFoodOrder(fid);
		ResponseStructure<FoodOrder> responseStructure=new ResponseStructure<>();
		if (foodOrder2 != null) {
			java.util.List<Items> list = foodOrder2.getItems();
			double totalprice = 0;
			for (Items items : list) {
				totalprice += items.getCost() * items.getQuantity();	

			}
			foodOrder.setTotalprice(totalprice);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Update Successfully");
			responseStructure.setData(dao.saveFoodOrder(dao.updateFoodOrder(foodOrder, fid)));
			
			return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure,HttpStatus.OK);
			
		}
		throw new FoodOrderNotFoundException("FOOD order id is not found for update ");
	}

	public ResponseEntity<ResponseStructure<FoodOrder>> deleteFoodOrder(int fid) {
		FoodOrder foodOrder = dao.deleteFoodOrder(fid);
		ResponseStructure<FoodOrder> responseStructure=new ResponseStructure<>();
		
		if (foodOrder != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Delete Successfully");
			responseStructure.setData(foodOrder);			

			return new  ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure,HttpStatus.OK);

		}
		throw new FoodOrderNotFoundException("FOOd ORDER is NOT found for delete");
	}

	public ResponseEntity<ResponseStructure<FoodOrder>> getFooodFoodOrderById(int fid) {
		ResponseStructure<FoodOrder> responseStructure=new ResponseStructure<>();
		
		FoodOrder foodOrder = dao.getFoodOrder(fid);
		if (foodOrder != null) {
			java.util.List<Items> list = foodOrder.getItems();
			double totalprice = 0;
			for (Items items : list) {
				totalprice += items.getCost() * items.getQuantity();
				foodOrder.setTotalprice(totalprice);
			}
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Delete Successfully");
			responseStructure.setData(foodOrder);	
			
			return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			
			throw new FoodOrderNotFoundException("Food Order is not fOUND");
			
		}
		
	}

}
