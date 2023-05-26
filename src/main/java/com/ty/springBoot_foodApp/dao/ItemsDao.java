package com.ty.springBoot_foodApp.dao;

import java.util.Optional;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.ty.springBoot_foodApp.Repo.ItemsRepo;
import com.ty.springBoot_foodApp.dto.Items;

import ch.qos.logback.core.joran.conditional.ElseAction;

@Repository
public class ItemsDao {
	@Autowired
	private ItemsRepo itemsRepo;
	
public Items saveItems(Items items) {
	    return itemsRepo.save(items);
}

public Items updateItems(Items items,int item_id) {
	Optional<Items> items2=itemsRepo.findById(item_id);
	if(items2.isPresent()) {
		items.setItem_id(item_id);
		itemsRepo.save(items);
		return items2.get();
		
	}
	else {
		return null;
	}
}
public Items deleteItems(int item_id) {
	Optional<Items> items=itemsRepo.findById(item_id);
	if(items.isPresent()){
		itemsRepo.deleteById(item_id);
		return items.get();
		
	}
	
	else {
		return null;
	}
	
}
public Items getItemsById(int item_id) {
	Optional<Items> items=itemsRepo.findById(item_id);
	if(items.isPresent()) {
		return items.get();
		
		
	}
	else {
		return null;
		
	}
}
}