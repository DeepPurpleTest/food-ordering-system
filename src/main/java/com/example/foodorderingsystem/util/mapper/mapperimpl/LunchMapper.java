package com.example.foodorderingsystem.util.mapper.mapperimpl;

import com.example.foodorderingsystem.dto.LunchDto;
import com.example.foodorderingsystem.entity.Cuisine;
import com.example.foodorderingsystem.entity.Dessert;
import com.example.foodorderingsystem.entity.Lunch;
import com.example.foodorderingsystem.entity.Meal;
import com.example.foodorderingsystem.util.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class LunchMapper implements Mapper<Lunch, LunchDto> {

	@Override
	public LunchDto mapToDto(Lunch entity) {
		return LunchDto.builder()
				.id(entity.getId())
				.name(entity.getName())
				.cuisineId(entity.getCuisine().getId())
				.dessertId(entity.getDessert().getId())
				.mealId(entity.getMeal().getId())
				.build();
	}

	@Override
	public Lunch mapToEntity(LunchDto dto) {
		return Lunch.builder()
				.id(dto.getId())
				.name(dto.getName())
				.cuisine(Cuisine.builder()
						.id(dto.getCuisineId())
						.build())
				.dessert(Dessert.builder()
						.id(dto.getDessertId())
						.build())
				.meal(Meal.builder()
						.id(dto.getMealId())
						.build())
				.build();
	}
}
