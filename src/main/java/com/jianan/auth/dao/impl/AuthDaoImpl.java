/**
 *	Copyright (C) 2014-2015 hst Software. All rights reserved. 
 *
 *	Author: sunny
 *
 *	CreatedAt: 2016年8月15日
 *  
 *	Description: ...
 */
package com.jianan.auth.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jianan.auth.dao.IAuthDao;
import com.jianan.software.pojo.CrmAdminUser;

@Repository("authDao")
public class AuthDaoImpl implements IAuthDao {
	
	@Autowired
	SqlSessionTemplate sqlSession;

	@Override
	public CrmAdminUser getAdminUser(String userName) {
		return sqlSession.selectOne("com.lepu.hst.crm.web.auth.dao.impl.getAdminUser", userName);
	}

	@Override
	public void updateUserLoginTime(int userId) {
		sqlSession.update("com.lepu.hst.crm.web.auth.dao.impl.updateUserLoginTime", userId);
	}

}
