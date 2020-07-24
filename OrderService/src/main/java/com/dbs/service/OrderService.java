package com.dbs.service;

import java.util.List;

import com.dbs.pojo.Order;

public interface OrderService {

	List<Order> getOrders();
	 
	Order saveOrder(Order order);
	
	Order findByID(int id);
}
