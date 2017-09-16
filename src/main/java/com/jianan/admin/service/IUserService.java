/**
 * 
 */
package com.jianan.admin.service;

import java.util.List;

import com.jianan.software.pojo.CrmAdminUser;
import com.jianan.software.util.Page;

/**
 * @author haiywang
 *
 */
public interface IUserService {

	List<CrmAdminUser> getUserList(Page page);

	public int saveUser(CrmAdminUser adminUser) throws Exception;


	void editPassword(CrmAdminUser adminUser, String oldActualPassword) throws Exception;


	void changeUserStatus(String userId, String status);


	int getUserCount();
	
	CrmAdminUser getUserBy(int userId);

	void dispatchNavigation(String userId, String[] ids);
	
	List<Integer> getNavIdsByUserId(String userId);
	
	String getSaltByUserId(String userId);

	public boolean insertIds(int roleId, int userId,String userName);

	CrmAdminUser getAdminUserByUserName(String userName);

	public boolean updateAdminUser(CrmAdminUser newAdminUser);
}
