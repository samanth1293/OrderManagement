package com.dbs.pojo;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="orders")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Order  {

	private Integer id;

	private String customerName;

	private Date orderedDate;

	private Address address;

	private List<OrderItem> orderItems;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "customer_name",nullable = false)
	@NotNull(message = "Customer Name must be provide")
	@Size(min=2, max=30)
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	@Column(name = "ordered_date",nullable = false)
	public Date getOrderedDate() {
		return orderedDate;
	}

	public void setOrderedDate(Date orderedDate) {
		this.orderedDate = orderedDate;
	}

	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name ="add_id")
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}




	@OneToMany(mappedBy = "order")
	public List<OrderItem> getOrderItems() {
		return orderItems; 
	}

	public void setOrderItems(List<OrderItem> orderItems){ 
		this.orderItems = orderItems; }





}
