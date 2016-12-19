package com.nongming.sunshine.entity;

public class Order {
	private int orderId;//订单id
	private String orderNum;//订单号
	private int userId;//用户Id
	private int amount;//订单金额（单位为分）
	private String createDate;//订单时间
	private String loseDate;//失效时间
	private int orderState;//订单状态:0为成功、1为待支付、2为失效
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getLoseDate() {
		return loseDate;
	}
	public void setLoseDate(String loseDate) {
		this.loseDate = loseDate;
	}
	public int getOrderState() {
		return orderState;
	}
	public void setOrderState(int orderState) {
		this.orderState = orderState;
	}
}
