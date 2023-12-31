package com.example.foodorderingsystem.service;

import com.example.foodorderingsystem.entity.Drink;

import java.util.List;
import java.util.Optional;

public interface DrinkService extends CrudService<Drink> {
	List<Drink> findAll();

	Drink findOne(Long id);

	Drink create(Drink newDrink);

	Drink update(Drink drinkToUpdate);

	Drink delete(Long id);

	Optional<Drink> findById(Long id);
}
