package com.ty.springBoot_foodApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springBoot_foodApp.Config.ResponseStructure;
import com.ty.springBoot_foodApp.dao.Menu1Dao;
import com.ty.springBoot_foodApp.dto.Items;
import com.ty.springBoot_foodApp.dto.Menu1;
import com.ty.springBoot_foodApp.exception.ItemsNotFoundException;
import com.ty.springBoot_foodApp.exception.Menu1NotFoundException;

@Service
public class Menu1Service {
	@Autowired
	private Menu1Dao dao;
	

	public ResponseEntity<ResponseStructure<Items>> saveMenu1(Menu1 menu1) {
		ResponseStructure<Items> responseStructure=new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Menu1 Saved Successfully");
		responseStructure.setData(dao.SaveMenu(menu1));
		return new ResponseEntity<ResponseStructure<Items>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Menu1>> updateMenu(Menu1 menu1,int mid) {
	    Menu1 menu2=dao.UpdateMenu(menu1, mid);
	    ResponseStructure<Menu1> responseStructure=new ResponseStructure<>();
	    
	if (menu2!=null) {
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Menu Updated Successfully");
		responseStructure.setData(menu1);
		return new ResponseEntity<ResponseStructure<Menu1>>(responseStructure,HttpStatus.OK);
		
	}else {
		throw new Menu1NotFoundException("Menu id is not found for upadte");
		
	}

}
	public ResponseEntity<ResponseStructure<Menu1>> deleteMenu(int mid) {
		Menu1 menu1=dao.deleteMenu(mid);
		ResponseStructure<Menu1> responseStructure=new ResponseStructure<>();
		
		if(menu1!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Menu Deleted Successfully");
			responseStructure.setData(menu1);
			
			
			return new ResponseEntity<ResponseStructure<Menu1>>(responseStructure,HttpStatus.OK);
			
		}
		else {
			throw new Menu1NotFoundException("Menu id is not valid for delete");
		}
	}
	public ResponseEntity<ResponseStructure<Menu1>> getMenu1ById(int mid) {
		Menu1 menu1=dao.getMenu1ById(mid);
		ResponseStructure<Menu1> responseStructure=new ResponseStructure<>();
		if (menu1!=null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("MENU Found Successfully");
			responseStructure.setData(menu1);
			
			return new ResponseEntity<ResponseStructure<Menu1>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			throw new Menu1NotFoundException("Menu Id Is Not Found");
		}
		
	}
}
