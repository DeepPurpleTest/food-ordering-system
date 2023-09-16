package com.example.foodorderingsystem.util.mapper.mapperimpl;

import com.example.foodorderingsystem.dto.DrinkDto;
import com.example.foodorderingsystem.entity.Drink;
import com.example.foodorderingsystem.util.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class DrinkMapper implements Mapper<Drink, DrinkDto> {
	@Override
	public DrinkDto mapToDto(Drink entity) {
		return DrinkDto.builder()
				.id(entity.getId())
				.name(entity.getName())
				.price(entity.getPrice())
				.build();
	}

	@Override
	public Drink mapToEntity(DrinkDto dto) {
		return Drink.builder()
				.id(dto.getId())
				.name(dto.getName())
				.price(dto.getPrice())
				.build();
	}
}
