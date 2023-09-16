package com.example.foodorderingsystem.service.serviceimpl;

import com.example.foodorderingsystem.entity.Dessert;
import com.example.foodorderingsystem.repository.DessertRepository;
import com.example.foodorderingsystem.service.DessertService;
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
public class DessertServiceImpl implements DessertService {
	DessertRepository dessertRepository;
	@Override
	@Transactional(readOnly = true)
	public List<Dessert> findAll() {
		return dessertRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Dessert findOne(Long id) {
		Optional<Dessert> byId = dessertRepository.findById(id);
		return byId.orElseThrow(() -> new EntityNotFoundException(String.format("Dessert with id %d is not found", id)));
	}

	@Transactional(readOnly = true)
	public Optional<Dessert> finById(Long id){
		return dessertRepository.findById(id);
	}

	@Override
	@Transactional
	public Dessert create(Dessert newDessert) {
		return dessertRepository.save(newDessert);
	}

	@Override
	@Transactional
	public Dessert update(Dessert dessertToUpdate) {
		return dessertRepository.save(dessertToUpdate);
	}

	@Override
	@Transactional
	public Dessert delete(Long id) {
		Optional<Dessert> byId = dessertRepository.findById(id);
		if (byId.isEmpty()) {
			throw new EntityNotFoundException(String.format("Dessert with id %d is not found", id));
		}

		return byId.get();
	}
}
