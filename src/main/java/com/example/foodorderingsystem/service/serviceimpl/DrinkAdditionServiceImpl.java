package com.example.foodorderingsystem.service.serviceimpl;

import com.example.foodorderingsystem.entity.DrinkAddition;
import com.example.foodorderingsystem.repository.DrinkAdditionRepository;
import com.example.foodorderingsystem.service.DrinkAdditionService;
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
public class DrinkAdditionServiceImpl implements DrinkAdditionService {
	DrinkAdditionRepository drinkAdditionRepository;
	@Override
	@Transactional(readOnly = true)
	public List<DrinkAddition> findAll() {
		return drinkAdditionRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public DrinkAddition findOne(Long id) {
		Optional<DrinkAddition> byId = drinkAdditionRepository.findById(id);
		return byId.orElseThrow(() -> new EntityNotFoundException(String.format("DrinkAddition with id %d is not found", id)));
	}

	@Override
	@Transactional
	public DrinkAddition create(DrinkAddition newDrinkAddition) {
		return drinkAdditionRepository.save(newDrinkAddition);
	}

	@Override
	@Transactional
	public DrinkAddition update(DrinkAddition drinkAdditionToUpdate) {
		return drinkAdditionRepository.save(drinkAdditionToUpdate);
	}

	@Override
	@Transactional
	public DrinkAddition delete(Long id) {
		Optional<DrinkAddition> byId = drinkAdditionRepository.findById(id);
		if (byId.isEmpty()) {
			throw new EntityNotFoundException(String.format("DrinkAddition with id %d is not found", id));
		}

		return byId.get();
	}
}