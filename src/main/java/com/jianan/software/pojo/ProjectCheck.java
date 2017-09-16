package com.jianan.software.pojo;

import java.util.Date;
import java.util.List;

public class ProjectCheck {
	private int 	id;
	private String 	serialNum;
	private String 	taxpayerIdentifyNum;
	private String  taxpayerName = "";
	private String  projectName;
	private String  projectAddress;
	private String  projectConstructor;
	private String  constructorIdentifyNum="";
	private double  projectTotalCost;
	private String isDown = "完工";
	private double  invoiceAmount;
	private double  appreciationRate;
	private double  appreciationTaxAmount;
	private double  incomeRate;
	private double  incomeTaxAmount;
	private String  incomeAffiliation = "";
	private double  urbanTaxRate;
	private double  urbanTaxAmount;
	private double  educationAdditionAmount;
	private double  localEducationAdditionAmount;
	private double  stampDutyRate;
	private double  stampDutyAmount;
	private double  laborUnionAmount;
	private double  waterConstructAmount;
	private String  payTaxUser="";
	private String  contactsPhone;
	private int     operatorId;
	private int		dutyUserId;
	private String	attachmentPath;
	private boolean isDeleted;
	private Date	createdAt;
	
	private String oldSerialNum;
	
	private String bureauLeader;	//局领导
	private String operatorName = "";	//经办人姓名
	private String dutyUserName;	//负责人姓名
	
	private int taxSerialNo;
	private ProjectCheckInvoiceInfo invoiceInfo;
	
	private List<ProjectCheckFile> checkFiles;
	
	public String getConstructorIdentifyNum() {
		return constructorIdentifyNum;
	}
	public void setConstructorIdentifyNum(String constructorIdentifyNum) {
		this.constructorIdentifyNum = constructorIdentifyNum;
	}
	public String getOldSerialNum() {
		return oldSerialNum;
	}
	public void setOldSerialNum(String oldSerialNum) {
		this.oldSerialNum = oldSerialNum;
	}
	public ProjectCheckInvoiceInfo getInvoiceInfo() {
		return invoiceInfo;
	}
	public void setInvoiceInfo(ProjectCheckInvoiceInfo invoiceInfo) {
		this.invoiceInfo = invoiceInfo;
	}
	public List<ProjectCheckFile> getCheckFiles() {
		return checkFiles;
	}
	public void setCheckFiles(List<ProjectCheckFile> checkFiles) {
		this.checkFiles = checkFiles;
	}
	public String getTaxSerialNoStr() {
		if (0 < taxSerialNo && taxSerialNo < 10) {
			return "00" + taxSerialNo;
		} else if (10 <= taxSerialNo && taxSerialNo < 100) {
			return "0" + taxSerialNo;
		} else {
			return "";
		}
	}

	public int getTaxSerialNo() {
		return taxSerialNo;
	}
	public void setTaxSerialNo(int taxSerialNo) {
		this.taxSerialNo = taxSerialNo;
	}
	public String getBureauLeader() {
		return bureauLeader;
	}
	public void setBureauLeader(String bureauLeader) {
		this.bureauLeader = bureauLeader;
	}
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	public String getDutyUserName() {
		return dutyUserName;
	}
	public void setDutyUserName(String dutyUserName) {
		this.dutyUserName = dutyUserName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSerialNum() {
		return serialNum;
	}
	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}
	public String getTaxpayerIdentifyNum() {
		return taxpayerIdentifyNum;
	}
	public void setTaxpayerIdentifyNum(String taxpayerIdentifyNum) {
		this.taxpayerIdentifyNum = taxpayerIdentifyNum;
	}
	public String getTaxpayerName() {
		return taxpayerName;
	}
	public void setTaxpayerName(String taxpayerName) {
		this.taxpayerName = taxpayerName;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectAddress() {
		return projectAddress;
	}
	public void setProjectAddress(String projectAddress) {
		this.projectAddress = projectAddress;
	}
	public String getProjectConstructor() {
		return projectConstructor;
	}
	public void setProjectConstructor(String projectConstructor) {
		this.projectConstructor = projectConstructor;
	}
	public double getProjectTotalCost() {
		return projectTotalCost;
	}
	public void setProjectTotalCost(double projectTotalCost) {
		this.projectTotalCost = projectTotalCost;
	}
	public String getIsDown() {
		return isDown;
	}
	public void setIsDown(String isDown) {
		this.isDown = isDown;
	}
	public double getInvoiceAmount() {
		return invoiceAmount;
	}
	public void setInvoiceAmount(double invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}
	public double getAppreciationRate() {
		return appreciationRate;
	}
	public void setAppreciationRate(double appreciationRate) {
		this.appreciationRate = appreciationRate;
	}
	public double getAppreciationTaxAmount() {
		return appreciationTaxAmount;
	}
	public void setAppreciationTaxAmount(double appreciationTaxAmount) {
		this.appreciationTaxAmount = appreciationTaxAmount;
	}
	public double getIncomeRate() {
		return incomeRate;
	}
	public void setIncomeRate(double incomeRate) {
		this.incomeRate = incomeRate;
	}
	public double getIncomeTaxAmount() {
		return incomeTaxAmount;
	}
	public void setIncomeTaxAmount(double incomeTaxAmount) {
		this.incomeTaxAmount = incomeTaxAmount;
	}
	public String getIncomeAffiliation() {
		return incomeAffiliation;
	}
	public void setIncomeAffiliation(String incomeAffiliation) {
		this.incomeAffiliation = incomeAffiliation;
	}
	public double getUrbanTaxRate() {
		return urbanTaxRate;
	}
	public void setUrbanTaxRate(double urbanTaxRate) {
		this.urbanTaxRate = urbanTaxRate;
	}
	public double getUrbanTaxAmount() {
		return urbanTaxAmount;
	}
	public void setUrbanTaxAmount(double urbanTaxAmount) {
		this.urbanTaxAmount = urbanTaxAmount;
	}
	public double getEducationAdditionAmount() {
		return educationAdditionAmount;
	}
	public void setEducationAdditionAmount(double educationAdditionAmount) {
		this.educationAdditionAmount = educationAdditionAmount;
	}
	public double getLocalEducationAdditionAmount() {
		return localEducationAdditionAmount;
	}
	public void setLocalEducationAdditionAmount(double localEducationAdditionAmount) {
		this.localEducationAdditionAmount = localEducationAdditionAmount;
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
	public double getLaborUnionAmount() {
		return laborUnionAmount;
	}
	public void setLaborUnionAmount(double laborUnionAmount) {
		this.laborUnionAmount = laborUnionAmount;
	}
	public double getWaterConstructAmount() {
		return waterConstructAmount;
	}
	public void setWaterConstructAmount(double waterConstructAmount) {
		this.waterConstructAmount = waterConstructAmount;
	}
	public String getPayTaxUser() {
		return payTaxUser;
	}
	public void setPayTaxUser(String payTaxUser) {
		this.payTaxUser = payTaxUser;
	}
	public String getContactsPhone() {
		return contactsPhone;
	}
	public void setContactsPhone(String contactsPhone) {
		this.contactsPhone = contactsPhone;
	}
	public int getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(int operatorId) {
		this.operatorId = operatorId;
	}
	public int getDutyUserId() {
		return dutyUserId;
	}
	public void setDutyUserId(int dutyUserId) {
		this.dutyUserId = dutyUserId;
	}
	public String getAttachmentPath() {
		return attachmentPath;
	}
	public void setAttachmentPath(String attachmentPath) {
		this.attachmentPath = attachmentPath;
	}
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	@Override
	public String toString() {
		return "ProjectCheckInvoiceInfo [id=" + id + ", serialNum=" + serialNum
				+ ", taxpayerIdentifyNum=" + taxpayerIdentifyNum
				+ ", taxpayerName=" + taxpayerName + ", projectName="
				+ projectName + ", projectAddress=" + projectAddress
				+ ", projectConstructor=" + projectConstructor
				+ ", projectTotalCost=" + projectTotalCost + ", isDown="
				+ isDown + ", invoiceAmount=" + invoiceAmount
				+ ", appreciationRate=" + appreciationRate
				+ ", appreciationTaxAmount=" + appreciationTaxAmount
				+ ", incomeRate=" + incomeRate + ", incomeTaxAmount="
				+ incomeTaxAmount + ", incomeAffiliation=" + incomeAffiliation
				+ ", urbanTaxRate=" + urbanTaxRate + ", urbanTaxAmount="
				+ urbanTaxAmount + ", educationAdditionAmount="
				+ educationAdditionAmount + ", localEducationAdditionAmount="
				+ localEducationAdditionAmount + ", stampDutyRate="
				+ stampDutyRate + ", stampDutyAmount=" + stampDutyAmount
				+ ", laborUnionAmount=" + laborUnionAmount
				+ ", waterConstructAmount=" + waterConstructAmount
				+ ", payTaxUser=" + payTaxUser + ", contactsPhone="
				+ contactsPhone + ", operatorId=" + operatorId
				+ ", dutyUserId=" + dutyUserId + ", attachmentPath="
				+ attachmentPath + ", isDeleted=" + isDeleted + ", createdAt="
				+ createdAt + "]";
	}
}
