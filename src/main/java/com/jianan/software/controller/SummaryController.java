package com.jianan.software.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jianan.auth.SessionManager;
import com.jianan.software.common.ICommonService;
import com.jianan.software.pojo.CrmAdminUser;
import com.jianan.software.pojo.HouseContract;
import com.jianan.software.pojo.ProjectCheck;
import com.jianan.software.pojo.ProjectCheckInvoiceInfo;
import com.jianan.software.pojo.ProjectOutertube;
import com.jianan.software.pojo.ProjectSettlement;
import com.jianan.software.pojo.SearchCondition;
import com.jianan.software.pojo.SinglePrint;
import com.jianan.software.service.IHouseContractService;
import com.jianan.software.service.IProjectCheckService;
import com.jianan.software.service.IProjectOuterubeService;
import com.jianan.software.service.IProjectSettlementService;
import com.jianan.software.service.ISummaryService;
import com.jianan.software.util.DataUtil;
import com.jianan.software.util.DateUtil;
import com.jianan.software.util.Page;
import com.jianan.software.util.ResponseUtil;
import com.jianan.software.util.SerialUtil;

@Controller
@RequestMapping("/summary")
public class SummaryController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SummaryController.class);
	
	@Autowired
	private ISummaryService summaryService;
	
	@Autowired
	private ICommonService commomService;
	
	@Autowired
	private IProjectCheckService projectCheckService;
	
	@Autowired
	private IProjectSettlementService projectSettlementService;
	
	@Autowired
	private IProjectOuterubeService projectOuterubeService;
	
	@Autowired
	private IHouseContractService houseContractService;
	
	

	@RequestMapping("/search")
	public ModelAndView search(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("/summary_search");
		
		String keyword = request.getParameter("keyword");
		if (keyword != null && "".equals(keyword.trim())) {
			keyword = null;
		} else if (keyword != null) {
			keyword = keyword.trim();
		}
		List<ProjectCheck> projectChecks = projectCheckService.search(keyword);
		List<ProjectSettlement> projectSettlements = projectSettlementService.search(keyword);
		List<ProjectOutertube> projectOutertubes = projectOuterubeService.search(keyword);
		//List<HouseContract> houseContracts = houseContractService.search(keyword);
		
		view.addObject("projectChecks", projectChecks);
		view.addObject("projectSettlements", projectSettlements);
		view.addObject("projectOutertubes", projectOutertubes);
		
		if (projectChecks.isEmpty()) {
			view.addObject("isEmpty_check", "1");
		}
		if (projectSettlements.isEmpty()) {
			view.addObject("isEmpty_settlement", "1");
		}
		if (projectOutertubes.isEmpty()) {
			view.addObject("isEmpty_outertubes", "1");
		}
		
		view.addObject("keyword", keyword == null?"":keyword);
		commomService.fillCommonView(request, view);
		return view;
	}
	
	@RequestMapping("/api/check/search")
	public void ajaxSearchProjectCheck(HttpServletRequest request, HttpServletResponse response) {
		SearchCondition condition = buildSearchCondition(request);
		Page page = new Page(100000, 1500, 1);
		List<ProjectCheck> projectChecks = projectCheckService.search(condition, page);
		
		Map<String, String> values = projectCheckService.sumCheckAmount(condition);
		JSONObject msgData = new JSONObject();
		msgData.put("projectChecks", projectChecks);
		msgData.put("sumAmount", values);
		ResponseUtil.writeResponseSuccess(response, msgData);
	}

	@RequestMapping("/api/settlement/search")
	public void ajaxSearchProjectSettlement(HttpServletRequest request, HttpServletResponse response) {
		SearchCondition condition = buildSearchCondition(request);
		Page page = new Page(100000, 1500, 1);
		
		List<ProjectSettlement> projectSettlements = projectSettlementService.search(condition, page);
		Map<String, String> settlementAmount = projectSettlementService.sumSettlementAmount(condition);
		JSONObject msgData = new JSONObject();
		msgData.put("projectSettlements", projectSettlements);
		msgData.put("sumAmount", settlementAmount);
		ResponseUtil.writeResponseSuccess(response, msgData);
	}
	
	@RequestMapping("/api/outertube/search")
	public void ajaxSearchOutertube(HttpServletRequest request, HttpServletResponse response) {
		SearchCondition condition = buildSearchCondition(request);
		Page page = new Page(100000, 1500, 1);
		
		List<ProjectOutertube> projectOutertubes = projectOuterubeService.search(condition, page);
		
		Map<String, String> sumAmount = projectOuterubeService.sumOuterubeAmount(condition);
		JSONObject msgData = new JSONObject();
		msgData.put("sumAmount", sumAmount);
		msgData.put("projectOutertubes", projectOutertubes);
		ResponseUtil.writeResponseSuccess(response, msgData);
	}
	
	@RequestMapping("/ajax/search")
	public void ajaxSearch(HttpServletRequest request, HttpServletResponse response) {
		String keyword = request.getParameter("keyword");
		
		List<ProjectCheck> projectChecks = projectCheckService.search(keyword);
		List<ProjectSettlement> projectSettlements = projectSettlementService.search(keyword);
		List<ProjectOutertube> projectOutertubes = projectOuterubeService.search(keyword);
		List<HouseContract> houseContracts = houseContractService.search(keyword);
		
		JSONObject msgData = new JSONObject();
		msgData.put("projectChecks", projectChecks);
		msgData.put("projectSettlements", projectSettlements);
		msgData.put("projectOutertubes", projectOutertubes);
		msgData.put("houseContracts", houseContracts);
		
		ResponseUtil.writeResponseSuccess(response, msgData);
	}
	
	@RequestMapping("/api/xls/export")
	public void export_xls(HttpServletRequest request, HttpServletResponse response) {
		SearchCondition condition = buildSearchCondition(request);
		Page page = new Page(1000000, 100000, 1);
		
		List<ProjectCheck> projectChecks = projectCheckService.search(condition, page);
		List<ProjectSettlement> projectSettlements = projectSettlementService.search(condition, page);
		List<ProjectOutertube> projectOutertubes = projectOuterubeService.search(condition, page);
		
		String filename = UUID.randomUUID().toString() + ".xls";
		String path = request.getSession().getServletContext().getRealPath("/") + "\\static_resources\\data\\";
		path += filename;
				
		HSSFWorkbook workbook = new HSSFWorkbook();
		
		//获取参数个数作为excel列数
	    //获取List size作为excel行数
	    HSSFSheet checkSheet = workbook.createSheet("工程审核表");
	    summaryService.createCheckXls(workbook, checkSheet, projectChecks);
	    HSSFSheet settlementSheet = workbook.createSheet("工程结算表");
	    summaryService.createSettlementXls(workbook, settlementSheet, projectSettlements);
	    HSSFSheet outertubesSheet = workbook.createSheet("外管工程表");
	    summaryService.createOutertubesXls(workbook, outertubesSheet, projectOutertubes);

	    //写到磁盘上
	    try {
	        FileOutputStream fileOutputStream = new FileOutputStream(new File(path));
	        workbook.write(fileOutputStream);
	        fileOutputStream.close();
	        
	        JSONObject msgData = new JSONObject();
	        msgData.put("filename", filename);
	        ResponseUtil.writeResponseSuccess(response, msgData);
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    
	}
	
	@RequestMapping("/prints/list")
	public ModelAndView listPrints(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("/singleprint_list");

		String pageIndex = request.getParameter("page") == null? "1" : request.getParameter("page");
        String pageSize = request.getParameter("page_size") == null ? "15" : request.getParameter("page_size");
        int singlePrintCount = projectCheckService.getSinglePrintCount();
        Page page = new Page(singlePrintCount, Integer.parseInt(pageSize), Integer.parseInt(pageIndex));
		
		List<SinglePrint> singlePrints = projectCheckService.getSinglePrints(page);
		view.addObject("singlePrints", singlePrints);
		view.addObject("page", page);
		
		commomService.fillCommonView(request, view);
		
		return view;
	}
	
	@RequestMapping("/prints/detail")
	public ModelAndView detailPrints(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("/add_single_print");
		String id = request.getParameter("id");
		SinglePrint singlePrint = projectCheckService.getSinglePrint(id);
		view.addObject("singlePrint", singlePrint);
		view.addObject("hasSinglePrint", 1);
		
		commomService.fillCommonView(request, view);
		return view;
	}
	
	@RequestMapping("/prints/toadd")
	public ModelAndView toAddSinglePrintInfo(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("/add_single_print");
		
		String id = request.getParameter("id");
		if (id == null || "".equals(id.trim())) {
			int maxTaxSerialNo = projectCheckService.getMaxPrintSerialNo();
			String nextTaxSerialNo = SerialUtil.nextTaxNumber(maxTaxSerialNo);
			view.addObject("nextSerialNo", nextTaxSerialNo);
			
			view.addObject("hasSinglePrint", 0);
		} else {
			SinglePrint singlePrint = projectCheckService.getSinglePrint(id);
			view.addObject("singlePrint", singlePrint);
			view.addObject("hasSinglePrint", 1);
		}
		commomService.fillCommonView(request, view);
		return view;
	}
	
	@RequestMapping("/singleprint/goto")
	public ModelAndView toSinglePrint(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("/print/print02");
		
		String id = request.getParameter("id");
		SinglePrint singlePrint = projectCheckService.getSinglePrint(id);
		view.addObject("singlePrint", singlePrint);
		
		view.addObject("amount", DataUtil.changeZF(singlePrint.getAmount()));
		view.addObject("year", DateUtil.getYear());
		view.addObject("month", DateUtil.getmonth());
		view.addObject("day", DateUtil.getDay());
		commomService.fillCommonView(request, view);
		return view;
	}
	
	@RequestMapping("/api/prints/submit")
	public void ajaxSubmitSinglePrintInfo(HttpServletRequest request, HttpServletResponse response) {
		try{
			SinglePrint singlePrint = buildSinglePrintInfo(request);
			
			int id = Integer.parseInt(request.getParameter("id"));
			if (id == -1) {
				projectCheckService.createSinglePrintInfo(singlePrint);
			} else {
				singlePrint.setId(id);
				projectCheckService.updateSinglePrintInfo(singlePrint);
			}
			JSONObject msgData = new JSONObject();
			msgData.put("id", singlePrint.getId());
			ResponseUtil.writeResponseSuccess(response, msgData);
		} catch (Exception e) {
			LOGGER.error(e.toString(), e);
			ResponseUtil.writeResponseFailure(response);
		}
	}
	
	@RequestMapping("/api/prints/delete")
	public void ajaxDeleteSinglePrintInfo(HttpServletRequest request, HttpServletResponse response) {
		try{
			int id = Integer.parseInt(request.getParameter("id"));
			
			projectCheckService.deletetSinglePrint(id);
			
			ResponseUtil.writeResponseSuccess(response);
		} catch (Exception e) {
			LOGGER.error(e.toString(), e);
			ResponseUtil.writeResponseFailure(response);
		}
	}
	
	@RequestMapping("/api/check/import")
	public void importCheck(HttpServletRequest request, HttpServletResponse response) {
		try {
			String path = request.getSession().getServletContext().getRealPath("/") +
					"\\static_resources\\data\\";
			String filename = request.getParameter("filename");
			
			String filePath = path + filename;
			CrmAdminUser user = SessionManager.getUserSession(request);
			summaryService.importProjectCheck(filePath, user);
			ResponseUtil.writeResponseSuccess(response);
		} catch (Exception e) {
			LOGGER.error(e.toString(), e);
			ResponseUtil.writeResponseFailure(response);
		}
	}

	@RequestMapping("/api/settlement/import")
	public void importSettlement(HttpServletRequest request, HttpServletResponse response) {
		try {
			String path = request.getSession().getServletContext().getRealPath("/") +
					"\\static_resources\\data\\";
			String filename = request.getParameter("filename");
			
			String filePath = path + filename;
			CrmAdminUser user = SessionManager.getUserSession(request);
			summaryService.importProjectSettlement(filePath);
			ResponseUtil.writeResponseSuccess(response);
		} catch (Exception e) {
			LOGGER.error(e.toString(), e);
			ResponseUtil.writeResponseFailure(response);
		}
	}

	
	@RequestMapping("/api/outertube/import")
	public void importOutertube(HttpServletRequest request, HttpServletResponse response) {
		try {
			String path = request.getSession().getServletContext().getRealPath("/") +
					"\\static_resources\\data\\";
			String filename = request.getParameter("filename");
			
			String filePath = path + filename;
			CrmAdminUser user = SessionManager.getUserSession(request);
			summaryService.importProjectOuteube(filePath);
			ResponseUtil.writeResponseSuccess(response);
		} catch (Exception e) {
			LOGGER.error(e.toString(), e);
			ResponseUtil.writeResponseFailure(response);
		}
	}

	private SinglePrint buildSinglePrintInfo(HttpServletRequest request) {
		SinglePrint singlePrint = new SinglePrint();
		singlePrint.setName(request.getParameter("name"));
		singlePrint.setServiceProducerCardNo(request.getParameter("service_producer_card_no"));
		singlePrint.setArea(request.getParameter("area"));
		singlePrint.setSerialNo(Integer.parseInt(request.getParameter("serial_no")));
		singlePrint.setAmount(Double.parseDouble(request.getParameter("amount")));
		singlePrint.setCreatedAt(new Date());
		CrmAdminUser user = SessionManager.getUserSession(request);
		singlePrint.setOperatorId(user.getUserId());
		singlePrint.setOperatorName(user.getUserName());
		singlePrint.setAddress(request.getParameter("address"));
		return singlePrint;
	}
	
	private SearchCondition buildSearchCondition(HttpServletRequest request) {
		SearchCondition searchCondition = new SearchCondition();
		searchCondition.setSerialNum("".equals(request.getParameter("serial_num"))?null:request.getParameter("serial_num").trim());
		searchCondition.setProjectName("".equals(request.getParameter("project_name"))?null:request.getParameter("project_name").trim());
		searchCondition.setProjectConstructor("".equals(request.getParameter("project_constructor"))?null:request.getParameter("project_constructor").trim());
		searchCondition.setTaxpayerName("".equals(request.getParameter("taxpayer_name"))?null:request.getParameter("taxpayer_name").trim());
		searchCondition.setNationalInvoiceNo("".equals(request.getParameter("national_invoice_no"))?null:request.getParameter("national_invoice_no").trim());
		searchCondition.setNationalInvoiceTaxNo("".equals(request.getParameter("national_invoice_tax_no"))?null:request.getParameter("national_invoice_tax_no").trim());
		searchCondition.setLocalInvoiceTaxNo("".equals(request.getParameter("local_invoice_tax_no"))?null:request.getParameter("local_invoice_tax_no").trim());
		searchCondition.setTaxStartTime("".equals(request.getParameter("start_time"))?null:request.getParameter("start_time").trim());
		searchCondition.setTaxEndTime("".equals(request.getParameter("end_time"))?null:request.getParameter("end_time").trim());
		
		return searchCondition;
	}
}
