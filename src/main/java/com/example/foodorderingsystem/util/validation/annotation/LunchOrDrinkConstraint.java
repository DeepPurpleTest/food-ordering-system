package com.example.foodorderingsystem.util.validation.annotation;

import com.example.foodorderingsystem.util.validation.OrderValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = OrderValidation.class)
@Target( { ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface LunchOrDrinkConstraint {
	String message() default "Invalid order";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
