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
public class AdditionDto {
	@Nullable
	Long id;
	@NotNull
	Boolean withLemon;
	@NotNull
	Boolean withIce;

}
