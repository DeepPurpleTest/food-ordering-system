package com.example.foodorderingsystem.util.mapper.mapperimpl;

import com.example.foodorderingsystem.dto.DrinkWithAdditionDto;
import com.example.foodorderingsystem.entity.Drink;
import com.example.foodorderingsystem.entity.DrinkWithAddition;
import com.example.foodorderingsystem.util.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class DrinkAdditionMapper implements Mapper<DrinkWithAddition, DrinkWithAdditionDto> {
	@Override
	public DrinkWithAdditionDto mapToDto(DrinkWithAddition entity) {
		return DrinkWithAdditionDto.builder()
				.drinkId(entity.getDrink().getId())
				.hasLemon(entity.isHasLemon())
				.hasIce(entity.isHasIce())
				.build();
	}

	@Override
	public DrinkWithAddition mapToEntity(DrinkWithAdditionDto dto) {
		return DrinkWithAddition.builder()
				.drink(Drink.builder()
						.id(dto.getDrinkId())
						.build())
				.hasIce(dto.isHasIce())
				.hasLemon(dto.isHasLemon())
				.build();
	}
}
