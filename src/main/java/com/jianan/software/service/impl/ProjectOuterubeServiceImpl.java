package com.jianan.software.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jianan.software.dao.IProjectCheckDao;
import com.jianan.software.dao.IProjectOutubeDao;
import com.jianan.software.pojo.ProjectCheck;
import com.jianan.software.pojo.ProjectCheckFile;
import com.jianan.software.pojo.ProjectCheckInvoiceInfo;
import com.jianan.software.pojo.ProjectOutertube;
import com.jianan.software.pojo.ProjectOutertubeInvoiceInfo;
import com.jianan.software.pojo.SearchCondition;
import com.jianan.software.service.IProjectCheckService;
import com.jianan.software.service.IProjectOuterubeService;
import com.jianan.software.util.DateUtil;
import com.jianan.software.util.Page;
import com.jianan.software.util.SerialUtil;

@Service("projectOuterubeService")
public class ProjectOuterubeServiceImpl implements IProjectOuterubeService {

	@Autowired
	private IProjectOutubeDao projectOutubeDao;
	
	@Override
	public String getNextSerialNo() {
		ProjectOutertube projectOuterube = projectOutubeDao.getMaxProjectOuterube();
		String preSerialNo = null;
		if (projectOuterube != null) {
			preSerialNo = projectOuterube.getSerialNum();
		}
		return SerialUtil.generateSerialNo("W", preSerialNo);
	}
	
	@Override
	public void createProjectOuterube(ProjectOutertube projectOuterube) {
		projectOutubeDao.createProjectOuterube(projectOuterube);
	}

	@Override
	public ProjectOutertube getProjectOuterubeByIdentifyNo(String taxpayerIdentifyNum) {
		return projectOutubeDao.getProjectOuterubeByIdentifyNo(taxpayerIdentifyNum);
	}

	@Override
	public ProjectOutertube getProjectOuterubeByProjectname(String projectname) {
		return projectOutubeDao.getProjectOuterubeByProjectname(projectname);
	}

	@Override
	public List<ProjectOutertube> getProjectOuterubes(Page page, String taxpayerName) {
		return projectOutubeDao.getProjectOuterubes(page, taxpayerName);
	}

	@Override
	public ProjectOutertube getProjectCheckBySerialNo(String serialNum) {
		return projectOutubeDao.getProjectOuterubeBySerialNo(serialNum);
	}

	@Override
	public void createProjectCheckInvoiceInfo(
			ProjectOutertubeInvoiceInfo projectOutertubeInvoiceInfo) {
		projectOutubeDao.createProjectOuterubeInvoiceInfo(projectOutertubeInvoiceInfo);
	}

	@Override
	public ProjectOutertubeInvoiceInfo getProjectOuterubeInvoiceInfoById(int checkId) {
		return projectOutubeDao.getProjectOuterubeInvoiceInfoById(checkId);
	}

	@Override
	public int getProjectOuterubeCount(String taxpayerName) {
		return projectOutubeDao.getProjectOuterubeCount(taxpayerName);
	}

	@Override
	public List<ProjectOutertube> search(String keyword) {
		return projectOutubeDao.search(keyword);
	}

	@Override
	public void updateOutertube(ProjectOutertube outertube) {
		projectOutubeDao.updateOutertube(outertube);
	}

	@Override
	public void delete(String serialNum) {
		projectOutubeDao.delete(serialNum);
	}

	@Override
	public List<ProjectOutertube> search(SearchCondition condition, Page page) {
		return projectOutubeDao.search(condition, page);
	}

	@Override
	public Map<String, String> sumOuterubeAmount(SearchCondition condition) {
		// TODO Auto-generated method stub
		return projectOutubeDao.sumOuterubeAmount(condition);
	}

	@Override
	public void createFiles(List<ProjectCheckFile> checkFiles) {
		projectOutubeDao.createProjectCheckFiles(checkFiles);
	}

	@Override
	public void createInvoiceFiles(List<ProjectCheckFile> checkFiles) {
		projectOutubeDao.createInvoiceFiles(checkFiles);
	}

	@Override
	public List<ProjectCheckFile> getInvoiceFiles(int invoiceId) {
		return projectOutubeDao.getInvoiceFiles(invoiceId);
	}

	@Override
	public void updateProjectCheckInvoiceInfo(
			ProjectOutertubeInvoiceInfo projectOuterubeInvoiceInfo) {
		projectOutubeDao.updateProjectCheckInvoiceInfo(projectOuterubeInvoiceInfo);
	}
}
