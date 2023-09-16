package com.example.foodorderingsystem.controller;

import com.example.foodorderingsystem.dto.DrinkAdditionDto;
import com.example.foodorderingsystem.entity.DrinkAddition;
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
@RequestMapping("/drink-addition")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DrinkAdditionController {
	CrudService<DrinkAddition> drinkAdditionService;
	Mapper<DrinkAddition, DrinkAdditionDto> drinkAdditionMapper;

	@GetMapping("/all")
	public List<DrinkAdditionDto> getAll() {
		return drinkAdditionService.findAll().stream()
				.map(drinkAdditionMapper::mapToDto)
				.toList();
	}
	@GetMapping("/{id}")
	public DrinkAdditionDto getOne(@PathVariable Long id) {
		return drinkAdditionMapper.mapToDto(drinkAdditionService.findOne(id));
	}

	@PostMapping("/create")
	public DrinkAdditionDto create(@RequestBody @Valid DrinkAdditionDto drinkAdditionDto,
							  BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new EntityValidationException("Addition validation exception");
		}

		DrinkAddition drinkAddition = drinkAdditionMapper.mapToEntity(drinkAdditionDto);
		return drinkAdditionMapper.mapToDto(drinkAdditionService.create(drinkAddition));
	}

	@PatchMapping("/update")
	public DrinkAdditionDto update(@RequestBody @Valid DrinkAdditionDto drinkAdditionDto,
							  BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new EntityValidationException("Addition validation exception");
		}

		DrinkAddition drinkAddition = drinkAdditionMapper.mapToEntity(drinkAdditionDto);
		return drinkAdditionMapper.mapToDto(drinkAdditionService.update(drinkAddition));
	}

	@DeleteMapping("/delete/{id}")
	public DrinkAdditionDto delete(@PathVariable Long id) {
		return drinkAdditionMapper.mapToDto(drinkAdditionService.delete(id));
	}
}
