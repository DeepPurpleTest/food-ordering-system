package com.example.foodorderingsystem.service;

import com.example.foodorderingsystem.entity.Meal;

import java.util.List;
import java.util.Optional;

public interface MealService extends CrudService<Meal> {
	List<Meal> findAll();

	Meal findOne(Long id);

	Optional<Meal> finById(Long id);

	Meal create(Meal newMeal);

	Meal update(Meal mealToUpdate);

	Meal delete(Long id);
}
