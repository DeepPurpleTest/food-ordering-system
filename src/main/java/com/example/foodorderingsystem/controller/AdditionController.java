package com.example.foodorderingsystem.controller;

import com.example.foodorderingsystem.dto.AdditionDto;
import com.example.foodorderingsystem.entity.Addition;
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
@RequestMapping("/addition")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AdditionController {
	CrudService<Addition> additionService;
	Mapper<Addition, AdditionDto> additionMapper;

	@GetMapping("/all")
	public List<AdditionDto> getAll() {
		return additionService.findAll().stream()
				.map(additionMapper::mapToDto)
				.toList();
	}
	@GetMapping("/{id}")
	public AdditionDto getOne(@PathVariable Long id) {
		return additionMapper.mapToDto(additionService.findOne(id));
	}

	@PostMapping("/create")
	public AdditionDto create(@RequestBody @Valid AdditionDto additionDto,
							 BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new EntityValidationException("Addition validation exception");
		}

		Addition addition = additionMapper.mapToEntity(additionDto);
		return additionMapper.mapToDto(additionService.create(addition));
	}

	@PatchMapping("/update")
	public AdditionDto update(@RequestBody @Valid AdditionDto additionDto,
							 BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new EntityValidationException("Addition validation exception");
		}

		Addition addition = additionMapper.mapToEntity(additionDto);
		return additionMapper.mapToDto(additionService.update(addition));
	}

	@DeleteMapping("/delete/{id}")
	public AdditionDto delete(@PathVariable Long id) {
		return additionMapper.mapToDto(additionService.delete(id));
	}
}
