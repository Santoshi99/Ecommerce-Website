package com.ecommapp.backendproject.dto;





public class OrderItemDTO {

    public OrderItemDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderItemDTO(int orderItemId, ProductDTO product, double totalProductprice, OrderDTO order) {
		super();
		this.orderItemId = orderItemId;
		this.product = product;
		this.totalProductprice = totalProductprice;
		this.order = order;
	}
	private int orderItemId;
    private ProductDTO product;
	private double totalProductprice;
	private OrderDTO order;
	public int getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}
	public ProductDTO getProduct() {
		return product;
	}
	public void setProduct(ProductDTO product) {
		this.product = product;
	}
	public double getTotalProductprice() {
		return totalProductprice;
	}
	public void setTotalProductprice(double totalProductprice) {
		this.totalProductprice = totalProductprice;
	}
	public OrderDTO getOrder() {
		return order;
	}
	public void setOrder(OrderDTO order) {
		this.order = order;
	}
}
