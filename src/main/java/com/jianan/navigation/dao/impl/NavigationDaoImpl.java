/**
 * 
 */
package com.jianan.navigation.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jianan.navigation.dao.INavigationDao;
import com.jianan.software.pojo.CrmAuthNavigation;

/**
 * @author haiywang
 *
 */
@Service("navigationDao")
public class NavigationDaoImpl implements INavigationDao{
	
	@Autowired
	SqlSessionTemplate sqlSession;

	@Override
	public List<CrmAuthNavigation> getNavigationList() {
		
		return sqlSession.selectList("com.lepu.hst.crm.web.navigation.dao.getNavigationList");
	}

	@Override
	public void saveFirstNavigation(CrmAuthNavigation nav) {
		sqlSession.insert("com.lepu.hst.crm.web.navigation.dao.saveFirstNavigation",nav);
		
	}

	@Override
	public List<CrmAuthNavigation> getNavListByParentId(String parentId) {
		
		return sqlSession.selectList("com.lepu.hst.crm.web.navigation.dao.getNavListByParentId", parentId);
	}
	@Override
	public void deleteNavById(String navId) {
		sqlSession.delete("com.lepu.hst.crm.web.navigation.dao.deleteNavById",navId);
		sqlSession.delete("com.lepu.hst.crm.web.navigation.dao.deleteUserNavById",navId);
		
	}

	@Override
	public void editNavigation(int navId, String navName, int resourceId) {
		Map<String,Object> param = new HashMap<>();
		param.put("navId", navId);
		param.put("navName", navName);
		param.put("resourceId", resourceId);
		sqlSession.update("com.lepu.hst.crm.web.navigation.dao.updateNavigationById", param);
	}
}
