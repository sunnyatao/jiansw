package com.jianan.software.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jianan.software.dao.IHouseContractDao;
import com.jianan.software.pojo.HouseContract;
import com.jianan.software.pojo.HouseContractTaxInfo;
import com.jianan.software.pojo.ProjectCheckFile;
import com.jianan.software.pojo.SearchCondition;
import com.jianan.software.util.Page;

@Repository("houseContract")
public class HouseContractDaoImpl implements IHouseContractDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int getHouseContractCount(String name) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", name);
		return sqlSession.selectOne("com.jianan.software.dao.impl.housecontract.getHouseContractCount");
	}

	@Override
	public List<HouseContract> getHouseContracts(Page page, String name) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("start", page.getStart());
		params.put("pageSize", page.getPageSize());
		if ("".equals(name)) {
			name = null;
		}
		params.put("name", name);
		return sqlSession.selectList("com.jianan.software.dao.impl.housecontract.getHouseContracts", params);
	}

	@Override
	public void createProjectCheck(HouseContract houseContract) {
		sqlSession.insert("com.jianan.software.dao.impl.housecontract.createProjectCheck", houseContract);
	}

	@Override
	public HouseContract getHouseConstractBy(int id) {
		return sqlSession.selectOne("com.jianan.software.dao.impl.housecontract.getHouseConstractBy", id);
	}

	@Override
	public List<HouseContract> search(String keyword) {
		return sqlSession.selectList("com.jianan.software.dao.impl.housecontract.search", keyword);
	}

	@Override
	public void delete(String serialNum) {
		sqlSession.update("com.jianan.software.dao.impl.housecontract.delete", serialNum);
	}

	@Override
	public HouseContractTaxInfo getHouseConstractTaxInfo(int houseContractId) {
		return sqlSession.selectOne("com.jianan.software.dao.impl.housecontract.getHouseConstractTaxInfo", houseContractId);
	}

	@Override
	public void createTaxInfo(HouseContractTaxInfo taxInfo) {
		sqlSession.insert("com.jianan.software.dao.impl.housecontract.createHouseContractTaxInfo", taxInfo);
	}

	@Override
	public List<HouseContract> searchContract(SearchCondition condition, Page page) {
		Map<String, Object> params = new HashMap<>();
		params.put("name", condition.getName());
		params.put("floorName", condition.getFloorName());
		params.put("taxStartTime", condition.getTaxStartTime());
		params.put("taxEndTime", condition.getTaxEndTime());
		params.put("start", page.getStart());
		params.put("pageSize", page.getPageSize());
		return sqlSession.selectList("com.jianan.software.dao.impl.housecontract.searchContract", params);
	}

	@Override
	public void createProjectCheckFiles(List<ProjectCheckFile> checkFiles) {
		sqlSession.insert("com.jianan.software.dao.impl.housecontract.createProjectCheckFiles", checkFiles);
	}

	@Override
	public void createInvoiceFiles(List<ProjectCheckFile> checkFiles) {
		sqlSession.insert("com.jianan.software.dao.impl.housecontract.createInvoiceFiles", checkFiles);
	}

	@Override
	public List<ProjectCheckFile> getInvoiceFiles(int invoiceId) {
		return sqlSession.selectList("com.jianan.software.dao.impl.housecontract.getInvoiceFiles", invoiceId);
	}

	@Override
	public void updateTaxInfo(HouseContractTaxInfo taxInfo) {
		sqlSession.update("com.jianan.software.dao.impl.housecontract.updateTaxInfo", taxInfo);
	}

	@Override
	public void updateProjectCheck(HouseContract houseContract) {
		sqlSession.update("com.jianan.software.dao.impl.housecontract.updateProjectCheck", houseContract);
	}

}
