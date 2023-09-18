package com.example.foodorderingsystem.util.mapper.mapperimpl;

import com.example.foodorderingsystem.dto.DrinkWithAdditionDto;
import com.example.foodorderingsystem.dto.OrderDto;
import com.example.foodorderingsystem.entity.Drink;
import com.example.foodorderingsystem.entity.DrinkWithAddition;
import com.example.foodorderingsystem.entity.Lunch;
import com.example.foodorderingsystem.entity.Order;
import com.example.foodorderingsystem.util.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper implements Mapper<Order, OrderDto> {
	@Override
	public OrderDto mapToDto(Order entity) {
		OrderDto orderDto = OrderDto.builder()
				.id(entity.getId())
				.build();

		Lunch lunch = entity.getLunch();
		DrinkWithAddition drinkWithAddition = entity.getDrinkWithAddition();

		if (lunch != null) {
			orderDto.setLunchId(lunch.getId());
		}

		if (drinkWithAddition != null) {
			orderDto.setDrinkWithAddition(DrinkWithAdditionDto.builder()
					.id(drinkWithAddition.getId())
					.drinkId(drinkWithAddition.getDrink().getId())
					.hasIce(drinkWithAddition.isHasIce())
					.hasLemon(drinkWithAddition.isHasLemon())
					.build());
		}

		return orderDto;
	}

	@Override
	public Order mapToEntity(OrderDto dto) {
		Order order = Order.builder()
				.id(dto.getId())
				.build();

		if (dto.getLunchId() != null) {
			order.setLunch(Lunch.builder()
					.id(dto.getLunchId())
					.build());
		}


		DrinkWithAdditionDto drinkWithAdditionDto = dto.getDrinkWithAddition();
		if (drinkWithAdditionDto != null) {
			order.setDrinkWithAddition(DrinkWithAddition.builder()
					.drink(Drink.builder()
							.id(drinkWithAdditionDto.getDrinkId())
							.build())
					.hasLemon(drinkWithAdditionDto.isHasLemon())
					.hasIce(drinkWithAdditionDto.isHasIce())
					.build());
		}

		return order;
	}
}
