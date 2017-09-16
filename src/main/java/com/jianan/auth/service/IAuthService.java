/**
 *	Copyright (C) 2014-2015 hst Software. All rights reserved. 
 *
 *	Author: sunny
 *
 *	CreatedAt: 2016年8月15日
 *  
 *	Description: ...
 */
package com.jianan.auth.service;

import com.jianan.software.pojo.CrmAdminUser;

public interface IAuthService {
	
	CrmAdminUser login(String userName, String password) throws Exception;
}
