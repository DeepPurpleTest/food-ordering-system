package com.example.foodorderingsystem.util.mapper.mapperimpl;

import com.example.foodorderingsystem.dto.DrinkAdditionDto;
import com.example.foodorderingsystem.entity.Addition;
import com.example.foodorderingsystem.entity.Drink;
import com.example.foodorderingsystem.entity.DrinkAddition;
import com.example.foodorderingsystem.util.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class DrinkAdditionMapper implements Mapper<DrinkAddition, DrinkAdditionDto> {
	@Override
	public DrinkAdditionDto mapToDto(DrinkAddition entity) {
		return DrinkAdditionDto.builder()
				.id(entity.getId())
				.drinkId(entity.getDrink().getId())
				.additionId(entity.getAddition().getId())
				.build();
	}

	@Override
	public DrinkAddition mapToEntity(DrinkAdditionDto dto) {
		return DrinkAddition.builder()
				.id(dto.getAdditionId())
				.drink(Drink.builder()
						.id(dto.getDrinkId())
						.build())
				.addition(Addition.builder()
						.id(dto.getId())
						.build())
				.build();
	}
}
