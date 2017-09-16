package com.jianan.software.pojo;

import java.util.Date;
import java.util.List;

import com.jianan.software.util.DateUtil;

/**
 * 房屋契税
 * @author taoliu
 *
 */
public class HouseContract {
	private int id;
	private String name;	//姓名
	private String floorName;	//楼栋
	private String serialNo;	//房号
	private double area;	//面积
	private double unitPrice;	//单价
	private double totalPrice;	//总价
	private double contractTaxRate;	//契税税率
	private double contractTax;	//契税
	private String cardNo;	//身份证号
	private Date contractDate;	//合同签订日期
	private String contractDown;	//契税完税
	private double firstPaymentAmount;	//首付
	private double mortgageAmount;		//按揭
	private int operatorId;
	private String operatorName;
	private Date createdAt;
	
	private String projectName;
	private double appreciationRate;
	private double appreciationAmount;
	private double stampDutyRate;
	private double stampDutyAmount;
	private String houseType;
	
	private HouseContractTaxInfo taxInfo;
	private List<ProjectCheckFile> checkFiles;
	
	public List<ProjectCheckFile> getCheckFiles() {
		return checkFiles;
	}
	public void setCheckFiles(List<ProjectCheckFile> checkFiles) {
		this.checkFiles = checkFiles;
	}
	public HouseContractTaxInfo getTaxInfo() {
		return taxInfo;
	}
	public void setTaxInfo(HouseContractTaxInfo taxInfo) {
		this.taxInfo = taxInfo;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public double getAppreciationRate() {
		return appreciationRate;
	}
	public void setAppreciationRate(double appreciationRate) {
		this.appreciationRate = appreciationRate;
	}
	public double getAppreciationAmount() {
		return appreciationAmount;
	}
	public void setAppreciationAmount(double appreciationAmount) {
		this.appreciationAmount = appreciationAmount;
	}
	public double getStampDutyRate() {
		return stampDutyRate;
	}
	public void setStampDutyRate(double stampDutyRate) {
		this.stampDutyRate = stampDutyRate;
	}
	public double getStampDutyAmount() {
		return stampDutyAmount;
	}
	public void setStampDutyAmount(double stampDutyAmount) {
		this.stampDutyAmount = stampDutyAmount;
	}
	public String getHouseType() {
		return houseType;
	}
	public void setHouseType(String houseType) {
		this.houseType = houseType;
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
	public String getFloorName() {
		return floorName;
	}
	public void setFloorName(String floorName) {
		this.floorName = floorName;
	}
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public double getContractTaxRate() {
		return contractTaxRate;
	}
	public void setContractTaxRate(double contractTaxRate) {
		this.contractTaxRate = contractTaxRate;
	}
	public double getContractTax() {
		return contractTax;
	}
	public void setContractTax(double contractTax) {
		this.contractTax = contractTax;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public Date getContractDate() {
		return contractDate;
	}
	public void setContractDate(Date contractDate) {
		this.contractDate = contractDate;
	}
	public String getContractDown() {
		return contractDown;
	}
	public void setContractDown(String contractDown) {
		this.contractDown = contractDown;
	}
	public double getFirstPaymentAmount() {
		return firstPaymentAmount;
	}
	public void setFirstPaymentAmount(double firstPaymentAmount) {
		this.firstPaymentAmount = firstPaymentAmount;
	}
	public double getMortgageAmount() {
		return mortgageAmount;
	}
	public void setMortgageAmount(double mortgageAmount) {
		this.mortgageAmount = mortgageAmount;
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
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	public String getContractFormatDate() {
		return DateUtil.formatDate(this.contractDate);
	}
}
