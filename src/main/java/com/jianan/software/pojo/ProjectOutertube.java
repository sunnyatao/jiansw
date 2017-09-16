package com.jianan.software.pojo;

import java.util.Date;
import java.util.List;

/**
 * 外管工程
 * @author taoliu
 *
 */
public class ProjectOutertube {
	private int 	id;
	private String 	serialNum;
	private String 	taxpayerIdentifyNum="";
	private String  taxpayerName="";
	private String  projectName="";
	private String  projectAddress="";
	private String  projectConstructor="";
	private String  constructorIdentifyNum="";
	private double  projectTotalCost;
	private String isDown="";
	private double  settlementAmount;
	private double  preAppreciationRate;
	private double  preAppreciationTaxAmount;
	private double	preCorporateIncomeTaxRate;
	private double	preCorporateIncomeTaxAmount;
	private double  urbanTaxRate;
	private double  urbanTaxAmount;
	private double  educationAdditionAmount;
	private double  localEducationAdditionAmount;
	private double  stampDutyRate;
	private double  stampDutyAmount;
	private double  laborUnionAmount;
	private double  waterConstructAmount;
	private int isInvoiced;
	private String  payTaxUser="";
	private String  contactsPhone="";
	private int     operatorId;
	private int		dutyUserId;
	private String	attachmentPath="";
	private boolean isDeleted;
	private Date	createdAt;
	
	private String bureauLeader="";	//局领导
	private String operatorName="";	//经办人姓名
	private String dutyUserName="";	//负责人姓名
	
	private String payTaxUserType="";	//纳税人类型
	private String taxType="";	//计税方式
	
	private String incomeAffiliation="";	//所得税归属
	
	private ProjectOutertubeInvoiceInfo invoiceInfo;
	
	private List<ProjectCheckFile> checkFiles;
	
	private String oldSerialNum;
	private String identifyNo;
	private String memo;
	
	
	public String getConstructorIdentifyNum() {
		return constructorIdentifyNum;
	}
	public void setConstructorIdentifyNum(String constructorIdentifyNum) {
		this.constructorIdentifyNum = constructorIdentifyNum;
	}
	public List<ProjectCheckFile> getCheckFiles() {
		return checkFiles;
	}
	public void setCheckFiles(List<ProjectCheckFile> checkFiles) {
		this.checkFiles = checkFiles;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getIdentifyNo() {
		return identifyNo;
	}
	public void setIdentifyNo(String identifyNo) {
		this.identifyNo = identifyNo;
	}
	public String getOldSerialNum() {
		return oldSerialNum;
	}
	public void setOldSerialNum(String oldSerialNum) {
		this.oldSerialNum = oldSerialNum;
	}
	public ProjectOutertubeInvoiceInfo getInvoiceInfo() {
		return invoiceInfo;
	}
	public void setInvoiceInfo(ProjectOutertubeInvoiceInfo invoiceInfo) {
		this.invoiceInfo = invoiceInfo;
	}
	public String getIncomeAffiliation() {
		return incomeAffiliation;
	}
	public void setIncomeAffiliation(String incomeAffiliation) {
		this.incomeAffiliation = incomeAffiliation;
	}
	public String getPayTaxUserType() {
		return payTaxUserType;
	}
	public void setPayTaxUserType(String payTaxUserType) {
		this.payTaxUserType = payTaxUserType;
	}
	public String getTaxType() {
		return taxType;
	}
	public void setTaxType(String taxType) {
		this.taxType = taxType;
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
	public double getSettlementAmount() {
		return settlementAmount;
	}
	public void setSettlementAmount(double settlementAmount) {
		this.settlementAmount = settlementAmount;
	}
	public double getPreAppreciationRate() {
		return preAppreciationRate;
	}
	public void setPreAppreciationRate(double preAppreciationRate) {
		this.preAppreciationRate = preAppreciationRate;
	}
	public double getPreAppreciationTaxAmount() {
		return preAppreciationTaxAmount;
	}
	public void setPreAppreciationTaxAmount(double preAppreciationTaxAmount) {
		this.preAppreciationTaxAmount = preAppreciationTaxAmount;
	}
	public double getPreCorporateIncomeTaxRate() {
		return preCorporateIncomeTaxRate;
	}
	public void setPreCorporateIncomeTaxRate(double preCorporateIncomeTaxRate) {
		this.preCorporateIncomeTaxRate = preCorporateIncomeTaxRate;
	}
	public double getPreCorporateIncomeTaxAmount() {
		return preCorporateIncomeTaxAmount;
	}
	public void setPreCorporateIncomeTaxAmount(double preCorporateIncomeTaxAmount) {
		this.preCorporateIncomeTaxAmount = preCorporateIncomeTaxAmount;
	}
	public int getIsInvoiced() {
		return isInvoiced;
	}
	public void setIsInvoiced(int isInvoiced) {
		this.isInvoiced = isInvoiced;
	}
	@Override
	public String toString() {
		return "ProjectOutertube [id=" + id + ", serialNum=" + serialNum
				+ ", taxpayerIdentifyNum=" + taxpayerIdentifyNum
				+ ", taxpayerName=" + taxpayerName + ", projectName="
				+ projectName + ", projectAddress=" + projectAddress
				+ ", projectConstructor=" + projectConstructor
				+ ", projectTotalCost=" + projectTotalCost + ", isDown="
				+ isDown + ", settlementAmount=" + settlementAmount
				+ ", preAppreciationRate=" + preAppreciationRate
				+ ", preAppreciationTaxAmount=" + preAppreciationTaxAmount
				+ ", preCorporateIncomeTaxRate=" + preCorporateIncomeTaxRate
				+ ", preCorporateIncomeTaxAmount="
				+ preCorporateIncomeTaxAmount + ", urbanTaxRate="
				+ urbanTaxRate + ", urbanTaxAmount=" + urbanTaxAmount
				+ ", educationAdditionAmount=" + educationAdditionAmount
				+ ", localEducationAdditionAmount="
				+ localEducationAdditionAmount + ", stampDutyRate="
				+ stampDutyRate + ", stampDutyAmount=" + stampDutyAmount
				+ ", laborUnionAmount=" + laborUnionAmount
				+ ", waterConstructAmount=" + waterConstructAmount
				+ ", isInvoiced=" + isInvoiced + ", payTaxUser=" + payTaxUser
				+ ", contactsPhone=" + contactsPhone + ", operatorId="
				+ operatorId + ", dutyUserId=" + dutyUserId
				+ ", attachmentPath=" + attachmentPath + ", isDeleted="
				+ isDeleted + ", createdAt=" + createdAt + "]";
	}
	
	
}
