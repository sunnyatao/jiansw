package com.jianan.software.service;

import java.util.List;
import java.util.Map;

import com.jianan.software.pojo.ProjectCheckFile;
import com.jianan.software.pojo.ProjectOutertube;
import com.jianan.software.pojo.ProjectOutertubeInvoiceInfo;
import com.jianan.software.pojo.SearchCondition;
import com.jianan.software.util.Page;

public interface IProjectOuterubeService {
	
	public String getNextSerialNo();

	public void createProjectOuterube(ProjectOutertube projectOutertube);

	public ProjectOutertube getProjectOuterubeByIdentifyNo(String taxpayerIdentifyNum);

	public ProjectOutertube getProjectOuterubeByProjectname(String projectname);

	public List<ProjectOutertube> getProjectOuterubes(Page page, String taxpayerName);

	public ProjectOutertube getProjectCheckBySerialNo(String serialNum);

	public void createProjectCheckInvoiceInfo(
			ProjectOutertubeInvoiceInfo projectOutertubeInvoiceInfo);

	public ProjectOutertubeInvoiceInfo getProjectOuterubeInvoiceInfoById(int id);

	public int getProjectOuterubeCount(String taxpayerName);
	
	public List<ProjectOutertube> search(String keyword);

	public void updateOutertube(ProjectOutertube outertube);

	public void delete(String serialNum);

	public List<ProjectOutertube> search(SearchCondition condition, Page page);
	
	public Map<String, String> sumOuterubeAmount(SearchCondition condition);
	
	public void createFiles(List<ProjectCheckFile> checkFiles);

	public void createInvoiceFiles(List<ProjectCheckFile> checkFiles);

	public List<ProjectCheckFile> getInvoiceFiles(int id);

	public void updateProjectCheckInvoiceInfo(
			ProjectOutertubeInvoiceInfo projectOuterubeInvoiceInfo); 
}
