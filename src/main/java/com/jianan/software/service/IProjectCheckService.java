package com.jianan.software.service;

import java.util.List;
import java.util.Map;

import com.jianan.software.pojo.ProjectCheck;
import com.jianan.software.pojo.ProjectCheckFile;
import com.jianan.software.pojo.ProjectCheckInvoiceInfo;
import com.jianan.software.pojo.SearchCondition;
import com.jianan.software.pojo.SinglePrint;
import com.jianan.software.util.Page;

public interface IProjectCheckService {
	
	public String getNextSerialNo();

	public void createProjectCheck(ProjectCheck projectCheck);

	public ProjectCheck getProjectCheckByIdentifyNo(String taxpayerIdentifyNum);

	public ProjectCheck getProjectCheckByProjectname(String projectname);

	public List<ProjectCheck> getProjectChecks(Page page, String taxpayerName);

	public ProjectCheck getProjectCheckBySerialNo(String serialNum);

	public void createProjectCheckInvoiceInfo(
			ProjectCheckInvoiceInfo projectCheckInvoiceInfo);

	public ProjectCheckInvoiceInfo getProjectCheckInvoiceInfoById(int id);

	public int getProjectCheckCount(String taxpayerName);
	
	public List<ProjectCheck> search(String keyword);
	
	public List<ProjectCheck> search(SearchCondition condition, Page page);

	public void updateProjectCheck(ProjectCheck projectCheck);

	public void delete(String serialNum);

	public String getMaxTaxSerialNo();

	public void updateTaxSerialNo(int id, String serialNo);

	public int getSinglePrintCount();

	public List<SinglePrint> getSinglePrints(Page page);

	public int getMaxPrintSerialNo();

	public void createSinglePrintInfo(SinglePrint singlePrint);

	public SinglePrint getSinglePrint(String id);
	
	public Map<String, String> sumCheckAmount(SearchCondition condition);

	public void createFiles(List<ProjectCheckFile> checkFiles);

	public void createInvoiceFiles(List<ProjectCheckFile> checkFiles);

	public List<ProjectCheckFile> getInvoiceFiles(int id);
	
	public void deletetSinglePrint(int id);
	
	public void updateInvoiceInfo(ProjectCheckInvoiceInfo invoiceInfo);

	public void updateSinglePrintInfo(SinglePrint singlePrint);
}
