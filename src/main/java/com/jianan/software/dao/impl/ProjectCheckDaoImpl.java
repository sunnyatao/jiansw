package com.jianan.software.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jianan.software.dao.IProjectCheckDao;
import com.jianan.software.pojo.ProjectCheck;
import com.jianan.software.pojo.ProjectCheckFile;
import com.jianan.software.pojo.ProjectCheckInvoiceInfo;
import com.jianan.software.pojo.SearchCondition;
import com.jianan.software.pojo.SinglePrint;
import com.jianan.software.util.Page;

@Repository("projectCheckDao")
public class ProjectCheckDaoImpl implements IProjectCheckDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public ProjectCheck getMaxProjectSettlement() {
		return sqlSession.selectOne("com.jianan.software.dao.impl.projectCheck.getMaxProjectCheck");
	}

	@Override
	public void createProjectCheck(ProjectCheck projectCheck) {
		sqlSession.insert("com.jianan.software.dao.impl.projectCheck.createProjectCheck", projectCheck);
	}

	@Override
	public ProjectCheck getProjectCheckByIdentifyNo(String taxpayerIdentifyNum) {
		return sqlSession.selectOne("com.jianan.software.dao.impl.projectCheck.getProjectCheckByIdentifyNo", taxpayerIdentifyNum);
	}

	@Override
	public ProjectCheck getProjectCheckByProjectname(String projectname) {
		return sqlSession.selectOne("com.jianan.software.dao.impl.projectCheck.getProjectCheckByProjectname", projectname);
	}

	@Override
	public List<ProjectCheck> getProjectChecks(Page page, String taxpayerName) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("start", page.getStart());
		params.put("pageSize", page.getPageSize());
		if ("".equals(taxpayerName)) {
			taxpayerName = null;
		}
		params.put("taxpayerName", taxpayerName);		
		return sqlSession.selectList("com.jianan.software.dao.impl.projectCheck.getProjectChecks", params);
	}

	@Override
	public ProjectCheck getProjectCheckBySerialNo(String serialNum) {
		return sqlSession.selectOne("com.jianan.software.dao.impl.projectCheck.getProjectCheckBySerialNo", serialNum);
	}

	@Override
	public void createProjectCheckInvoiceInfo(
			ProjectCheckInvoiceInfo projectCheckInvoiceInfo) {
		sqlSession.insert("com.jianan.software.dao.impl.projectCheck.createProjectCheckInvoiceInfo", projectCheckInvoiceInfo);
	}

	@Override
	public ProjectCheckInvoiceInfo getProjectCheckInvoiceInfoById(int checkId) {
		return sqlSession.selectOne("com.jianan.software.dao.impl.projectCheck.getProjectCheckInvoiceInfoById", checkId);
	}

	@Override
	public int getProjectCheckCount(String taxpayerName) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("taxpayerName", taxpayerName);
		return sqlSession.selectOne("com.jianan.software.dao.impl.projectCheck.getProjectCheckCount", params);
	}

	@Override
	public List<ProjectCheck> search(String keyword) {
		return sqlSession.selectList("com.jianan.software.dao.impl.projectCheck.search", keyword);
	}

	@Override
	public void updateProjectCheck(ProjectCheck projectCheck) {
		sqlSession.update("com.jianan.software.dao.impl.projectCheck.updateProjectCheck", projectCheck);
	}

	@Override
	public void delete(String serialNum) {
		sqlSession.update("com.jianan.software.dao.impl.projectCheck.delete", serialNum);
	}

	@Override
	public String getMaxTaxSerialNo() {
		return sqlSession.selectOne("com.jianan.software.dao.impl.projectCheck.getMaxTaxSerialNo");
	}

	@Override
	public void updateTaxSerialNo(int id, String serialNo) {
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		params.put("serialNo", Integer.parseInt(serialNo));
		sqlSession.update("com.jianan.software.dao.impl.projectCheck.updateTaxSerialNo", params);
	}

	@Override
	public List<SinglePrint> getSinglePrints(Page page) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("start", page.getStart());
		params.put("pageSize", page.getPageSize());
		return sqlSession.selectList("com.jianan.software.dao.impl.projectCheck.getSinglePrints", params);
	}

	@Override
	public int getSinglePrintCount() {
		return sqlSession.selectOne("com.jianan.software.dao.impl.projectCheck.getSinglePrintCount");
	}

	@Override
	public int getMaxPrintSerialNo() {
		Integer result = sqlSession.selectOne("com.jianan.software.dao.impl.projectCheck.getMaxPrintSerialNo");
		if (result == null) {
			return 0;
		}
		return result;
	}

	@Override
	public void createSinglePrintInfo(SinglePrint singlePrint) {
		sqlSession.insert("com.jianan.software.dao.impl.projectCheck.createSinglePrintInfo", singlePrint);
	}

	@Override
	public SinglePrint getSinglePrint(String id) {
		return sqlSession.selectOne("com.jianan.software.dao.impl.projectCheck.getSinglePrint", id);
	}

	@Override
	public void createProjectCheckFiles(List<ProjectCheckFile> checkFiles) {
		sqlSession.insert("com.jianan.software.dao.impl.projectCheck.createProjectCheckFiles", checkFiles);
	}

	@Override
	public List<ProjectCheck> search(SearchCondition condition, Page page) {
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
		return sqlSession.selectList("com.jianan.software.dao.impl.projectCheck.zksearch", params);
	}

	@Override
	public Map<String, String> sumCheckAmount(SearchCondition condition) {
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
		return sqlSession.selectOne("com.jianan.software.dao.impl.projectCheck.sumCheckAmount", params);
	}

	@Override
	public void createInvoiceFiles(List<ProjectCheckFile> checkFiles) {
		sqlSession.insert("com.jianan.software.dao.impl.projectCheck.createInvoiceFiles", checkFiles);
	}

	@Override
	public List<ProjectCheckFile> getInvoiceFiles(int invoiceId) {
		return sqlSession.selectList("com.jianan.software.dao.impl.projectCheck.getInvoiceFiles", invoiceId);
	}

	@Override
	public void deletetSinglePrint(int id) {
		sqlSession.update("com.jianan.software.dao.impl.projectCheck.deletetSinglePrint", id);
	}

	@Override
	public void updateInvoiceInfo(ProjectCheckInvoiceInfo invoiceInfo) {
		sqlSession.update("com.jianan.software.dao.impl.projectCheck.updateCheckInvoiceInfo", invoiceInfo);
	}

}
