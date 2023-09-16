package com.example.foodorderingsystem.controller;

import com.example.foodorderingsystem.dto.OrderDto;
import com.example.foodorderingsystem.entity.Order;
import com.example.foodorderingsystem.service.CrudService;
import com.example.foodorderingsystem.util.exception.EntityValidationException;
import com.example.foodorderingsystem.util.mapper.Mapper;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderController {
	CrudService<Order> orderService;
	Mapper<Order, OrderDto> orderMapper;

	@GetMapping("/all")
	public List<OrderDto> getAll() {
		return orderService.findAll().stream()
				.map(orderMapper::mapToDto)
				.toList();
	}
	@GetMapping("/{id}")
	public OrderDto getOne(@PathVariable Long id) {
		return orderMapper.mapToDto(orderService.findOne(id));
	}

	@PostMapping("/create")
	public OrderDto create(@RequestBody @Valid OrderDto orderDto,
						  BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new EntityValidationException("Order validation exception");
		}

		Order order = orderMapper.mapToEntity(orderDto);
		return orderMapper.mapToDto(orderService.create(order));
	}

	@PatchMapping("/update")
	public OrderDto update(@RequestBody @Valid OrderDto orderDto,
						  BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new EntityValidationException("Order validation exception");
		}

		Order order = orderMapper.mapToEntity(orderDto);
		return orderMapper.mapToDto(orderService.update(order));
	}

	@DeleteMapping("/delete/{id}")
	public OrderDto delete(@PathVariable Long id) {
		return orderMapper.mapToDto(orderService.delete(id));
	}
}
