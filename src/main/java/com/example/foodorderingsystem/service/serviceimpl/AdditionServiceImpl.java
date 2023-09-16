package com.example.foodorderingsystem.service.serviceimpl;

import com.example.foodorderingsystem.entity.Addition;
import com.example.foodorderingsystem.repository.AdditionRepository;
import com.example.foodorderingsystem.service.AdditionService;
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
public class AdditionServiceImpl implements AdditionService {
	AdditionRepository additionRepository;
	@Override
	@Transactional(readOnly = true)
	public List<Addition> findAll() {
		return additionRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Addition findOne(Long id) {
		Optional<Addition> byId = additionRepository.findById(id);
		return byId.orElseThrow(() -> new EntityNotFoundException(String.format("Addition with id %d is not found", id)));
	}

	@Override
	@Transactional
	public Addition create(Addition newAddition) {
		return additionRepository.save(newAddition);
	}

	@Override
	@Transactional
	public Addition update(Addition additionToUpdate) {
		return additionRepository.save(additionToUpdate);
	}

	@Override
	@Transactional
	public Addition delete(Long id) {
		Optional<Addition> byId = additionRepository.findById(id);
		if (byId.isEmpty()) {
			throw new EntityNotFoundException(String.format("Addition with id %d is not found", id));
		}

		return byId.get();
	}
}
