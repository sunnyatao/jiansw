package com.jianan.software.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jianan.software.dao.IProjectSettlementDao;
import com.jianan.software.pojo.ProjectCheckFile;
import com.jianan.software.pojo.ProjectSettlement;
import com.jianan.software.pojo.ProjectSettlementInvoiceInfo;
import com.jianan.software.pojo.SearchCondition;
import com.jianan.software.util.Page;

@Service("projectSettlementDao")
public class ProjectSettlementDaoImpl implements IProjectSettlementDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public ProjectSettlement getMaxProjectCheck() {
		return sqlSession.selectOne("com.jianan.software.dao.impl.projectSettlement.getMaxProjectSettlement");
	}

	@Override
	public void createProjectCheck(ProjectSettlement projectSettlement) {
		sqlSession.insert("com.jianan.software.dao.impl.projectSettlement.createProjectSettlement", projectSettlement);
	}

	@Override
	public ProjectSettlement getProjectCheckByIdentifyNo(
			String taxpayerIdentifyNum) {
		return sqlSession.selectOne("com.jianan.software.dao.impl.projectSettlement.getProjectCheckByIdentifyNo", taxpayerIdentifyNum);
	}

	@Override
	public ProjectSettlement getProjectCheckByProjectname(String projectname) {
		return sqlSession.selectOne("com.jianan.software.dao.impl.projectSettlement.getProjectCheckByProjectname", projectname);
	}

	@Override
	public List<ProjectSettlement> getProjectChecks(Page page, String taxpayerName) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("start", page.getStart());
		params.put("pageSize", page.getPageSize());
		if ("".equals(taxpayerName)) {
			taxpayerName = null;
		}
		params.put("taxpayerName", taxpayerName);	
		return sqlSession.selectList("com.jianan.software.dao.impl.projectSettlement.getProjectSettlements", params);
	}

	@Override
	public ProjectSettlement getProjectCheckBySerialNo(String serialNum) {
		return sqlSession.selectOne("com.jianan.software.dao.impl.projectSettlement.getProjectSettlementBySerialNo", serialNum);
	}

	@Override
	public void createProjectCheckInvoiceInfo(
			ProjectSettlementInvoiceInfo projectSettlementInvoiceInfo) {
		sqlSession.insert("com.jianan.software.dao.impl.projectSettlement.createProjectCheckInvoiceInfo", projectSettlementInvoiceInfo);
	}

	@Override
	public ProjectSettlementInvoiceInfo getProjectCheckInvoiceInfoById(
			int checkId) {
		return sqlSession.selectOne("com.jianan.software.dao.impl.projectSettlement.getProjectCheckInvoiceInfoById", checkId);
	}

	@Override
	public int getProjectSettlementCount(String taxpayerName) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("taxpayerName", taxpayerName);
		return sqlSession.selectOne("com.jianan.software.dao.impl.projectSettlement.getProjectSettlementCount", params);
	}

	@Override
	public List<ProjectSettlement> search(String keyword) {
		return sqlSession.selectList("com.jianan.software.dao.impl.projectSettlement.search", keyword);
	}

	@Override
	public Object updateSettlement(ProjectSettlement settlement) {
		return sqlSession.update("com.jianan.software.dao.impl.projectSettlement.updateSettlement", settlement);
	}

	@Override
	public void delete(String serialNum) {
		sqlSession.update("com.jianan.software.dao.impl.projectSettlement.delete", serialNum);
	}

	@Override
	public String getMaxTaxSerialNo() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("com.jianan.software.dao.impl.projectSettlement.getMaxTaxSerialNo");
	}

	@Override
	public void updateTaxSerialNo(int id, String serialNo) {
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		params.put("serialNo", Integer.parseInt(serialNo));
		sqlSession.update("com.jianan.software.dao.impl.projectSettlement.updateTaxSerialNo", params);
	}

	@Override
	public List<ProjectSettlement> search(SearchCondition condition, Page page) {
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
		return sqlSession.selectList("com.jianan.software.dao.impl.projectSettlement.zksearch", params);
	}

	@Override
	public Map<String, String> sumSettlementAmount(SearchCondition condition) {
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
		return sqlSession.selectOne("com.jianan.software.dao.impl.projectSettlement.sumSettlementAmount", params);
	}

	@Override
	public void createProjectCheckFiles(List<ProjectCheckFile> checkFiles) {
		sqlSession.insert("com.jianan.software.dao.impl.projectSettlement.createProjectCheckFiles", checkFiles);
	}

	@Override
	public void createInvoiceFiles(List<ProjectCheckFile> checkFiles) {
		sqlSession.insert("com.jianan.software.dao.impl.projectSettlement.createInvoiceFiles", checkFiles);
	}

	@Override
	public List<ProjectCheckFile> getInvoiceFiles(int invoiceId) {
		return sqlSession.selectList("com.jianan.software.dao.impl.projectSettlement.getInvoiceFiles", invoiceId);
	}

}
