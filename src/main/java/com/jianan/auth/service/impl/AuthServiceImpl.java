/**
 *	Copyright (C) 2014-2015 hst Software. All rights reserved. 
 *
 *	Author: sunny
 *
 *	CreatedAt: 2016年8月15日
 *  
 *	Description: ...
 */
package com.jianan.auth.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jianan.auth.dao.IAuthDao;
import com.jianan.auth.service.IAuthService;
import com.jianan.software.pojo.CrmAdminUser;
import com.jianan.software.util.AccountUtil;

@Service("authService")
public class AuthServiceImpl implements IAuthService {

	private Logger LOGGER = LoggerFactory.getLogger(AuthServiceImpl.class);
	
	@Autowired
	private IAuthDao authDao;
	
	@Override
	public CrmAdminUser login(String userName, String password) throws Exception {
		CrmAdminUser adminUser = authDao.getAdminUser(userName);
		if (adminUser == null) {
			throw new Exception("不存在管理员");
		}
		
		if (adminUser.getStatus() == CrmAdminUser.STATUS_INVALID) {
			throw new Exception();
		}
		
		String expectedPwd = adminUser.getPassword();
		String actualPwd = AccountUtil.compilePassword(password, adminUser.getSalt());
		
		if (!expectedPwd.equals(actualPwd)) {
			LOGGER.info("-----------password:" + password + " userPass:"+adminUser.getPassword()+"----------------");
			throw new Exception();
		}
		
		authDao.updateUserLoginTime(adminUser.getUserId());
		return adminUser;
	}

}
