package com.dbs.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.dbs.pojo.OrderItem;

@FeignClient(name= "ORDER-ITEM-SERVICE")
public interface OrderItemClient {
	
	@PostMapping(value = "/orderItem/save")
	public void orderItemSave(@RequestBody OrderItem orderItem) ;

}
