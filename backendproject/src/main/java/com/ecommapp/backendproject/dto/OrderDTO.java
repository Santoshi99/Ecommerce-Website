package com.ecommapp.backendproject.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;



public class OrderDTO {

	public OrderDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDTO(int orderId, String orderStatus, String paymentStatus, Date orderDelivered, double orderAmt,
			String billingAddress, UserDTO user, Set<OrderItemDTO> orderItem) {
		super();
		this.orderId = orderId;
		this.orderStatus = orderStatus;
		this.paymentStatus = paymentStatus;
		this.orderDelivered = orderDelivered;
		this.orderAmt = orderAmt;
		this.billingAddress = billingAddress;
		this.user = user;
		this.orderItem = orderItem;
	}
	private int orderId;
	private String orderStatus;
	private String paymentStatus;
	private Date orderDelivered;
	private double orderAmt;
	private String billingAddress;
	private UserDTO user;
	private Set<OrderItemDTO> orderItem = new HashSet<>();
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public Date getOrderDelivered() {
		return orderDelivered;
	}
	public void setOrderDelivered(Date orderDelivered) {
		this.orderDelivered = orderDelivered;
	}
	public double getOrderAmt() {
		return orderAmt;
	}
	public void setOrderAmt(double orderAmt) {
		this.orderAmt = orderAmt;
	}
	public String getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}
	public UserDTO getUser() {
		return user;
	}
	public void setUser(UserDTO user) {
		this.user = user;
	}
	public Set<OrderItemDTO> getOrderItem() {
		return orderItem;
	}
	public void setOrderItem(Set<OrderItemDTO> orderItem) {
		this.orderItem = orderItem;
	}
}
