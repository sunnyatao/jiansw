/**
 *	Copyright (C) 2014-2015 hst Software. All rights reserved. 
 *
 *	Author: sunny
 *
 *	CreatedAt: 2016年8月17日
 *  
 *	Description: ...
 */
package com.jianan.software.common;

import javax.naming.NoPermissionException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jianan.software.util.ResponseUtil;

@Controller
@RequestMapping("/crm/v1/common")
public class CommonController {
	
	private static Logger LOGGER = LoggerFactory.getLogger(CommonController.class);
	
	@Autowired
	private ICommonService commonService;
	
	@RequestMapping("/permission/error")
	public ModelAndView permissionError(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("/permission_error");
		commonService.fillCommonView(request, view);
		
		return view;
	}
	
	@RequestMapping("/permission/ajax/error")
	public void ajaxPermissionError(HttpServletRequest request, HttpServletResponse response) {
		try {
			throw new NoPermissionException();
		} catch (Exception e) {
			LOGGER.error(e.toString(), e);
			ResponseUtil.writeResponseFailure(response, e);
		}
	}
}
