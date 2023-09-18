package com.example.foodorderingsystem.service.serviceimpl;

import com.example.foodorderingsystem.entity.Drink;
import com.example.foodorderingsystem.repository.DrinkRepository;
import com.example.foodorderingsystem.service.DrinkService;
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
public class DrinkServiceImpl implements DrinkService {
	DrinkRepository drinkRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Drink> findAll() {
		return drinkRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Drink findOne(Long id) {
		Optional<Drink> byId = drinkRepository.findById(id);
		return byId.orElseThrow(() -> new EntityNotFoundException(String.format("Drink with id %d is not found", id)));
	}

	@Override
	@Transactional
	public Drink create(Drink newDrink) {
		return drinkRepository.save(newDrink);
	}

	@Override
	@Transactional
	public Drink update(Drink drinkToUpdate) {
		return drinkRepository.save(drinkToUpdate);
	}

	@Override
	@Transactional
	public Drink delete(Long id) {
		Optional<Drink> byId = drinkRepository.findById(id);
		if (byId.isEmpty()) {
			throw new EntityNotFoundException(String.format("Drink with id %d is not found", id));
		}

		return byId.get();
	}

	@Override
	public Optional<Drink> findById(Long id) {
		return drinkRepository.findById(id);
	}
}
