/**
 * 
 */
package com.jianan.admin.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jianan.admin.dao.IUserDao;
import com.jianan.software.pojo.CrmAdminUser;
import com.jianan.software.pojo.CrmAuthUserResource;
import com.jianan.software.pojo.CrmAuthUserRole;
import com.jianan.software.util.Page;

/**
 * @author haiywang
 *
 */
@Service("userDao")
public class UserDaoImpl implements IUserDao{

	
	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Override
	public List<CrmAdminUser> getUserList(Page page) {
		
		return sqlSession.selectList("com.lepu.hst.crm.web.admin.dao.user.getUserList",page);
	}

	@Override
	public int saveUser(CrmAdminUser adminUser) {
		return sqlSession.insert("com.lepu.hst.crm.web.admin.dao.user.saveUser",adminUser);
		
	}
	@Override
	public int getUserByUserName(String userName) {
		
		return sqlSession.selectOne("com.lepu.hst.crm.web.admin.dao.user.getUserByUserName",userName);
	}

	@Override
	public String getPasswordByUserId(int userId) {
		
		return sqlSession.selectOne("com.lepu.hst.crm.web.admin.dao.user.getPasswordByUserId",userId);
	}

	@Override
	public void editPassword(CrmAdminUser adminUser) {
		sqlSession.update("com.lepu.hst.crm.web.admin.dao.user.editPassword", adminUser);
	}

	@Override
	public void changeUserStatus(String userId, String status) {
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("userId", userId);
		param.put("status", status);
		sqlSession.update("com.lepu.hst.crm.web.admin.dao.user.changeUserStatus",param);
	}

	@Override
	public int getUserCount() {
		return sqlSession.selectOne("com.lepu.hst.crm.web.admin.dao.user.getUserCount");
		
	}

	@Override
	public CrmAdminUser getUserById(int userId) {
		return sqlSession.selectOne("com.lepu.hst.crm.web.admin.dao.user.getUserById", userId);
	}

	@Override
	public void dispatchNavigation(String userId, String navId) {
		HashMap<String,Object> param = new HashMap<String,Object>();
		param.put("userId", userId);
		param.put("navId", navId);
		param.put("createdOn", new Date());
		sqlSession.insert("com.lepu.hst.crm.web.admin.dao.user.dispatchNavigation",param);
	}


	@Override
	public List<Integer> getNavIdsByUserId(String userId) {
		
		return sqlSession.selectList("com.lepu.hst.crm.web.admin.dao.user.getNavIdsByUserId", userId);
	}
	@Override
	public void deleteNavigationByUserId(String userId) {
		sqlSession.delete("com.lepu.hst.crm.web.admin.dao.user.deleteNavigationByUserId", userId);
		
	}

	@Override
	public String getSaltByUserId(String userId) {
		
		return sqlSession.selectOne("com.lepu.hst.crm.web.admin.dao.user.getSaltByUserId", userId);
	}

	@Override
	public List<Integer> getResourcesIdsBy(int roleId) {
		return sqlSession.selectList("com.lepu.hst.crm.web.admin.dao.user.getResourcesIdsBy",roleId);
	}

	@Override
	public int insertCrmAuthUserResources(List<CrmAuthUserResource> crmAuthUserResources) {
		return sqlSession.insert("com.lepu.hst.crm.web.admin.dao.user.insertCrmAuthUserResources", crmAuthUserResources);
	}

	@Override
	public int insertCrmAuthUserRole(CrmAuthUserRole crmAuthUserRole) {
		return sqlSession.insert("com.lepu.hst.crm.web.admin.dao.user.insertCrmAuthUserRole", crmAuthUserRole);
	}
	
	@Override
	public CrmAdminUser getAdminUserByUserName(String userName) {
		return sqlSession.selectOne("com.lepu.hst.crm.web.admin.dao.user.getAdminUserByUserName",userName);
	}

	@Override
	public int updateAdminUser(CrmAdminUser newAdminUser) {
		return sqlSession.update("com.lepu.hst.crm.web.admin.dao.user.updateAdminUser", newAdminUser);
	}

}
