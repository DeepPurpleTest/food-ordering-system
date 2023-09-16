package com.example.foodorderingsystem.service;

import com.example.foodorderingsystem.entity.Order;

import java.util.List;

public interface OrderService extends CrudService<Order> {
	List<Order> findAll();

	Order findOne(Long id);

	Order create(Order newOrder);

	Order update(Order orderToUpdate);

	Order delete(Long id);
}
