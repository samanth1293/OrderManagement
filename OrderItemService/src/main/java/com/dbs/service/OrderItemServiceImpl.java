package com.dbs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.pojo.Order;
import com.dbs.pojo.OrderItem;
import com.dbs.repository.OrderItemRepository;

@Service
public class OrderItemServiceImpl implements OrderItemService{
	
	@Autowired
	OrderItemRepository orderItemRepository;
	
	@Autowired
	OrderClient orderClient;

	@Override
	public List<OrderItem> getOrderItems() {
		return orderItemRepository.findAll();
	}

	@Override
	public void saveOrderItem(OrderItem orderItem) {
		Order order=orderClient.orderSave(orderItem.getOrder());
		orderItem.setOrder(order);
		orderItemRepository.save(orderItem);
		
	}

	@Override
	public OrderItem findById(int id) {
		Optional<OrderItem> optional=orderItemRepository.findById(id);
		return optional.isPresent()?optional.get():null;
	}
	
	

}
