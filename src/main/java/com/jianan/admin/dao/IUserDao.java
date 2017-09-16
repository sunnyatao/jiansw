/**
 * 
 */
package com.jianan.admin.dao;

import java.util.List;

import com.jianan.software.pojo.CrmAdminUser;
import com.jianan.software.pojo.CrmAuthUserResource;
import com.jianan.software.pojo.CrmAuthUserRole;
import com.jianan.software.util.Page;

/**
 * @author haiywang
 *
 */
public interface IUserDao {

	
	List<CrmAdminUser> getUserList(Page page);

	
	public int saveUser(CrmAdminUser adminUser);
	
	int getUserByUserName(String userName);

	String getPasswordByUserId(int userId);

	void editPassword(CrmAdminUser adminUser);

	void changeUserStatus(String userId, String status);

	int getUserCount();


	/**
	 * @param userId
	 * @return
	 */
	CrmAdminUser getUserById(int userId);

	void dispatchNavigation(String userId, String navId);

	List<Integer> getNavIdsByUserId(String userId);

	void deleteNavigationByUserId(String userId);

	String getSaltByUserId(String userId);

	List<Integer> getResourcesIdsBy(int roleId);

	public int insertCrmAuthUserResources(List<CrmAuthUserResource> crmAuthUserResources);

	public int insertCrmAuthUserRole(CrmAuthUserRole crmAuthUserRole);

	public CrmAdminUser getAdminUserByUserName(String userName);

	public int updateAdminUser(CrmAdminUser newAdminUser);

}
