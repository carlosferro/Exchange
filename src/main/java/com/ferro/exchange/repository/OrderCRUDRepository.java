package com.ferro.exchange.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ferro.exchange.model.orderbook.Order;
import com.ferro.exchange.model.orderbook.OrderSide;

@Repository
public interface OrderCRUDRepository extends CrudRepository<Order, Long> {
	Iterable<Order> findAllBySide(String category);

	Iterable<Order> findAllByCategoryOrderByName(OrderSide side);

	long countBySide(OrderSide side);

//	Iterable<Order> findByNameOrCategory(String name, String category);

//	Iterable<Order> findByNameStartsWith(String name);

//	Stream<Order> streamAllByCategory(String category);
}