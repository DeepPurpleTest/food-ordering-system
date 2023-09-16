package com.example.foodorderingsystem.controller;

import com.example.foodorderingsystem.dto.MealDto;
import com.example.foodorderingsystem.entity.Meal;
import com.example.foodorderingsystem.service.CrudService;
import com.example.foodorderingsystem.util.exception.EntityValidationException;
import com.example.foodorderingsystem.util.mapper.Mapper;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/meal")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MealController {
	CrudService<Meal> mealService;
	Mapper<Meal, MealDto> mealMapper;

	@GetMapping("/all")
	public List<MealDto> getAll() {
		return mealService.findAll().stream()
				.map(mealMapper::mapToDto)
				.toList();
	}
	@GetMapping("/{id}")
	public MealDto getOne(@PathVariable Long id) {
		return mealMapper.mapToDto(mealService.findOne(id));
	}

	@PostMapping("/create")
	public MealDto create(@RequestBody @Valid MealDto mealDto,
						  BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new EntityValidationException("Meal validation exception");
		}

		Meal meal = mealMapper.mapToEntity(mealDto);
		return mealMapper.mapToDto(mealService.create(meal));
	}

	@PatchMapping("/update")
	public MealDto update(@RequestBody @Valid MealDto mealDto,
						  BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new EntityValidationException("Meal validation exception");
		}

		Meal meal = mealMapper.mapToEntity(mealDto);
		return mealMapper.mapToDto(mealService.update(meal));
	}

	@DeleteMapping("/delete/{id}")
	public MealDto delete(@PathVariable Long id) {
		return mealMapper.mapToDto(mealService.delete(id));
	}
}
