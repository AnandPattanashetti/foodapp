package com.ty.springBoot_foodApp.service;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties.Rsocket;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springBoot_foodApp.Config.ResponseStructure;
import com.ty.springBoot_foodApp.dao.ItemsDao;
import com.ty.springBoot_foodApp.dto.Items;
import com.ty.springBoot_foodApp.exception.ItemsNotFoundException;
@Service
public class ItemsService {
	@Autowired
	private ItemsDao dao;
	
	public ResponseEntity<ResponseStructure<Items>> saveItems(Items items) {
		ResponseStructure<Items> responseStructure=new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Items Saved Successfully");
		responseStructure.setData(dao.saveItems(items));
		return new ResponseEntity<ResponseStructure<Items>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Items>> updateItems(Items items,int item_id) {
		    Items items2=dao.updateItems(items, item_id);
		    ResponseStructure<Items> responseStructure=new ResponseStructure<>();
		    
		if (items2!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Items Updated Successfully");
			responseStructure.setData(items);
			return new ResponseEntity<ResponseStructure<Items>>(responseStructure,HttpStatus.OK);
			
		}else {
			throw new ItemsNotFoundException("item id is not found for upadte");
		}
	}
	
	public ResponseEntity<ResponseStructure<Items>> deleteItems(int item_id) {
		Items items=dao.deleteItems(item_id);
		ResponseStructure<Items> responseStructure=new ResponseStructure<>();
		
		if(items!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Items Deleted Successfully");
			responseStructure.setData(items);
			
			
			return new ResponseEntity<ResponseStructure<Items>>(responseStructure,HttpStatus.OK);
			
		}
		else {
			throw new ItemsNotFoundException("Items id is not valid for delete");
		}
	}
	
	public ResponseEntity<ResponseStructure<Items>> getItemsById(int item_id) {
		Items items=dao.getItemsById(item_id);
		ResponseStructure<Items> responseStructure=new ResponseStructure<>();
		if (items!=null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Items Found Successfully");
			responseStructure.setData(items);
			
			return new ResponseEntity<ResponseStructure<Items>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			throw new ItemsNotFoundException("Items Id Is Not Found");
		}
		
	}

}
