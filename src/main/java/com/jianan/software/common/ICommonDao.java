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

import com.jianan.software.pojo.CrmAuthNavigation;
import com.jianan.software.pojo.CrmAuthResource;
import com.jianan.software.pojo.CrmAuthUserNav;
import com.jianan.software.pojo.CrmAuthUserResource;

public interface ICommonDao {

	List<CrmAuthUserResource> getAllUserResources();
	
	List<CrmAuthResource> getAllResources();

	/**
	 * @return
	 */
	List<CrmAuthNavigation> getAllNavigations();

	/**
	 * @return
	 */
	List<CrmAuthUserNav> getAllUserNavs();

	/**
	 * @param currentUri
	 * @return
	 */
	Integer getTopNavIdByResourceUri(String currentUri);

}
