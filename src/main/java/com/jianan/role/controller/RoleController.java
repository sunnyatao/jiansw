/**
 * 
 */
package com.jianan.role.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jianan.auth.SessionManager;
import com.jianan.role.service.IRoleService;
import com.jianan.software.common.ICommonService;
import com.jianan.software.pojo.CrmAdminUser;
import com.jianan.software.pojo.CrmAuthResource;
import com.jianan.software.pojo.CrmAuthRole;
import com.jianan.software.pojo.CrmauthRoleResource;
import com.jianan.software.util.ResponseUtil;
/**
 * @author weiwzhou
 *
 */
@RequestMapping("/crm/v1/role")
@Controller
public class RoleController {
	
	private static Logger LOGGER = LoggerFactory.getLogger(RoleController.class);
	@Autowired
	private IRoleService roleService;
	@Autowired
	private ICommonService commonService;
	
	@RequestMapping("/admin/toRoleRoute")   //在前端的展示
	public ModelAndView toRoleView(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/admin/role_list");
		List<CrmAuthRole> authRoles = roleService.getRoles();
		mav.addObject("authRoles",authRoles);
		commonService.fillCommonView(request, mav);
		return mav;
	}
	
	@RequestMapping("/ajax/deleteRole")   //删除某一个角色
	public void deleteRole(HttpServletRequest request,HttpServletResponse response) {
		try {
			int roleId = Integer.parseInt(request.getParameter("roleId"));
			if(roleService.deleteRole(roleId)) {
				LOGGER.debug("在auth_role中的role_id"+roleId+"的值已经删除成功");
				ResponseUtil.writeResponseSuccess(response);
			} else {
				LOGGER.error("在auth_role中的role_id"+roleId+"的值删除失败");
				ResponseUtil.writeResponseFailure(response);
			}
		}catch (Exception e) {
			LOGGER.error(e.toString(),e);
			ResponseUtil.writeResponseFailure(response,e);
		}
	}
	
	@RequestMapping("/ajax/getRoles")   //从后台将role相关的东西发送到前端，进行显示   这里可以进行重复使用，更新和插入
	public void getRoles(HttpServletRequest request,HttpServletResponse response) {
		int roleId = Integer.parseInt(request.getParameter("roleId"));
		try{
			//进行更新操作,在前端通过resourceId进行判断选中的对象
			JSONObject jsonObject = new JSONObject();
			if(roleId > 0) {  //进行更新时
				CrmAuthRole crmAuthRole = roleService.getRoleBy(roleId);
				jsonObject.put("crmAuthRole",crmAuthRole);
			}
			List<CrmAuthResource> crmAuthResources = commonService.getResources();
			jsonObject.put("crmAuthResources",crmAuthResources);
			ResponseUtil.writeResponseSuccess(response, jsonObject);
		}catch(Exception e) {
			LOGGER.error(e.toString());
			ResponseUtil.writeResponseFailure(response,e);
		}
	}
	
	@RequestMapping("/ajax/updateOrInsert") //这里进行的是进行角色的添加和更新。这个函数进行的是从前端向后台发送数据。
	public void updateOrInsert(HttpServletRequest request,HttpServletResponse response) {
		//根据roleId进行判断是进行添加还是进行更新操作
		try {
			int roleId = Integer.parseInt(request.getParameter("roleId"));
			String roleName = request.getParameter("roleName");
			String description = request.getParameter("description");
			String arrResource = request.getParameter("arrResource");
			CrmAdminUser user = SessionManager.getUserSession(request);
			String userName = user.getUserName();
			JSONArray jsonArray = new JSONArray(arrResource);
			int size = jsonArray.length();
			List<CrmauthRoleResource> carrList = new ArrayList<>();
			if(roleId == 0) { //进行添加
				CrmAuthRole car = new CrmAuthRole();
				car.setRoleName(roleName);
				car.setDescription(description);
				car.setCreatedOn(new Date());
				car.setCreatedBy(userName);
				if(roleService.insertRole(car)) {
					roleId = car.getRoleId();
				}
			    for(int i = 0; i < size; i++) {
			    	CrmauthRoleResource carr = new CrmauthRoleResource();
			    	carr.setResourceId(jsonArray.getInt(i));
			    	carr.setRoleId(roleId);
			    	carr.setCreatedOn(new Date());
			    	carr.setCreatedBy(userName);
			    	carrList.add(carr);
			    }
			    roleService.insertRoleResource(carrList);
			}else {
				CrmAuthRole car = new CrmAuthRole();
				car.setRoleId(roleId);
				car.setRoleName(roleName);
				car.setDescription(description);
				car.setCreatedOn(new Date());
				car.setCreatedBy(userName);
				
			    for(int i = 0;i < size;i++) {
			    	CrmauthRoleResource carr = new CrmauthRoleResource();
			    	carr.setResourceId(Integer.parseInt(jsonArray.getString(i)));
			    	carr.setRoleId(roleId);
			    	carr.setCreatedOn(new Date());
			    	carr.setCreatedBy(userName);
			    	carrList.add(carr);
			    }
			    roleService.updateRole(car, carrList);
			}
			ResponseUtil.writeResponseSuccess(response);
		}catch (Exception e) {
			LOGGER.error(e.toString(),e);
			ResponseUtil.writeResponseFailure(response);
		}
	}
}

