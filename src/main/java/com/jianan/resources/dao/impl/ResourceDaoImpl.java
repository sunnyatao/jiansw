/**
 * 
 */
package com.jianan.resources.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jianan.resources.dao.IResourceDao;
import com.jianan.software.pojo.CrmAuthResource;
import com.jianan.software.pojo.CrmAuthUserResource;
import com.jianan.software.util.Page;

/**
 * @author haiywang
 *
 */
@Service("resourceDao")
public class ResourceDaoImpl implements IResourceDao{
	@Autowired
	private SqlSessionTemplate sqlSession;

	
	@Override
	public List<CrmAuthResource> getResourceList(Page page) {
		
		return sqlSession.selectList("com.lepu.hst.crm.web.resources.dao.getResourceList",page);
	}


	
	@Override
	public CrmAuthResource getCrmResource(int resourceId) {
		
		return sqlSession.selectOne("com.lepu.hst.crm.web.resources.dao.getResourceById", resourceId);
	}


	
	@Override
	public void createResource(CrmAuthResource resource) {
		sqlSession.insert("com.lepu.hst.crm.web.resources.dao.createResource", resource);
		
	}


	@Override
	public void updateResource(CrmAuthResource resource) {
		sqlSession.update("com.lepu.hst.crm.web.resources.dao.updateResource", resource);
	}

	@Override
	public void deleteResource(String resourceId) {
		sqlSession.delete("com.lepu.hst.crm.web.resources.dao.deleteResource", resourceId);
		sqlSession.delete("com.lepu.hst.crm.web.resources.dao.deleteNavigationByResourceId",resourceId);
		sqlSession.delete("com.lepu.hst.crm.web.resources.dao.deleteUserResourceByResourceId",resourceId);
		sqlSession.delete("com.lepu.hst.crm.web.resources.dao.deleteRoleResourceByResourceId",resourceId);
	}

	@Override
	public int getResourceCount() {
		
		return sqlSession.selectOne("com.lepu.hst.crm.web.resources.dao.getResourceCount");
	}

	@Override
	public void removeUserResources(int userId) {
		sqlSession.delete("com.lepu.hst.crm.web.resources.dao.removeUserResources", userId);
	}

	@Override
	public void insertUserResources(List<CrmAuthUserResource> userResources) {
		sqlSession.insert("com.lepu.hst.crm.web.resources.dao.insertUserResources", userResources);
	}

	@Override
	public List<CrmAuthResource> getAllResource() {
		
		return sqlSession.selectList("com.lepu.hst.crm.web.resources.dao.getAllResource");
	}
}
