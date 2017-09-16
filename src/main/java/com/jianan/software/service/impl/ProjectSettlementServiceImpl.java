package com.jianan.software.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jianan.software.dao.IProjectSettlementDao;
import com.jianan.software.pojo.ProjectCheckFile;
import com.jianan.software.pojo.ProjectSettlement;
import com.jianan.software.pojo.ProjectSettlementInvoiceInfo;
import com.jianan.software.pojo.SearchCondition;
import com.jianan.software.service.IProjectSettlementService;
import com.jianan.software.util.Page;
import com.jianan.software.util.SerialUtil;

@Service("projectSettlementService")
public class ProjectSettlementServiceImpl implements IProjectSettlementService {
	
	@Autowired
	private IProjectSettlementDao projectSettlementDao;

	@Override
	public String getNextSerialNo() {
		ProjectSettlement settlement = projectSettlementDao.getMaxProjectCheck();
		String preSerialNo = null;
		if (settlement != null) {
			preSerialNo = settlement.getSerialNum();
		}
		return SerialUtil.generateSerialNo("J", preSerialNo);
	}

	@Override
	public void createSettlement(ProjectSettlement projectSettlement) {
		projectSettlementDao.createProjectCheck(projectSettlement);
	}

	@Override
	public ProjectSettlement getProjectSettlementByIdentifyNo(
			String taxpayerIdentifyNum) {
		return projectSettlementDao.getProjectCheckByIdentifyNo(taxpayerIdentifyNum);
	}

	@Override
	public ProjectSettlement getProjectSettlementByProjectname(
			String projectname) {
		return projectSettlementDao.getProjectCheckByProjectname(projectname);
	}

	@Override
	public List<ProjectSettlement> getProjectSettlements(Page page, String taxpayerName) {
		return projectSettlementDao.getProjectChecks(page, taxpayerName);
	}

	@Override
	public ProjectSettlement getProjectSettlementBySerialNo(String serialNum) {
		return projectSettlementDao.getProjectCheckBySerialNo(serialNum);
	}

	@Override
	public void createProjectSettlementInvoiceInfo(
			ProjectSettlementInvoiceInfo projectSettlementInvoiceInfo) {
		projectSettlementDao.createProjectCheckInvoiceInfo(projectSettlementInvoiceInfo);
	}

	@Override
	public ProjectSettlementInvoiceInfo getProjectSettlementInvoiceInfoById(
			int id) {
		return projectSettlementDao.getProjectCheckInvoiceInfoById(id);
	}

	@Override
	public int getProjectSettlementCount(String taxpayerName) {
		return projectSettlementDao.getProjectSettlementCount(taxpayerName);
	}

	@Override
	public List<ProjectSettlement> search(String keyword) {
		return projectSettlementDao.search(keyword);
	}

	@Override
	public void updateSettlement(ProjectSettlement settlement) {
		projectSettlementDao.updateSettlement(settlement);
	}

	@Override
	public void delete(String serialNum) {
		projectSettlementDao.delete(serialNum);
	}

	@Override
	public String getMaxTaxSerialNo() {
		return projectSettlementDao.getMaxTaxSerialNo();
	}

	@Override
	public void updateTaxSerialNo(int id, String serialNo) {
		projectSettlementDao.updateTaxSerialNo(id, serialNo);
	}

	@Override
	public List<ProjectSettlement> search(SearchCondition condition, Page page) {
		return projectSettlementDao.search(condition, page);
	}

	@Override
	public Map<String, String> sumSettlementAmount(SearchCondition condition) {
		return projectSettlementDao.sumSettlementAmount(condition);
	}

	@Override
	public void createFiles(List<ProjectCheckFile> checkFiles) {
		projectSettlementDao.createProjectCheckFiles(checkFiles);
	}

	@Override
	public void createInvoiceFiles(List<ProjectCheckFile> checkFiles) {
		projectSettlementDao.createInvoiceFiles(checkFiles);
	}

	@Override
	public List<ProjectCheckFile> getInvoiceFiles(int invoiceId) {
		return projectSettlementDao.getInvoiceFiles(invoiceId);
	}

}
