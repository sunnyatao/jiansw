/**
 *	Copyright (C) 2014-2015 hst Software. All rights reserved. 
 *
 *	Author: sunny
 *
 *	CreatedAt: 2016年8月15日
 *  
 *	Description: ...
 */
package com.jianan.admin.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.NoPermissionException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jianan.admin.service.IUserService;
import com.jianan.auth.SessionManager;
import com.jianan.resources.service.IResourceService;
import com.jianan.role.service.IRoleService;
import com.jianan.software.common.ICommonService;
import com.jianan.software.pojo.CrmAdminUser;
import com.jianan.software.pojo.CrmAuthResource;
import com.jianan.software.pojo.CrmAuthRole;
import com.jianan.software.pojo.CrmAuthUserResource;
import com.jianan.software.util.AccountUtil;
import com.jianan.software.util.Page;
import com.jianan.software.util.ResponseUtil;

@Controller
@RequestMapping("/crm/v1/admin")
public class UserManagerController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserManagerController.class);
	@Autowired
	private ICommonService commonService;
	@Autowired
	private IUserService userService;
	@Autowired
	private IRoleService  roleService;
	@Autowired
	private IResourceService resourceService;
	
	@RequestMapping("/user/list")
	public ModelAndView toUsers(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView view = new ModelAndView("/admin/admin_user_list");
		try{
			String pageIndex = request.getParameter("page") == null? "1" : request.getParameter("page");
	        String pageSize = request.getParameter("page_size") == null ? "20" : request.getParameter("page_size");
	        int userCount = userService.getUserCount();
	        Page page = new Page(userCount, Integer.parseInt(pageSize), Integer.parseInt(pageIndex));
			List<CrmAdminUser> userList = userService.getUserList(page);
			view.addObject("userList", userList);
			view.addObject("page", page);
			commonService.fillCommonView(request, view);	
			return view;
		}catch(Exception e){
			LOGGER.error(e.toString(),e);  
			return view;
		}
		
	}
	@RequestMapping("/getRoles") 
	public void getRoles(HttpServletRequest request,HttpServletResponse response) {
		try {
			List<CrmAuthRole>  crmAuthRoles = roleService.getRoles();//只获取roleName 和roleId.
			if(crmAuthRoles != null) {
				LOGGER.debug("角色获取成功");
			} else {
				LOGGER.error("角色获取失败");
			}
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("crmAuthRoles", crmAuthRoles);
			ResponseUtil.writeResponseSuccess(response,jsonObject);
		} catch(Exception e) {
			LOGGER.error(e.toString(),e);
			ResponseUtil.writeResponseFailure(response,e);
		}
		
	}
	@RequestMapping("/ajax/save")
	public void saveUser(HttpServletRequest request, HttpServletResponse response){
		try{
			String salt= String.valueOf((int) (Math.random()*(9999-1000+1)));
			String userName = request.getParameter("user_name");
			String password = request.getParameter("password");
			String actualPwd = AccountUtil.compilePassword(password,salt);
			int roleId = Integer.parseInt(request.getParameter("roleId"));
			CrmAdminUser adminUser = new CrmAdminUser();
			adminUser.setUserName(userName);
			adminUser.setPassword(actualPwd);
			adminUser.setSalt(salt);
			adminUser.setCreatedOn(new Date());
			adminUser.setLastLoginTime(new Date());
			adminUser.setStatus(1);
			int userId = userService.saveUser(adminUser);  //从数据库 中返回了userId.
			//创建人的名字
			CrmAdminUser user = SessionManager.getUserSession(request);
			String createUserName = user.getUserName();
			if(userId > 0) {
				//根据userId,roleId 插入到auth_user_role中，2 根据roleId 找到所有的resourceId，将roleId和所有的resourceId插入到auth_user_resource中，
				userService.insertIds(roleId,userId,createUserName);
				ResponseUtil.writeResponseSuccess(response);
			} else {
				ResponseUtil.writeResponseFailure(response);
			}
		} catch (Exception e) {
			LOGGER.error(e.toString(), e);
			ResponseUtil.writeResponseFailure(response);
		}
	}
	@RequestMapping("/ajax/editPassword")
	public void editPassword(HttpServletRequest request, HttpServletResponse response){
		try{
			String userId = request.getParameter("user_id");
			String salt = userService.getSaltByUserId(userId);
			String oldPassword = request.getParameter("old_password");
			String newPassword = request.getParameter("new_password");
			String oldActualPassword = AccountUtil.compilePassword(oldPassword,salt);
			String newActualPassword = AccountUtil.compilePassword(newPassword,salt);
			CrmAdminUser adminUser = new CrmAdminUser();
			adminUser.setUserId(Integer.valueOf(userId));
			adminUser.setSalt(salt);
			adminUser.setPassword(newActualPassword);
			userService.editPassword(adminUser,oldActualPassword);
			ResponseUtil.writeResponseSuccess(response);
		} catch (Exception e) {
			LOGGER.error(e.toString(), e);
			ResponseUtil.writeResponseFailure(response);
		}
	}
	
	@RequestMapping("/ajax/updatePassword") 
	public void updatePassword(HttpServletRequest request,HttpServletResponse response) {
		try {
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			String newPassword = request.getParameter("newPassword");
			CrmAdminUser adminUser = userService.getAdminUserByUserName(userName);
			String oldPassword = adminUser.getPassword();
			String salt = adminUser.getSalt();
			String oldActualPassword = AccountUtil.compilePassword(password,salt);
			String newActualPassword = AccountUtil.compilePassword(newPassword,salt);
			//进行比对，判断。
			if(!oldActualPassword.equals(oldPassword)) {
				String msgData = "errorPassword";
				ResponseUtil.writeResponseFailure(response,msgData);
			} else {
				CrmAdminUser newAdminUser = new CrmAdminUser();
				newAdminUser.setPassword(newActualPassword);
				newAdminUser.setUserName(userName);
				if(userService.updateAdminUser(newAdminUser)) {
					LOGGER.debug("密码更新成功");
					ResponseUtil.writeResponseSuccess(response);
				} else {
					LOGGER.error("密码更新失败");
					ResponseUtil.writeResponseFailure(response);
				}
			}
		} catch (Exception e) {
			LOGGER.error(e.toString(),e);
			ResponseUtil.writeResponseFailure(response);
		}
		
		
	}
	
	
	@RequestMapping("/ajax/changeUserStatus")
	public void changeUserStatus(HttpServletRequest request, HttpServletResponse response){
		try{
			String userId = request.getParameter("user_id");
			String status = request.getParameter("status");
			userService.changeUserStatus(userId,status);
			ResponseUtil.writeResponseSuccess(response);
		} catch (Exception e) {
			LOGGER.error(e.toString(), e);
			ResponseUtil.writeResponseFailure(response);
		}
	}
	
	@RequestMapping("/ajax/dispatchNavigation")
	public void dispatchNavigation(HttpServletRequest request, HttpServletResponse response){
		try{
			String userId = request.getParameter("user_id");
			String newList = request.getParameter("navIds");
			String[] ids = newList.split(",");
			userService.dispatchNavigation(userId,ids);
			ResponseUtil.writeResponseSuccess(response);
		} catch (Exception e) {
			LOGGER.error(e.toString(), e);
			ResponseUtil.writeResponseFailure(response);
		}
	}
	
	@RequestMapping("/user/resource/list")
	public ModelAndView toUserResource(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("/admin/user_resources");
		commonService.fillCommonView(request, view);
		
		int userId = Integer.parseInt(request.getParameter("user_id"));
		CrmAdminUser user = userService.getUserBy(userId);
		
		Map<Integer, List<CrmAuthResource>> type2resources = new HashMap<Integer, List<CrmAuthResource>>();
		List<CrmAuthResource> allResource = commonService.getResources();
		for (CrmAuthResource resource : allResource) {
			List<CrmAuthResource> tResources = type2resources.get(resource.getResourceType());
			if (tResources == null) {
				tResources = new ArrayList<>();
				type2resources.put(resource.getResourceType(), tResources);
			}
			tResources.add(resource);
		}
		
		List<CrmAuthUserResource> userResources = commonService.getUserResourcesBy(userId);
		List<Integer> userResourceIds = new ArrayList<>();
		if (userResources != null) {
			for (CrmAuthUserResource userResource : userResources) {
				userResourceIds.add(userResource.getResourceId());
			}
		}
		
		view.addObject("user", user);
		view.addObject("user_resource_ids", userResourceIds);
		view.addObject("member_resources", type2resources.get(CrmAuthResource.RESOURCETYPE_MEMBER));
		view.addObject("auth_resources", type2resources.get(CrmAuthResource.RESOURCETYPE_AUTH));
		view.addObject("marketing_resources", type2resources.get(CrmAuthResource.RESOURCETYPE_MARKETING));
		return view;
	}
	
	@RequestMapping("/ajax/user_resource/set")
	public void setUserResources(HttpServletRequest request, HttpServletResponse response) {
		try {
			
			CrmAdminUser currentUser = SessionManager.getUserSession(request);
			
			int userId = Integer.parseInt(request.getParameter("user_id"));
			if (userId == currentUser.getUserId() && !"superAdmin".equals(currentUser.getUserName())) {
				throw new NoPermissionException("请勿修改自己的权限!");
			}
			
			String[] resourceIds = request.getParameter("resource_ids").split(",");
			
			CrmAdminUser user = SessionManager.getUserSession(request);
			List<Integer> rIds = new ArrayList<>();
			for (String resourceId : resourceIds) {
				if (!resourceId.isEmpty()) {
					rIds.add(Integer.parseInt(resourceId));
				}
			}
			
			resourceService.setUserResources(userId, rIds, user.getUserName());
			ResponseUtil.writeResponseSuccess(response);
		} catch (Exception e) {
			LOGGER.error(e.toString(), e);
			ResponseUtil.writeResponseFailure(response);
		}
	}
	
	@RequestMapping("/updateUserInfo")
	public ModelAndView updateUserInfo(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/admin/personal");
		String userName = request.getParameter("userName");
		mav.addObject("userName", userName);
		commonService.fillCommonView(request, mav);
		return mav;
	}
}
