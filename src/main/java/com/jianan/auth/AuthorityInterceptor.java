/**
 *	Copyright (C) 2014-2015 hst Software. All rights reserved. 
 *
 *	Author: sunny
 *
 *	CreatedAt: 2016年8月12日
 *  
 *	Description: ...
 */
package com.jianan.auth;

import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.jianan.software.common.ICommonService;
import com.jianan.software.pojo.CrmAdminUser;
import com.jianan.software.pojo.CrmAuthResource;
import com.jianan.software.pojo.CrmAuthUserResource;
import com.jianan.software.util.DateUtil;

public class AuthorityInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthorityInterceptor.class);
	
	
	@Autowired
	private ICommonService commonService;
	
	public AuthorityInterceptor() {
		
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String contextPath = request.getContextPath();
		String uri = request.getRequestURI();
		if (uri.startsWith(contextPath + "/crm/v1/auth/to_login") || uri.startsWith(contextPath + "/crm/v1/auth/ajax/login") || uri.startsWith(contextPath + "/crm/v1/admin/updateUserInfo")) {
			return true;
		}
		
		CrmAdminUser user = SessionManager.getUserSession(request);
		if (user == null) {
			Map<String, String[]> name2values = request.getParameterMap();
			StringBuilder paramBuilder = new StringBuilder();
			for (Map.Entry<String, String[]> entry : name2values.entrySet()) {
				String key = entry.getKey();
				String value = entry.getValue()[0];
				paramBuilder.append(key).append("=").append(value).append("&");
			}
			if (paramBuilder.length() > 0) {
				paramBuilder.deleteCharAt(paramBuilder.length() - 1);
			}
			uri = URLEncoder.encode(uri + "?" + paramBuilder.toString(), "utf-8");
			response.sendRedirect(contextPath + "/crm/v1/auth/to_login?target_url="+uri);
			return false;
		}
		
		Date currentDate = new Date();
		Date targetDate = DateUtil.parseDate("2030-06-17 00:00:00");
		if (currentDate.after(targetDate)) {
			return false;
		}
		
		String currentUri = request.getRequestURI().replace(contextPath, "").replace("\\\\", "\\");
		currentUri = request.getRequestURI().replace(contextPath, "").replace("//", "/");
		CrmAuthResource resource = commonService.getResourceBy(currentUri);
		if (resource == null) {	//路径如果没有加入到资源表, 择不受权限控制
			return true;
		}
		List<CrmAuthUserResource> userResources = commonService.getUserResourcesBy(user.getUserId());
		if (userResources == null) {
			response.sendRedirect(contextPath + "/crm/v1/common/permission/error");
			return false;
		}
		boolean hasPermission = false;
		for (CrmAuthUserResource userResource : userResources) {
			if (currentUri.equals(userResource.getAuthResource().getResourcePath())) {
				hasPermission = true;
				break;
			}
		}
		if (hasPermission) {
			return true;
		} else {
			if (currentUri.contains("/ajax/")) {
				response.sendRedirect(contextPath + "/crm/v1/common/permission/ajax/error");
			} else {
				response.sendRedirect(contextPath + "/crm/v1/common/permission/error");
			}
			return false;
		}
	}

}
