package com.example.foodorderingsystem.util.mapper.mapperimpl;

import com.example.foodorderingsystem.dto.CuisineDto;
import com.example.foodorderingsystem.entity.Cuisine;
import com.example.foodorderingsystem.util.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class CuisineMapper implements Mapper<Cuisine, CuisineDto> {
	@Override
	public CuisineDto mapToDto(Cuisine entity) {
		return CuisineDto.builder()
				.id(entity.getId())
				.name(entity.getName())
				.build();
	}

	@Override
	public Cuisine mapToEntity(CuisineDto dto) {
		return Cuisine.builder()
				.id(dto.getId())
				.name(dto.getName())
				.build();
	}
}
