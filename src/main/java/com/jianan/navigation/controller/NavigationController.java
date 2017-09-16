/**
 * 
 */
package com.jianan.navigation.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jianan.navigation.service.INavigationService;
import com.jianan.resources.service.IResourceService;
import com.jianan.software.common.ICommonService;
import com.jianan.software.pojo.CrmAuthNavigation;
import com.jianan.software.util.ResponseUtil;

/**
 * @author haiywang
 *
 */
@Controller
@RequestMapping("/crm/v1/navigation")
public class NavigationController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(NavigationController.class);
	@Autowired
	private INavigationService navigationService;
	@Autowired
	private ICommonService commonService;
	@Autowired
	private IResourceService resourceService;
	
	@RequestMapping("/ajax/navigation/list")
	public void getNavigationList(HttpServletRequest request,HttpServletResponse response){
		try {
			List<CrmAuthNavigation> navigations = navigationService.getNavigationList();
			JSONObject msgData = new JSONObject();
			msgData.put("navigations", navigations);		
			ResponseUtil.writeResponseSuccess(response, msgData);
		} catch (Exception e) {
			LOGGER.error(e.toString(), e);
		}
	}
	@RequestMapping("/list")
	public ModelAndView getNavigationsList(HttpServletRequest request,HttpServletResponse response){
		ModelAndView view = new ModelAndView("/admin/navigation_list");
		try{
			List<CrmAuthNavigation> navigationList = navigationService.getNavigationList();
			view.addObject("navigationList", navigationList);
			commonService.fillCommonView(request, view);	
			return view;
		}catch(Exception e){
			LOGGER.error(e.toString(),e);  
			return view;
		}
	}
	@RequestMapping("/ajax/save")
	public void saveFirstNavigation(HttpServletRequest request,HttpServletResponse response){
		try {
			String navName = request.getParameter("nav_name");
			String parentId = request.getParameter("parent_id");
			String navLevel = request.getParameter("navLevel");
		    int resourceId = Integer.valueOf(request.getParameter("resource_id"));
		    CrmAuthNavigation nav = new CrmAuthNavigation();
		    nav.setNavName(navName);
		    nav.setResourceId(resourceId);
		    if(parentId==""){
		    	nav.setParentId(0);
		    }else{
		    	nav.setParentId(Integer.valueOf(parentId));
		    }
		    if(navLevel==""){
		    	nav.setNavLevel(1);
		    }else{
		    	nav.setNavLevel(Integer.valueOf(navLevel));
		    }
		    nav.setCreatedOn(new Date());
			navigationService.saveFirstNavigation(nav);
			ResponseUtil.writeResponseSuccess(response);
		} catch (Exception e) {
			LOGGER.error(e.toString(), e);
		}
	}
	@RequestMapping("/ajax/edit")
	public void editNavigation(HttpServletRequest request,HttpServletResponse response){
		try {
			String navName = request.getParameter("nav_name");
			int navId = Integer.valueOf(request.getParameter("nav_id"));
		    int resourceId = Integer.valueOf(request.getParameter("resource_id"));
			navigationService.editNavigation(navId,navName,resourceId);
			ResponseUtil.writeResponseSuccess(response);
		} catch (Exception e) {
			LOGGER.error(e.toString(), e);
		}
	}
	@RequestMapping("/ajax/getNavListByParentId")
	public void getNavListByParentId(HttpServletRequest request,HttpServletResponse response){
		try {
			String parentId = request.getParameter("parent_id");
			List<CrmAuthNavigation> navList = navigationService.getNavListByParentId(parentId);
			JSONObject msgData = new JSONObject();
			msgData.put("navList", navList);		
			ResponseUtil.writeResponseSuccess(response, msgData);
		} catch (Exception e) {
			LOGGER.error(e.toString(), e);
		}
	}
	@RequestMapping("/ajax/deleteNav")
	public void deleteNavById(HttpServletRequest request,HttpServletResponse response){
		try {
			String navId = request.getParameter("nav_id");
			navigationService.deleteNavById(navId);
			ResponseUtil.writeResponseSuccess(response);
		} catch (Exception e) {
			LOGGER.error(e.toString(), e);
		}
	}
}
