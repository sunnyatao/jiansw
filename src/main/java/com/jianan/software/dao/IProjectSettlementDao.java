package com.jianan.software.dao;

import java.util.List;
import java.util.Map;

import com.jianan.software.pojo.ProjectCheck;
import com.jianan.software.pojo.ProjectCheckFile;
import com.jianan.software.pojo.ProjectCheckInvoiceInfo;
import com.jianan.software.pojo.ProjectSettlement;
import com.jianan.software.pojo.ProjectSettlementInvoiceInfo;
import com.jianan.software.pojo.SearchCondition;
import com.jianan.software.util.Page;

public interface IProjectSettlementDao {
	
	public ProjectSettlement getMaxProjectCheck();

	public void createProjectCheck(ProjectSettlement projectSettlement);

	public ProjectSettlement getProjectCheckByIdentifyNo(String taxpayerIdentifyNum);

	public ProjectSettlement getProjectCheckByProjectname(String projectname);

	/**
	 * 待实现分页查询
	 * @param taxpayerName TODO
	 * @return
	 */
	public List<ProjectSettlement> getProjectChecks(Page page, String taxpayerName);

	public ProjectSettlement getProjectCheckBySerialNo(String serialNum);

	public void createProjectCheckInvoiceInfo(
			ProjectSettlementInvoiceInfo projectSettlementInvoiceInfo);

	public ProjectSettlementInvoiceInfo getProjectCheckInvoiceInfoById(int checkId);

	public int getProjectSettlementCount(String taxpayerName);

	public List<ProjectSettlement> search(String keyword);

	public Object updateSettlement(ProjectSettlement settlement);

	public void delete(String serialNum);

	public String getMaxTaxSerialNo();

	public void updateTaxSerialNo(int id, String serialNo);

	public List<ProjectSettlement> search(SearchCondition condition, Page page);

	public Map<String, String> sumSettlementAmount(SearchCondition condition);

	public void createProjectCheckFiles(List<ProjectCheckFile> checkFiles);

	public void createInvoiceFiles(List<ProjectCheckFile> checkFiles);

	public List<ProjectCheckFile> getInvoiceFiles(int invoiceId);
}
