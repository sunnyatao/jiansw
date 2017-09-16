package com.jianan.software.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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
import com.jianan.software.pojo.HouseContractTaxInfo;
import com.jianan.software.pojo.ProjectCheck;
import com.jianan.software.pojo.ProjectCheckFile;
import com.jianan.software.pojo.SearchCondition;
import com.jianan.software.service.IHouseContractService;
import com.jianan.software.service.ISummaryService;
import com.jianan.software.util.DateUtil;
import com.jianan.software.util.Page;
import com.jianan.software.util.ResponseUtil;

@Controller
@RequestMapping("housecontract")
public class HouseContractController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HouseContractController.class);
	
	@Autowired
	ICommonService commomService;

	@Autowired
	private IHouseContractService houseContractService;
	
	@RequestMapping("/api/delete")
	public void delete(HttpServletRequest request, HttpServletResponse response) {
		try {
			String id = request.getParameter("id");
			houseContractService.delete(id);
			ResponseUtil.writeResponseSuccess(response);
		} catch (Exception e){
			LOGGER.error(e.toString(), e);
			ResponseUtil.writeResponseFailure(response);
		}
	}
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response){
		ModelAndView view = new ModelAndView("/housecontract_list");
		
		String name = request.getParameter("name");
		
		String pageIndex = request.getParameter("page") == null? "1" : request.getParameter("page");
        String pageSize = request.getParameter("page_size") == null ? "15" : request.getParameter("page_size");
        int userCount = houseContractService.getHouseContractCount(name);
        Page page = new Page(userCount, Integer.parseInt(pageSize), Integer.parseInt(pageIndex));
		
		List<HouseContract> houseContracts = houseContractService.getHouseContracts(page, name);
		view.addObject("houseContracts", houseContracts);
		view.addObject("name", name == null?"":name);
		view.addObject("page", page);
		commomService.fillCommonView(request, view);
		return view;
	}
	
	@RequestMapping("/api/search")
	public void ajaxSearch(HttpServletRequest request, HttpServletResponse response) {
		try {
			String name = request.getParameter("name");
			String floorName =request.getParameter("floor_name");
			String searchStartTime = request.getParameter("search_start_time");
			String searchEndTime = request.getParameter("search_end_time");
			
			SearchCondition condition = new SearchCondition();
			condition.setName("".equals(name)?null:name);
			condition.setFloorName("".equals(floorName)?null:floorName);
			condition.setTaxStartTime("".equals(searchStartTime)?null:searchStartTime);
			condition.setTaxEndTime("".equals(searchEndTime)?null:searchEndTime);
			
			Page page = new Page(100000, 10000, 1);
			List<HouseContract> houseContracts = houseContractService.searchContract(condition, page);
			
			JSONObject msgData = new JSONObject();
			msgData.put("houseContracts", houseContracts);
			ResponseUtil.writeResponseSuccess(response, msgData);
		} catch (Exception e) {
			ResponseUtil.writeResponseFailure(response);
		}
		
	}
	
	@RequestMapping("/toadd")
	public ModelAndView toadd(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("/add_house_contract");
		
		commomService.fillCommonView(request, view);
		return view;
	}
	
	@RequestMapping("/taxinfo/toadd")
	public ModelAndView toAddTaxInfo(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("/house_contract_taxinfo");
		
		int houseContractId = Integer.parseInt(request.getParameter("house_contract_id"));
		HouseContract houseContract = houseContractService.getHouseConstractBy(houseContractId);
		HouseContractTaxInfo contractTaxInfo = houseContractService.getHouseConstractTaxInfo(houseContractId);
		if (contractTaxInfo == null) {
			view.addObject("containsInvoiceInfo", "0");
		} else {
			view.addObject("containsInvoiceInfo", "1");
			view.addObject("contractTaxInfo", contractTaxInfo);
		}
		view.addObject("houseContract", houseContract);
		view.addObject("today", DateUtil.getTodayStr());
		
		commomService.fillCommonView(request, view);
		return view;
	}
	
	@RequestMapping("/toprint")
	public ModelAndView toprint(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("/print/print06");
		int houseContractId = Integer.parseInt(request.getParameter("id"));
		HouseContract houseContract = houseContractService.getHouseConstractBy(houseContractId);
		
		view.addObject("year", DateUtil.getYear());
		view.addObject("month", DateUtil.getmonth());
		view.addObject("day", DateUtil.getDay());
		view.addObject("houseContract", houseContract);
		return view;
	}
	
	@RequestMapping("/submit")
	public ModelAndView submit(HttpServletRequest request, HttpServletResponse response) {
		CrmAdminUser user = SessionManager.getUserSession(request);
		
		ModelAndView view = new ModelAndView("redirect:/housecontract/toview");
		HouseContract houseContract = buildHouseContract(request);
		houseContract.setOperatorId(user.getUserId());
		houseContract.setOperatorName(user.getUserName());
		houseContract.setCreatedAt(new Date());
		
		houseContractService.createProjectCheck(houseContract);
		return view;
	}
	
	@RequestMapping("/api/submit")
	public void ajaxSubmit(HttpServletRequest request, HttpServletResponse response) {
		try {
			CrmAdminUser user = SessionManager.getUserSession(request);
			HouseContract houseContract = buildHouseContract(request);
			houseContract.setOperatorId(user.getUserId());
			houseContract.setOperatorName(user.getUserName());
			houseContract.setCreatedAt(new Date());
			
			houseContractService.createProjectCheck(houseContract);
			JSONObject msgData = new JSONObject();
			msgData.put("id", houseContract.getId());
			ResponseUtil.writeResponseSuccess(response, msgData);
		} catch (Exception e) {
			LOGGER.error(e.toString(), e);
			ResponseUtil.writeResponseFailure(response);
		}
	}
	
	@RequestMapping("/api/taxinfo/submit")
	public void ajaxSubmitTaxInfo(HttpServletRequest request, HttpServletResponse response) {
		try{
			HouseContractTaxInfo taxInfo = buildTaxInfo(request);
		
			houseContractService.createTaxInfo(taxInfo);
			
			ResponseUtil.writeResponseSuccess(response);
		} catch (Exception e) {
			LOGGER.error(e.toString(), e);
			ResponseUtil.writeResponseFailure(response);
		}
	}
	
	@RequestMapping("/toview")
	public ModelAndView toview(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("/house_contract_view");
		
		int id = Integer.parseInt(request.getParameter("id"));
		HouseContract houseContract = houseContractService.getHouseConstractBy(id);
		view.addObject("houseContract", houseContract);
		
		commomService.fillCommonView(request, view);
		return view;
	}
	
	@RequestMapping("/api/xls/export")
	public void export_xls(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String floorName =request.getParameter("floor_name");
		String searchStartTime = request.getParameter("search_start_time");
		String searchEndTime = request.getParameter("search_end_time");
		
		SearchCondition condition = new SearchCondition();
		condition.setName("".equals(name)?null:name);
		condition.setFloorName("".equals(floorName)?null:floorName);
		condition.setTaxStartTime("".equals(searchStartTime)?null:searchStartTime);
		condition.setTaxEndTime("".equals(searchEndTime)?null:searchEndTime);
		
		Page page = new Page(100000, 100000, 1);
		List<HouseContract> houseContracts = houseContractService.searchContract(condition, page);
		
		String filename = UUID.randomUUID().toString() + ".xls";
		String path = request.getSession().getServletContext().getRealPath("/") + "\\static_resources\\data\\";
		path += filename;
				
		HSSFWorkbook workbook = new HSSFWorkbook();
		
		//获取参数个数作为excel列数
	    //获取List size作为excel行数
	    HSSFSheet sheet = workbook.createSheet("房屋契税");
		houseContractService.createHouseContractXls(workbook, sheet, houseContracts);
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
	
	@RequestMapping("/toscan")
	public ModelAndView toscan(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("/scan");
		String id = request.getParameter("id");
		view.addObject("up_type", ISummaryService.UPLOAD_TYPE_HOUSE_CONTRACT);
		view.addObject("id", id);
		view.addObject("serial_num", id);
		return view;
	}
	
	@RequestMapping("/toscan_invoice")
	public ModelAndView toscanInvoice(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("/scan");
		String id = request.getParameter("id");
		view.addObject("up_type", ISummaryService.UPLOAD_TYPE_HOUSE_CONTRACT_INVOICE);
		view.addObject("id", id);
		view.addObject("serial_num", id);
		return view;
	}
	
	@RequestMapping("/viewinvoicefile")
	public ModelAndView viewinvoicefile(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		List<ProjectCheckFile> checkFiles = houseContractService.getInvoiceFiles(Integer.parseInt(id));
		
		ModelAndView view = new ModelAndView("/scanfile");
		view.addObject("checkFiles", checkFiles);
		return view;
	}
	
	public HouseContract buildHouseContract(HttpServletRequest request) {
		HouseContract houseContract = new HouseContract();
		houseContract.setName(request.getParameter("name"));
		houseContract.setFloorName(request.getParameter("floor_name"));
		houseContract.setSerialNo(request.getParameter("serial_no"));
		houseContract.setArea(Float.parseFloat(request.getParameter("area")));
		houseContract.setUnitPrice(Float.parseFloat(request.getParameter("unit_price")));
		houseContract.setTotalPrice(Float.parseFloat(request.getParameter("total_price")));
		houseContract.setContractTaxRate(Float.parseFloat(request.getParameter("contract_tax_rate")));
		houseContract.setContractTax(Float.parseFloat(request.getParameter("contract_tax")));
		houseContract.setCardNo(request.getParameter("card_no"));
		try {
			houseContract.setContractDate(DateUtil.parseDate(request.getParameter("contract_date")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		houseContract.setContractDown(request.getParameter("contract_down"));
		houseContract.setFirstPaymentAmount(Float.parseFloat(request.getParameter("first_payment_amount")));
		houseContract.setMortgageAmount(Float.parseFloat(request.getParameter("mortgage_amount")));
		houseContract.setOperatorName(request.getParameter("operator_name"));
		
		houseContract.setProjectName(request.getParameter("project_name"));
		houseContract.setAppreciationRate(Float.parseFloat(request.getParameter("appreciation_rate")));
		//houseContract.setAppreciationAmount(Float.parseFloat(request.getParameter("appreciation_amount")));
		houseContract.setStampDutyRate(Float.parseFloat(request.getParameter("stamp_duty_rate")));
		houseContract.setStampDutyAmount(Float.parseFloat(request.getParameter("stamp_duty_amount")));
		houseContract.setHouseType(request.getParameter("house_type"));
		
		return houseContract;
	}
	
	private HouseContractTaxInfo buildTaxInfo(HttpServletRequest request) {
		HouseContractTaxInfo taxInfo = new HouseContractTaxInfo();
		taxInfo.setHouseContractId(Integer.parseInt(request.getParameter("house_contract_id")));
		taxInfo.setContractTaxNo(request.getParameter("contract_tax_no"));
		taxInfo.setStampTaxNo(request.getParameter("stamp_tax_no"));
		try {
			taxInfo.setContractTaxDate(DateUtil.parseDate(request.getParameter("contact_tax_date")));
			taxInfo.setStampTaxDate(DateUtil.parseDate(request.getParameter("stamp_tax_date")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		CrmAdminUser user = SessionManager.getUserSession(request);
		taxInfo.setOperatorId(user.getUserId());
		taxInfo.setOperatorName(user.getUserName());
		taxInfo.setCreatedAt(new Date());
		return taxInfo;
	}
}
