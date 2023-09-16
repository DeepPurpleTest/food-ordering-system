package com.example.foodorderingsystem.dto;

import com.example.foodorderingsystem.util.validation.annotation.LunchOrDrinkConstraint;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.Nullable;

@Getter
@Setter
@Builder
@Jacksonized
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@LunchOrDrinkConstraint
public class OrderDto {
	@Nullable
	Long id;

	@Nullable
	Long lunchId;

	@Nullable
	Long drinkAdditionId;
}
