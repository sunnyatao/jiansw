package com.jianan.software.pojo;

import java.util.Date;
import java.util.List;

public class ProjectSettlement {
	private int 	id;
	private String 	serialNum;
	private String 	taxpayerIdentifyNum="";
	private String  taxpayerName="";
	private String  projectName="";
	private String  projectAddress="";
	private String  projectConstructor="";
	private double  projectTotalCost;
	private String isDown="";
	private double	settlementAmount;
	private String	serviceProducerCardNo="";
	private String	serviceProducerName="";
	private double	costInvoiceRate;
	private int	obtainInvoiceNum;
	private double	obtainInvoiceAmount;
	private String	withholdDepartment="";
	private double	withholdTaxAmount;	//withhold_tax_amount
	private double	appreciationLocalTaxAmount;
	private double	refundTaxAmount;
	private String	imposeDepartment="";
	private String  payTaxUser="";
	private String  contactsPhone="";
	private int     operatorId;
	private int		dutyUserId;
	private String	attachmentPath;
	private boolean isDeleted;
	private Date	createdAt;
	
	private String  bureauLeader;	//局领导
	private String operatorName;	//经办人姓名
	private String dutyUserName;	//负责人姓名
	
	private int taxSerialNo;
	private Date overTime;
	
	private double cDkje;	//代扣金额
	private double cZsje;	//征收金额
	
	private String economicNature;	//经济性质
	
	private ProjectSettlementInvoiceInfo invoiceInfo;
	
	private List<ProjectCheckFile> checkFiles;
	
	private String oldSerialNum;
	private String memo;
	
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

	public String getOldSerialNum() {
		return oldSerialNum;
	}

	public void setOldSerialNum(String oldSerialNum) {
		this.oldSerialNum = oldSerialNum;
	}

	public ProjectSettlementInvoiceInfo getInvoiceInfo() {
		return invoiceInfo;
	}

	public void setInvoiceInfo(ProjectSettlementInvoiceInfo invoiceInfo) {
		this.invoiceInfo = invoiceInfo;
	}

	public String getEconomicNature() {
		return economicNature;
	}

	public void setEconomicNature(String economicNature) {
		this.economicNature = economicNature;
	}

	public double getDkje() {
		return 100;
	}
	
	public double getcDkje() {
		return cDkje;
	}

	public double getCDkje() {
		return cDkje;
	}
	public void setcDkje(double cDkje) {
		this.cDkje = cDkje;
	}
	
	public double getcZsje() {
		return cZsje;
	}
	public double getCZsje() {
		return cZsje;
	}
	public void setcZsje(double cZsje) {
		this.cZsje = cZsje;
	}
	public Date getOverTime() {
		return overTime;
	}
	public void setOverTime(Date overTime) {
		this.overTime = overTime;
	}
	public String getTaxSerialNoStr() {
		/*if (0 < id && id < 10) {
			return "00" + id;
		} else if (10 <= id && id < 100) {
			return "0" + id;
		} else {
			return ""+id;
		}*/
		int serialSize = this.serialNum.length();
		String last4Serial = this.serialNum.substring(serialSize-4, serialSize-0);
		return last4Serial;
	}

	public int getTaxSerialNo() {
		return taxSerialNo;
	}
	public void setTaxSerialNo(int taxSerialNo) {
		this.taxSerialNo = taxSerialNo;
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
	public double getSettlementAmount() {
		return settlementAmount;
	}
	public void setSettlementAmount(double settlementAmount) {
		this.settlementAmount = settlementAmount;
	}
	public String getServiceProducerCardNo() {
		return serviceProducerCardNo;
	}
	public void setServiceProducerCardNo(String serviceProducerCardNo) {
		this.serviceProducerCardNo = serviceProducerCardNo;
	}
	public String getServiceProducerName() {
		return serviceProducerName;
	}
	public void setServiceProducerName(String serviceProducerName) {
		this.serviceProducerName = serviceProducerName;
	}
	public double getCostInvoiceRate() {
		return costInvoiceRate;
	}
	public void setCostInvoiceRate(double costInvoiceRate) {
		this.costInvoiceRate = costInvoiceRate;
	}
	public int getObtainInvoiceNum() {
		return obtainInvoiceNum;
	}
	public void setObtainInvoiceNum(int obtainInvoiceNum) {
		this.obtainInvoiceNum = obtainInvoiceNum;
	}
	public double getObtainInvoiceAmount() {
		return obtainInvoiceAmount;
	}
	public void setObtainInvoiceAmount(double obtainInvoiceAmount) {
		this.obtainInvoiceAmount = obtainInvoiceAmount;
	}
	public String getWithholdDepartment() {
		return withholdDepartment;
	}
	public void setWithholdDepartment(String withholdDepartment) {
		this.withholdDepartment = withholdDepartment;
	}
	public double getWithholdTaxAmount() {
		return withholdTaxAmount;
	}
	public void setWithholdTaxAmount(double withholdTaxAmount) {
		this.withholdTaxAmount = withholdTaxAmount;
	}
	public double getAppreciationLocalTaxAmount() {
		return appreciationLocalTaxAmount;
	}
	public void setAppreciationLocalTaxAmount(double appreciationLocalTaxAmount) {
		this.appreciationLocalTaxAmount = appreciationLocalTaxAmount;
	}
	public double getRefundTaxAmount() {
		return refundTaxAmount;
	}
	public void setRefundTaxAmount(double refundTaxAmount) {
		this.refundTaxAmount = refundTaxAmount;
	}
	public String getImposeDepartment() {
		return imposeDepartment;
	}
	public void setImposeDepartment(String imposeDepartment) {
		this.imposeDepartment = imposeDepartment;
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
	public String getBureauLeader() {
		return bureauLeader;
	}
	public void setBureauLeader(String bureauLeader) {
		this.bureauLeader = bureauLeader;
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
}
