package com.example.foodorderingsystem.controller;

import com.example.foodorderingsystem.dto.LunchDto;
import com.example.foodorderingsystem.entity.Lunch;
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
@RequestMapping("/lunch")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LunchController {
	CrudService<Lunch> lunchService;
	Mapper<Lunch, LunchDto> lunchMapper;

	@GetMapping("/all")
	public List<LunchDto> getAll() {
		return lunchService.findAll().stream()
				.map(lunchMapper::mapToDto)
				.toList();
	}
	@GetMapping("/{id}")
	public LunchDto getOne(@PathVariable Long id) {
		return lunchMapper.mapToDto(lunchService.findOne(id));
	}

	@PostMapping("/create")
	public LunchDto create(@RequestBody @Valid LunchDto lunchDto,
						  BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new EntityValidationException("Lunch validation exception");
		}

		Lunch lunch = lunchMapper.mapToEntity(lunchDto);
		return lunchMapper.mapToDto(lunchService.create(lunch));
	}

	@PatchMapping("/update")
	public LunchDto update(@RequestBody @Valid LunchDto lunchDto,
						  BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new EntityValidationException("Lunch validation exception");
		}

		Lunch lunch = lunchMapper.mapToEntity(lunchDto);
		return lunchMapper.mapToDto(lunchService.update(lunch));
	}

	@DeleteMapping("/delete/{id}")
	public LunchDto delete(@PathVariable Long id) {
		return lunchMapper.mapToDto(lunchService.delete(id));
	}
}
