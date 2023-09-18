package com.example.foodorderingsystem.util.validation;

import com.example.foodorderingsystem.dto.OrderDto;
import com.example.foodorderingsystem.util.validation.annotation.LunchOrDrinkConstraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable
@RequiredArgsConstructor
public class OrderValidation implements ConstraintValidator<LunchOrDrinkConstraint, OrderDto> {
	@Override
	public boolean isValid(OrderDto orderDto, ConstraintValidatorContext constraintValidatorContext) {
		return orderDto.getLunchId() != null || orderDto.getDrinkWithAddition() != null;
	}
}
