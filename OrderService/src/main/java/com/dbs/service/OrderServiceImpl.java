package com.dbs.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.pojo.Order;
import com.dbs.pojo.OrderItem;
import com.dbs.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	OrderItemClient orderItemClient;
	
	@Override
	public List<Order> getOrders() {
		return orderRepository.findAll();
	}

	@Override
	public Order saveOrder(Order order) {
		order.setOrderedDate(new Date(System.currentTimeMillis()));
		Order result=orderRepository.save(order);
		OrderItem orderItem=order.getOrderItems().get(0);
		orderItem.setOrder(result);
		orderItemClient.orderItemSave(orderItem);
		return result;
	}

	@Override
	public Order findByID(int id) {
		Optional<Order> optional=orderRepository.findById(id);
		return optional.isPresent()?optional.get():null;
	}



}
