/**
 *	Copyright (C) 2014-2015 hst Software. All rights reserved. 
 *
 *	Author: sunny
 *
 *	CreatedAt: 2016年8月15日
 *  
 *	Description: ...
 */
package com.jianan.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.jianan.software.pojo.CrmAdminUser;

public class SessionManager {

	public static CrmAdminUser getUserSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("user_id");
		String userName = (String) session.getAttribute("user_name");
		
		if (userId == null || userId.isEmpty()) {
			return null;
		}
		CrmAdminUser user = new CrmAdminUser();
		user.setUserId(Integer.parseInt(userId));
		user.setUserName(userName);
		return user;
	}
	
	public static void writeUserSession(HttpServletRequest request, CrmAdminUser user) {
		HttpSession session = request.getSession();
		session.setAttribute("user_id", String.valueOf(user.getUserId()));
		session.setAttribute("user_name", user.getUserName());
	}

	/**
	 * @param request
	 */
	public static void removeUserSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("user_id", null);
		session.setAttribute("user_name", null);
	} 
}
