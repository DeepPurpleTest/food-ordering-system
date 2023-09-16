package com.example.foodorderingsystem.service;

import com.example.foodorderingsystem.entity.Dessert;

import java.util.List;
import java.util.Optional;

public interface DessertService extends CrudService<Dessert> {
	List<Dessert> findAll();

	Dessert findOne(Long id);

	Optional<Dessert> finById(Long id);

	Dessert create(Dessert newDessert);

	Dessert update(Dessert dessertToUpdate);

	Dessert delete(Long id);
}
