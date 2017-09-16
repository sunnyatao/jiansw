package com.jianan.software.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jianan.software.dao.IProjectOutubeDao;
import com.jianan.software.pojo.ProjectCheck;
import com.jianan.software.pojo.ProjectCheckFile;
import com.jianan.software.pojo.ProjectCheckInvoiceInfo;
import com.jianan.software.pojo.ProjectOutertube;
import com.jianan.software.pojo.ProjectOutertubeInvoiceInfo;
import com.jianan.software.pojo.SearchCondition;
import com.jianan.software.util.Page;

@Repository("projectOuterubeDao")
public class ProjectOuterubeDaoImpl implements IProjectOutubeDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public ProjectOutertube getMaxProjectOuterube() {
		return sqlSession.selectOne("com.jianan.software.dao.impl.outerubeDao.getMaxProjectCheck");
	}

	@Override
	public void createProjectOuterube(ProjectOutertube projectOutertube) {
		sqlSession.insert("com.jianan.software.dao.impl.outerubeDao.createProjectCheck", projectOutertube);
	}

	@Override
	public ProjectOutertube getProjectOuterubeByIdentifyNo(String taxpayerIdentifyNum) {
		return sqlSession.selectOne("com.jianan.software.dao.impl.outerubeDao.getProjectCheckByIdentifyNo", taxpayerIdentifyNum);
	}

	@Override
	public ProjectOutertube getProjectOuterubeByProjectname(String projectname) {
		return sqlSession.selectOne("com.jianan.software.dao.impl.outerubeDao.getProjectCheckByProjectname", projectname);
	}

	@Override
	public List<ProjectOutertube> getProjectOuterubes(Page page, String taxpayerName) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("start", page.getStart());
		params.put("pageSize", page.getPageSize());
		if ("".equals(taxpayerName)) {
			taxpayerName = null;
		}
		params.put("taxpayerName", taxpayerName);
		return sqlSession.selectList("com.jianan.software.dao.impl.outerubeDao.getProjectChecks", params);
	}

	@Override
	public ProjectOutertube getProjectOuterubeBySerialNo(String serialNum) {
		return sqlSession.selectOne("com.jianan.software.dao.impl.outerubeDao.getProjectCheckBySerialNo", serialNum);
	}

	@Override
	public void createProjectOuterubeInvoiceInfo(
			ProjectOutertubeInvoiceInfo projectOutertubeInvoiceInfo) {
		sqlSession.insert("com.jianan.software.dao.impl.outerubeDao.createProjectCheckInvoiceInfo", projectOutertubeInvoiceInfo);
	}

	@Override
	public ProjectOutertubeInvoiceInfo getProjectOuterubeInvoiceInfoById(int checkId) {
		return sqlSession.selectOne("com.jianan.software.dao.impl.outerubeDao.getProjectCheckInvoiceInfoById", checkId);
	}

	@Override
	public int getProjectOuterubeCount(String taxpayerName) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("taxpayerName", taxpayerName);
		return sqlSession.selectOne("com.jianan.software.dao.impl.outerubeDao.getProjectOuterubeCount", params);
	}

	@Override
	public List<ProjectOutertube> search(String keyword) {
		return sqlSession.selectList("com.jianan.software.dao.impl.outerubeDao.search", keyword);
	}

	@Override
	public void updateOutertube(ProjectOutertube outertube) {
		sqlSession.update("com.jianan.software.dao.impl.outerubeDao.updateOutertube", outertube);
	}

	@Override
	public void delete(String serialNum) {
		sqlSession.update("com.jianan.software.dao.impl.outerubeDao.delete", serialNum);
	}

	@Override
	public List<ProjectOutertube> search(SearchCondition condition, Page page) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("serialNum", condition.getSerialNum());
		params.put("projectName", condition.getProjectName());
		params.put("taxpayerName", condition.getTaxpayerName());
		params.put("projectConstructor", condition.getProjectConstructor());
		params.put("nationalInvoiceNo", condition.getNationalInvoiceNo());
		params.put("nationalInvoiceTaxNo", condition.getNationalInvoiceTaxNo());
		params.put("localInvoiceTaxNo", condition.getLocalInvoiceTaxNo());
		params.put("taxStartTime", condition.getTaxStartTime());
		params.put("taxEndTime", condition.getTaxEndTime());
		params.put("start", page.getStart());
		params.put("pageSize", page.getPageSize());
		return sqlSession.selectList("com.jianan.software.dao.impl.outerubeDao.zksearch", params);
	}

	@Override
	public Map<String, String> sumOuterubeAmount(SearchCondition condition) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("serialNum", condition.getSerialNum());
		params.put("projectName", condition.getProjectName());
		params.put("taxpayerName", condition.getTaxpayerName());
		params.put("projectConstructor", condition.getProjectConstructor());
		params.put("nationalInvoiceNo", condition.getNationalInvoiceNo());
		params.put("nationalInvoiceTaxNo", condition.getNationalInvoiceTaxNo());
		params.put("localInvoiceTaxNo", condition.getLocalInvoiceTaxNo());
		params.put("taxStartTime", condition.getTaxStartTime());
		params.put("taxEndTime", condition.getTaxEndTime());
		return sqlSession.selectOne("com.jianan.software.dao.impl.outerubeDao.sumOuterubeAmount", params);
	}

	@Override
	public void createProjectCheckFiles(List<ProjectCheckFile> checkFiles) {
		sqlSession.insert("com.jianan.software.dao.impl.outerubeDao.createProjectCheckFiles", checkFiles);
	}

	@Override
	public void createInvoiceFiles(List<ProjectCheckFile> checkFiles) {
		sqlSession.insert("com.jianan.software.dao.impl.outerubeDao.createInvoiceFiles", checkFiles);		
	}

	@Override
	public List<ProjectCheckFile> getInvoiceFiles(int invoiceId) {
		return sqlSession.selectList("com.jianan.software.dao.impl.outerubeDao.getInvoiceFiles", invoiceId);
	}

}
