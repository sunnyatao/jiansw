/**
 * 
 */
package com.jianan.admin.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jianan.admin.dao.IUserDao;
import com.jianan.admin.service.IUserService;
import com.jianan.software.pojo.CrmAdminUser;
import com.jianan.software.pojo.CrmAuthUserResource;
import com.jianan.software.pojo.CrmAuthUserRole;
import com.jianan.software.util.Page;

/**
 * @author haiywang
 *
 */
@Service("userService")
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private IUserDao userDao;

	@Override
	public List<CrmAdminUser> getUserList(Page page) {
		
		return userDao.getUserList(page);
	}

	@Override
	public int saveUser(CrmAdminUser adminUser) throws Exception {
		int count = userDao.getUserByUserName(adminUser.getUserName());
		if(count!=0){
			throw new Exception();
		}
	   if(userDao.saveUser(adminUser) > 0) {
		   int userId = adminUser.getUserId();
		   return userId;
	   }else {
		   return 0;
	   }
	}

	@Override
	public void editPassword(CrmAdminUser adminUser, String oldActualPassword) throws Exception {
		String pwd = userDao.getPasswordByUserId(adminUser.getUserId());
		if(!pwd.equals(oldActualPassword)){
			throw new Exception();
		}
		userDao.editPassword(adminUser);
		
	}

	@Override
	public void changeUserStatus(String userId, String status) {
		
		userDao.changeUserStatus(userId,status);
	}
	
	@Override
	public int getUserCount() {
		
		return userDao.getUserCount();
	}

	@Override
	public CrmAdminUser getUserBy(int userId) {
		return userDao.getUserById(userId);
	}

	@Override
	@Transactional
	public void dispatchNavigation(String userId, String[] navIds) {
		userDao.deleteNavigationByUserId(userId);
		for(int i=0;i<navIds.length;i++){
			userDao.dispatchNavigation(userId,navIds[i]);
		}	
	}


	@Override
	public List<Integer> getNavIdsByUserId(String userId) {
		
		return userDao.getNavIdsByUserId(userId);
	}

	@Override
	public String getSaltByUserId(String userId) {
		
		return userDao.getSaltByUserId(userId);
	}
	 
	//根据userId,roleId 插入到auth_user_role中，2 根据roleId 找到所有的resourceId，将roleId和所有的resourceId插入到auth_user_resource中，
	@Override
	public boolean insertIds(int roleId, int userId,String userName) {
		List<Integer> resourcesIds = userDao.getResourcesIdsBy(roleId);
		List<CrmAuthUserResource> CrmAuthUserResources = new ArrayList<>();
		for(Integer resourceId : resourcesIds) {
			CrmAuthUserResource crmAuthUserResource = new CrmAuthUserResource();
			crmAuthUserResource.setCreatedOn(new Date());
			crmAuthUserResource.setCreatedBy(userName);
			crmAuthUserResource.setResourceId(resourceId);
			crmAuthUserResource.setUserId(userId);
			
			CrmAuthUserResources.add(crmAuthUserResource);
		}
		
		CrmAuthUserRole crmAuthUserRole = new CrmAuthUserRole();
		crmAuthUserRole.setCreatedBy(userName);
		crmAuthUserRole.setCreatedOn(new Date());
		crmAuthUserRole.setRoleId(roleId);
		crmAuthUserRole.setUserId(userId);
		if(userDao.insertCrmAuthUserRole(crmAuthUserRole)==1 && userDao.insertCrmAuthUserResources(CrmAuthUserResources)>1) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public CrmAdminUser getAdminUserByUserName(String userName) {
	     return  userDao.getAdminUserByUserName(userName);
	}

	@Override
	public boolean updateAdminUser(CrmAdminUser newAdminUser) {
		if(userDao.updateAdminUser(newAdminUser)==1) {
			return true;
		}else {
			return false;
		}
	}
	

}
