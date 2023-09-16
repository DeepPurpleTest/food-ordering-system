package com.example.foodorderingsystem.service.serviceimpl;

import com.example.foodorderingsystem.entity.Cuisine;
import com.example.foodorderingsystem.repository.CuisineRepository;
import com.example.foodorderingsystem.service.CuisineService;
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
public class CuisineServiceImpl implements CuisineService {
	CuisineRepository cuisineRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Cuisine> findAll() {
		return cuisineRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Cuisine findOne(Long id) {
		Optional<Cuisine> byId = cuisineRepository.findById(id);
		return byId.orElseThrow(() -> new EntityNotFoundException(String.format("Cuisine with id %d is not found", id)));
	}

	@Override
	@Transactional
	public Cuisine create(Cuisine newCuisine) {
		return cuisineRepository.save(newCuisine);
	}

	@Override
	@Transactional
	public Cuisine update(Cuisine cuisineToUpdate) {
		return cuisineRepository.save(cuisineToUpdate);
	}

	@Override
	@Transactional
	public Cuisine delete(Long id) {
		Optional<Cuisine> byId = cuisineRepository.findById(id);
		if (byId.isEmpty()) {
			throw new EntityNotFoundException(String.format("Cuisine with id %d is not found", id));
		}

		return byId.get();
	}
}
