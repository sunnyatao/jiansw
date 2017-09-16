/**
 *	Copyright (C) 2014-2015 hst Software. All rights reserved. 
 *
 *	Author: sunny
 *
 *	CreatedAt: 2016年8月15日
 *  
 *	Description: ...
 */
package com.jianan.software.common;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jianan.software.pojo.CrmAuthNavigation;
import com.jianan.software.pojo.CrmAuthResource;
import com.jianan.software.pojo.CrmAuthUserNav;
import com.jianan.software.pojo.CrmAuthUserResource;

@Repository("commonDao")
public class CommonDaoImpl implements ICommonDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<CrmAuthUserResource> getAllUserResources() {
		return sqlSession.selectList("com.lepu.hst.crm.web.common.getAllUserResources");
	}

	@Override
	public List<CrmAuthResource> getAllResources() {
		return sqlSession.selectList("com.lepu.hst.crm.web.common.getAllResources");
	}

	@Override
	public List<CrmAuthNavigation> getAllNavigations() {
		return sqlSession.selectList("com.lepu.hst.crm.web.common.getAllNavigations");
	}

	@Override
	public List<CrmAuthUserNav> getAllUserNavs() {
		return sqlSession.selectList("com.lepu.hst.crm.web.common.getAllUserNavs");
	}

	@Override
	public Integer getTopNavIdByResourceUri(String uri) {
		return sqlSession.selectOne("com.lepu.hst.crm.web.common.getTopNavIdByResourceUri", uri);
	}
}
