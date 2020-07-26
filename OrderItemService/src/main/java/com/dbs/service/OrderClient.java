package com.dbs.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.dbs.pojo.Order;

@FeignClient(name= "ORDER-SERVICE")
public interface OrderClient {
	
	@PostMapping(value = "/order/saveOrder")
	public Order orderSave(@RequestBody Order order) ;

}
