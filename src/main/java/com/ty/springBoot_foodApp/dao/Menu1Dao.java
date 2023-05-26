package com.ty.springBoot_foodApp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Repository;

import com.ty.springBoot_foodApp.Repo.Menu1Repo;
import com.ty.springBoot_foodApp.dto.Items;
import com.ty.springBoot_foodApp.dto.Menu1;
@Repository
public class Menu1Dao {
	@Autowired
	private Menu1Repo menu1Repo;

	public Menu1 SaveMenu(Menu1 menu1) {
		return menu1Repo.save(menu1);
	}
	
	public Menu1 UpdateMenu(Menu1 menu1,int mid) {
		Optional<Menu1> menu2=menu1Repo.findById(mid);
		if (menu2.isPresent()) {
			menu1.setMid(mid);
			menu1Repo.save(menu1);
			return menu2.get();
			
		}
		
		else {
			return null;
		}
		
	}
	
	public Menu1 deleteMenu(int mid) {
		Optional<Menu1> menu1=menu1Repo.findById(mid);
		if(menu1.isPresent()){
			menu1Repo.deleteById(mid);
			return menu1.get();
			
		}
		
		else {
			return null;
		}
	
	}
	
	public Menu1 getMenu1ById(int mid) {
		Optional<Menu1> menu1=menu1Repo.findById(mid);
		if(menu1.isPresent()) {
			return menu1.get();
			
			
		}
		else {
			return null;
			
		}
	}
	
}
