/**
 * 
 */
package com.jianan.role.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jianan.role.dao.IRoleDao;
import com.jianan.software.pojo.CrmAuthRole;
import com.jianan.software.pojo.CrmauthRoleResource;

/**
 * @author weiwzhou
 *
 */
@Repository(value = "roleDao")
public class RoleDaoImpl implements IRoleDao{
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<CrmAuthRole> getRoleList() {
		return sqlSession.selectList("com.lepu.hst.crm.web.role.dao.getRoleList");
	}
	
	@Override
	public int deleteAuthRole(int roleId) {
		return sqlSession.delete("com.lepu.hst.crm.web.role.dao.deleteAuthRole", roleId);
	}
	@Override
	public int deleteAuthUserRole(int roleId) {
		return sqlSession.delete("com.lepu.hst.crm.web.role.dao.deleteAuthUserRole",roleId);
	}

	@Override
	public int deleteAuthRoleResource(int roleId) {
		return sqlSession.delete("com.lepu.hst.crm.web.role.dao.deleteAuthRoleResource", roleId);
	}

	@Override
	public CrmAuthRole getRoleBy(int roleId) {
		return sqlSession.selectOne("com.lepu.hst.crm.web.role.dao.getRoleBy",roleId);
	}
	
	@Override
	public int updateRole(CrmAuthRole role) {
		return sqlSession.update("com.lepu.hst.crm.web.role.dao.updateRole", role);
	}
	
	@Override
	public int deleteRoleResources(int roleId) {
		return sqlSession.delete("com.lepu.hst.crm.web.role.dao.deleteRoleResources",roleId);
	}

	@Override
	public int insertRoleResources(List<CrmauthRoleResource> roleResources) {
		return sqlSession.insert("com.lepu.hst.crm.web.role.dao.insertRoleResources", roleResources);
	}
	
	@Override
	public int insertRole(CrmAuthRole role) {
		return sqlSession.insert("com.lepu.hst.crm.web.role.dao.insertRole",role);
	}

}

