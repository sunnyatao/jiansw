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

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.jianan.software.pojo.CrmAuthResource;
import com.jianan.software.pojo.CrmAuthUserResource;

public interface ICommonService {

	void fillCommonView(HttpServletRequest request, ModelAndView view);
	
	CrmAuthResource getResourceBy(String path);
	
	List<CrmAuthUserResource> getUserResourcesBy(int userId);
	
	List<CrmAuthResource> getResources();
}
