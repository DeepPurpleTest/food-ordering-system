package com.example.foodorderingsystem.util.mapper.mapperimpl;

import com.example.foodorderingsystem.dto.OrderDto;
import com.example.foodorderingsystem.entity.DrinkAddition;
import com.example.foodorderingsystem.entity.Lunch;
import com.example.foodorderingsystem.entity.Order;
import com.example.foodorderingsystem.util.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper implements Mapper<Order, OrderDto> {
	@Override
	public OrderDto mapToDto(Order entity) {
		return OrderDto.builder()
				.id(entity.getId())
				.lunchId(entity.getLunch().getId())
				.drinkAdditionId(entity.getDrink().getId())
				.build();
	}

	@Override
	public Order mapToEntity(OrderDto dto) {
		return Order.builder()
				.id(dto.getId())
				.lunch(Lunch.builder()
						.id(dto.getLunchId())
						.build())
				.drink(DrinkAddition.builder()
						.id(dto.getDrinkAdditionId())
						.build())
				.build();
	}
}
