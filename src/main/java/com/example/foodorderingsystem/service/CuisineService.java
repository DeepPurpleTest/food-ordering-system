package com.example.foodorderingsystem.service;

import com.example.foodorderingsystem.entity.Cuisine;

import java.util.List;

public interface CuisineService extends CrudService<Cuisine> {
	List<Cuisine> findAll();

	Cuisine findOne(Long id);

	Cuisine create(Cuisine newCuisine);

	Cuisine update(Cuisine cuisineToUpdate);

	Cuisine delete(Long id);
}
