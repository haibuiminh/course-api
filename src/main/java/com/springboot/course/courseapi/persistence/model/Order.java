package com.springboot.course.courseapi.persistence.model;

import org.springframework.hateoas.RepresentationModel;

public class Order extends RepresentationModel<Order> {

	private String orderId;

	private double price;

	private int quantity;

	public Order() {
		super();
	}

	public Order(final String orderId, final double price, final int quantity) {
		this.orderId = orderId;
		this.price = price;
		this.quantity = quantity;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", price=" + price + ", quantity=" + quantity + "]";
	}

}