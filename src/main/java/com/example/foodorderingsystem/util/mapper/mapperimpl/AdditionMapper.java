package com.example.foodorderingsystem.util.mapper.mapperimpl;

import com.example.foodorderingsystem.dto.AdditionDto;
import com.example.foodorderingsystem.entity.Addition;
import com.example.foodorderingsystem.util.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class AdditionMapper implements Mapper<Addition, AdditionDto> {
	@Override
	public AdditionDto mapToDto(Addition entity) {
		return AdditionDto.builder()
				.id(entity.getId())
				.withLemon(entity.getLemon())
				.withIce(entity.getIce())
				.build();
	}

	@Override
	public Addition mapToEntity(AdditionDto dto) {
		return Addition.builder()
				.id(dto.getId())
				.lemon(dto.getWithLemon())
				.ice(dto.getWithIce())
				.build();
	}
}
