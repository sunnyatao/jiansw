package com.jianan.software.service.impl;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jianan.software.dao.IHouseContractDao;
import com.jianan.software.pojo.HouseContract;
import com.jianan.software.pojo.HouseContractTaxInfo;
import com.jianan.software.pojo.ProjectCheckFile;
import com.jianan.software.pojo.SearchCondition;
import com.jianan.software.service.IHouseContractService;
import com.jianan.software.util.DateUtil;
import com.jianan.software.util.Page;

@Service("houseContractService")
public class HouseContractServiceImpl implements IHouseContractService {

	@Autowired
	private IHouseContractDao houseContractDao;
	
	@Override
	public int getHouseContractCount(String name) {
		return houseContractDao.getHouseContractCount(name);
	}

	@Override
	public List<HouseContract> getHouseContracts(Page page, String name) {
		return houseContractDao.getHouseContracts(page, name);
	}

	@Override
	public void createProjectCheck(HouseContract houseContract) {
		houseContractDao.createProjectCheck(houseContract);
	}

	@Override
	public HouseContract getHouseConstractBy(int id) {
		return houseContractDao.getHouseConstractBy(id);
	}

	@Override
	public List<HouseContract> search(String keyword) {
		return houseContractDao.search(keyword);
	}

	@Override
	public void delete(String serialNum) {
		houseContractDao.delete(serialNum);
	}

	@Override
	public HouseContractTaxInfo getHouseConstractTaxInfo(int houseContractId) {
		return houseContractDao.getHouseConstractTaxInfo(houseContractId);
	}

	@Override
	public void createTaxInfo(HouseContractTaxInfo taxInfo) {
		houseContractDao.createTaxInfo(taxInfo);
	}

	@Override
	public List<HouseContract> searchContract(SearchCondition condition, Page page) {
		return houseContractDao.searchContract(condition, page);
	}

	@Override
	public void createHouseContractXls(HSSFWorkbook workbook, HSSFSheet sheet,
			List<HouseContract> houseContracts) {
		//创建第一栏
	    HSSFRow headRow = sheet.createRow(0);
	    String[] titleArray = {"项目名称", "纳税人", "楼栋", "房号", "面积", "单价", "总价", "增值税税率", "契税税率", "契税税额", "印花税税率", "印花税额",
	    		"房屋类型", "身份证号", "合同签订日期", "契税完税", "首付", "按揭", "契税税票号码", "契税开票日期", "印花税税票号码", "印花税开票日期"};
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
	    for (HouseContract houseContract: houseContracts) {
	    	HSSFRow row = sheet.createRow(index+1);
	        for(int n=0;n<=columeCount-1;n++)
	            row.createCell(n);
	        row.getCell(0).setCellValue(houseContract.getProjectName());
	        row.getCell(1).setCellValue(houseContract.getName());
	        row.getCell(2).setCellValue(houseContract.getFloorName());
	        row.getCell(3).setCellValue(houseContract.getSerialNo());
	        row.getCell(4).setCellValue(houseContract.getArea());
	        row.getCell(5).setCellValue(houseContract.getUnitPrice());
	        row.getCell(6).setCellValue(houseContract.getTotalPrice());
	        row.getCell(7).setCellValue(houseContract.getAppreciationRate());
	        row.getCell(8).setCellValue(houseContract.getContractTaxRate());
	        row.getCell(9).setCellValue(houseContract.getContractTax());
	        row.getCell(10).setCellValue(houseContract.getStampDutyRate());
	        row.getCell(11).setCellValue(houseContract.getStampDutyAmount());
	        row.getCell(12).setCellValue(houseContract.getHouseType());
	        row.getCell(13).setCellValue(houseContract.getCardNo());
	        row.getCell(14).setCellValue(DateUtil.formatDate(houseContract.getContractDate()));
	        row.getCell(15).setCellValue(houseContract.getContractDown());
	        row.getCell(16).setCellValue(houseContract.getFirstPaymentAmount());
	        row.getCell(17).setCellValue(houseContract.getMortgageAmount());
	        
	        HouseContractTaxInfo taxInfo = houseContract.getTaxInfo();
	        if (taxInfo != null) {
		        row.getCell(18).setCellValue(taxInfo.getContractTaxNo());
		        row.getCell(19).setCellValue(DateUtil.formatDate(taxInfo.getContractTaxDate()));
		        row.getCell(20).setCellValue(taxInfo.getStampTaxNo());
		        row.getCell(21).setCellValue(DateUtil.formatDate(taxInfo.getStampTaxDate()));
	        }
	        index++;
	    }
	}

	@Override
	public void createFiles(List<ProjectCheckFile> checkFiles) {
		houseContractDao.createProjectCheckFiles(checkFiles);
	}

	@Override
	public void createInvoiceFiles(List<ProjectCheckFile> checkFiles) {
		houseContractDao.createInvoiceFiles(checkFiles);
	}

	@Override
	public List<ProjectCheckFile> getInvoiceFiles(int id) {
		return houseContractDao.getInvoiceFiles(id);
	}

	@Override
	public void updateTaxInfo(HouseContractTaxInfo taxInfo) {
		houseContractDao.updateTaxInfo(taxInfo);
	}

	@Override
	public void updateProjectCheck(HouseContract houseContract) {
		houseContractDao.updateProjectCheck(houseContract);
	}

}
