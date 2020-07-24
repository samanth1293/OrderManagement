package com.dbs.service;

import java.util.List;

import com.dbs.pojo.OrderItem;

public interface OrderItemService {

	List<OrderItem> getOrderItems();
	 
	void saveOrderItem(OrderItem orderItem);
	
	OrderItem findById(int id);
}
