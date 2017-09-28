package com.jianan.software.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jianan.software.dao.IProjectCheckDao;
import com.jianan.software.pojo.ProjectCheck;
import com.jianan.software.pojo.ProjectCheckFile;
import com.jianan.software.pojo.ProjectCheckInvoiceInfo;
import com.jianan.software.pojo.SearchCondition;
import com.jianan.software.pojo.SinglePrint;
import com.jianan.software.service.IProjectCheckService;
import com.jianan.software.util.DateUtil;
import com.jianan.software.util.Page;
import com.jianan.software.util.SerialUtil;

@Service("projectCheckService")
public class ProjectCheckServiceImpl implements IProjectCheckService {

	@Autowired
	private IProjectCheckDao projectCheckDao;
	
	@Override
	public String getNextSerialNo() {
		ProjectCheck check = projectCheckDao.getMaxProjectSettlement();
		String preSerialNo = null;
		if (check != null) {
			preSerialNo = check.getSerialNum();
		}
		return SerialUtil.generateSerialNo("S", preSerialNo);
	}
	
	@Override
	public void createProjectCheck(ProjectCheck projectCheck) {
		projectCheckDao.createProjectCheck(projectCheck);
		if (projectCheck.getCheckFiles() != null && !projectCheck.getCheckFiles().isEmpty()) {
			List<ProjectCheckFile> checkFiles = projectCheck.getCheckFiles();
			for (ProjectCheckFile checkFile : checkFiles) {
				checkFile.setCheckId(projectCheck.getId());
			}
			projectCheckDao.createProjectCheckFiles(checkFiles);
		}
	}

	@Override
	public ProjectCheck getProjectCheckByIdentifyNo(String taxpayerIdentifyNum) {
		return projectCheckDao.getProjectCheckByIdentifyNo(taxpayerIdentifyNum);
	}

	@Override
	public ProjectCheck getProjectCheckByProjectname(String projectname) {
		return projectCheckDao.getProjectCheckByProjectname(projectname);
	}

	@Override
	public List<ProjectCheck> getProjectChecks(Page page, String taxpayerName) {
		return projectCheckDao.getProjectChecks(page, taxpayerName);
	}

	@Override
	public ProjectCheck getProjectCheckBySerialNo(String serialNum) {
		return projectCheckDao.getProjectCheckBySerialNo(serialNum);
	}

	@Override
	public void createProjectCheckInvoiceInfo(
			ProjectCheckInvoiceInfo projectCheckInvoiceInfo) {
		projectCheckDao.createProjectCheckInvoiceInfo(projectCheckInvoiceInfo);
	}

	@Override
	public ProjectCheckInvoiceInfo getProjectCheckInvoiceInfoById(int checkId) {
		return projectCheckDao.getProjectCheckInvoiceInfoById(checkId);
	}

	@Override
	public int getProjectCheckCount(String taxpayerName) {
		return projectCheckDao.getProjectCheckCount(taxpayerName);
	}

	@Override
	public List<ProjectCheck> search(String keyword) {
		return projectCheckDao.search(keyword);
	}
	
	@Override
	public List<ProjectCheck> search(SearchCondition condition, Page page) {
		return projectCheckDao.search(condition, page);
	}

	@Override
	public void updateProjectCheck(ProjectCheck projectCheck) {
		projectCheckDao.updateProjectCheck(projectCheck);
	}

	@Override
	public void delete(String serialNum) {
		projectCheckDao.delete(serialNum);
	}

	@Override
	public String getMaxTaxSerialNo() {
		return projectCheckDao.getMaxTaxSerialNo();
	}

	@Override
	public void updateTaxSerialNo(int id, String serialNo) {
		projectCheckDao.updateTaxSerialNo(id, serialNo);
	}

	@Override
	public int getSinglePrintCount() {
		return projectCheckDao.getSinglePrintCount();
	}

	@Override
	public List<SinglePrint> getSinglePrints(Page page) {
		return projectCheckDao.getSinglePrints(page);
	}

	@Override
	public int getMaxPrintSerialNo() {
		return projectCheckDao.getMaxPrintSerialNo();
	}

	@Override
	public void createSinglePrintInfo(SinglePrint singlePrint) {
		projectCheckDao.createSinglePrintInfo(singlePrint);
	}

	@Override
	public SinglePrint getSinglePrint(String id) {
		return projectCheckDao.getSinglePrint(id);
	}

	@Override
	public Map<String, String> sumCheckAmount(SearchCondition condition) {
		return projectCheckDao.sumCheckAmount(condition);
	}

	@Override
	public void createFiles(List<ProjectCheckFile> checkFiles) {
		projectCheckDao.createProjectCheckFiles(checkFiles);
	}

	@Override
	public void createInvoiceFiles(List<ProjectCheckFile> checkFiles) {
		projectCheckDao.createInvoiceFiles(checkFiles);
	}

	@Override
	public List<ProjectCheckFile> getInvoiceFiles(int invoiceId) {
		return projectCheckDao.getInvoiceFiles(invoiceId);
	}

	@Override
	public void deletetSinglePrint(int id) {
		projectCheckDao.deletetSinglePrint(id);
	}

	@Override
	public void updateInvoiceInfo(ProjectCheckInvoiceInfo invoiceInfo) {
		projectCheckDao.updateInvoiceInfo(invoiceInfo);
	}

	@Override
	public void updateSinglePrintInfo(SinglePrint singlePrint) {
		projectCheckDao.updateSinglePrintInfo(singlePrint);
	}
}
