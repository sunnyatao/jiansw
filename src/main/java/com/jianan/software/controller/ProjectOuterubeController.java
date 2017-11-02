package com.jianan.software.controller;

import java.io.IOException;
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

import com.jianan.auth.SessionManager;
import com.jianan.software.common.ICommonService;
import com.jianan.software.exception.ServerBaseException;
import com.jianan.software.pojo.CrmAdminUser;
import com.jianan.software.pojo.DutyUser;
import com.jianan.software.pojo.ProjectCheck;
import com.jianan.software.pojo.ProjectCheckFile;
import com.jianan.software.pojo.ProjectCheckInvoiceInfo;
import com.jianan.software.pojo.ProjectOutertube;
import com.jianan.software.pojo.ProjectOutertubeInvoiceInfo;
import com.jianan.software.service.IDutyManagerService;
import com.jianan.software.service.IProjectOuterubeService;
import com.jianan.software.service.ISummaryService;
import com.jianan.software.util.DataUtil;
import com.jianan.software.util.DateUtil;
import com.jianan.software.util.Page;
import com.jianan.software.util.ResponseUtil;
import com.jianan.software.util.SerialUtil;

@Controller
@RequestMapping("/projectouterube")
public class ProjectOuterubeController {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectOuterubeController.class);
	
	@Autowired
	ICommonService commomService;
	
	@Autowired
	private IProjectOuterubeService projectOuterubeService;
	
	@Autowired
	private IDutyManagerService dutyManagerService;
	
	@RequestMapping("/api/delete")
	public void delete(HttpServletRequest request, HttpServletResponse response) {
		try {
			String serialNum = request.getParameter("serial_num");
			projectOuterubeService.delete(serialNum);
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
			
			ProjectOutertube outerube = projectOuterubeService.getProjectOuterubeByIdentifyNo(taxpayerIdentifyNum);
			JSONObject msgData = new JSONObject();
			msgData.put("taxpayer_name", outerube.getTaxpayerName());
			msgData.put("contacts_phone", outerube.getContactsPhone());
			msgData.put("pay_tax_user", outerube.getPayTaxUser());
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
			
			ProjectOutertube outertube = projectOuterubeService.getProjectOuterubeByProjectname(projectname);
			JSONObject msgData = new JSONObject();
			msgData.put("taxpayer_identify_num", outertube.getTaxpayerIdentifyNum());
			msgData.put("taxpayer_name", outertube.getTaxpayerName());
			msgData.put("project_constructor", outertube.getProjectConstructor());
			msgData.put("project_total_cost", outertube.getProjectTotalCost());
			msgData.put("income_affiliation", outertube.getIncomeAffiliation());
			msgData.put("is_down", outertube.getIsDown());
			msgData.put("pay_tax_user_type", outertube.getPayTaxUserType());
			msgData.put("contacts_phone", outertube.getContactsPhone());
			msgData.put("pay_tax_user", outertube.getPayTaxUser());
			msgData.put("constructor_identify_num", outertube.getConstructorIdentifyNum());
			ResponseUtil.writeResponseSuccess(response, msgData);
		} catch (Exception e) {
			LOGGER.error(e.toString(), e);
			ResponseUtil.writeResponseFailure(response);
		}
	}
	
	@RequestMapping("/toadd")
	public ModelAndView toAddCheckProject(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("/add_outertube_project");
		
		String nextSerialNo = projectOuterubeService.getNextSerialNo();
		view.addObject("nextSerialNo", nextSerialNo);
		
		CrmAdminUser user = SessionManager.getUserSession(request);
		view.addObject("operatorName", user.getUserName());

		List<DutyUser> dutyUsers = dutyManagerService.getDutyUsers();
		view.addObject("dutyUsers", dutyUsers);
		
		commomService.fillCommonView(request, view);
		return view;
	}
	
	@RequestMapping("/submit")
	public ModelAndView submitCheckProject(HttpServletRequest request, HttpServletResponse response) {
		ProjectOutertube projectOutertube = buildProjectOutertube(request);
		projectOuterubeService.createProjectOuterube(projectOutertube);
		
		String nextType = request.getParameter("submit_next_type");
		ModelAndView view = null;
		if ("0".equals(nextType)) {
			view = new ModelAndView("redirect:/projectouterube/toview");
		} else if ("1".equals(nextType)) {
			view = new ModelAndView("redirect:/projectouterube/toprint");
		} else if ("2".equals(nextType)) {
			view = new ModelAndView("redirect:/projectouterube/toadd");
		}
		view.addObject("serial_num", projectOutertube.getSerialNum());
		
		commomService.fillCommonView(request, view);
		return view;
	}
	
	@RequestMapping("/api/submit")
	public void ajaxSubmitCheckProject(HttpServletRequest request, HttpServletResponse response) {
		try {
			ProjectOutertube outertube = buildProjectOutertube(request);
			projectOuterubeService.createProjectOuterube(outertube);
			ResponseUtil.writeResponseSuccess(response);
		} catch (Exception e){
			LOGGER.error(e.toString(), e);
			ResponseUtil.writeResponseFailure(response);
		}
	}
	
	@RequestMapping("/api/update")
	public void ajaxUpdateCheckProject(HttpServletRequest request, HttpServletResponse response) {
		try {
			ProjectOutertube outertube = buildProjectOutertube(request);
			outertube.setConstructorIdentifyNum(request.getParameter("constructor_identify_num"));
			projectOuterubeService.updateOutertube(outertube);
			ResponseUtil.writeResponseSuccess(response);
		} catch (ServerBaseException se) {
			LOGGER.error(se.toString(), se);
			ResponseUtil.writeResponseFailure(response, se);
		} catch (Exception e) {
			LOGGER.error(e.toString(), e);
			ResponseUtil.writeResponseFailure(response, e);
		}
	}
	
	@RequestMapping("/toview")
	public ModelAndView toViewProjectCheck(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = null;
		String isEdit = request.getParameter("is_edit") == null?"0":request.getParameter("is_edit");
		if ("1".equals(isEdit)) {
			view = new ModelAndView("/project_outerube_edit");
		} else {
			view = new ModelAndView("/project_outerube_view");
		}
		String serialNum = request.getParameter("serial_num");
		if (serialNum == null) {
			serialNum = (String) request.getAttribute("serial_num");
		}
		
		ProjectOutertube projectOutertube = projectOuterubeService.getProjectCheckBySerialNo(serialNum);
		view.addObject("projectOutertube", projectOutertube);
		
		List<DutyUser> dutyUsers = dutyManagerService.getDutyUsers();
		view.addObject("dutyUsers", dutyUsers);
		
		commomService.fillCommonView(request, view);
		return view;
	}
	
	@RequestMapping("/list")
	public ModelAndView listProjectCheck(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("/projectouterube_list");
		
		String taxpayerName = request.getParameter("taxpayer_name");
		
		String pageIndex = request.getParameter("page") == null? "1" : request.getParameter("page");
        String pageSize = request.getParameter("page_size") == null ? "15" : request.getParameter("page_size");
        int userCount = projectOuterubeService.getProjectOuterubeCount(taxpayerName);
        Page page = new Page(userCount, Integer.parseInt(pageSize), Integer.parseInt(pageIndex));
        
		List<ProjectOutertube> projectOutertubes = projectOuterubeService.getProjectOuterubes(page, taxpayerName);
		view.addObject("rojectOutertubes", projectOutertubes);
		view.addObject("taxpayerName", taxpayerName == null?"":taxpayerName);
		view.addObject("page", page);
		commomService.fillCommonView(request, view);
		return view;
	}
	
	@RequestMapping("/taxinfo/toadd")
	public ModelAndView toAddTaxInfo(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("/project_outerube_add_taxinfo");
		String serialNum = request.getParameter("serial_num");
		if (serialNum == null) {
			serialNum = (String) request.getAttribute("serial_num");
		}
		
		ProjectOutertube outertube = projectOuterubeService.getProjectCheckBySerialNo(serialNum);
		ProjectOutertubeInvoiceInfo invoiceInfo = projectOuterubeService.getProjectOuterubeInvoiceInfoById(outertube.getId());
		if (invoiceInfo == null) {
			view.addObject("containsInvoiceInfo", "0");
		} else {
			view.addObject("containsInvoiceInfo", "1");
			view.addObject("invoiceInfo", invoiceInfo);
		}
		view.addObject("outertube", outertube);
		
		commomService.fillCommonView(request, view);
		return view;
	}
	
	@RequestMapping("/taxinfo/submit")
	public ModelAndView submitTaxInfo(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("redirect:/projectouterube/list");
		
		try {
			int infoId = Integer.parseInt(request.getParameter("invoice_info_id"));
			if (infoId == -1) {
				ProjectOutertubeInvoiceInfo projectOuterubeInvoiceInfo = buildProjectCheckInvoiceInfo(request);
				String serialNum = request.getParameter("serial_num");
				ProjectOutertube outertube = projectOuterubeService.getProjectCheckBySerialNo(serialNum);
				projectOuterubeInvoiceInfo.setProjectOuterubeId(outertube.getId());
				projectOuterubeService.createProjectCheckInvoiceInfo(projectOuterubeInvoiceInfo);
			} else {
				ProjectOutertubeInvoiceInfo projectOuterubeInvoiceInfo = buildProjectCheckInvoiceInfo(request);
				projectOuterubeInvoiceInfo.setId(infoId);
				projectOuterubeService.updateProjectCheckInvoiceInfo(projectOuterubeInvoiceInfo);
			}
			commomService.fillCommonView(request, view);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return view;
	}
	
	@RequestMapping("/api/taxinfo/submit")
	public void ajaxSubmitTaxInfo(HttpServletRequest request, HttpServletResponse response) {
		try {
			ProjectOutertubeInvoiceInfo projectOuterubeInvoiceInfo = buildProjectCheckInvoiceInfo(request);
			String serialNum = request.getParameter("serial_num");
			ProjectOutertube outertube = projectOuterubeService.getProjectCheckBySerialNo(serialNum);
			projectOuterubeInvoiceInfo.setProjectOuterubeId(outertube.getId());
			projectOuterubeService.createProjectCheckInvoiceInfo(projectOuterubeInvoiceInfo);
			ResponseUtil.writeResponseSuccess(response);
		} catch (Exception e) {
			LOGGER.error(e.toString(), e);
			ResponseUtil.writeResponseFailure(response, e);
		}
	}
	
	@RequestMapping("/toprint")
	private ModelAndView toPrint(HttpServletRequest request, HttpServletResponse response){
		ModelAndView view = new ModelAndView("/print/print01");
		String serialNum = request.getParameter("serial_num");
		if (serialNum == null) {
			serialNum = (String) request.getAttribute("serial_num");
		}
		
		ProjectOutertube projectOutertube = projectOuterubeService.getProjectCheckBySerialNo(serialNum);
		
		view.addObject("is_normal_invoice", "y");
		view.addObject("is_zp_invoice", "n");
		view.addObject("year", DateUtil.getYear());
		view.addObject("month", DateUtil.getmonth());
		view.addObject("day", DateUtil.getDay());
		
		view.addObject("project_constructor", projectOutertube.getProjectConstructor());
		view.addObject("project_address", projectOutertube.getProjectAddress());
		view.addObject("taxpayer_name", projectOutertube.getTaxpayerName());
		view.addObject("taxpayer_identify_num", projectOutertube.getTaxpayerIdentifyNum());
		
		String taxPayType = projectOutertube.getTaxpayerIdentifyNum().endsWith("L")?"o":"z";
		view.addObject("tax_pay_type", taxPayType);
		
		view.addObject("service_name", projectOutertube.getProjectName());
		
		double appreciationRate = projectOutertube.getPreAppreciationRate();
		double salesAmount = projectOutertube.getSettlementAmount()/(1+appreciationRate);
		view.addObject("sale_amount", DataUtil.changeZF(salesAmount));
		
		//增值税率
		view.addObject("appreciation_rate", "3%");
		
		//税额
		view.addObject("tax_amount", DataUtil.changeZF(salesAmount*appreciationRate));
		
		double needTaxAmount = projectOutertube.getPreAppreciationTaxAmount() + projectOutertube.getPreCorporateIncomeTaxAmount() +
				projectOutertube.getUrbanTaxAmount() + projectOutertube.getEducationAdditionAmount() +
				projectOutertube.getLocalEducationAdditionAmount() + projectOutertube.getStampDutyAmount() +
				projectOutertube.getLaborUnionAmount() + projectOutertube.getWaterConstructAmount();
		view.addObject("need_tax_amount", needTaxAmount);
		
		//本次开票金额
		double currentInvoiceAmount = projectOutertube.getSettlementAmount();
		view.addObject("current_invoice_amount", DataUtil.changeZF(currentInvoiceAmount));
		//将本次开票金额换算成大写
		view.addObject("current_big_invoice_amount", DataUtil.toChineseCurrency(currentInvoiceAmount));
		view.addObject("pay_tax_user", projectOutertube.getPayTaxUser());
		view.addObject("contact_phone", projectOutertube.getContactsPhone());
		
		view.addObject("constructor_identify_num", projectOutertube.getConstructorIdentifyNum());
		return view;
	}
	
	@RequestMapping("/bills/toprint")
	private ModelAndView toPrintTaxManagerBills(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("/print/print04");
		
		String serialNum = request.getParameter("serial_num");
		if (serialNum == null) {
			serialNum = (String) request.getAttribute("serial_num");
		}
		
		ProjectOutertube projectOutertube = projectOuterubeService.getProjectCheckBySerialNo(serialNum);
		ProjectOutertubeInvoiceInfo invoiceInfo = projectOuterubeService.getProjectOuterubeInvoiceInfoById(projectOutertube.getId());
		view.addObject("projectOutertube", projectOutertube);
		view.addObject("invoiceInfo", invoiceInfo);
		view.addObject("settlementAmount", DataUtil.changeZF(projectOutertube.getSettlementAmount()));
		double pre_appreciation_rate = projectOutertube.getPreAppreciationRate()*100;
		view.addObject("pre_appreciation_rate", DataUtil.changeZF(pre_appreciation_rate));
		
		Date nationalInvoiceDate = invoiceInfo.getNationalInvoiceDate();
		view.addObject("nationalInvoiceYear", DateUtil.getYear(nationalInvoiceDate));
		view.addObject("nationalInvoiceMonth", DateUtil.getmonth(nationalInvoiceDate));
		view.addObject("nationalInvoiceDay", DateUtil.getDay(nationalInvoiceDate));
		
		view.addObject("year", DateUtil.getYear());
		view.addObject("month", DateUtil.getmonth());
		view.addObject("day", DateUtil.getDay());
		return view;
	}
	
	@RequestMapping("/toscan")
	public ModelAndView toscan(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("/scan");
		String serialNum = request.getParameter("serial_num");
		ProjectOutertube outertube = projectOuterubeService.getProjectCheckBySerialNo(serialNum);
		view.addObject("up_type", ISummaryService.UPLOAD_TYPE_PROJECTOuterube);
		view.addObject("id", outertube.getId());
		view.addObject("serial_num", serialNum);
		return view;
	}
	
	@RequestMapping("/toscan_invoice")
	public ModelAndView toscanInvoice(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("/scan");
		String serialNum = request.getParameter("serial_num");
		ProjectOutertube outertube = projectOuterubeService.getProjectCheckBySerialNo(serialNum);
		view.addObject("up_type", ISummaryService.UPLOAD_TYPE_PROJECTouterube_INVOICE);
		view.addObject("id", outertube.getInvoiceInfo().getId());
		view.addObject("serial_num", serialNum);
		return view;
	}
	
	@RequestMapping("/viewfile")
	public ModelAndView viewFiles(HttpServletRequest request, HttpServletResponse response) {
		String serialNum = request.getParameter("serial_num");
		ProjectOutertube outertube = projectOuterubeService.getProjectCheckBySerialNo(serialNum);
		List<ProjectCheckFile> checkFiles = outertube.getCheckFiles();
		
		ModelAndView view = new ModelAndView("/scanfile");
		view.addObject("checkFiles", checkFiles);
		return view;
	}

	@RequestMapping("/viewinvoicefile")
	public ModelAndView viewinvoicefile(HttpServletRequest request, HttpServletResponse response) {
		String serialNum = request.getParameter("serial_num");
		ProjectOutertube outertube = projectOuterubeService.getProjectCheckBySerialNo(serialNum);
		List<ProjectCheckFile> checkFiles = projectOuterubeService.getInvoiceFiles(outertube.getInvoiceInfo().getId());
		
		ModelAndView view = new ModelAndView("/scanfile");
		view.addObject("checkFiles", checkFiles);
		return view;
	}

	private ProjectOutertubeInvoiceInfo buildProjectCheckInvoiceInfo(
			HttpServletRequest request) throws Exception {
		ProjectOutertubeInvoiceInfo projectOuterubeInvoiceInfo = new ProjectOutertubeInvoiceInfo();
		projectOuterubeInvoiceInfo.setNationalInvoiceDate(DateUtil.parseDate(request.getParameter("national_invoice_date")));
		projectOuterubeInvoiceInfo.setNationalInvoiceTaxNo(request.getParameter("national_invoice_tax_no"));
		projectOuterubeInvoiceInfo.setNationalInvoiceNo(request.getParameter("national_invoice_no"));
		projectOuterubeInvoiceInfo.setLocalInvoiceDate(DateUtil.parseDate(request.getParameter("local_invoice_date")));
		projectOuterubeInvoiceInfo.setLocalInvoiceTaxNo(request.getParameter("local_invoice_tax_no"));
		return projectOuterubeInvoiceInfo;
	}

	private ProjectOutertube buildProjectOutertube(HttpServletRequest request) {
		try {
			ProjectOutertube projectOutertube = new ProjectOutertube();
			projectOutertube.setSerialNum(request.getParameter("serial_num"));
			projectOutertube.setTaxpayerIdentifyNum(request.getParameter("taxpayer_identify_num"));
			projectOutertube.setTaxpayerName(request.getParameter("taxpayer_name"));
			projectOutertube.setProjectName(request.getParameter("project_name"));
			projectOutertube.setProjectAddress(request.getParameter("project_address"));
			projectOutertube.setProjectConstructor(request.getParameter("project_constructor"));
			projectOutertube.setConstructorIdentifyNum(request.getParameter("constructor_identify_num"));
			projectOutertube.setProjectTotalCost(Float.parseFloat(request.getParameter("project_total_cost")));
			projectOutertube.setIsDown(request.getParameter("is_down"));
			
			projectOutertube.setSettlementAmount(Float.parseFloat(request.getParameter("settlement_amount")));
			projectOutertube.setPreAppreciationRate(Float.parseFloat(request.getParameter("pre_appreciation_rate")));
			projectOutertube.setPreAppreciationTaxAmount(Float.parseFloat(request.getParameter("pre_appreciation_tax_amount")));
			projectOutertube.setPreCorporateIncomeTaxRate(Float.parseFloat(request.getParameter("pre_corporate_income_tax_rate")));
			projectOutertube.setPreCorporateIncomeTaxAmount(Float.parseFloat(request.getParameter("pre_corporate_income_tax_amount")));
			projectOutertube.setIncomeAffiliation(request.getParameter("income_affiliation"));
			projectOutertube.setUrbanTaxRate(Float.parseFloat(request.getParameter("urban_tax_rate")));
			projectOutertube.setUrbanTaxAmount(Float.parseFloat(request.getParameter("urban_tax_amount")));
			projectOutertube.setEducationAdditionAmount(Float.parseFloat(request.getParameter("education_addition_amount")));
			projectOutertube.setLocalEducationAdditionAmount(Float.parseFloat(request.getParameter("local_education_addition_amount")));
			projectOutertube.setStampDutyRate(Float.parseFloat(request.getParameter("stamp_duty_rate")));
			projectOutertube.setStampDutyAmount(Float.parseFloat(request.getParameter("stamp_duty_amount")));
			projectOutertube.setLaborUnionAmount(Float.parseFloat(request.getParameter("labor_union_amount")));
			projectOutertube.setWaterConstructAmount(Float.parseFloat(request.getParameter("water_construct_amount")));
			projectOutertube.setIsInvoiced(Integer.parseInt(request.getParameter("is_invoiced")));
			projectOutertube.setPayTaxUserType(request.getParameter("pay_tax_user_type"));
			projectOutertube.setTaxType(request.getParameter("tax_type"));
			
			projectOutertube.setOperatorName(request.getParameter("operator_name"));
			projectOutertube.setDutyUserName(request.getParameter("duty_user_name"));
			projectOutertube.setBureauLeader(request.getParameter("bureau_leader"));
			projectOutertube.setPayTaxUser(request.getParameter("pay_tax_user"));
			projectOutertube.setContactsPhone(request.getParameter("contacts_phone"));
			projectOutertube.setCreatedAt(new Date());
			projectOutertube.toString();
			return projectOutertube;
		} catch (Exception e) {
			LOGGER.error(e.toString(), e);
			return null;
		}
	}

}
