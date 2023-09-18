package com.example.foodorderingsystem.service.serviceimpl;

import com.example.foodorderingsystem.entity.Drink;
import com.example.foodorderingsystem.entity.DrinkWithAddition;
import com.example.foodorderingsystem.entity.Lunch;
import com.example.foodorderingsystem.entity.Order;
import com.example.foodorderingsystem.repository.OrderRepository;
import com.example.foodorderingsystem.service.DrinkAdditionService;
import com.example.foodorderingsystem.service.DrinkService;
import com.example.foodorderingsystem.service.LunchService;
import com.example.foodorderingsystem.service.OrderService;
import com.example.foodorderingsystem.util.exception.EntityNotFoundException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderServiceImpl implements OrderService {
	OrderRepository orderRepository;
	DrinkAdditionService drinkAdditionService;
	DrinkService drinkService;
	LunchService lunchService;

	@Override
	@Transactional(readOnly = true)
	public List<Order> findAll() {
		return orderRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Order findOne(Long id) {
		Optional<Order> byId = orderRepository.findById(id);
		return byId.orElseThrow(() -> new EntityNotFoundException(String.format("Order with id %d is not found", id)));
	}

	@Override
	@Transactional
	public Order create(Order newOrder) {
		Order order = orderRepository.save(Order.builder().build());

		Lunch lunch = newOrder.getLunch();
		if(lunch != null) {
			lunch = lunchService.findOne(lunch.getId());
			order.setLunch(lunch);
		}

		DrinkWithAddition drinkWithAddition = newOrder.getDrinkWithAddition();
		if(drinkWithAddition != null) {
			DrinkWithAddition createdDrinkWithAddition = drinkAdditionService.create(drinkWithAddition);
			Drink drink = drinkWithAddition.getDrink();
			drink = drinkService.findOne(drink.getId());

			createdDrinkWithAddition.setDrink(drink);
			createdDrinkWithAddition.setHasLemon(drinkWithAddition.isHasLemon());
			createdDrinkWithAddition.setHasIce(drinkWithAddition.isHasIce());

			order.setDrinkWithAddition(createdDrinkWithAddition);
		}

		return order;
	}

	@Override
	@Transactional
	public Order update(Order orderToUpdate) {
		return orderRepository.save(orderToUpdate);
	}

	@Override
	@Transactional
	public Order delete(Long id) {
		Optional<Order> byId = orderRepository.findById(id);
		if (byId.isEmpty()) {
			throw new EntityNotFoundException(String.format("Order with id %d is not found", id));
		}

		return byId.get();
	}

	@Override
	public Optional<Order> findById(Long id) {
		return orderRepository.findById(id);
	}
}
