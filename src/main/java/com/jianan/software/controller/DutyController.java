package com.jianan.software.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jianan.software.common.ICommonService;
import com.jianan.software.pojo.BureauLeader;
import com.jianan.software.pojo.DutyUser;
import com.jianan.software.service.IDutyManagerService;
import com.jianan.software.util.ResponseUtil;

@RequestMapping("/duty")
@Controller
public class DutyController {
	
	@Autowired
	private IDutyManagerService dutyManagerService;
	
	@Autowired
	ICommonService commomService;

	@RequestMapping("/list/")
	public ModelAndView listDuty(HttpServletRequest request, HttpServletResponse response) {
		List<BureauLeader> bureauLeaders = dutyManagerService.getBureauLeaders();
		List<DutyUser> dutyUsers = dutyManagerService.getDutyUsers();
		
		ModelAndView view = new ModelAndView("/lead_list");
		view.addObject("bureauLeaders", bureauLeaders);
		view.addObject("dutyUsers", dutyUsers);
		
		commomService.fillCommonView(request, view);
		return view;
	}
	
	@RequestMapping("/api/submit")
	public void submitAddDuty(HttpServletRequest request, HttpServletResponse response) {
		try {
			String username = request.getParameter("name");
			int type = Integer.parseInt(request.getParameter("type"));
			if (type == 0) {
				BureauLeader leader = new BureauLeader();
				leader.setName(username);
				dutyManagerService.insertBureauLeader(leader);
			} else if (type == 1) {
				DutyUser dutyUser = new DutyUser();
				dutyUser.setName(username);
				dutyManagerService.insertDutyUser(dutyUser);
			}
			ResponseUtil.writeResponseSuccess(response);
		} catch (Exception e) {
			e.printStackTrace();
			ResponseUtil.writeResponseFailure(response);
		}
		return ;
	}
	
	@RequestMapping("/api/delete")
	public void deleteDuty(HttpServletRequest request, HttpServletResponse response) {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			int type = Integer.parseInt(request.getParameter("type"));
			if (type == 0) {
				dutyManagerService.deleteBureauLeader(id);
			} else if (type == 1) {
				dutyManagerService.deleteDutyUser(id);
			}
			ResponseUtil.writeResponseSuccess(response);
		} catch (Exception e) {
			e.printStackTrace();
			ResponseUtil.writeResponseFailure(response);
		}
	}
}
