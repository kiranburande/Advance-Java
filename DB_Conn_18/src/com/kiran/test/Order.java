package com.kiran.test;

public class Order {
	private String ordId;
	private String custName;
	private String date;
	private int tAmt;
	public Order(String ordId, String custName, String date, int tAmt) {
		super();
		this.ordId = ordId;
		this.custName = custName;
		this.date = date;
		this.tAmt = tAmt;
	}
	public Order() {
		super();
	}
	public String getOrdId() {
		return ordId;
	}
	public void setOrdId(String ordId) {
		this.ordId = ordId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int gettAmt() {
		return tAmt;
	}
	public void settAmt(int tAmt) {
		this.tAmt = tAmt;
	}
	@Override
	public String toString() {
		return "Order [ordId=" + ordId + ", custName=" + custName + ", date=" + date + ", tAmt=" + tAmt + "]";
	}
	
	
}
