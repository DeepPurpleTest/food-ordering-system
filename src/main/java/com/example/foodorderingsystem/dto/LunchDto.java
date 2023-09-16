package com.example.foodorderingsystem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
public class LunchDto {
	@Nullable
	Long id;
	@NotBlank
	String name;
	@NotNull
	@Positive(message = "cuisineId must be greater then 0")
	Long cuisineId;
	@NotNull
	@Positive(message = "mealId must be greater then 0")
	Long mealId;
	@NotNull
	@Positive(message = "dessertId must be greater then 0")
	Long dessertId;
}
