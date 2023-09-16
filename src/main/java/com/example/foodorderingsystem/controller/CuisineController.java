package com.example.foodorderingsystem.controller;

import com.example.foodorderingsystem.dto.CuisineDto;
import com.example.foodorderingsystem.entity.Cuisine;
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
@RequestMapping("/cuisine")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CuisineController {
	CrudService<Cuisine> cuisineService;
	Mapper<Cuisine, CuisineDto> cuisineMapper;

	@GetMapping("/all")
	public List<CuisineDto> getAll() {
		return cuisineService.findAll().stream()
				.map(cuisineMapper::mapToDto)
				.toList();
	}

	@GetMapping("/{id}")
	public CuisineDto getOne(@PathVariable Long id) {
		return cuisineMapper.mapToDto(cuisineService.findOne(id));
	}

	@PostMapping("/create")
	public CuisineDto create(@RequestBody @Valid CuisineDto cuisineDto,
						  BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new EntityValidationException("Cuisine validation exception");
		}

		Cuisine cuisine = cuisineMapper.mapToEntity(cuisineDto);
		return cuisineMapper.mapToDto(cuisineService.create(cuisine));
	}

	@PatchMapping("/update")
	public CuisineDto update(@RequestBody @Valid CuisineDto cuisineDto,
						  BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new EntityValidationException("Cuisine validation exception");
		}

		Cuisine cuisine = cuisineMapper.mapToEntity(cuisineDto);
		return cuisineMapper.mapToDto(cuisineService.update(cuisine));
	}

	@DeleteMapping("/delete/{id}")
	public CuisineDto delete(@PathVariable Long id) {
		return cuisineMapper.mapToDto(cuisineService.delete(id));
	}
}
