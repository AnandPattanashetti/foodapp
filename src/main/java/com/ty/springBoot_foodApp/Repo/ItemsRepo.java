package com.ty.springBoot_foodApp.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.springBoot_foodApp.dto.Items;

public interface ItemsRepo extends JpaRepository< Items, Integer> {

}
