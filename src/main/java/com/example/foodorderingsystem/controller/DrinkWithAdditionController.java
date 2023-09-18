package com.example.foodorderingsystem.controller;

import com.example.foodorderingsystem.dto.DrinkWithAdditionDto;
import com.example.foodorderingsystem.entity.DrinkWithAddition;
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
@RequestMapping("/{orderId}/drink-addition")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DrinkWithAdditionController {
	CrudService<DrinkWithAddition> drinkAdditionService;
	Mapper<DrinkWithAddition, DrinkWithAdditionDto> drinkAdditionMapper;

	@GetMapping("/all")
	public List<DrinkWithAdditionDto> getAll() {
		return drinkAdditionService.findAll().stream()
				.map(drinkAdditionMapper::mapToDto)
				.toList();
	}
	@GetMapping("/{id}")
	public DrinkWithAdditionDto getOne(@PathVariable Long id) {
		return drinkAdditionMapper.mapToDto(drinkAdditionService.findOne(id));
	}

	@PostMapping("/create")
	public DrinkWithAdditionDto create(@RequestBody @Valid DrinkWithAdditionDto drinkWithAdditionDto,
									   BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new EntityValidationException("Addition validation exception");
		}

		DrinkWithAddition drinkWithAddition = drinkAdditionMapper.mapToEntity(drinkWithAdditionDto);
		return drinkAdditionMapper.mapToDto(drinkAdditionService.create(drinkWithAddition));
	}

	@PatchMapping("/update")
	public DrinkWithAdditionDto update(@RequestBody @Valid DrinkWithAdditionDto drinkWithAdditionDto,
									   BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new EntityValidationException("Addition validation exception");
		}

		DrinkWithAddition drinkWithAddition = drinkAdditionMapper.mapToEntity(drinkWithAdditionDto);
		return drinkAdditionMapper.mapToDto(drinkAdditionService.update(drinkWithAddition));
	}

	@DeleteMapping("/delete/{id}")
	public DrinkWithAdditionDto delete(@PathVariable Long id) {
		return drinkAdditionMapper.mapToDto(drinkAdditionService.delete(id));
	}
}
