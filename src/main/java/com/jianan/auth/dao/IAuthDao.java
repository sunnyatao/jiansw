/**
 *	Copyright (C) 2014-2015 hst Software. All rights reserved. 
 *
 *	Author: sunny
 *
 *	CreatedAt: 2016年8月15日
 *  
 *	Description: ...
 */
package com.jianan.auth.dao;

import com.jianan.software.pojo.CrmAdminUser;

public interface IAuthDao {

	CrmAdminUser getAdminUser(String userName);

	/**
	 * @param userId
	 */
	void updateUserLoginTime(int userId);
}
