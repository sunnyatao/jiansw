package com.jianan.software.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jianan.auth.SessionManager;
import com.jianan.software.common.ICommonService;
import com.jianan.software.exception.ServerBaseException;
import com.jianan.software.pojo.CrmAdminUser;
import com.jianan.software.pojo.DutyUser;
import com.jianan.software.pojo.ProjectCheck;
import com.jianan.software.pojo.ProjectCheckFile;
import com.jianan.software.pojo.ProjectCheckInvoiceInfo;
import com.jianan.software.service.IDutyManagerService;
import com.jianan.software.service.IProjectCheckService;
import com.jianan.software.service.ISummaryService;
import com.jianan.software.util.DataUtil;
import com.jianan.software.util.DateUtil;
import com.jianan.software.util.Page;
import com.jianan.software.util.ResponseUtil;
import com.jianan.software.util.SerialUtil;

@Controller
@RequestMapping("/projectcheck")
public class ProjectCheckController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectCheckController.class);
	
	@Autowired
	ICommonService commomService;
	
	@Autowired
	private IProjectCheckService projectCheckService;
	
	@Autowired
	private IDutyManagerService dutyManagerService;
	
	@RequestMapping("/api/taxserialno/save")
	public void saveTaxSerialNo(HttpServletRequest request, HttpServletResponse response) {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			String serialNo = request.getParameter("serial_no");
			projectCheckService.updateTaxSerialNo(id, serialNo);
			ResponseUtil.writeResponseSuccess(response);
		} catch (Exception e) {
			LOGGER.error(e.toString(), e);
			ResponseUtil.writeResponseSuccess(response);
		}
	}
	
	@RequestMapping("/api/delete")
	public void delete(HttpServletRequest request, HttpServletResponse response) {
		try {
			String serialNum = request.getParameter("serial_num");
			projectCheckService.delete(serialNum);
			ResponseUtil.writeResponseSuccess(response);
		} catch (Exception e){
			LOGGER.error(e.toString(), e);
			ResponseUtil.writeResponseFailure(response);
		}
	}
	
	@RequestMapping("/username/get")
	public void getUsername(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String uname = request.getParameter("uname");
		String gender = request.getParameter("gender");
		JSONObject msgData = new JSONObject();
		msgData.put("uname", uname);
		msgData.put("gender", gender);
		ResponseUtil.writeResponseSuccess(response, msgData);
	}
	
	@RequestMapping("/api/get_by/identifynum")
	public void getProjectCheckByTaxpayerIdentifyNum(HttpServletRequest request, HttpServletResponse response) {
		try {
			String taxpayerIdentifyNum = request.getParameter("taxpayer_identify_num");
			
			ProjectCheck check = projectCheckService.getProjectCheckByIdentifyNo(taxpayerIdentifyNum);
			JSONObject msgData = new JSONObject();
			msgData.put("taxpayer_name", check.getTaxpayerName());
			msgData.put("contacts_phone", check.getContactsPhone());
			msgData.put("pay_tax_user", check.getPayTaxUser());
			ResponseUtil.writeResponseSuccess(response, msgData);
		} catch (Exception e) {
			LOGGER.error(e.toString(), e);
			ResponseUtil.writeResponseFailure(response);
		}
	}

	@RequestMapping("/api/get_by/projectname")
	public void getProjectCheckByProjectname(HttpServletRequest request, HttpServletResponse response) {
		try {
			String projectname = request.getParameter("project_name");
			
			ProjectCheck check = projectCheckService.getProjectCheckByProjectname(projectname);
			JSONObject msgData = new JSONObject();
			msgData.put("taxpayer_identify_num", check.getTaxpayerIdentifyNum());
			msgData.put("taxpayer_name", check.getTaxpayerName());
			msgData.put("project_constructor", check.getProjectConstructor());
			msgData.put("constructor_identify_num", check.getConstructorIdentifyNum());
			msgData.put("project_total_cost", check.getProjectTotalCost());
			msgData.put("income_affiliation", check.getIncomeAffiliation());
			msgData.put("is_down", check.getIsDown());
			msgData.put("contacts_phone", check.getContactsPhone());
			msgData.put("pay_tax_user", check.getPayTaxUser());
			ResponseUtil.writeResponseSuccess(response, msgData);
		} catch (Exception e) {
			LOGGER.error(e.toString(), e);
			ResponseUtil.writeResponseFailure(response);
		}
	}
	
	@RequestMapping("/toadd")
	public ModelAndView toAddCheckProject(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("/add_check_project");
		
		//String nextSerialNo = projectCheckService.getNextSerialNo();
		view.addObject("nextSerialNo", "");
		
		CrmAdminUser user = SessionManager.getUserSession(request);
		view.addObject("operatorName", user.getUserName());
		
		List<DutyUser> dutyUsers = dutyManagerService.getDutyUsers();
		view.addObject("dutyUsers", dutyUsers);
		
		commomService.fillCommonView(request, view);
		return view;
	}
	
	@RequestMapping("/submit")
	public ModelAndView submitCheckProject(HttpServletRequest request, HttpServletResponse response) {
		ProjectCheck projectCheck = buildProjectCheck(request);
		String nextSerialNo = projectCheckService.getNextSerialNo();
		projectCheck.setSerialNum(nextSerialNo);
		projectCheckService.createProjectCheck(projectCheck);
		String nextType = request.getParameter("submit_next_type");
		ModelAndView view = null;
		if ("0".equals(nextType)) {
			view = new ModelAndView("redirect:/projectcheck/toview");
		} else if ("1".equals(nextType)) {
			view = new ModelAndView("redirect:/projectcheck/toprint");
		} else if ("2".equals(nextType)) {
			view = new ModelAndView("redirect:/projectcheck/toadd");
		}
		view.addObject("serial_num", projectCheck.getSerialNum());
		
		commomService.fillCommonView(request, view);
		return view;
	}
	
	@RequestMapping("/api/submit")
	public void ajaxSubmitCheckProject(HttpServletRequest request, HttpServletResponse response) {
		try {
			ProjectCheck projectCheck = buildProjectCheck(request);
			String nextSerialNo = projectCheckService.getNextSerialNo();
			projectCheck.setSerialNum(nextSerialNo);
			projectCheckService.createProjectCheck(projectCheck);
			JSONObject msgData = new JSONObject();
			msgData.put("id", projectCheck.getId());
			ResponseUtil.writeResponseSuccess(response, msgData);
		} catch (Exception e){
			LOGGER.error(e.toString(), e);
			ResponseUtil.writeResponseFailure(response);
		}
	}
	
	@RequestMapping("/api/update")
	public void ajaxUpdateCheckProject(HttpServletRequest request, HttpServletResponse response) {
		try {
			ProjectCheck projectCheck = buildProjectCheck(request);
			projectCheckService.updateProjectCheck(projectCheck);
			ResponseUtil.writeResponseSuccess(response);
		} catch (ServerBaseException se) {
			LOGGER.error(se.toString(), se);
			ResponseUtil.writeResponseFailure(response, se);
		} catch (Exception e) {
			LOGGER.error(e.toString(), e);
			ResponseUtil.writeResponseFailure(response, e);
		}
	}
	
	@RequestMapping("/viewfile")
	public ModelAndView viewFiles(HttpServletRequest request, HttpServletResponse response) {
		String serialNum = request.getParameter("serial_num");
		ProjectCheck check = projectCheckService.getProjectCheckBySerialNo(serialNum);
		List<ProjectCheckFile> checkFiles = check.getCheckFiles();
		
		ModelAndView view = new ModelAndView("/scanfile");
		view.addObject("checkFiles", checkFiles);
		return view;
	}

	@RequestMapping("/viewinvoicefile")
	public ModelAndView viewinvoicefile(HttpServletRequest request, HttpServletResponse response) {
		String serialNum = request.getParameter("serial_num");
		ProjectCheck check = projectCheckService.getProjectCheckBySerialNo(serialNum);
		List<ProjectCheckFile> checkFiles = projectCheckService.getInvoiceFiles(check.getInvoiceInfo().getId());
		
		ModelAndView view = new ModelAndView("/scanfile");
		view.addObject("checkFiles", checkFiles);
		return view;
	}
	
	
	
	@RequestMapping("/toview")
	public ModelAndView toViewProjectCheck(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		String isEdit = request.getParameter("is_edit") == null?"0":request.getParameter("is_edit");
		if ("1".equals(isEdit)) {
			view = new ModelAndView("/project_check_edit");
		} else {
			view = new ModelAndView("/project_check_view");
		}
		
		String serialNum = request.getParameter("serial_num");
		if (serialNum == null) {
			serialNum = (String) request.getAttribute("serial_num");
		}
		
		ProjectCheck check = projectCheckService.getProjectCheckBySerialNo(serialNum);
		view.addObject("projectCheck", check);
		
		List<DutyUser> dutyUsers = dutyManagerService.getDutyUsers();
		view.addObject("dutyUsers", dutyUsers);
		
		commomService.fillCommonView(request, view);
		return view;
	}
	
	@RequestMapping("/list")
	public ModelAndView listProjectCheck(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("/projectcheck_list");
		
		String taxpayerName = request.getParameter("taxpayer_name");
		
		String pageIndex = request.getParameter("page") == null? "1" : request.getParameter("page");
        String pageSize = request.getParameter("page_size") == null ? "15" : request.getParameter("page_size");
        int userCount = projectCheckService.getProjectCheckCount(taxpayerName);
        Page page = new Page(userCount, Integer.parseInt(pageSize), Integer.parseInt(pageIndex));
		
		List<ProjectCheck> projectChecks = projectCheckService.getProjectChecks(page, taxpayerName);
		view.addObject("projectChecks", projectChecks);
		view.addObject("page", page);
		view.addObject("taxpayerName", taxpayerName == null?"":taxpayerName);
		commomService.fillCommonView(request, view);
		return view;
	}
	
	@RequestMapping("/taxinfo/toadd")
	public ModelAndView toAddTaxInfo(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("/project_check_add_taxinfo");
		String serialNum = request.getParameter("serial_num");
		if (serialNum == null) {
			serialNum = (String) request.getAttribute("serial_num");
		}
		
		ProjectCheck check = projectCheckService.getProjectCheckBySerialNo(serialNum);
		ProjectCheckInvoiceInfo invoiceInfo = projectCheckService.getProjectCheckInvoiceInfoById(check.getId());
		if (invoiceInfo == null) {
			view.addObject("containsInvoiceInfo", "0");
		} else {
			view.addObject("containsInvoiceInfo", "1");
			view.addObject("invoiceInfo", invoiceInfo);
		}
		view.addObject("projectCheck", check);
		
		view.addObject("today", DateUtil.getTodayStr());
		
		commomService.fillCommonView(request, view);
		return view;
	}
	
	@RequestMapping("/taxinfo/submit")
	public ModelAndView submitTaxInfo(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("redirect:/projectcheck/list");
		
		try {
			int infoId = Integer.parseInt(request.getParameter("invoice_info_id"));
			if (infoId == -1) {
				ProjectCheckInvoiceInfo projectCheckInvoiceInfo = buildProjectCheckInvoiceInfo(request);
				String serialNum = request.getParameter("serial_num");
				ProjectCheck check = projectCheckService.getProjectCheckBySerialNo(serialNum);
				projectCheckInvoiceInfo.setProjectCheckId(check.getId());
				projectCheckService.createProjectCheckInvoiceInfo(projectCheckInvoiceInfo);
				
				String checkStampDutyRate = request.getParameter("check_stamp_duty_rate");
				String checkLaborUnion = request.getParameter("check_labor_union");
				String checkWaterConstruct = request.getParameter("check_water_construct");
				
				boolean needUpdate = false;
				if (checkStampDutyRate == null) {
					check.setStampDutyRate(0);
					check.setStampDutyAmount(0);
					needUpdate = true;
				}
				
				if (checkLaborUnion == null) {
					check.setLaborUnionAmount(0);
					needUpdate = true;
				}
				
				if (checkWaterConstruct == null) {
					check.setWaterConstructAmount(0);
					needUpdate = true;
				}
				
				if (needUpdate) {
					projectCheckService.updateProjectCheck(check);
				}
			} else {
				ProjectCheckInvoiceInfo invoiceInfo = buildProjectCheckInvoiceInfo(request);
				invoiceInfo.setId(infoId);
				projectCheckService.updateInvoiceInfo(invoiceInfo);
			}
			commomService.fillCommonView(request, view);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return view;
	}
	
	@RequestMapping("/toprint")
	private ModelAndView toPrint(HttpServletRequest request, HttpServletResponse response){
		ModelAndView view = new ModelAndView("/print/print01");
		String serialNum = request.getParameter("serial_num");
		if (serialNum == null) {
			serialNum = (String) request.getAttribute("serial_num");
		}
		
		ProjectCheck projectCheck = projectCheckService.getProjectCheckBySerialNo(serialNum);
		
		view.addObject("is_normal_invoice", "y");
		view.addObject("is_zp_invoice", "n");
		view.addObject("year", DateUtil.getYear());
		view.addObject("month", DateUtil.getmonth());
		view.addObject("day", DateUtil.getDay());
		
		view.addObject("project_constructor", projectCheck.getProjectConstructor());
		view.addObject("project_address", projectCheck.getProjectAddress());
		view.addObject("taxpayer_name", projectCheck.getTaxpayerName());
		view.addObject("taxpayer_identify_num", projectCheck.getTaxpayerIdentifyNum());
		
		String taxPayType = projectCheck.getTaxpayerIdentifyNum().endsWith("L")?"o":"z";
		view.addObject("tax_pay_type", taxPayType);
		
		view.addObject("service_name", projectCheck.getProjectName());
		
		double salesAmount = projectCheck.getInvoiceAmount()/(1+projectCheck.getAppreciationRate());
		view.addObject("sale_amount", DataUtil.changeZF(salesAmount));
		
		//增值税率
		view.addObject("appreciation_rate", "3%");
		
		//税额
		view.addObject("tax_amount", DataUtil.changeZF(salesAmount*projectCheck.getAppreciationRate()));
		
		double needTaxAmount = projectCheck.getAppreciationTaxAmount() + projectCheck.getIncomeTaxAmount() +
				projectCheck.getUrbanTaxAmount() + projectCheck.getEducationAdditionAmount() +
				projectCheck.getLocalEducationAdditionAmount() + projectCheck.getStampDutyAmount() +
				projectCheck.getLaborUnionAmount() + projectCheck.getWaterConstructAmount();
		view.addObject("need_tax_amount", needTaxAmount);
		
		//本次开票金额
		double currentInvoiceAmount = projectCheck.getInvoiceAmount();
		view.addObject("current_invoice_amount", DataUtil.changeZF(currentInvoiceAmount));
		//将本次开票金额换算成大写
		view.addObject("current_big_invoice_amount", DataUtil.toChineseCurrency(currentInvoiceAmount));
		view.addObject("pay_tax_user", projectCheck.getPayTaxUser());
		
		view.addObject("contact_phone", projectCheck.getContactsPhone());
		
		view.addObject("constructor_identify_num", projectCheck.getConstructorIdentifyNum());
		
		view.addObject("print_type", "1");
		view.addObject("projectCheck", projectCheck);
		double projectCheckTotal = projectCheck.getAppreciationTaxAmount() + projectCheck.getIncomeTaxAmount()+
				projectCheck.getUrbanTaxAmount() + projectCheck.getEducationAdditionAmount() + 
				projectCheck.getLocalEducationAdditionAmount() + projectCheck.getStampDutyAmount() + 
				projectCheck.getLaborUnionAmount() + projectCheck.getWaterConstructAmount();
		view.addObject("projectCheckTotal", projectCheckTotal);
		return view;
	}
	
	@RequestMapping("/bills/toprint")
	private ModelAndView toPrintTaxManagerBills(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("/print/print03");
		
		String serialNum = request.getParameter("serial_num");
		if (serialNum == null) {
			serialNum = (String) request.getAttribute("serial_num");
		}
		
		ProjectCheck projectCheck = projectCheckService.getProjectCheckBySerialNo(serialNum);
		String nextTaxSerialNo = null;
		if (projectCheck.getTaxSerialNoStr() == null || projectCheck.getTaxSerialNoStr().isEmpty()) {
			String maxTaxSerialNo = projectCheckService.getMaxTaxSerialNo();
			nextTaxSerialNo = SerialUtil.nextTaxNumber(maxTaxSerialNo);
		} else {
			nextTaxSerialNo = projectCheck.getTaxSerialNoStr();
		}
		view.addObject("nextSerialNo", nextTaxSerialNo);
		view.addObject("projectCheck", projectCheck);
		view.addObject("invoiceAmount", DataUtil.changeZF(projectCheck.getInvoiceAmount()));
		
		view.addObject("year", DateUtil.getYear());
		view.addObject("month", DateUtil.getmonth());
		view.addObject("day", DateUtil.getDay());
		return view;
	}
	
	@RequestMapping("/toscan")
	public ModelAndView toscan(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("/scan");
		String serialNum = request.getParameter("serial_num");
		ProjectCheck check = projectCheckService.getProjectCheckBySerialNo(serialNum);
		view.addObject("up_type", ISummaryService.UPLOAD_TYPE_PROJECTCHECK);
		view.addObject("id", check.getId());
		view.addObject("serial_num", serialNum);
		return view;
	}
	
	@RequestMapping("/toscan_invoice")
	public ModelAndView toscanInvoice(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("/scan");
		String serialNum = request.getParameter("serial_num");
		ProjectCheck check = projectCheckService.getProjectCheckBySerialNo(serialNum);
		view.addObject("up_type", ISummaryService.UPLOAD_TYPE_PROJECTCHECK_INVOICE);
		view.addObject("id", check.getInvoiceInfo().getId());
		view.addObject("serial_num", serialNum);
		return view;
	}

	private ProjectCheckInvoiceInfo buildProjectCheckInvoiceInfo(
			HttpServletRequest request) throws Exception {
		ProjectCheckInvoiceInfo projectCheckInvoiceInfo = new ProjectCheckInvoiceInfo();
		projectCheckInvoiceInfo.setNationalInvoiceDate(DateUtil.parseDate(request.getParameter("national_invoice_date")));
		projectCheckInvoiceInfo.setNationalInvoiceTaxNo(request.getParameter("national_invoice_tax_no"));
		projectCheckInvoiceInfo.setNationalInvoiceNo(request.getParameter("national_invoice_no"));
		projectCheckInvoiceInfo.setLocalInvoiceDate(DateUtil.parseDate(request.getParameter("local_invoice_date")));
		projectCheckInvoiceInfo.setLocalInvoiceTaxNo(request.getParameter("local_invoice_tax_no"));
		return projectCheckInvoiceInfo;
	}

	private ProjectCheck buildProjectCheck(HttpServletRequest request) {
		try {
			ProjectCheck projectCheck = new ProjectCheck();
			projectCheck.setSerialNum(request.getParameter("serial_num"));
			projectCheck.setTaxpayerIdentifyNum(request.getParameter("taxpayer_identify_num"));
			projectCheck.setTaxpayerName(request.getParameter("taxpayer_name"));
			projectCheck.setProjectName(request.getParameter("project_name"));
			projectCheck.setProjectAddress(request.getParameter("project_address"));
			projectCheck.setProjectConstructor(request.getParameter("project_constructor"));
			projectCheck.setConstructorIdentifyNum(request.getParameter("constructor_identify_num"));
			projectCheck.setProjectTotalCost(Float.parseFloat(request.getParameter("project_total_cost")));
			projectCheck.setIsDown(request.getParameter("is_down"));
			
			projectCheck.setInvoiceAmount(Float.parseFloat(request.getParameter("invoice_amount")));
			projectCheck.setAppreciationRate(Float.parseFloat(request.getParameter("appreciation_rate")));
			projectCheck.setAppreciationTaxAmount(Float.parseFloat(request.getParameter("appreciation_tax_amount")));
			projectCheck.setIncomeRate(Float.parseFloat(request.getParameter("income_rate")));
			projectCheck.setIncomeTaxAmount(Float.parseFloat(request.getParameter("income_tax_amount")));
			projectCheck.setIncomeAffiliation(request.getParameter("income_affiliation"));
			projectCheck.setUrbanTaxRate(Float.parseFloat(request.getParameter("urban_tax_rate")));
			projectCheck.setUrbanTaxAmount(Float.parseFloat(request.getParameter("urban_tax_amount")));
			projectCheck.setEducationAdditionAmount(Float.parseFloat(request.getParameter("education_addition_amount")));
			projectCheck.setLocalEducationAdditionAmount(Float.parseFloat(request.getParameter("local_education_addition_amount")));
			projectCheck.setStampDutyRate(Float.parseFloat(request.getParameter("stamp_duty_rate")));
			projectCheck.setStampDutyAmount(Float.parseFloat(request.getParameter("stamp_duty_amount")));
			projectCheck.setLaborUnionAmount(Float.parseFloat(request.getParameter("labor_union_amount")));
			projectCheck.setWaterConstructAmount(Float.parseFloat(request.getParameter("water_construct_amount")));
			
			projectCheck.setOperatorName(request.getParameter("operator_name"));
			projectCheck.setDutyUserName(request.getParameter("duty_user_name"));
			//projectCheck.setBureauLeader(request.getParameter("bureau_leader"));
			projectCheck.setPayTaxUser(request.getParameter("pay_tax_user"));
			projectCheck.setContactsPhone(request.getParameter("contacts_phone"));
			projectCheck.setCreatedAt(new Date());
			
			String uploadSuccessFilenames = request.getParameter("upload_success_filenames");
			if (uploadSuccessFilenames != null && !uploadSuccessFilenames.isEmpty()) {
				List<ProjectCheckFile> checkFiles = new ArrayList<ProjectCheckFile>();
				projectCheck.setCheckFiles(checkFiles);
				String[] files = uploadSuccessFilenames.split(",");
				for (String file : files) {
					ProjectCheckFile checkFile = new ProjectCheckFile();
					checkFile.setFileName(file.trim());
					checkFiles.add(checkFile);
				}
			}
			projectCheck.toString();
			return projectCheck;
		} catch (Exception e) {
			LOGGER.error(e.toString(), e);
			return null;
		}
	}
}


















