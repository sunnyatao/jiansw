package com.jianan.software.pojo;

import java.util.Date;

public class ProjectOutertubeInvoiceInfo {
	private int		id;
	private int 	projectOuterubeId;
	private Date	nationalInvoiceDate;
	private String	nationalInvoiceNo;
	private String 	nationalInvoiceTaxNo;
	private String  nationalInvoiceType;
	private Date	localInvoiceDate;
	private String	localInvoiceNo;
	private String 	localInvoiceTaxNo;
	private String 	attachmentPath;
	private double localInvoiceAmount;
	
	public double getLocalInvoiceAmount() {
		return localInvoiceAmount;
	}
	public void setLocalInvoiceAmount(double localInvoiceAmount) {
		this.localInvoiceAmount = localInvoiceAmount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProjectOuterubeId() {
		return projectOuterubeId;
	}
	public void setProjectOuterubeId(int projectOuterubeId) {
		this.projectOuterubeId = projectOuterubeId;
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
	
}
