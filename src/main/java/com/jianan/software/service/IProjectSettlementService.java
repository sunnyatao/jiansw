package com.jianan.software.service;

import java.util.List;
import java.util.Map;

import com.jianan.software.pojo.ProjectCheckFile;
import com.jianan.software.pojo.ProjectSettlement;
import com.jianan.software.pojo.ProjectSettlementInvoiceInfo;
import com.jianan.software.pojo.SearchCondition;
import com.jianan.software.util.Page;

public interface IProjectSettlementService {
	
	public String getNextSerialNo();

	public void createSettlement(ProjectSettlement projectSettlement);

	public ProjectSettlement getProjectSettlementByIdentifyNo(String taxpayerIdentifyNum);

	public ProjectSettlement getProjectSettlementByProjectname(String projectname);

	public List<ProjectSettlement> getProjectSettlements(Page page, String taxpayerName);

	public ProjectSettlement getProjectSettlementBySerialNo(String serialNum);
	
	public void createProjectSettlementInvoiceInfo(
			ProjectSettlementInvoiceInfo projectSettlementInvoiceInfo);

	public ProjectSettlementInvoiceInfo getProjectSettlementInvoiceInfoById(
			int id);

	public int getProjectSettlementCount(String taxpayerName);
	
	public List<ProjectSettlement> search(String keyword);

	public void updateSettlement(ProjectSettlement settlement);

	public void delete(String serialNum);

	public String getMaxTaxSerialNo();

	public void updateTaxSerialNo(int id, String serialNo);

	public List<ProjectSettlement> search(SearchCondition condition, Page page);
	
	public Map<String, String> sumSettlementAmount(SearchCondition condition);
	
	public void createFiles(List<ProjectCheckFile> checkFiles);

	public void createInvoiceFiles(List<ProjectCheckFile> checkFiles);

	public List<ProjectCheckFile> getInvoiceFiles(int id); 
	
	public void updateSettlementInvoiceInfo(
			ProjectSettlementInvoiceInfo projectSettlementInvoiceInfo);
}
