package com.dbs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.exception.OrderNotFoundException;
import com.dbs.pojo.Order;
import com.dbs.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService orderService;
	
	

	@PostMapping("/save")
	public Order orderSave(@Valid @RequestBody Order order) 	{
		return orderSave(order);
	}

	@GetMapping(value="/retriveAll",produces ="application/json")
	public List<Order> retriveAll() {
		return orderService.getOrders();
	}
	
	@GetMapping(value="reetrive/{id}",produces ="application/json")
	public Order retrive(@PathVariable("id") String id) throws OrderNotFoundException {
		Order order=orderService.findByID(Integer.valueOf(id));
		if(order==null) {
			throw new OrderNotFoundException("Invalid Order");
		}
		return order;
	}

}
