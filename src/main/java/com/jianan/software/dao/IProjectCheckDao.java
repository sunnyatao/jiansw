package com.jianan.software.dao;

import java.util.List;
import java.util.Map;

import com.jianan.software.pojo.ProjectCheck;
import com.jianan.software.pojo.ProjectCheckFile;
import com.jianan.software.pojo.ProjectCheckInvoiceInfo;
import com.jianan.software.pojo.SearchCondition;
import com.jianan.software.pojo.SinglePrint;
import com.jianan.software.util.Page;

public interface IProjectCheckDao {
	
	public ProjectCheck getMaxProjectSettlement();

	public void createProjectCheck(ProjectCheck projectCheck);

	public ProjectCheck getProjectCheckByIdentifyNo(String taxpayerIdentifyNum);

	public ProjectCheck getProjectCheckByProjectname(String projectname);

	/**
	 * 待实现分页查询
	 * @param taxpayerName TODO
	 * @return
	 */
	public List<ProjectCheck> getProjectChecks(Page page, String taxpayerName);

	public ProjectCheck getProjectCheckBySerialNo(String serialNum);

	public void createProjectCheckInvoiceInfo(
			ProjectCheckInvoiceInfo projectCheckInvoiceInfo);

	public ProjectCheckInvoiceInfo getProjectCheckInvoiceInfoById(int checkId);

	public int getProjectCheckCount(String taxpayerName);

	public List<ProjectCheck> search(String keyword);

	public void updateProjectCheck(ProjectCheck projectCheck);

	public void delete(String serialNum);

	public String getMaxTaxSerialNo();

	public void updateTaxSerialNo(int id, String serialNo);

	public List<SinglePrint> getSinglePrints(Page page);

	public int getSinglePrintCount();

	public int getMaxPrintSerialNo();

	public void createSinglePrintInfo(SinglePrint singlePrint);

	public SinglePrint getSinglePrint(String id);

	public void createProjectCheckFiles(List<ProjectCheckFile> checkFiles);

	public List<ProjectCheck> search(SearchCondition condition, Page page);

	public Map<String, String> sumCheckAmount(SearchCondition condition);

	public void createInvoiceFiles(List<ProjectCheckFile> checkFiles);

	public List<ProjectCheckFile> getInvoiceFiles(int invoiceId);
	
	public void deletetSinglePrint(int id);
	
	public void updateInvoiceInfo(ProjectCheckInvoiceInfo invoiceInfo);
}
