
package com.jianan.role.service;

import java.util.List;

import com.jianan.software.pojo.CrmAuthRole;
import com.jianan.software.pojo.CrmauthRoleResource;

/**
 * @author weiwzhou
 *
 */
public interface IRoleService {
	
	//角色列表的显示,查询的是auth_role
	public List<CrmAuthRole> getRoles();
	//角色的删除,删除auth_role和auth_role_resource，auth_user_role中的内容
	public boolean deleteRole(int roleId);
	//这里用于修改角色中的查询角色，其中有角色的关联resourceId,和auth_role,获得了显示的信息， 和这个函数同步的还有一个获得auth_resource 在IcommonService中，通过resource_id来进行判断选中的内容
	public CrmAuthRole getRoleBy(int roleId);
	/**
	 * 删除操作独立出来，在进行插入操作的时候，要返回roleId.
	 */
	public boolean insertRole(CrmAuthRole car);
	public boolean insertRoleResource(List<CrmauthRoleResource> carr);
	/**
	 * 当role存在时,进行的更新操作,更新数据记录: 1、更新role（auth_role）， 2、删除与role相关的roleResources，3、插入roleResources,
	 * 从前端传来的数据一定要有roleId;
	 * @param role
	 * @param resourceIds  
	 */
	public boolean updateRole(CrmAuthRole role, List<CrmauthRoleResource> carr);
}

