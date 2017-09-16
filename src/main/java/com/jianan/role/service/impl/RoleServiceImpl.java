
package com.jianan.role.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jianan.role.dao.IRoleDao;
import com.jianan.role.service.IRoleService;
import com.jianan.software.pojo.CrmAuthRole;
import com.jianan.software.pojo.CrmauthRoleResource;

/**
 * @author weiwzhou
 *
 */
@Service(value = "roleService")
public class RoleServiceImpl  implements IRoleService {
	private Logger LOGGER = LoggerFactory.getLogger(RoleServiceImpl.class);
	
	@Autowired
	private IRoleDao roleDao;
	
	@Override
	public List<CrmAuthRole> getRoles() {
		
		return roleDao.getRoleList();
	}

	@Override
	public boolean deleteRole(int roleId) {  //这里要完成三部分内容，一部分是将auth_role中的内容删除，一部分是将auth_role_resource中的记录删除，最后将auth_user_role中的内容删除
		
		if(roleDao.deleteAuthRole(roleId)==1) {
			LOGGER.debug("角色信息删除成功");
		}else {
			LOGGER.error("角色信息删除失败");
		}
		
		if(roleDao.deleteAuthUserRole(roleId) >= 1) {
			LOGGER.debug("用户和角色的关系删除成功");
		}else {
			LOGGER.error("用户和角色的关系删除失败");
		}
		if(roleDao.deleteAuthRoleResource(roleId) >= 1){
			LOGGER.debug("角色关联表删除成功");
			return true;
		}else {
			LOGGER.error("角色关联表删除失败");
			return false;
		}
	}

	@Override
	public CrmAuthRole getRoleBy(int roleId) {
		return roleDao.getRoleBy(roleId);
	}

	@Override
	public boolean updateRole(CrmAuthRole role, List<CrmauthRoleResource> carr) {
		int roleId = role.getRoleId();
		if(roleDao.updateRole(role)==1) {
			LOGGER.debug("auth_role数据更新成功");
		}else {
			LOGGER.error("auth_role数据更新失败");
		}
		if(roleDao.deleteAuthRoleResource(roleId) >= 1) {
			LOGGER.debug("auth_role_resource数据删除成功");
		}else {
			LOGGER.error("auth_role_resource数据删除失败");
		}
		
		if(roleDao.insertRoleResources(carr) >= 1) {
			LOGGER.debug("auth_role_resource数据插入成功");
			return true;
		}else {
			LOGGER.error("auth_role_resource数据插入失败");
			return false;
		}
	}

	@Override
	public boolean insertRole(CrmAuthRole car) {
		if(roleDao.insertRole(car) != 0) {
			LOGGER.debug("auth_role数据插入成功");
			return true;
		}else {
			LOGGER.error("auth_role_resource数据插入失败");
			return false;
		}
	}

	@Override
	public boolean insertRoleResource(List<CrmauthRoleResource> carr) {
		if(roleDao.insertRoleResources(carr) >= 1) {
			LOGGER.debug("auth_role_resource数据插入成功");
			return true;
		} else {
			LOGGER.error("auth_role_resource数据插入失败");
			return false;
		}
	}

}

