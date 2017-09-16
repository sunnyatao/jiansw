
/**
 * 
 */
package com.jianan.role.dao;

import java.util.List;

import com.jianan.software.pojo.CrmAuthRole;
import com.jianan.software.pojo.CrmauthRoleResource;

/**
 * @author weiwzhou
 *
 */
public interface IRoleDao {
	
	public List<CrmAuthRole> getRoleList();
	
	public int deleteAuthRole(int roleId);
	
	public int deleteAuthRoleResource(int roleId);
	
	public int updateRole(CrmAuthRole role);
	
	public int insertRole(CrmAuthRole role);
	
	public int deleteRoleResources(int roleId);
	
	public int insertRoleResources(List<CrmauthRoleResource> roleResources);
	
	public int deleteAuthUserRole(int roleId);
	
	public CrmAuthRole getRoleBy(int roleId);

}

