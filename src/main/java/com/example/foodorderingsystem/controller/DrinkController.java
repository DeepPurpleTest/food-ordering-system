package com.example.foodorderingsystem.controller;

import com.example.foodorderingsystem.dto.DrinkDto;
import com.example.foodorderingsystem.entity.Drink;
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
@RequestMapping("/drink")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DrinkController {
	CrudService<Drink> drinkService;
	Mapper<Drink, DrinkDto> drinkMapper;

	@GetMapping("/all")
	public List<DrinkDto> getAll() {
		return drinkService.findAll().stream()
				.map(drinkMapper::mapToDto)
				.toList();
	}
	@GetMapping("/{id}")
	public DrinkDto getOne(@PathVariable Long id) {
		return drinkMapper.mapToDto(drinkService.findOne(id));
	}

	@PostMapping("/create")
	public DrinkDto create(@RequestBody @Valid DrinkDto drinkDto,
						  BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new EntityValidationException("Drink validation exception");
		}

		Drink drink = drinkMapper.mapToEntity(drinkDto);
		return drinkMapper.mapToDto(drinkService.create(drink));
	}

	@PatchMapping("/update")
	public DrinkDto update(@RequestBody @Valid DrinkDto drinkDto,
						  BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new EntityValidationException("Drink validation exception");
		}

		Drink drink = drinkMapper.mapToEntity(drinkDto);
		return drinkMapper.mapToDto(drinkService.update(drink));
	}

	@DeleteMapping("/delete/{id}")
	public DrinkDto delete(@PathVariable Long id) {
		return drinkMapper.mapToDto(drinkService.delete(id));
	}
}
