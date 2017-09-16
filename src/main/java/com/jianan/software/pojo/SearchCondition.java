package com.jianan.software.pojo;

public class SearchCondition {

	private String serialNum;				//编号
	private String projectName;				//工程名称
	private String projectConstructor;		//建设单位
	private String taxpayerName;			//施工单位
	private String nationalInvoiceNo;		//发票号码
	private String nationalInvoiceTaxNo;	//税票号码
	private String localInvoiceTaxNo;	//地税税票号码
	private String taxStartTime;			//开票日期起
	private String taxEndTime;				//开票日期止
	
	private String name;
	private String floorName;

	public String getLocalInvoiceTaxNo() {
		return localInvoiceTaxNo;
	}
	public void setLocalInvoiceTaxNo(String localInvoiceTaxNo) {
		this.localInvoiceTaxNo = localInvoiceTaxNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFloorName() {
		return floorName;
	}
	public void setFloorName(String floorName) {
		this.floorName = floorName;
	}
	public String getSerialNum() {
		return serialNum;
	}
	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectConstructor() {
		return projectConstructor;
	}
	public void setProjectConstructor(String projectConstructor) {
		this.projectConstructor = projectConstructor;
	}
	public String getTaxpayerName() {
		return taxpayerName;
	}
	public void setTaxpayerName(String taxpayerName) {
		this.taxpayerName = taxpayerName;
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
	public String getTaxStartTime() {
		return taxStartTime;
	}
	public void setTaxStartTime(String taxStartTime) {
		this.taxStartTime = taxStartTime;
	}
	public String getTaxEndTime() {
		return taxEndTime;
	}
	public void setTaxEndTime(String taxEndTime) {
		this.taxEndTime = taxEndTime;
	}
}
