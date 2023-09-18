package com.example.foodorderingsystem.service.serviceimpl;

import com.example.foodorderingsystem.entity.Dessert;
import com.example.foodorderingsystem.entity.Lunch;
import com.example.foodorderingsystem.entity.Meal;
import com.example.foodorderingsystem.repository.LunchRepository;
import com.example.foodorderingsystem.service.DessertService;
import com.example.foodorderingsystem.service.LunchService;
import com.example.foodorderingsystem.service.MealService;
import com.example.foodorderingsystem.util.exception.EntityNotFoundException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LunchServiceImpl implements LunchService {
	LunchRepository lunchRepository;
	MealService mealService;
	DessertService dessertService;

	@Override
	@Transactional(readOnly = true)
	public List<Lunch> findAll() {
		return lunchRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Lunch findOne(Long id) {
		Optional<Lunch> byId = lunchRepository.findById(id);
		return byId.orElseThrow(() -> new EntityNotFoundException(String.format("Lunch with id %d is not found", id)));
	}

	@Override
	@Transactional
	public Lunch create(Lunch newLunch) {
		Optional<Meal> mealById = mealService.finById(newLunch.getMeal().getId());
		Optional<Dessert> dessertById = dessertService.finById(newLunch.getDessert().getId());

		if (mealById.isEmpty() || dessertById.isEmpty()) {
			throw new EntityNotFoundException("Meal or Dessert is not found");
		}

		return lunchRepository.save(newLunch);
	}

	@Override
	@Transactional
	public Lunch update(Lunch lunchToUpdate) {
		return lunchRepository.save(lunchToUpdate);
	}

	@Override
	@Transactional
	public Lunch delete(Long id) {
		Optional<Lunch> byId = lunchRepository.findById(id);
		if (byId.isEmpty()) {
			throw new EntityNotFoundException(String.format("Lunch with id %d is not found", id));
		}

		return byId.get();
	}

	@Override
	public Optional<Lunch> findById(Long id) {
		return lunchRepository.findById(id);
	}
}
