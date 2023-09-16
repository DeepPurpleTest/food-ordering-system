package com.example.foodorderingsystem.util.mapper.mapperimpl;

import com.example.foodorderingsystem.dto.DessertDto;
import com.example.foodorderingsystem.entity.Dessert;
import com.example.foodorderingsystem.util.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class DessertMapper implements Mapper<Dessert, DessertDto> {
	@Override
	public DessertDto mapToDto(Dessert entity) {
		return DessertDto.builder()
				.id(entity.getId())
				.name(entity.getName())
				.price(entity.getPrice())
				.build();
	}

	@Override
	public Dessert mapToEntity(DessertDto dto) {
		return Dessert.builder()
				.id(dto.getId())
				.name(dto.getName())
				.price(dto.getPrice())
				.build();
	}
}
