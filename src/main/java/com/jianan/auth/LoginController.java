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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jianan.auth.service.IAuthService;
import com.jianan.software.pojo.CrmAdminUser;
import com.jianan.software.util.ResponseUtil;

@RequestMapping("/crm/v1/auth")
@Controller
public class LoginController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private IAuthService authService;
	
	@RequestMapping("/to_login")
	public ModelAndView toLogin(HttpServletRequest request, HttpServletResponse response){
		ModelAndView view = new ModelAndView("/admin/login");
		String targetUrl = request.getParameter("target_url");
		view.addObject("target_url", targetUrl);
		return view;
	}
	
	@RequestMapping("/ajax/login")
	public void login(HttpServletRequest request, HttpServletResponse response) {
		try {
			String userName = request.getParameter("user_name");
			String password = request.getParameter("password");
			
			CrmAdminUser adminUser = authService.login(userName, password);
			SessionManager.writeUserSession(request, adminUser);
			
			ResponseUtil.writeResponseSuccess(response);
		} catch (Exception e) {
			LOGGER.error(e.toString(), e);
			ResponseUtil.writeResponseFailure(response, e);
		} 
		
	}
	
	@RequestMapping("/ajax/logout")
	public void logout(HttpServletRequest request, HttpServletResponse response) {
		try {
			SessionManager.removeUserSession(request);
			ResponseUtil.writeResponseSuccess(response);
		} catch (Exception e) {
			LOGGER.error(e.toString(), e);
			ResponseUtil.writeResponseFailure(response, e);
		} 
	}
}
