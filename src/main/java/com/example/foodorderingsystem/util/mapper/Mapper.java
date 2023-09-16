package com.example.foodorderingsystem.util.mapper;

public interface Mapper<T, U>{
	U mapToDto(T entity);
	T mapToEntity(U dto);
}
