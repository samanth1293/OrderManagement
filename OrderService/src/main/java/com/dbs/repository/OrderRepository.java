package com.dbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbs.pojo.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {

}
