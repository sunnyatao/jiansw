/**
 * 
 */
package com.jianan.navigation.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jianan.navigation.dao.INavigationDao;
import com.jianan.navigation.service.INavigationService;
import com.jianan.software.pojo.CrmAuthNavigation;

/**
 * @author haiywang
 *
 */
@Service("navigationService")
public class NavigationServiceImpl implements INavigationService{
	
	@Autowired
	private INavigationDao navigationDao;

	@Override
	public List<CrmAuthNavigation> getNavigationList() {
		
		return navigationDao.getNavigationList();
	}
	@Override
	public void saveFirstNavigation(CrmAuthNavigation nav) {
		navigationDao.saveFirstNavigation(nav);
		
	}
	
	@Override
	public List<CrmAuthNavigation> getNavListByParentId(String parentId) {
		
		return navigationDao.getNavListByParentId(parentId);
	}
	@Override
	public void deleteNavById(String navId) {
		
		navigationDao.deleteNavById(navId);
	}
	
	@Override
	public void editNavigation(int navId, String navName, int resourceId) {
		navigationDao.editNavigation(navId,navName,resourceId);
		
	}
}
