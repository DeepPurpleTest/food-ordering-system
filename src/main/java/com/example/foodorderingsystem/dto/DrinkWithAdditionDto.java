package com.example.foodorderingsystem.dto;

import jakarta.validation.constraints.NotNull;
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
public class DrinkWithAdditionDto {
	@Nullable
	Long id;
	@NotNull
	Long drinkId;
	@NotNull
	boolean hasLemon;
	@NotNull
	boolean hasIce;
}
