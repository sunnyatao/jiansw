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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.jianan.auth.SessionManager;
import com.jianan.software.pojo.CrmAdminUser;
import com.jianan.software.pojo.CrmAuthNavigation;
import com.jianan.software.pojo.CrmAuthResource;
import com.jianan.software.pojo.CrmAuthUserNav;
import com.jianan.software.pojo.CrmAuthUserResource;

@Service("commonService")
public class CommonServiceImpl implements ICommonService {
	
	@Autowired
	private ICommonDao commonDao;
	
	private Map<Integer, List<CrmAuthUserResource>> userId2userResource = null;
	
	private Map<Integer, Set<String>> userId2deleteUrls = null;	//用户拥有的删除的权限
	
	private Map<Integer, List<CrmAuthNavigation>> parentId2childNavs = null;
	
	private Map<Integer, List<CrmAuthUserNav>> userId2navs = null;
	
	private Map<String, CrmAuthResource> path2resource = null;
	
	private Map<Integer, List<CrmAuthNavigation>> resourceId2navs = null;
	
	private List<CrmAuthResource> resources = null;
	
	public void loadUserResource() {
		clear();
		loadUResource();
		loadNavigate();
		loadResource();
	}
	
	/**
	 * 
	 */
	private void clear() {
		if (userId2userResource != null) {
			userId2userResource.clear();
		}
		
		if (parentId2childNavs != null) {
			parentId2childNavs.clear();
		}
		
		if (userId2navs != null) {
			userId2navs.clear();
		}
		
		if (path2resource != null) {
			path2resource.clear();
		}
		
		if (resources != null) {
			resources.clear();
		}
		
		if (userId2deleteUrls != null) {
			userId2deleteUrls.clear();
		}
	}

	/**
	 * 加载用户资源
	 */
	private void loadUResource() {
		//根据用户资源表加载资源
		userId2userResource = new HashMap<>();
		userId2deleteUrls = new HashMap<>();
		
		List<CrmAuthUserResource> userResources = commonDao.getAllUserResources();
		for (CrmAuthUserResource userResource : userResources) {
			List<CrmAuthUserResource> currentUResources = userId2userResource.get(userResource.getUserId());
			if (currentUResources == null) {
				currentUResources = new ArrayList<>();
				userId2userResource.put(userResource.getUserId(), currentUResources);
			}
			currentUResources.add(userResource);
			
			CrmAuthResource authResource = userResource.getAuthResource();
			String resourcePath = authResource.getResourcePath();
			if (resourcePath.equals("/projectcheck/api/delete") || resourcePath.equals("/projectsettlement/api/delete") 
					|| resourcePath.equals("/projectouterube/api/delete") || resourcePath.equals("/housecontract/api/delete")
					|| resourcePath.equals("/summary/api/prints/delete")) {
				Set<String> userDeleteResourceUrls = userId2deleteUrls.get(userResource.getUserId());
				if (userDeleteResourceUrls == null) {
					userDeleteResourceUrls = new HashSet<String>();
					userDeleteResourceUrls.add(resourcePath);
					userId2deleteUrls.put(userResource.getUserId(), userDeleteResourceUrls);
				} else {
					userDeleteResourceUrls.add(resourcePath);
				}
			}
		}
	}
	
	/**
	 * 加载导航与用户导航
	 */
	private void loadNavigate() {
		parentId2childNavs = new HashMap<Integer, List<CrmAuthNavigation>>();
		List<CrmAuthNavigation> navigations = commonDao.getAllNavigations();
		for (CrmAuthNavigation navigation : navigations) {
			if (navigation.getParentId() != 0) {
				List<CrmAuthNavigation> childNavs = parentId2childNavs.get(navigation.getParentId());
				if (childNavs == null) {
					childNavs = new ArrayList<CrmAuthNavigation>();
					parentId2childNavs.put(navigation.getParentId(), childNavs);
				}
				childNavs.add(navigation);
			}
		}
		
		userId2navs = new HashMap<Integer, List<CrmAuthUserNav>>();
		List<CrmAuthUserNav> userNavs = commonDao.getAllUserNavs();
		for (CrmAuthUserNav userNav : userNavs) {
			List<CrmAuthUserNav> unavs = userId2navs.get(userNav.getUserId());
			if (unavs == null) {
				unavs = new ArrayList<CrmAuthUserNav>();
				userId2navs.put(userNav.getUserId(), unavs);
			}
			if (unavs.contains(userNav)) {
				continue;
			}
			unavs.add(userNav);
		}
		
		resourceId2navs = new HashMap<>();
		for (CrmAuthNavigation navigation : navigations) {
			List<CrmAuthNavigation> navs = resourceId2navs.get(navigation.getResourceId());
			if (navs == null) {
				navs = new ArrayList<>();
				resourceId2navs.put(navigation.getResourceId(), navs);
			}
			navs.add(navigation);
		}
	}

	private void loadResource() {
		path2resource = new HashMap<>();
		resources = commonDao.getAllResources();
		for (CrmAuthResource resource : resources) {
			path2resource.put(resource.getResourcePath(), resource);
		}
	}
	
	@Override
	public void fillCommonView(HttpServletRequest request, ModelAndView view) {
		CrmAdminUser adminUser = SessionManager.getUserSession(request);
		int userId = adminUser.getUserId();
		view.addObject("userName", adminUser.getUserName());
		String contextPath = request.getContextPath();
		
		view.addObject("navList", userId2navs.get(userId));
		
		String currentUri = request.getRequestURI().replace(contextPath, "").replace("\\\\", "\\");
		currentUri = request.getRequestURI().replace(contextPath, "").replace("//", "/");
		Integer currentTopNavId = commonDao.getTopNavIdByResourceUri(currentUri);
		if (currentTopNavId == null) {
			return;
		}
		
		List<CrmAuthNavigation> childNavs = parentId2childNavs.get(currentTopNavId);
		if (childNavs == null) {
			return;
		}
		
		List<CrmAuthUserResource> userResources = userId2userResource.get(userId);
		Map<Integer, CrmAuthUserResource> reouceId2userResource = new HashMap<>();
		for (CrmAuthUserResource userResource : userResources) {
			reouceId2userResource.put(userResource.getResourceId(), userResource);
		}
		
		List<Integer> relatedResourceIds = new ArrayList<>();
		CrmAuthResource currentResource = path2resource.get(currentUri);
		if (currentResource != null) {
			List<CrmAuthNavigation> authNavigations = resourceId2navs.get(currentResource.getResourceId());
			if (authNavigations != null) {
				for (CrmAuthNavigation authNavigation : authNavigations) {
					relatedResourceIds.add(authNavigation.getRelateResourceId());
				}
			}
		}
		
		List<CrmAuthNavigation> currentChildNavs = new ArrayList<>();
		for (CrmAuthNavigation childNav : childNavs) {
			childNav.setActive("");
			if (reouceId2userResource.get(childNav.getResourceId()) == null || childNav.getNavLevel() != CrmAuthNavigation.NAVLEVEL_SECOND) {
				continue;
			}
			
			if (currentChildNavs.contains(childNav)) {
				continue;
			}
			
			currentChildNavs.add(childNav);
			
			if(relatedResourceIds == null) {
				continue;
			}
			for(Integer relatedResourceId : relatedResourceIds) {
				if (childNav.getResourceId() == relatedResourceId) {
					childNav.setActive("active");
				}
			}
		}
		
		Set<String> userDeletePaths = userId2deleteUrls.get(userId);
		if (userDeletePaths != null && userDeletePaths.contains("/projectcheck/api/delete")) {
			view.addObject("delete_projectcheck", "y");
		} else {
			view.addObject("delete_projectcheck", "n");
		}
		
		if (userDeletePaths != null && userDeletePaths.contains("/projectsettlement/api/delete")) {
			view.addObject("delete_projectsettlement", "y");
		} else {
			view.addObject("delete_projectsettlement", "n");
		}
		
		if (userDeletePaths != null && userDeletePaths.contains("/projectouterube/api/delete")) {
			view.addObject("delete_projectouterube", "y");
		} else {
			view.addObject("delete_projectouterube", "n");
		}
		
		if (userDeletePaths != null && userDeletePaths.contains("/housecontract/api/delete")) {
			view.addObject("delete_housecontract", "y");
		} else {
			view.addObject("delete_housecontract", "n");
		}
		
		if (userDeletePaths != null && userDeletePaths.contains("/summary/api/prints/delete")) {
			view.addObject("delete_single_print", "y");
		} else {
			view.addObject("delete_single_print", "n");
		}
		
		view.addObject("childNavs", currentChildNavs);
	}

	@Override
	public CrmAuthResource getResourceBy(String path) {
		return path2resource.get(path);
	}

	@Override
	public List<CrmAuthUserResource> getUserResourcesBy(int userId) {
		return userId2userResource.get(userId);
	}

	@Override
	public List<CrmAuthResource> getResources() {
		return this.resources;
	}
}
