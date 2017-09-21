package com.jianan.software.dao;

import java.util.List;
import java.util.Map;

import com.jianan.software.pojo.ProjectCheckFile;
import com.jianan.software.pojo.ProjectOutertube;
import com.jianan.software.pojo.ProjectOutertubeInvoiceInfo;
import com.jianan.software.pojo.SearchCondition;
import com.jianan.software.util.Page;

public interface IProjectOutubeDao {
	
	public ProjectOutertube getMaxProjectOuterube();

	public void createProjectOuterube(ProjectOutertube projectOutertube);

	public ProjectOutertube getProjectOuterubeByIdentifyNo(String taxpayerIdentifyNum);

	public ProjectOutertube getProjectOuterubeByProjectname(String projectname);

	/**
	 * 待实现分页查询
	 * @param taxPayName TODO
	 * @return
	 */
	public List<ProjectOutertube> getProjectOuterubes(Page page, String taxPayName);

	public ProjectOutertube getProjectOuterubeBySerialNo(String serialNum);

	public void createProjectOuterubeInvoiceInfo(
			ProjectOutertubeInvoiceInfo projectOutertubeInvoiceInfo);

	public ProjectOutertubeInvoiceInfo getProjectOuterubeInvoiceInfoById(int checkId);

	public int getProjectOuterubeCount(String taxPayName);

	public List<ProjectOutertube> search(String keyword);

	public void updateOutertube(ProjectOutertube outertube);

	public void delete(String serialNum);

	public List<ProjectOutertube> search(SearchCondition condition, Page page);

	public Map<String, String> sumOuterubeAmount(SearchCondition condition);

	public void createProjectCheckFiles(List<ProjectCheckFile> checkFiles);

	public void createInvoiceFiles(List<ProjectCheckFile> checkFiles);

	public List<ProjectCheckFile> getInvoiceFiles(int invoiceId);
	
	public void updateProjectCheckInvoiceInfo(
			ProjectOutertubeInvoiceInfo projectOuterubeInvoiceInfo); 
}
