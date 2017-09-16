package com.jianan.software.pojo;

import java.util.Date;

public class HouseContractTaxInfo {
	private int id;
	private int houseContractId;
	private String contractTaxNo;
	private String stampTaxNo;
	private Date contractTaxDate;
	private Date stampTaxDate;
	private Date createdAt;
	private int operatorId;
	private String operatorName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHouseContractId() {
		return houseContractId;
	}

	public void setHouseContractId(int houseContractId) {
		this.houseContractId = houseContractId;
	}

	public String getContractTaxNo() {
		return contractTaxNo;
	}

	public void setContractTaxNo(String contractTaxNo) {
		this.contractTaxNo = contractTaxNo;
	}

	public String getStampTaxNo() {
		return stampTaxNo;
	}

	public void setStampTaxNo(String stampTaxNo) {
		this.stampTaxNo = stampTaxNo;
	}

	public Date getContractTaxDate() {
		return contractTaxDate;
	}

	public void setContractTaxDate(Date contractTaxDate) {
		this.contractTaxDate = contractTaxDate;
	}

	public Date getStampTaxDate() {
		return stampTaxDate;
	}

	public void setStampTaxDate(Date stampTaxDate) {
		this.stampTaxDate = stampTaxDate;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public int getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(int operatorId) {
		this.operatorId = operatorId;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
}
