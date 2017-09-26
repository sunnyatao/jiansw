package com.jianan.software.controller;

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
import com.jianan.software.pojo.BureauLeader;
import com.jianan.software.pojo.CrmAdminUser;
import com.jianan.software.pojo.DutyUser;
import com.jianan.software.pojo.ProjectCheck;
import com.jianan.software.pojo.ProjectCheckFile;
import com.jianan.software.pojo.ProjectCheckInvoiceInfo;
import com.jianan.software.pojo.ProjectOutertube;
import com.jianan.software.pojo.ProjectOutertubeInvoiceInfo;
import com.jianan.software.pojo.ProjectSettlement;
import com.jianan.software.pojo.ProjectSettlementInvoiceInfo;
import com.jianan.software.service.IDutyManagerService;
import com.jianan.software.service.IProjectSettlementService;
import com.jianan.software.service.ISummaryService;
import com.jianan.software.util.DataUtil;
import com.jianan.software.util.DateUtil;
import com.jianan.software.util.Page;
import com.jianan.software.util.ResponseUtil;
import com.jianan.software.util.SerialUtil;

@Controller
@RequestMapping("/projectsettlement")
public class ProjectSettlementController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectSettlementController.class);
	
	@Autowired
	private IProjectSettlementService projectSettlementService;
	
	@Autowired
	private IDutyManagerService dutyManagerService;
	
	@Autowired
	ICommonService commomService;
	
	@RequestMapping("/api/taxserialno/save")
	public void saveTaxSerialNo(HttpServletRequest request, HttpServletResponse response) {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			String serialNo = request.getParameter("serial_no");
			projectSettlementService.updateTaxSerialNo(id, serialNo);
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
			projectSettlementService.delete(serialNum);
			ResponseUtil.writeResponseSuccess(response);
		} catch (Exception e){
			LOGGER.error(e.toString(), e);
			ResponseUtil.writeResponseFailure(response);
		}
	}
	
	@RequestMapping("/api/get_by/identifynum")
	public void getProjectSettlementByTaxpayerIdentifyNum(HttpServletRequest request, HttpServletResponse response) {
		try {
			String taxpayerIdentifyNum = request.getParameter("taxpayer_identify_num");
			
			ProjectSettlement check = projectSettlementService.getProjectSettlementByIdentifyNo(taxpayerIdentifyNum);
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
	public void getProjectSettlementByProjectname(HttpServletRequest request, HttpServletResponse response) {
		try {
			String projectname = request.getParameter("project_name");
			
			ProjectSettlement settlement = projectSettlementService.getProjectSettlementByProjectname(projectname.trim());
			JSONObject msgData = new JSONObject();
			msgData.put("taxpayer_identify_num", settlement.getTaxpayerIdentifyNum());
			msgData.put("taxpayer_name", settlement.getTaxpayerName());
			msgData.put("project_constructor", settlement.getProjectConstructor());
			msgData.put("project_total_cost", settlement.getProjectTotalCost());
			//msgData.put("income_affiliation", settlement.getIncomeAffiliation());
			msgData.put("is_down", settlement.getIsDown());
			msgData.put("contacts_phone", settlement.getContactsPhone());
			msgData.put("pay_tax_user", settlement.getPayTaxUser());
			ResponseUtil.writeResponseSuccess(response, msgData);
		} catch (Exception e) {
			LOGGER.error(e.toString(), e);
			ResponseUtil.writeResponseFailure(response);
		}
	}
	
	@RequestMapping("/toadd")
	public ModelAndView toAddCheckProject(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("/add_settlement_project");
		
		String nextSerialNo = projectSettlementService.getNextSerialNo();
		view.addObject("nextSerialNo", nextSerialNo);
		
		CrmAdminUser user = SessionManager.getUserSession(request);
		if (user == null) {
			view.addObject("operatorName", "");
		} else {
			view.addObject("operatorName", user.getUserName());
		}
		
		List<DutyUser> dutyUsers = dutyManagerService.getDutyUsers();
		List<BureauLeader> bureauLeaders = dutyManagerService.getBureauLeaders();
		view.addObject("dutyUsers", dutyUsers);
		view.addObject("bureauLeaders", bureauLeaders);
		
		String taxPayerIdentifyNum = request.getParameter("taxpayer_identify_num") == null?"":request.getParameter("taxpayer_identify_num");
		String taxpayerName = request.getParameter("taxpayer_name") == null?"":request.getParameter("taxpayer_name");
		String projectName = request.getParameter("project_name") == null?"":request.getParameter("project_name");
		String projectAddress = request.getParameter("project_address") == null?"新晃侗族自治县":request.getParameter("project_address");
		String projectTotalCost = request.getParameter("project_total_cost") == null?"":request.getParameter("project_total_cost");
		String projectConstructor = request.getParameter("project_constructor") == null?"":request.getParameter("project_constructor");
		String isDown = request.getParameter("is_down") == null?"":request.getParameter("is_down");
		
		view.addObject("taxPayerIdentifyNum", taxPayerIdentifyNum);
		view.addObject("taxpayerName", taxpayerName);
		view.addObject("projectName", projectName);
		view.addObject("projectAddress", projectAddress);
		view.addObject("projectTotalCost", projectTotalCost);
		view.addObject("projectConstructor", projectConstructor);
		view.addObject("isDown", isDown);
		
		commomService.fillCommonView(request, view);
		return view;
	}
	
	@RequestMapping("/submit")
	public ModelAndView submitCheckProject(HttpServletRequest request, HttpServletResponse response) {
		ProjectSettlement projectSettlement = buildProjectSettlement(request);
		projectSettlementService.createSettlement(projectSettlement);
		
		String nextType = request.getParameter("submit_next_type");
		ModelAndView view = null;
		if ("0".equals(nextType)) {
			view = new ModelAndView("redirect:/projectsettlement/toview");
		} else if ("1".equals(nextType)) {
			view = new ModelAndView("redirect:/projectsettlement/toprint");
		} else if ("2".equals(nextType)) {
			view = new ModelAndView("redirect:/projectsettlement/toadd");
		}
		view.addObject("serial_num", projectSettlement.getSerialNum());
		return view;
	}
	
	@RequestMapping("/api/submit")
	public void ajaxSubmitCheckProject(HttpServletRequest request, HttpServletResponse response) {
		try {
			ProjectSettlement settlement = buildProjectSettlement(request);
			projectSettlementService.createSettlement(settlement);
			ResponseUtil.writeResponseSuccess(response);
		} catch (Exception e){
			LOGGER.error(e.toString(), e);
			ResponseUtil.writeResponseFailure(response);
		}
	}
	
	@RequestMapping("/api/update")
	public void ajaxUpdateCheckProject(HttpServletRequest request, HttpServletResponse response) {
		try {
			ProjectSettlement settlement = buildProjectSettlement(request);
			projectSettlementService.updateSettlement(settlement);
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
	public ModelAndView toViewProjectSettlement(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("/project_settlement_view");
		String isEdit = request.getParameter("is_edit") == null?"0":request.getParameter("is_edit");
		if ("1".equals(isEdit)) {
			view = new ModelAndView("/project_settlement_edit");
		} else {
			view = new ModelAndView("/project_settlement_view");
		}
		
		String serialNum = request.getParameter("serial_num");
		if (serialNum == null) {
			serialNum = (String) request.getAttribute("serial_num");
		}
		
		ProjectSettlement settlement = projectSettlementService.getProjectSettlementBySerialNo(serialNum);
		view.addObject("projectSettlement", settlement);
		
		List<DutyUser> dutyUsers = dutyManagerService.getDutyUsers();
		List<BureauLeader> bureauLeaders = dutyManagerService.getBureauLeaders();
		view.addObject("dutyUsers", dutyUsers);
		view.addObject("bureauLeaders", bureauLeaders);
		
		commomService.fillCommonView(request, view);
		return view;
	}
	
	@RequestMapping("/list")
	public ModelAndView listProjectSettlement(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("/projectsettlement_list");
		
		String taxpayerName = request.getParameter("taxpayer_name");

		String pageIndex = request.getParameter("page") == null? "1" : request.getParameter("page");
		String pageSize = request.getParameter("page_size") == null ? "15" : request.getParameter("page_size");
		int userCount = projectSettlementService.getProjectSettlementCount(taxpayerName);
		Page page = new Page(userCount, Integer.parseInt(pageSize), Integer.parseInt(pageIndex));
		
		List<ProjectSettlement> projectSettlements = projectSettlementService.getProjectSettlements(page, taxpayerName);
		view.addObject("projectSettlements", projectSettlements);
		view.addObject("page", page);
		
		view.addObject("taxpayerName", taxpayerName == null?"":taxpayerName);
		commomService.fillCommonView(request, view);
		return view;
	}
	
	@RequestMapping("/taxinfo/toadd")
	public ModelAndView toAddTaxInfo(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("/project_settlement_add_taxinfo");
		String serialNum = request.getParameter("serial_num");
		if (serialNum == null) {
			serialNum = (String) request.getAttribute("serial_num");
		}
		
		ProjectSettlement settlement = projectSettlementService.getProjectSettlementBySerialNo(serialNum);
		ProjectSettlementInvoiceInfo invoiceInfo = projectSettlementService.getProjectSettlementInvoiceInfoById(settlement.getId());
		if (invoiceInfo == null) {
			view.addObject("containsInvoiceInfo", "0");
		} else {
			view.addObject("containsInvoiceInfo", "1");
			view.addObject("invoiceInfo", invoiceInfo);
		}
		
		ProjectSettlement check = projectSettlementService.getProjectSettlementBySerialNo(serialNum);
		view.addObject("projectSettlement", check);
		
		view.addObject("today", DateUtil.getTodayStr());
		
		commomService.fillCommonView(request, view);
		return view;
	}
	
	@RequestMapping("/taxinfo/submit")
	public ModelAndView submitTaxInfo(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("redirect:/projectsettlement/list");
		
		try {
			int infoId = Integer.parseInt(request.getParameter("invoice_info_id"));
			if (infoId == -1)
			{
				ProjectSettlementInvoiceInfo projectCheckInvoiceInfo = buildProjectCheckInvoiceInfo(request);
				String serialNum = request.getParameter("serial_num");
				ProjectSettlement settlement = projectSettlementService.getProjectSettlementBySerialNo(serialNum);
				projectCheckInvoiceInfo.setProjectCheckId(settlement.getId());
				projectSettlementService.createProjectSettlementInvoiceInfo(projectCheckInvoiceInfo);
			} else {
				ProjectSettlementInvoiceInfo projectSettlementInvoiceInfo = buildProjectCheckInvoiceInfo(request);
				projectSettlementInvoiceInfo.setId(infoId);
				projectSettlementService.updateSettlementInvoiceInfo(projectSettlementInvoiceInfo);
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
			ProjectSettlementInvoiceInfo projectOuterubeInvoiceInfo = buildProjectCheckInvoiceInfo(request);
			String serialNum = request.getParameter("serial_num");
			ProjectSettlement settlement = projectSettlementService.getProjectSettlementBySerialNo(serialNum);
			projectOuterubeInvoiceInfo.setProjectCheckId(settlement.getId());
			projectSettlementService.createProjectSettlementInvoiceInfo(projectOuterubeInvoiceInfo);
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
		
		ProjectSettlement projectSettlement = projectSettlementService.getProjectSettlementBySerialNo(serialNum);
		
		view.addObject("is_normal_invoice", "y");
		view.addObject("is_zp_invoice", "n");
		view.addObject("year", DateUtil.getYear());
		view.addObject("month", DateUtil.getmonth());
		view.addObject("day", DateUtil.getDay());
		
		if ("个人".equals(projectSettlement.getEconomicNature())) {
			view.addObject("project_constructor", projectSettlement.getTaxpayerName() + "施工队");
		} else {
			view.addObject("project_constructor", projectSettlement.getTaxpayerName());
		}
		view.addObject("project_address", projectSettlement.getProjectAddress());
		//view.addObject("taxpayer_name", projectSettlement.getTaxpayerName());
		view.addObject("taxpayer_name", projectSettlement.getServiceProducerName());
		view.addObject("taxpayer_identify_num", projectSettlement.getServiceProducerCardNo());
		
		String taxPayType = projectSettlement.getTaxpayerIdentifyNum().endsWith("L")?"o":"z";
		view.addObject("tax_pay_type", taxPayType);
		
		view.addObject("service_name", "建筑材料");
		
		//projectSettlement.getAppreciationRate();
		double appreciationRate = 0.02;
		
		double salesAmount = projectSettlement.getSettlementAmount()/(1+appreciationRate);
		//不含税销售额
		view.addObject("sale_amount", DataUtil.changeZF(projectSettlement.getRefundTaxAmount()/4.8*3/0.03));
		
		//增值税率
		view.addObject("appreciation_rate", "3%");
		
		//税额
		view.addObject("tax_amount", DataUtil.changeZF(projectSettlement.getRefundTaxAmount()/4.8*3));
		
		double needTaxAmount = projectSettlement.getRefundTaxAmount();
		view.addObject("need_tax_amount", needTaxAmount);
		
		//本次开票金额=>“价税合计”=本次结算金额*成本发票比例:2017-06-16 修改
		//double currentInvoiceAmount = projectSettlement.getSettlementAmount()*projectSettlement.getCostInvoiceRate();
		//税价合计=本次结算*成本比例-已取得-（已代扣增值/0.48*1.03） 2017-08-09 修改
		/*double currentInvoiceAmount = projectSettlement.getSettlementAmount()*projectSettlement.getCostInvoiceRate() 
				- projectSettlement.getObtainInvoiceAmount() 
				- (projectSettlement.getWithholdTaxAmount()/0.48*1.03);*/
		//税价合计=本次结算应补应退税额/0.048*1.03 2017-08-22
		double currentInvoiceAmount = projectSettlement.getRefundTaxAmount()/0.048*1.03;
		view.addObject("current_invoice_amount", DataUtil.changeZF(currentInvoiceAmount));
		//将本次开票金额换算成大写
		view.addObject("current_big_invoice_amount", DataUtil.toChineseCurrency(currentInvoiceAmount));
		view.addObject("pay_tax_user", projectSettlement.getServiceProducerName());
		
		view.addObject("contact_phone", projectSettlement.getContactsPhone());
		
		view.addObject("constructor_identify_num", projectSettlement.getTaxpayerIdentifyNum());
		return view;
	}
	
	@RequestMapping("/bills/toprint")
	private ModelAndView toPrintTaxManagerBills(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("/print/print05");
		
		String serialNum = request.getParameter("serial_num");
		if (serialNum == null) {
			serialNum = (String) request.getAttribute("serial_num");
		}
		
		ProjectSettlement settlement = projectSettlementService.getProjectSettlementBySerialNo(serialNum);
		ProjectSettlementInvoiceInfo infoInvoiceInfo = projectSettlementService.getProjectSettlementInvoiceInfoById(settlement.getId());
		
		String nextTaxSerialNo = settlement.getTaxSerialNoStr();
		/*if (settlement.getTaxSerialNoStr() == null || settlement.getTaxSerialNoStr().isEmpty()) {
			String maxTaxSerialNo = projectSettlementService.getMaxTaxSerialNo();
			nextTaxSerialNo = SerialUtil.nextTaxNumber(maxTaxSerialNo);
		} else {
			nextTaxSerialNo = settlement.getTaxSerialNoStr();
		}*/
		view.addObject("nextSerialNo", nextTaxSerialNo);
		view.addObject("settlement", settlement);
		view.addObject("settlementAmount", DataUtil.changeZF(settlement.getSettlementAmount()));
		view.addObject("projectTotalCost", DataUtil.changeZF(settlement.getProjectTotalCost()));
		view.addObject("costInvoiceRate", DataUtil.changeZF(settlement.getCostInvoiceRate()*100));
		view.addObject("infoInvoiceInfo", infoInvoiceInfo);
		
		//应取得发票金额
		double yqdfpje = settlement.getSettlementAmount() * settlement.getCostInvoiceRate();
		view.addObject("yqdfpje", DataUtil.changeZF(yqdfpje));
		
		//应纳税额
		//double ynse = (yqdfpje - settlement.getObtainInvoiceAmount())/(1+0.03)*0.048;
		view.addObject("ynse", DataUtil.changeZF(settlement.getAppreciationLocalTaxAmount()));
		
		//判断企业性质
		String qyType = "企业";
		if (settlement.getTaxpayerName().length() <= 4) {
			qyType = "个人";
		}
		
		if ("个人".equals(settlement.getEconomicNature())) {
			view.addObject("project_constructor", settlement.getTaxpayerName() + "施工队");
		} else {
			view.addObject("project_constructor", settlement.getTaxpayerName());
		}
		view.addObject("qyType", qyType);
		view.addObject("year", DateUtil.getYear());
		view.addObject("month", DateUtil.getmonth());
		view.addObject("day", DateUtil.getDay());
		return view;
	}
	
	@RequestMapping("/toscan")
	public ModelAndView toscan(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("/scan");
		String serialNum = request.getParameter("serial_num");
		ProjectSettlement settlement = projectSettlementService.getProjectSettlementBySerialNo(serialNum);
		view.addObject("up_type", ISummaryService.UPLOAD_TYPE_PROJECTSettlement);
		view.addObject("id", settlement.getId());
		view.addObject("serial_num", serialNum);
		return view;
	}
	
	@RequestMapping("/toscan_invoice")
	public ModelAndView toscanInvoice(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("/scan");
		String serialNum = request.getParameter("serial_num");
		//ProjectCheck check = projectCheckService.getProjectCheckBySerialNo(serialNum);
		ProjectSettlement settlement = projectSettlementService.getProjectSettlementBySerialNo(serialNum);
		view.addObject("up_type", ISummaryService.UPLOAD_TYPE_PROJECTCHECK_INVOICE);
		view.addObject("id", settlement.getInvoiceInfo().getId());
		view.addObject("serial_num", serialNum);
		return view;
	}
	
	@RequestMapping("/viewfile")
	public ModelAndView viewFiles(HttpServletRequest request, HttpServletResponse response) {
		String serialNum = request.getParameter("serial_num");
		ProjectSettlement settlement = projectSettlementService.getProjectSettlementBySerialNo(serialNum);
		List<ProjectCheckFile> checkFiles = settlement.getCheckFiles();
		
		ModelAndView view = new ModelAndView("/scanfile");
		view.addObject("checkFiles", checkFiles);
		return view;
	}
	
	@RequestMapping("/viewinvoicefile")
	public ModelAndView viewinvoicefile(HttpServletRequest request, HttpServletResponse response) {
		String serialNum = request.getParameter("serial_num");
		ProjectSettlement settlement = projectSettlementService.getProjectSettlementBySerialNo(serialNum);
		List<ProjectCheckFile> checkFiles = projectSettlementService.getInvoiceFiles(settlement.getInvoiceInfo().getId());
		
		ModelAndView view = new ModelAndView("/scanfile");
		view.addObject("checkFiles", checkFiles);
		return view;
	}
	
	private ProjectSettlementInvoiceInfo buildProjectCheckInvoiceInfo(
			HttpServletRequest request) throws Exception {
		ProjectSettlementInvoiceInfo projectSettlementInvoiceInfo = new ProjectSettlementInvoiceInfo();
		projectSettlementInvoiceInfo.setNationalInvoiceDate(DateUtil.parseDate(request.getParameter("national_invoice_date")));
		projectSettlementInvoiceInfo.setNationalInvoiceTaxNo(request.getParameter("national_invoice_tax_no"));
		projectSettlementInvoiceInfo.setNationalInvoiceNo(request.getParameter("national_invoice_no"));
		projectSettlementInvoiceInfo.setLocalInvoiceDate(DateUtil.parseDate(request.getParameter("local_invoice_date")));
		projectSettlementInvoiceInfo.setLocalInvoiceTaxNo(request.getParameter("local_invoice_tax_no"));
		return projectSettlementInvoiceInfo;
	}

	private ProjectSettlement buildProjectSettlement(HttpServletRequest request) {
		try {
			ProjectSettlement projectSettlement = new ProjectSettlement();
			projectSettlement.setSerialNum(request.getParameter("serial_num"));
			projectSettlement.setTaxpayerIdentifyNum(request.getParameter("taxpayer_identify_num"));
			projectSettlement.setTaxpayerName(request.getParameter("taxpayer_name"));
			projectSettlement.setProjectName(request.getParameter("project_name"));
			projectSettlement.setProjectAddress(request.getParameter("project_address"));
			projectSettlement.setProjectConstructor(request.getParameter("project_constructor"));
			projectSettlement.setProjectTotalCost(Float.parseFloat(request.getParameter("project_total_cost")));
			projectSettlement.setIsDown(request.getParameter("is_down"));
			
			projectSettlement.setSettlementAmount(Float.parseFloat(request.getParameter("settlement_amount")));
			projectSettlement.setServiceProducerCardNo(request.getParameter("service_producer_card_no"));
			projectSettlement.setServiceProducerName(request.getParameter("service_producer_name"));
			projectSettlement.setCostInvoiceRate(Float.parseFloat(request.getParameter("cost_invoice_rate"))/100);
			projectSettlement.setObtainInvoiceNum(Integer.parseInt(request.getParameter("obtain_invoice_num")));
			projectSettlement.setObtainInvoiceAmount(Float.parseFloat(request.getParameter("obtain_invoice_amount")));
			projectSettlement.setWithholdDepartment(request.getParameter("withhold_department"));
			projectSettlement.setWithholdTaxAmount(Float.parseFloat(request.getParameter("withhold_tax_amount")));
			projectSettlement.setAppreciationLocalTaxAmount(Float.parseFloat(request.getParameter("appreciation_local_tax_amount")));
			projectSettlement.setRefundTaxAmount(Float.parseFloat(request.getParameter("refund_tax_amount")));
			projectSettlement.setImposeDepartment(request.getParameter("impose_department"));
			//设置代扣金额和征收金额
			projectSettlement.setcDkje(Float.parseFloat(request.getParameter("c_dkje")));
			projectSettlement.setcZsje(Float.parseFloat(request.getParameter("c_zsje")));
			
			projectSettlement.setOperatorName(request.getParameter("operator_name"));
			projectSettlement.setDutyUserName(request.getParameter("duty_user_name"));
			projectSettlement.setBureauLeader(request.getParameter("bureau_leader"));
			projectSettlement.setPayTaxUser(request.getParameter("pay_tax_user"));
			projectSettlement.setContactsPhone(request.getParameter("contacts_phone"));
			projectSettlement.setCreatedAt(new Date());
			if (request.getParameter("over_time") != null && !request.getParameter("over_time").isEmpty()) {
				projectSettlement.setOverTime(DateUtil.parseDate(request.getParameter("over_time")));
			}
			projectSettlement.setEconomicNature(request.getParameter("economic_nature"));
			projectSettlement.toString();
			return projectSettlement;
		} catch (Exception e) {
			LOGGER.error(e.toString(), e);
			return null;
		}
	}
}

