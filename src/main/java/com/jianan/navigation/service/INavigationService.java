/**
 * 
 */
package com.jianan.navigation.service;

import java.util.List;

import com.jianan.software.pojo.CrmAuthNavigation;


/**
 * @author haiywang
 *
 */
public interface INavigationService {

	List<CrmAuthNavigation> getNavigationList();

	void saveFirstNavigation(CrmAuthNavigation nav);

	List<CrmAuthNavigation> getNavListByParentId(String parentId);

	void deleteNavById(String navId);

	void editNavigation(int navId, String navName, int resourceId);

	


}
