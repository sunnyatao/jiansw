/**
 * 
 */
package com.jianan.navigation.dao;

import java.util.List;

import com.jianan.software.pojo.CrmAuthNavigation;

/**
 * @author haiywang
 *
 */
public interface INavigationDao {


	List<CrmAuthNavigation> getNavigationList();

	void saveFirstNavigation(CrmAuthNavigation nav);

	List<CrmAuthNavigation> getNavListByParentId(String parentId);

	void deleteNavById(String navId);

	void editNavigation(int navId, String navName, int resourceId);

}
