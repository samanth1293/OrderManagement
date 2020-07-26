package com.dbs.controller;

import java.sql.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.exception.OrderItemNotFoundException;
import com.dbs.pojo.OrderItem;
import com.dbs.service.OrderItemService;

@RestController
@RequestMapping("/orderItem")
public class OrderItemController {

	@Autowired
	OrderItemService orderItemService;

	@PostMapping(value="/saveOrder")
	public void orderItemByOwn(@Valid @RequestBody OrderItem orderItem) 	{
		orderItem.setCreationDate(new Date(System.currentTimeMillis()));
		orderItemService.saveOrderItem(orderItem);
	}
	
	@PostMapping(value="/save")
	public void orderItemSave(@Valid @RequestBody OrderItem orderItem) 	{
		orderItem.setCreationDate(new Date(System.currentTimeMillis()));
		orderItemService.saveOrder(orderItem);
	}

	@GetMapping(value = "/retriveAll",produces ="application/json")
	public List<OrderItem> retiveAll() {
		return orderItemService.getOrderItems();
	}
	
	@GetMapping(value = "/retrive/{id}",produces ="application/json")
	public OrderItem retive(@PathVariable("id") String id) throws OrderItemNotFoundException {
		OrderItem orderItem=orderItemService.findById(Integer.valueOf(id));
		if(orderItem==null) {
			throw new OrderItemNotFoundException("Invalid OrderItem");
		}
		return orderItem;
	}
	

}
