package com.example.foodorderingsystem.service;

import java.util.List;

public interface CrudService<T> {
	List<T> findAll();

	T findOne(Long id);

	T create(T entity);

	T update(T entity);

	T delete(Long id);
}
