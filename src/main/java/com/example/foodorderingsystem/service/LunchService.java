package com.example.foodorderingsystem.service;

import com.example.foodorderingsystem.entity.Lunch;

import java.util.List;
import java.util.Optional;

public interface LunchService extends CrudService<Lunch> {
	List<Lunch> findAll();

	Lunch findOne(Long id);

	Lunch create(Lunch newLunch);

	Lunch update(Lunch lunchToUpdate);

	Lunch delete(Long id);

	Optional<Lunch> findById(Long id);
}
