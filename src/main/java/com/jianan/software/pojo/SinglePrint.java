package com.jianan.software.pojo;

import java.util.Date;

public class SinglePrint {
	
	private int id;
	
	private String name;
	
	private String serviceProducerCardNo;
	
	private String area;
	
	private int serialNo;
	
	private double amount;
	
	private Date createdAt;
	
	private String operatorName;
	
	private int operatorId;
	
	private String address;
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSerialNoStr() {
		if (serialNo < 10) {
			return "00" + serialNo;
		} else if (10 <= serialNo && serialNo < 100) {
			return "0" + serialNo;
		} else {
			return "" + serialNo;
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getServiceProducerCardNo() {
		return serviceProducerCardNo;
	}

	public void setServiceProducerCardNo(String serviceProducerCardNo) {
		this.serviceProducerCardNo = serviceProducerCardNo;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public int getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(int operatorId) {
		this.operatorId = operatorId;
	}
}
