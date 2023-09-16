package com.example.foodorderingsystem.service.serviceimpl;

import com.example.foodorderingsystem.entity.Meal;
import com.example.foodorderingsystem.repository.MealRepository;
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
public class MealServiceImpl implements MealService {
	MealRepository mealRepository;

	@Transactional(readOnly = true)
	public List<Meal> findAll() {
		return mealRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Meal findOne(Long id) {
		Optional<Meal> byId = mealRepository.findById(id);
		return byId.orElseThrow(() -> new EntityNotFoundException(String.format("Meal with id %d is not found", id)));
	}

	@Transactional(readOnly = true)
	public Optional<Meal> finById(Long id){
		return mealRepository.findById(id);
	}

	@Override
	@Transactional
	public Meal create(Meal newMeal) {
		return mealRepository.save(newMeal);
	}

	@Override
	@Transactional
	public Meal update(Meal mealToUpdate) {
		return mealRepository.save(mealToUpdate);

	}

	@Override
	@Transactional
	public Meal delete(Long id) {
		Optional<Meal> byId = mealRepository.findById(id);
		if (byId.isEmpty()) {
			throw new EntityNotFoundException(String.format("Meal with id %d is not found", id));
		}

		return byId.get();
	}
}
