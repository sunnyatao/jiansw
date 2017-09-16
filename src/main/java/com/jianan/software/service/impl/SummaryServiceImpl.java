package com.jianan.software.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jianan.software.pojo.CrmAdminUser;
import com.jianan.software.pojo.ProjectCheck;
import com.jianan.software.pojo.ProjectCheckInvoiceInfo;
import com.jianan.software.pojo.ProjectOutertube;
import com.jianan.software.pojo.ProjectOutertubeInvoiceInfo;
import com.jianan.software.pojo.ProjectSettlement;
import com.jianan.software.pojo.ProjectSettlementInvoiceInfo;
import com.jianan.software.service.IProjectCheckService;
import com.jianan.software.service.IProjectOuterubeService;
import com.jianan.software.service.IProjectSettlementService;
import com.jianan.software.service.ISummaryService;
import com.jianan.software.util.DateUtil;

@Service("summaryService")
public class SummaryServiceImpl implements ISummaryService {
	
	@Autowired
	private IProjectCheckService projectCheckService;
	
	@Autowired
	private IProjectSettlementService projectSettlementService;
	
	@Autowired
	private IProjectOuterubeService projectOuterubeService;

	@Override
	public void createCheckXls(HSSFWorkbook workbook, HSSFSheet sheet, List<ProjectCheck> projectChecks) {
		//创建第一栏
	    HSSFRow headRow = sheet.createRow(0);
	    String[] titleArray = {"编号", "纳税人识别号", "纳税人名称", "工程项目名称", "工程项目地址", "工程发包方", "工程总造价", "是否完工", 
	    		"本次开票金额", "增值税率", "增值税额", "所得税率", "所得税额", "所得税归属", "城建税率", "城建税额", "教育费附加", "地方教育费附加",
	    		"印花税", "工会经费", "水利建设专项收入", "纳税经办人", "联系电话", "经办人", "负责人", 
	    		"国税发票号码", "国税税票号码", "国税开票日期", "地税税票号码", "地税开票日期"};
	    int columeCount = titleArray.length;
	    for(int m=0;m<=columeCount-1;m++)
	    {
	        HSSFCell cell = headRow.createCell(m);
	        cell.setCellType(HSSFCell.CELL_TYPE_STRING);
	        sheet.setColumnWidth(m, 6000);
	        HSSFCellStyle style = workbook.createCellStyle();
	        HSSFFont font = workbook.createFont();
	        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	        short color = HSSFColor.RED.index;
	        font.setColor(color);
	        style.setFont(font);
	        //填写数据
	        cell.setCellStyle(style);
	        cell.setCellValue(titleArray[m]);

	    }
	    double allTotalCost = 0;	//工程总造价之和 
	    double totalInvoiceAmount = 0;		//本次开票金额之和
	    double totalAppreciationTaxAmount = 0;	//增值税额之和
	    double totalIncomeTaxAmount = 0;	//所得税之和
	    double totalUrbanTaxAmount = 0;	// 城建税额
	    double totalEducationAdditionAmount = 0;	//教育费附加
	    double totalLocalEducationAdditionAmount = 0;	//地方教育费附加
	    double totalstamp_duty_amount = 0;
	    double totallabor_union_amount = 0;
	    double totalwater_construct_amount = 0;

	    int index = 0;
	    //写入数据
	    for(ProjectCheck check : projectChecks)
	    {
	    	allTotalCost += check.getProjectTotalCost();
	    	totalInvoiceAmount += check.getInvoiceAmount();
	    	totalAppreciationTaxAmount += check.getAppreciationTaxAmount();
	    	totalIncomeTaxAmount += check.getIncomeTaxAmount();
	    	totalUrbanTaxAmount += check.getUrbanTaxAmount();
	    	totalEducationAdditionAmount += check.getEducationAdditionAmount();
	    	totalLocalEducationAdditionAmount += check.getLocalEducationAdditionAmount();
	    	totalstamp_duty_amount += check.getStampDutyAmount();
	    	totallabor_union_amount += check.getLaborUnionAmount();
	    	totalwater_construct_amount += check.getWaterConstructAmount();
	    	
	        //logger.info("写入二行");
	        HSSFRow row = sheet.createRow(index+2);
	        for(int n=0;n<=columeCount-1;n++)
	            row.createCell(n);
	        row.getCell(0).setCellValue(check.getSerialNum());
	        row.getCell(1).setCellValue(check.getTaxpayerIdentifyNum());
	        row.getCell(2).setCellValue(check.getTaxpayerName());
	        row.getCell(3).setCellValue(check.getProjectName());
	        row.getCell(4).setCellValue(check.getProjectAddress());
	        row.getCell(5).setCellValue(check.getProjectConstructor());
	        row.getCell(6).setCellValue(check.getProjectTotalCost());
	        row.getCell(7).setCellValue(check.getIsDown());
	        row.getCell(8).setCellValue(check.getInvoiceAmount());
	        row.getCell(9).setCellValue(check.getAppreciationRate());
	        row.getCell(10).setCellValue(check.getAppreciationTaxAmount());
	        row.getCell(11).setCellValue(check.getIncomeRate());
	        row.getCell(12).setCellValue(check.getIncomeTaxAmount());
	        row.getCell(13).setCellValue(check.getIncomeAffiliation());
	        row.getCell(14).setCellValue(check.getUrbanTaxRate());
	        row.getCell(15).setCellValue(check.getUrbanTaxAmount());
	        row.getCell(16).setCellValue(check.getEducationAdditionAmount());
	        row.getCell(17).setCellValue(check.getLocalEducationAdditionAmount());
	        row.getCell(18).setCellValue(check.getStampDutyAmount());
	        row.getCell(19).setCellValue(check.getLaborUnionAmount());
	        row.getCell(20).setCellValue(check.getWaterConstructAmount());
	        row.getCell(21).setCellValue(check.getPayTaxUser());
	        row.getCell(22).setCellValue(check.getContactsPhone());
	        row.getCell(23).setCellValue(check.getOperatorName());
	        row.getCell(24).setCellValue(check.getDutyUserName());
	        ProjectCheckInvoiceInfo invoiceInfo = check.getInvoiceInfo();
	        if (invoiceInfo != null) {
		        row.getCell(25).setCellValue(invoiceInfo.getNationalInvoiceNo());
		        row.getCell(26).setCellValue(invoiceInfo.getNationalInvoiceTaxNo());
		        row.getCell(27).setCellValue(DateUtil.formatDate(invoiceInfo.getNationalInvoiceDate()));
		        row.getCell(28).setCellValue(invoiceInfo.getLocalInvoiceTaxNo());
		        row.getCell(29).setCellValue(DateUtil.formatDate(invoiceInfo.getLocalInvoiceDate()));
	        }
	        index++;
	    }
	    
	    HSSFRow row = sheet.createRow(1);
        for(int n=0;n<=columeCount-1;n++)
            row.createCell(n);
        row.getCell(0).setCellValue("总计");
        row.getCell(6).setCellValue(allTotalCost);
        row.getCell(8).setCellValue(totalInvoiceAmount);
        row.getCell(10).setCellValue(totalAppreciationTaxAmount);
        row.getCell(12).setCellValue(totalIncomeTaxAmount);
        row.getCell(15).setCellValue(totalUrbanTaxAmount);
        row.getCell(16).setCellValue(totalEducationAdditionAmount);
        row.getCell(17).setCellValue(totalLocalEducationAdditionAmount);
        row.getCell(18).setCellValue(totalstamp_duty_amount);
        row.getCell(19).setCellValue(totallabor_union_amount);
        row.getCell(20).setCellValue(totalwater_construct_amount);
	}

	@Override
	public void createSettlementXls(HSSFWorkbook workbook, HSSFSheet sheet,
			List<ProjectSettlement> settlements) {
		//创建第一栏
	    HSSFRow headRow = sheet.createRow(0);
	    String[] titleArray = {"编号", "施工方名称", "纳税人名称", "工程项目名称", "工程项目地址", "工程发包方", "工程总造价", "是否完工", 
	    		"本次结算金额", "供货方身份证号码", "供货方姓名", "成本发票比例", "已取得发票分数", "已取得发票金额", "代扣单位", "已代扣增值税及地税附征税额",
	    		"增值税额及地税附征税款", "本次结算应补应退税额", "征收单位", "经济性质", "竣工时间", 
	    		"纳税经办人", "联系电话", "经办人", "负责人", "局领导",
	    		"国税发票号码", "国税税票号码", "国税开票日期", "地税税票号码", "地税开票日期"};
	    
	    double allTotalCost = 0;	//工程总造价之和 
	    double totalSettlementAmount = 0;		//本次开票金额之和
	    int totalobtain_invoice_num = 0;
	    double totalobtain_invoice_amount = 0;
	    double totalWithholdTaxAmount = 0;
	    double totalAppreciationLocalTaxAmount = 0;
	    double totalRefundTaxAmount = 0;
	    
	    int columeCount = titleArray.length;
	    for(int m=0;m<=columeCount-1;m++)
	    {
	        HSSFCell cell = headRow.createCell(m);
	        cell.setCellType(HSSFCell.CELL_TYPE_STRING);
	        sheet.setColumnWidth(m, 6000);
	        HSSFCellStyle style = workbook.createCellStyle();
	        HSSFFont font = workbook.createFont();
	        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	        short color = HSSFColor.RED.index;
	        font.setColor(color);
	        style.setFont(font);
	        //填写数据
	        cell.setCellStyle(style);
	        cell.setCellValue(titleArray[m]);

	    }
	    int index = 0;
	    //写入数据
	    for(ProjectSettlement settlement : settlements)
	    {
	    	allTotalCost += settlement.getProjectTotalCost();
	    	totalAppreciationLocalTaxAmount += settlement.getAppreciationLocalTaxAmount();
	    	totalobtain_invoice_amount += settlement.getObtainInvoiceAmount();
	    	totalobtain_invoice_num += settlement.getObtainInvoiceNum();
	    	totalRefundTaxAmount += settlement.getRefundTaxAmount();
	    	totalSettlementAmount += settlement.getSettlementAmount();
	    	totalWithholdTaxAmount += settlement.getWithholdTaxAmount();
	    	
	        //logger.info("写入一行");
	        HSSFRow row = sheet.createRow(index+2);
	        for(int n=0;n<=columeCount-1;n++)
	            row.createCell(n);
	        row.getCell(0).setCellValue(settlement.getSerialNum());
	        row.getCell(1).setCellValue(settlement.getTaxpayerIdentifyNum());
	        row.getCell(2).setCellValue(settlement.getTaxpayerName());
	        row.getCell(3).setCellValue(settlement.getProjectName());
	        row.getCell(4).setCellValue(settlement.getProjectAddress());
	        row.getCell(5).setCellValue(settlement.getProjectConstructor());
	        row.getCell(6).setCellValue(settlement.getProjectTotalCost());
	        row.getCell(7).setCellValue(settlement.getIsDown());
	        
	        row.getCell(8).setCellValue(settlement.getSettlementAmount());
	        row.getCell(9).setCellValue(settlement.getServiceProducerCardNo());
	        row.getCell(10).setCellValue(settlement.getServiceProducerName());
	        row.getCell(11).setCellValue(settlement.getCostInvoiceRate());
	        row.getCell(12).setCellValue(settlement.getObtainInvoiceNum());
	        row.getCell(13).setCellValue(settlement.getObtainInvoiceAmount());
	        row.getCell(14).setCellValue(settlement.getWithholdDepartment());
	        row.getCell(15).setCellValue(settlement.getWithholdTaxAmount());
	        row.getCell(16).setCellValue(settlement.getAppreciationLocalTaxAmount());
	        row.getCell(17).setCellValue(settlement.getRefundTaxAmount());
	        row.getCell(18).setCellValue(settlement.getImposeDepartment());
	        row.getCell(19).setCellValue(settlement.getEconomicNature());
	        row.getCell(20).setCellValue(DateUtil.formatDate(settlement.getOverTime()));
	        
	        row.getCell(21).setCellValue(settlement.getPayTaxUser());
	        row.getCell(22).setCellValue(settlement.getContactsPhone());
	        row.getCell(23).setCellValue(settlement.getOperatorName());
	        row.getCell(24).setCellValue(settlement.getDutyUserName());
	        row.getCell(25).setCellValue(settlement.getBureauLeader());
	        ProjectSettlementInvoiceInfo invoiceInfo = settlement.getInvoiceInfo();
	        if (invoiceInfo != null) {
		        row.getCell(26).setCellValue(invoiceInfo.getNationalInvoiceNo());
		        row.getCell(27).setCellValue(invoiceInfo.getNationalInvoiceTaxNo());
		        row.getCell(28).setCellValue(DateUtil.formatDate(invoiceInfo.getNationalInvoiceDate()));
		        row.getCell(29).setCellValue(invoiceInfo.getLocalInvoiceTaxNo());
		        row.getCell(30).setCellValue(DateUtil.formatDate(invoiceInfo.getLocalInvoiceDate()));
	        }
	        index++;
	    }
	    
	    HSSFRow row = sheet.createRow(1);
        for(int n=0;n<=columeCount-1;n++)
            row.createCell(n);
        row.getCell(0).setCellValue("总计");
        row.getCell(6).setCellValue(allTotalCost);
        row.getCell(8).setCellValue(totalSettlementAmount);
        row.getCell(12).setCellValue(totalobtain_invoice_num);
        row.getCell(13).setCellValue(totalobtain_invoice_amount);
        row.getCell(15).setCellValue(totalWithholdTaxAmount);
        row.getCell(16).setCellValue(totalAppreciationLocalTaxAmount);
        row.getCell(17).setCellValue(totalRefundTaxAmount);
	}

	@Override
	public void createOutertubesXls(HSSFWorkbook workbook, HSSFSheet sheet,
			List<ProjectOutertube> projectOutertubes) {
		//创建第一栏
	    HSSFRow headRow = sheet.createRow(0);
	    String[] titleArray = {"编号", "纳税人识别号", "纳税人名称", "工程项目名称", "工程项目地址", "工程发包方", "工程总造价", "是否完工", 
	    		"本次结算金额", "预缴增值税比率", "预缴增值税金额", "纳税人类型", "计税方式", "预缴企业所得比率", "预缴企业所得金额", "所得税归属",
	    		"城建税率", "城建税金额", "教育费附加", "地方教育费附加", "印花税", "工会经费", "水利建设专项收入", "是否开票",
	    		"纳税经办人", "联系电话", "经办人", "负责人",
	    		"国税发票号码", "国税税票号码", "国税开票日期", "地税税票号码", "地税开票日期"};
	    
	    int allTotalCost = 0;
	    double totalSettlementAmount = 0;
	    double totalpre_appreciation_tax_amount = 0;
	    double totalpre_corporate_income_tax_amount = 0;
	    double totalurban_tax_amount = 0;
	    double totaleducation_addition_amount = 0;
	    double totallocal_education_addition_amount = 0;
	    double totalstamp_duty_amount = 0;
	    double totallabor_union_amount = 0;
	    double totalwater_construct_amount = 0;
	    
	    int columeCount = titleArray.length;
	    for(int m=0;m<=columeCount-1;m++)
	    {
	        HSSFCell cell = headRow.createCell(m);
	        cell.setCellType(HSSFCell.CELL_TYPE_STRING);
	        sheet.setColumnWidth(m, 6000);
	        HSSFCellStyle style = workbook.createCellStyle();
	        HSSFFont font = workbook.createFont();
	        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	        short color = HSSFColor.RED.index;
	        font.setColor(color);
	        style.setFont(font);
	        //填写数据
	        cell.setCellStyle(style);
	        cell.setCellValue(titleArray[m]);

	    }
	    int index = 0;
	    //写入数据
	    for(ProjectOutertube outertube : projectOutertubes)
	    {
	    	allTotalCost += outertube.getProjectTotalCost();
	    	totalSettlementAmount += outertube.getSettlementAmount();
	    	totalpre_appreciation_tax_amount += outertube.getPreAppreciationTaxAmount();
	    	totalpre_corporate_income_tax_amount += outertube.getPreCorporateIncomeTaxAmount();
	    	totalurban_tax_amount += outertube.getUrbanTaxAmount();
	    	totaleducation_addition_amount += outertube.getEducationAdditionAmount();
	    	totallocal_education_addition_amount += outertube.getLocalEducationAdditionAmount();
	    	totalstamp_duty_amount += outertube.getStampDutyAmount();
	    	totallabor_union_amount += outertube.getLaborUnionAmount();
	    	totalwater_construct_amount += outertube.getWaterConstructAmount();
	    	
	        //logger.info("写入一行");
	        HSSFRow row = sheet.createRow(index+2);
	        for(int n=0;n<=columeCount-1;n++)
	            row.createCell(n);
	        row.getCell(0).setCellValue(outertube.getSerialNum());
	        row.getCell(1).setCellValue(outertube.getTaxpayerIdentifyNum());
	        row.getCell(2).setCellValue(outertube.getTaxpayerName());
	        row.getCell(3).setCellValue(outertube.getProjectName());
	        row.getCell(4).setCellValue(outertube.getProjectAddress());
	        row.getCell(5).setCellValue(outertube.getProjectConstructor());
	        row.getCell(6).setCellValue(outertube.getProjectTotalCost());
	        row.getCell(7).setCellValue(outertube.getIsDown());
	        
	        row.getCell(8).setCellValue(outertube.getSettlementAmount());
	        row.getCell(9).setCellValue(outertube.getPreAppreciationRate());
	        row.getCell(10).setCellValue(outertube.getPreAppreciationTaxAmount());
	        row.getCell(11).setCellValue(outertube.getPayTaxUserType());
	        row.getCell(12).setCellValue(outertube.getTaxType());
	        row.getCell(13).setCellValue(outertube.getPreCorporateIncomeTaxRate());
	        row.getCell(14).setCellValue(outertube.getPreCorporateIncomeTaxAmount());
	        row.getCell(15).setCellValue(outertube.getIncomeAffiliation());
	        row.getCell(16).setCellValue(outertube.getUrbanTaxRate());
	        row.getCell(17).setCellValue(outertube.getUrbanTaxAmount());
	        row.getCell(18).setCellValue(outertube.getEducationAdditionAmount());
	        row.getCell(19).setCellValue(outertube.getLocalEducationAdditionAmount());
	        row.getCell(20).setCellValue(outertube.getStampDutyAmount());
	        row.getCell(21).setCellValue(outertube.getLaborUnionAmount());
	        row.getCell(22).setCellValue(outertube.getWaterConstructAmount());
	        if (outertube.getIsInvoiced() == 0) {
	        	row.getCell(23).setCellValue("无");
	        } else if (outertube.getIsInvoiced() == 1) {
	        	row.getCell(23).setCellValue("增值税普通发票");
	        } else {
	        	row.getCell(23).setCellValue("增值税专用发票");
	        }
	        
	        row.getCell(24).setCellValue(outertube.getPayTaxUser());
	        row.getCell(25).setCellValue(outertube.getContactsPhone());
	        row.getCell(26).setCellValue(outertube.getOperatorName());
	        row.getCell(27).setCellValue(outertube.getDutyUserName());
	        
	        ProjectOutertubeInvoiceInfo invoiceInfo = outertube.getInvoiceInfo();
	        if (invoiceInfo != null) {
		        row.getCell(28).setCellValue(invoiceInfo.getNationalInvoiceNo());
		        row.getCell(29).setCellValue(invoiceInfo.getNationalInvoiceTaxNo());
		        row.getCell(30).setCellValue(DateUtil.formatDate(invoiceInfo.getNationalInvoiceDate()));
		        row.getCell(31).setCellValue(invoiceInfo.getLocalInvoiceTaxNo());
		        row.getCell(32).setCellValue(DateUtil.formatDate(invoiceInfo.getLocalInvoiceDate()));
	        }
	        index++;
	    }
	    
	    HSSFRow row = sheet.createRow(1);
        for(int n=0;n<=columeCount-1;n++)
            row.createCell(n);
        row.getCell(0).setCellValue("总计");
        row.getCell(6).setCellValue(allTotalCost);
        row.getCell(8).setCellValue(totalSettlementAmount);
        row.getCell(10).setCellValue(totalpre_appreciation_tax_amount);
        row.getCell(14).setCellValue(totalpre_corporate_income_tax_amount);
        row.getCell(17).setCellValue(totalurban_tax_amount);
        row.getCell(18).setCellValue(totaleducation_addition_amount);
        row.getCell(19).setCellValue(totallocal_education_addition_amount);
        row.getCell(20).setCellValue(totalstamp_duty_amount);
        row.getCell(21).setCellValue(totallabor_union_amount);
        row.getCell(22).setCellValue(totalwater_construct_amount);
	}

	@Override
	public void importProjectCheck(String filename, CrmAdminUser user) throws InvalidFormatException, IOException {
		POIFSFileSystem poifsFileSystem = new POIFSFileSystem(new FileInputStream(filename));
		HSSFWorkbook xssfWorkbook = new HSSFWorkbook(poifsFileSystem);
	    HSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);

	    int rowEnd = xssfSheet.getLastRowNum();
	    
	    /*2016
	     */
	    for (int i=1; i < rowEnd; i++) {
		    	try {
		    	HSSFRow row = xssfSheet.getRow(i);
		        if(null == row) {
		        	continue;
		        }
		        
		    	ProjectCheck check = new ProjectCheck();
		    	
		    	check.setSerialNum(projectCheckService.getNextSerialNo());
		    	check.setOldSerialNum(row.getCell(0).toString());
		    	check.setProjectName(row.getCell(1).getStringCellValue());
		    	check.setProjectConstructor(row.getCell(2).getStringCellValue());	//建设单位
		    	check.setTaxpayerName(row.getCell(3)==null?"":row.getCell(3).getStringCellValue());		//施工单位
		    	double amount = 0;
		    	try {
		    		if (row.getCell(4) != null) {
		    			if (row.getCell(4).getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
		    				amount = row.getCell(4).getNumericCellValue();
		    			} else if (row.getCell(4).getCellType() == HSSFCell.CELL_TYPE_STRING) {
		    				amount = Double.parseDouble(row.getCell(4).getStringCellValue());
		    			}
		    		}
		    	} catch (Exception e) {
		    		e.printStackTrace();
		    	}
		    	check.setProjectTotalCost(amount);	//工程总造价
		    	check.setInvoiceAmount(amount);
		    	if (row.getCell(10) != null) {
			    	try {
			    		check.setAppreciationTaxAmount(row.getCell(10) == null?0:row.getCell(10).getNumericCellValue());
			    	} catch (Exception e) {
			    		try {
			    			check.setAppreciationTaxAmount(Double.parseDouble(row.getCell(10).getStringCellValue()));
			    		}catch(NumberFormatException e1) {
			    			e1.printStackTrace();
			    		}
			    	}
		    	}
		    	if (row.getCell(11) != null) {
			    	if (row.getCell(11).getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
			    		check.setUrbanTaxAmount(row.getCell(11) == null?0:row.getCell(11).getNumericCellValue());
			    	} else if (row.getCell(11).getCellType() == HSSFCell.CELL_TYPE_STRING){
			    		try {
			    			check.setUrbanTaxAmount(Double.parseDouble(row.getCell(11).getStringCellValue()));
			    		} catch (Exception e) {
			    			e.printStackTrace();
			    		}
			    	}
		    	}
		    	//check.setIncomeTaxAmount(row.getCell(9)==null?0:row.getCell(9).getNumericCellValue());		//大厅结算
		    	check.setTaxpayerName(row.getCell(12) == null?"":row.getCell(12).getStringCellValue());		//经办人
		    	check.setTaxpayerIdentifyNum(row.getCell(13)==null?"":row.getCell(13).getStringCellValue());
		    	try {
		    		check.setContactsPhone(row.getCell(14)==null?"":row.getCell(14).getStringCellValue());	//联系电话
		    	} catch (Exception e) {
		    		e.printStackTrace();
		    	}
		    	check.setProjectAddress(row.getCell(15)==null?"":row.getCell(15).getStringCellValue());	//地址
		    	check.setCreatedAt(new Date());
		    	/*String cell13Value = row.getCell(14) == null?null:row.getCell(14).toString();
		    	if (cell13Value != null && !"".equals(cell13Value.trim())) {
		    		try{
		    			check.setAppreciationTaxAmount(Double.parseDouble(cell13Value));
		    		} catch (Exception e) {
		    			
		    		}
		    	}*/
		    	projectCheckService.createProjectCheck(check);
		    	
		    	ProjectCheckInvoiceInfo invoiceInfo = new ProjectCheckInvoiceInfo();
		    	invoiceInfo.setProjectCheckId(check.getId());
		    	String nationalInvoiceNo = "";
		    	try {
		    		nationalInvoiceNo = row.getCell(6) == null?"":row.getCell(6).getStringCellValue();
		    	} catch (Exception e) {
		    		nationalInvoiceNo = row.getCell(6).toString();
		    	}
		    	invoiceInfo.setNationalInvoiceNo(nationalInvoiceNo);
		    	if (row.getCell(7) == null) {
			    	if (row.getCell(7).getCellType() == HSSFCell.CELL_TYPE_STRING) {
			    		invoiceInfo.setNationalInvoiceTaxNo(row.getCell(7)==null?"":row.getCell(7).getStringCellValue());
			    	} else {
			    		invoiceInfo.setNationalInvoiceTaxNo(row.getCell(7)==null?"":row.getCell(7).toString());
			    	}
		    	}
		    	
		    	try {
		    		invoiceInfo.setLocalInvoiceNo(row.getCell(8) == null?"":row.getCell(8).getStringCellValue());
		    	} catch (Exception e) {
		    		e.printStackTrace();
		    	}
		    	
		    	String dateStr = row.getCell(9).getStringCellValue();
		    	invoiceInfo.setNationalInvoiceDate(DateUtil.parseDate(dateStr, "yyyy.MM.dd"));
		    	/*try {
		    		invoiceInfo.setNationalInvoiceAmount(row.getCell(10) == null?0:row.getCell(10).getNumericCellValue());
		    	} catch (Exception e) {
		    		try {
		    			invoiceInfo.setNationalInvoiceAmount(Double.parseDouble(row.getCell(10).getStringCellValue()));
		    		}catch(NumberFormatException e1) {
		    			e1.printStackTrace();
		    		}
		    	}
		    	if (row.getCell(11) != null) {
			    	if (row.getCell(11).getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
			    		invoiceInfo.setLocalInvoiceAmount(row.getCell(11) == null?0:row.getCell(11).getNumericCellValue());
			    	} else if (row.getCell(11).getCellType() == HSSFCell.CELL_TYPE_STRING){
			    		try {
			    			invoiceInfo.setLocalInvoiceAmount(Double.parseDouble(row.getCell(11).getStringCellValue()));
			    		} catch (Exception e) {
			    			e.printStackTrace();
			    		}
			    	}
		    	}*/
		    	
		    	projectCheckService.createProjectCheckInvoiceInfo(invoiceInfo);
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
	    }
	    
	    /*2017第一种格式
	    for (int i=6; i < rowEnd; i++) {
	    	HSSFRow row = xssfSheet.getRow(i);
	        if(null == row) {
	        	continue;
	        }
	        
	    	ProjectCheck check = new ProjectCheck();
	    	
	    	check.setSerialNum(projectCheckService.getNextSerialNo());
	    	check.setOldSerialNum(row.getCell(0).toString());
	    	check.setProjectName(row.getCell(1).getStringCellValue());
	    	check.setProjectConstructor(row.getCell(2).getStringCellValue());	//建设单位
	    	check.setTaxpayerName(row.getCell(3)==null?"":row.getCell(3).getStringCellValue());		//施工单位
	    	check.setProjectTotalCost(row.getCell(4) == null?0:row.getCell(4).getNumericCellValue());	//工程总造价
	    	check.setIncomeTaxAmount(row.getCell(9)==null?0:row.getCell(9).getNumericCellValue());		//大厅结算
	    	check.setTaxpayerName(row.getCell(10) == null?"":row.getCell(10).getStringCellValue());		//经办人
	    	check.setTaxpayerIdentifyNum(row.getCell(11).getStringCellValue());
	    	check.setContactsPhone(row.getCell(12).getStringCellValue());	//联系电话
	    	check.setProjectAddress(row.getCell(13)==null?"":row.getCell(13).getStringCellValue());	//地址
	    	check.setCreatedAt(new Date());
	    	String cell13Value = row.getCell(14) == null?null:row.getCell(14).toString();
	    	if (cell13Value != null && !"".equals(cell13Value.trim())) {
	    		try{
	    			check.setAppreciationTaxAmount(Double.parseDouble(cell13Value));
	    		} catch (Exception e) {
	    			
	    		}
	    	}
	    	projectCheckService.createProjectCheck(check);
	    	
	    	ProjectCheckInvoiceInfo invoiceInfo = new ProjectCheckInvoiceInfo();
	    	invoiceInfo.setProjectCheckId(check.getId());
	    	String nationalInvoiceNo = row.getCell(5) == null?"":row.getCell(5).getStringCellValue();
	    	invoiceInfo.setNationalInvoiceNo(nationalInvoiceNo);
	    	invoiceInfo.setNationalInvoiceTaxNo(row.getCell(6).getStringCellValue());
	    	String dateStr = row.getCell(8).getStringCellValue();
	    	invoiceInfo.setNationalInvoiceDate(DateUtil.parseDate(dateStr, "yyyy.MM.dd"));
	    	projectCheckService.createProjectCheckInvoiceInfo(invoiceInfo);
	    	
	    }*/
	    
	  //2017第二种格式
    	/*for (int i=3; i < rowEnd; i++) {
	    	HSSFRow row = xssfSheet.getRow(i);
	        if(null == row) {
	        	continue;
	        }
	        
	    	ProjectCheck check = new ProjectCheck();
	    	
	    	check.setSerialNum(projectCheckService.getNextSerialNo());
	    	check.setOldSerialNum(row.getCell(0)==null?"":row.getCell(0).toString());
	    	check.setProjectName(row.getCell(1)==null?"":row.getCell(1).getStringCellValue());
	    	check.setProjectConstructor(row.getCell(2)==null?"":row.getCell(2).getStringCellValue());	//建设单位
	    	check.setTaxpayerName(row.getCell(3)==null?"":row.getCell(3).getStringCellValue());		//施工单位
	    	try{
	    		check.setProjectTotalCost(row.getCell(4) == null?0:row.getCell(4).getNumericCellValue());	//工程总造价
	    	} catch (Exception e) {
	    		
	    	}
	    	//check.setIncomeTaxAmount(row.getCell(9)==null?0:row.getCell(9).getNumericCellValue());		//大厅结算
	    	check.setTaxpayerName(row.getCell(12) == null?"":row.getCell(12).getStringCellValue());		//经办人
	    	check.setTaxpayerIdentifyNum(row.getCell(13)==null?"":row.getCell(13).getStringCellValue());
	    	check.setContactsPhone(row.getCell(14)==null?"":row.getCell(14).toString());	//联系电话
	    	check.setProjectAddress(row.getCell(15)==null?"":row.getCell(15).getStringCellValue());	//地址
	    	check.setCreatedAt(new Date());
	
	    	projectCheckService.createProjectCheck(check);
	    	
	    	ProjectCheckInvoiceInfo invoiceInfo = new ProjectCheckInvoiceInfo();
	    	invoiceInfo.setProjectCheckId(check.getId());
	    	String nationalInvoiceNo = row.getCell(6) == null?"":row.getCell(6).toString();
	    	invoiceInfo.setNationalInvoiceNo(nationalInvoiceNo);
	    	invoiceInfo.setNationalInvoiceTaxNo(row.getCell(7)==null?"":row.getCell(7).toString());
	    	invoiceInfo.setLocalInvoiceTaxNo(row.getCell(8)==null?"":row.getCell(8).getStringCellValue());
	    	String dateStr = row.getCell(9).getStringCellValue();
	    	invoiceInfo.setNationalInvoiceDate(DateUtil.parseDate(dateStr, "yyyy.MM.dd"));
	    	projectCheckService.createProjectCheckInvoiceInfo(invoiceInfo);
    	}*/
	}

	@Override
	public void importProjectSettlement(String filename) throws FileNotFoundException, IOException {
		POIFSFileSystem poifsFileSystem = new POIFSFileSystem(new FileInputStream(filename));
		HSSFWorkbook xssfWorkbook = new HSSFWorkbook(poifsFileSystem);
	    HSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);

	    int rowEnd = xssfSheet.getLastRowNum();
	    
	    /*
	     * 2016年重点工程项目税收结算证明台账1
	     */
	    for (int i=3; i < rowEnd; i++) {
	    	HSSFRow row = xssfSheet.getRow(i);
	        if(null == row) {
	        	continue;
	        }
	        
	        ProjectSettlement settlement = new ProjectSettlement();
	        settlement.setSerialNum(projectSettlementService.getNextSerialNo());
	        settlement.setOldSerialNum(row.getCell(0)==null?"":row.getCell(0).toString());
	        settlement.setProjectName(row.getCell(1) == null?"":row.getCell(1).getStringCellValue());
	        settlement.setProjectConstructor(row.getCell(2) == null?"":row.getCell(2).getStringCellValue());
	        settlement.setTaxpayerName(row.getCell(3) == null?"":row.getCell(3).getStringCellValue());
	        
	        double amount = 0;
	    	try {
	    		if (row.getCell(4) != null) {
	    			if (row.getCell(4).getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
	    				amount = row.getCell(4).getNumericCellValue();
	    			} else if (row.getCell(4).getCellType() == HSSFCell.CELL_TYPE_STRING) {
	    				amount = Double.parseDouble(row.getCell(4).getStringCellValue());
	    			}
	    		}
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
	    	settlement.setProjectTotalCost(amount);
	    	settlement.setSettlementAmount(amount);
	    	
	    	try {
	    		double withholdTaxAmount = row.getCell(9) == null?0:row.getCell(9).getNumericCellValue();
	    		settlement.setWithholdTaxAmount(withholdTaxAmount);
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
	    	
	    	try {
	        	double nationalInvoiceAmount = row.getCell(10)==null?0:row.getCell(10).getNumericCellValue();
	        	settlement.setRefundTaxAmount(nationalInvoiceAmount);
	        } catch(Exception e) {
	        	e.printStackTrace();
	        }

	        settlement.setImposeDepartment(row.getCell(12) == null?"":row.getCell(12).toString());
	        settlement.setMemo(row.getCell(13) == null?"":row.getCell(13).toString());
	        projectSettlementService.createSettlement(settlement);
	        
	        
	        ProjectSettlementInvoiceInfo invoiceInfo = new ProjectSettlementInvoiceInfo();
	        invoiceInfo.setProjectCheckId(settlement.getId());
	        try {
		        String invoiceNo = row.getCell(6) == null?"":row.getCell(6).toString();
		        if (invoiceNo.endsWith(".0")) {
		        	invoiceNo = invoiceNo.substring(0, invoiceNo.length()-2);
		        }
		        invoiceInfo.setNationalInvoiceNo(invoiceNo);
	        } catch (Exception e) {
	        	e.printStackTrace();
	        }
	        
	        try {
		        String taxNo = row.getCell(7) == null?"":row.getCell(7).toString();
		        if (taxNo.endsWith(".0")) {
		        	taxNo = taxNo.substring(0, taxNo.length()-2);
		        }
		        invoiceInfo.setNationalInvoiceTaxNo(taxNo);
	        } catch (Exception e) {
	        	e.printStackTrace();
	        }
	        
	        String originalTime = row.getCell(8)==null?"":row.getCell(8).toString();
	        if (!"".equals(originalTime)) {
        		invoiceInfo.setNationalInvoiceDate(DateUtil.parseDate(originalTime.trim(), "dd-MM-yyyy"));
	        }
	        
	        /*try {
	        	double nationalInvoiceAmount = row.getCell(10)==null?0:row.getCell(10).getNumericCellValue();
	        	invoiceInfo.setNationalInvoiceAmount(nationalInvoiceAmount);
	        } catch(Exception e) {
	        	e.printStackTrace();
	        }*/

	        try {
	        	double localInvoiceAmount = row.getCell(11)==null?0:row.getCell(11).getNumericCellValue();
	        	invoiceInfo.setLocalInvoiceAmount(localInvoiceAmount);
	        } catch(Exception e) {
	        	e.printStackTrace();
	        }
	        
	        projectSettlementService.createProjectSettlementInvoiceInfo(invoiceInfo);
	    }
	    
	    
	    
	    /**
	     * 2016年重点项目工程结算（代扣）台账2
	     
	    for (int i=2; i < rowEnd; i++) {
	    	HSSFRow row = xssfSheet.getRow(i);
	        if(null == row) {
	        	continue;
	        }
	        
	        ProjectSettlement settlement = new ProjectSettlement();
	        settlement.setSerialNum(projectSettlementService.getNextSerialNo());
	        settlement.setOldSerialNum(row.getCell(0)==null?"":row.getCell(0).toString());
	        settlement.setProjectName(row.getCell(1) == null?"":row.getCell(1).getStringCellValue());
	        settlement.setProjectConstructor(row.getCell(2) == null?"":row.getCell(2).getStringCellValue());
	        settlement.setTaxpayerName(row.getCell(3) == null?"":row.getCell(3).getStringCellValue());
	        settlement.setProjectTotalCost(row.getCell(4) == null?0:row.getCell(4).getNumericCellValue());
	        settlement.setAppreciationLocalTaxAmount(row.getCell(5) == null?0:row.getCell(5).getNumericCellValue());
	        settlement.setRefundTaxAmount(row.getCell(6) == null?0:row.getCell(6).getNumericCellValue());
	        settlement.setCreatedAt(DateUtil.parseDate(row.getCell(7).getStringCellValue(), "yyyy.MM.dd"));
	        settlement.setWithholdDepartment(row.getCell(8).getStringCellValue());
	        settlement.setPayTaxUser(row.getCell(9).getStringCellValue());
	        settlement.setContactsPhone(row.getCell(10).toString());
	        settlement.setMemo(row.getCell(11) == null?"":row.getCell(11).toString());
	        
	        projectSettlementService.createSettlement(settlement);
	        
	        */
	    
	}

	@Override
	public void importProjectOuteube(String filename) throws FileNotFoundException, IOException {
		POIFSFileSystem poifsFileSystem = new POIFSFileSystem(new FileInputStream(filename));
		HSSFWorkbook xssfWorkbook = new HSSFWorkbook(poifsFileSystem);
	    HSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);

	    int rowEnd = xssfSheet.getLastRowNum();
	    
	    /*
	     * 2016年外管证预缴税款台账.xls
	     */ 
	    for (int i=3; i < rowEnd; i++) {
	    	HSSFRow row = xssfSheet.getRow(i);
	        if(null == row) {
	        	continue;
	        }
	        
	        ProjectOutertube outertube = new ProjectOutertube();
	        outertube.setSerialNum(projectOuterubeService.getNextSerialNo());
	        outertube.setOldSerialNum(row.getCell(0).getStringCellValue());
	        outertube.setProjectName(row.getCell(1).getStringCellValue());
	        outertube.setProjectConstructor(row.getCell(2)==null?"":row.getCell(2).getStringCellValue());
	        outertube.setTaxpayerName(row.getCell(3)==null?"":row.getCell(3).getStringCellValue());
	        try{
	        	outertube.setProjectTotalCost(row.getCell(4)==null?0:row.getCell(4).getNumericCellValue());
	        	outertube.setSettlementAmount(row.getCell(4)==null?0:row.getCell(4).getNumericCellValue());
	        } catch(Exception e) {
	        	try {
	        		outertube.setProjectTotalCost(Double.parseDouble(row.getCell(4).getStringCellValue()));
	        		outertube.setSettlementAmount(Double.parseDouble(row.getCell(4).getStringCellValue()));
	        	} catch (NumberFormatException ex) {
	        		ex.printStackTrace();
	        	}
	        }
	        try{
	        	outertube.setPreAppreciationTaxAmount(row.getCell(9)==null?0:row.getCell(9).getNumericCellValue());
	        } catch (Exception e) {
	        	e.printStackTrace();
	        }
	        outertube.setPayTaxUser(row.getCell(10)==null?"":row.getCell(10).getStringCellValue());
	        if (row.getCell(11)!=null) {
	        	try {
		        	if (row.getCell(11).getCellType() == HSSFCell.CELL_TYPE_STRING) {
		        		outertube.setTaxpayerIdentifyNum(row.getCell(11)==null?"":row.getCell(11).getStringCellValue());
		        	} else if (row.getCell(11).getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
		        		outertube.setTaxpayerIdentifyNum(row.getCell(11)==null?"":row.getCell(11).toString());
		        	}
	        	} catch (Exception e) {
	        		e.printStackTrace();
	        	}
	        }
	        try {
	        	outertube.setContactsPhone(row.getCell(12)==null?"":row.getCell(12).getStringCellValue());
	        } catch (Exception e) {
	        	outertube.setContactsPhone(row.getCell(12)==null?"":row.getCell(12).toString());
	        }
	        
	        outertube.setProjectAddress(row.getCell(13)==null?"":row.getCell(13).getStringCellValue());
	        outertube.setCreatedAt(new Date());
	        if (row.getCell(14).getCellType() == HSSFCell.CELL_TYPE_STRING) {
	        	outertube.setIncomeAffiliation(row.getCell(14).getStringCellValue());
	        } else {
	        	outertube.setIncomeAffiliation("国税");
	        	outertube.setPreCorporateIncomeTaxAmount(row.getCell(14).getNumericCellValue());
	        }
	        try {
	        	outertube.setPreAppreciationTaxAmount(row.getCell(15)==null?0:row.getCell(15).getNumericCellValue());
	        }catch (Exception e) {
	        	try {
	        		outertube.setPreAppreciationTaxAmount(Double.parseDouble(row.getCell(15).toString()));
	        	} catch (NumberFormatException ex) {
	        		ex.printStackTrace();
	        	}
	        }
	        outertube.setIsDown(row.getCell(16)==null?"":row.getCell(16).toString());
	        outertube.setUrbanTaxAmount(row.getCell(17)==null?0:row.getCell(17).getNumericCellValue());
	        outertube.setMemo(row.getCell(19)==null?"":row.getCell(19).getStringCellValue());
	        projectOuterubeService.createProjectOuterube(outertube);
	        
	        ProjectOutertubeInvoiceInfo invoiceInfo = new ProjectOutertubeInvoiceInfo();
	        invoiceInfo.setProjectOuterubeId(outertube.getId());
	        invoiceInfo.setNationalInvoiceNo(row.getCell(6)==null?"":row.getCell(6).getStringCellValue());
	        try {
	        	invoiceInfo.setNationalInvoiceTaxNo(row.getCell(7)==null?"":row.getCell(7).getStringCellValue());
	        } catch (Exception e) {
	        	invoiceInfo.setNationalInvoiceTaxNo(row.getCell(7).toString());
	        	e.printStackTrace();
	        }
	        try {
	        	invoiceInfo.setNationalInvoiceDate(row.getCell(8)==null?null:DateUtil.parseDate(row.getCell(8).getStringCellValue(), "yyyy.MM.dd"));
	        } catch (Exception e) {
	        	e.printStackTrace();
	        }
	        try {
	        	invoiceInfo.setLocalInvoiceNo(row.getCell(18)==null?"":row.getCell(18).getStringCellValue());
	        } catch (Exception e) {
	        	e.printStackTrace();
	        	invoiceInfo.setLocalInvoiceNo(row.getCell(18)==null?"":row.getCell(18).toString());
	        }
	        projectOuterubeService.createProjectCheckInvoiceInfo(invoiceInfo);
	    }
	    
	    /*
	     * 2017年重点工程项目税收结算证明台账1
	     
	    for (int i=6; i < rowEnd; i++) {
	    	HSSFRow row = xssfSheet.getRow(i);
	        if(null == row) {
	        	continue;
	        }
	        
	        ProjectOutertube outertube = new ProjectOutertube();
	        outertube.setSerialNum(projectOuterubeService.getNextSerialNo());
	        outertube.setOldSerialNum(row.getCell(0).getStringCellValue());
	        outertube.setProjectName(row.getCell(1).getStringCellValue());
	        outertube.setProjectConstructor(row.getCell(2)==null?"":row.getCell(2).getStringCellValue());
	        outertube.setTaxpayerName(row.getCell(3)==null?"":row.getCell(3).getStringCellValue());
	        try{
	        	outertube.setProjectTotalCost(row.getCell(4)==null?0:row.getCell(4).getNumericCellValue());
	        } catch(Exception e) {
	        	outertube.setProjectTotalCost(Double.parseDouble(row.getCell(4).getStringCellValue()));
	        }
	        try{
	        	outertube.setPreAppreciationTaxAmount(row.getCell(9)==null?0:row.getCell(9).getNumericCellValue());
	        } catch (Exception e) {
	        	
	        }
	        outertube.setPayTaxUser(row.getCell(10)==null?"":row.getCell(10).getStringCellValue());
	        outertube.setIdentifyNo(row.getCell(11)==null?"":row.getCell(11).getStringCellValue());
	        outertube.setContactsPhone(row.getCell(12)==null?"":row.getCell(12).getStringCellValue());
	        outertube.setProjectAddress(row.getCell(13)==null?"":row.getCell(13).getStringCellValue());
	        outertube.setCreatedAt(new Date());
	        if (row.getCell(14).getCellType() == HSSFCell.CELL_TYPE_STRING) {
	        	outertube.setIncomeAffiliation(row.getCell(14).getStringCellValue());
	        } else {
	        	outertube.setIncomeAffiliation("国税");
	        	outertube.setPreCorporateIncomeTaxAmount(row.getCell(14).getNumericCellValue());
	        }
	        outertube.setIncomeAffiliation(row.getCell(14)==null?"":row.getCell(14).getStringCellValue());
	        outertube.setPreCorporateIncomeTaxAmount(row.getCell(15)==null?0:row.getCell(15).getNumericCellValue());
	        outertube.setIsDown(row.getCell(16)==null?"":row.getCell(16).getStringCellValue());
	        outertube.setMemo(row.getCell(19)==null?"":row.getCell(19).toString());
	        projectOuterubeService.createProjectOuterube(outertube);
	        
	        ProjectOutertubeInvoiceInfo invoiceInfo = new ProjectOutertubeInvoiceInfo();
	        invoiceInfo.setProjectOuterubeId(outertube.getId());
	        invoiceInfo.setNationalInvoiceNo(row.getCell(6)==null?"":row.getCell(6).getStringCellValue());
	        invoiceInfo.setNationalInvoiceTaxNo(row.getCell(7)==null?"":row.getCell(7).getStringCellValue());
	        invoiceInfo.setNationalInvoiceDate(row.getCell(8)==null?null:DateUtil.parseDate(row.getCell(8).getStringCellValue(), "yyyy.MM.dd"));
	        invoiceInfo.setLocalInvoiceAmount(row.getCell(17)==null?0:row.getCell(17).getNumericCellValue());
	        try{
	        	invoiceInfo.setLocalInvoiceTaxNo(row.getCell(18)==null?"":row.getCell(18).getStringCellValue());
	        } catch (Exception e) {
	        	
	        }
	        projectOuterubeService.createProjectCheckInvoiceInfo(invoiceInfo);
	    }*/
	}
}
