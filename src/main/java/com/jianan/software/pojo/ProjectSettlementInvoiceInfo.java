package com.jianan.software.pojo;

import java.util.Date;

public class ProjectSettlementInvoiceInfo {
	private int		id;
	private int 	projectCheckId;
	private Date	nationalInvoiceDate;
	private String	nationalInvoiceNo;
	private String 	nationalInvoiceTaxNo;
	private double	nationalInvoiceAppreciationAmount;
	private String  nationalInvoiceType;
	private Date	localInvoiceDate;
	private String	localInvoiceNo;
	private String 	localInvoiceTaxNo;
	private double	localInvoiceAddtional;
	private String 	attachmentPath;
	
	private double nationnalSettlement;
	
	private double nationalInvoiceAmount;
	private double localInvoiceAmount;
	
	public double getNationalInvoiceAmount() {
		return nationalInvoiceAmount;
	}
	public void setNationalInvoiceAmount(double nationalInvoiceAmount) {
		this.nationalInvoiceAmount = nationalInvoiceAmount;
	}
	public double getLocalInvoiceAmount() {
		return localInvoiceAmount;
	}
	public void setLocalInvoiceAmount(double localInvoiceAmount) {
		this.localInvoiceAmount = localInvoiceAmount;
	}
	public double getNationnalSettlement() {
		return nationnalSettlement;
	}
	public void setNationnalSettlement(double nationnalSettlement) {
		this.nationnalSettlement = nationnalSettlement;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProjectCheckId() {
		return projectCheckId;
	}
	public void setProjectCheckId(int projectCheckId) {
		this.projectCheckId = projectCheckId;
	}
	public Date getNationalInvoiceDate() {
		return nationalInvoiceDate;
	}
	public void setNationalInvoiceDate(Date nationalInvoiceDate) {
		this.nationalInvoiceDate = nationalInvoiceDate;
	}
	public String getNationalInvoiceNo() {
		return nationalInvoiceNo;
	}
	public void setNationalInvoiceNo(String nationalInvoiceNo) {
		this.nationalInvoiceNo = nationalInvoiceNo;
	}
	public String getNationalInvoiceTaxNo() {
		return nationalInvoiceTaxNo;
	}
	public void setNationalInvoiceTaxNo(String nationalInvoiceTaxNo) {
		this.nationalInvoiceTaxNo = nationalInvoiceTaxNo;
	}
	public String getNationalInvoiceType() {
		return nationalInvoiceType;
	}
	public void setNationalInvoiceType(String nationalInvoiceType) {
		this.nationalInvoiceType = nationalInvoiceType;
	}
	public Date getLocalInvoiceDate() {
		return localInvoiceDate;
	}
	public void setLocalInvoiceDate(Date localInvoiceDate) {
		this.localInvoiceDate = localInvoiceDate;
	}
	public String getLocalInvoiceNo() {
		return localInvoiceNo;
	}
	public void setLocalInvoiceNo(String localInvoiceNo) {
		this.localInvoiceNo = localInvoiceNo;
	}
	public String getLocalInvoiceTaxNo() {
		return localInvoiceTaxNo;
	}
	public void setLocalInvoiceTaxNo(String localInvoiceTaxNo) {
		this.localInvoiceTaxNo = localInvoiceTaxNo;
	}
	public String getAttachmentPath() {
		return attachmentPath;
	}
	public void setAttachmentPath(String attachmentPath) {
		this.attachmentPath = attachmentPath;
	}
	public double getNationalInvoiceAppreciationAmount() {
		return nationalInvoiceAppreciationAmount;
	}
	public void setNationalInvoiceAppreciationAmount(
			double nationalInvoiceAppreciationAmount) {
		this.nationalInvoiceAppreciationAmount = nationalInvoiceAppreciationAmount;
	}
	public double getLocalInvoiceAddtional() {
		return localInvoiceAddtional;
	}
	public void setLocalInvoiceAddtional(double localInvoiceAddtional) {
		this.localInvoiceAddtional = localInvoiceAddtional;
	}
}
