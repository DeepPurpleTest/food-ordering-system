package com.example.foodorderingsystem.controller;

import com.example.foodorderingsystem.dto.DessertDto;
import com.example.foodorderingsystem.entity.Dessert;
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
@RequestMapping("/dessert")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DessertController {
	CrudService<Dessert> dessertService;
	Mapper<Dessert, DessertDto> dessertMapper;

	@GetMapping("/all")
	public List<DessertDto> getAll() {
		return dessertService.findAll().stream()
				.map(dessertMapper::mapToDto)
				.toList();
	}
	@GetMapping("/{id}")
	public DessertDto getOne(@PathVariable Long id) {
		return dessertMapper.mapToDto(dessertService.findOne(id));
	}

	@PostMapping("/create")
	public DessertDto create(@RequestBody @Valid DessertDto dessertDto,
						  BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new EntityValidationException("Dessert validation exception");
		}

		Dessert dessert = dessertMapper.mapToEntity(dessertDto);
		return dessertMapper.mapToDto(dessertService.create(dessert));
	}

	@PatchMapping("/update")
	public DessertDto update(@RequestBody @Valid DessertDto dessertDto,
						  BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new EntityValidationException("Dessert validation exception");
		}

		Dessert dessert = dessertMapper.mapToEntity(dessertDto);
		return dessertMapper.mapToDto(dessertService.update(dessert));
	}

	@DeleteMapping("/delete/{id}")
	public DessertDto delete(@PathVariable Long id) {
		return dessertMapper.mapToDto(dessertService.delete(id));
	}
}
