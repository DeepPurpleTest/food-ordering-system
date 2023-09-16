package com.example.foodorderingsystem.util.mapper.mapperimpl;

import com.example.foodorderingsystem.dto.MealDto;
import com.example.foodorderingsystem.entity.Meal;
import com.example.foodorderingsystem.util.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class MealMapper implements Mapper<Meal, MealDto> {
	@Override
	public MealDto mapToDto(Meal entity) {
		return MealDto.builder()
				.id(entity.getId())
				.name(entity.getName())
				.price(entity.getPrice())
				.build();
	}

	@Override
	public Meal mapToEntity(MealDto dto) {
		return Meal.builder()
				.id(dto.getId())
				.name(dto.getName())
				.price(dto.getPrice())
				.build();
	}
}
