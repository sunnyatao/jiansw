package com.jianan.software.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.jianan.software.pojo.CrmAdminUser;
import com.jianan.software.pojo.ProjectCheck;
import com.jianan.software.pojo.ProjectOutertube;
import com.jianan.software.pojo.ProjectSettlement;

public interface ISummaryService {
	
	public static int UPLOAD_TYPE_PROJECTCHECK = 1;
	public static int UPLOAD_TYPE_PROJECTCHECK_INVOICE = 2;
	public static int UPLOAD_TYPE_PROJECTSettlement = 3;
	public static int UPLOAD_TYPE_PROJECTSettlement_INVOICE = 4;
	public static int UPLOAD_TYPE_PROJECTOuterube = 5;
	public static int UPLOAD_TYPE_PROJECTouterube_INVOICE = 6;
	public static int UPLOAD_TYPE_HOUSE_CONTRACT = 7;
	public static int UPLOAD_TYPE_HOUSE_CONTRACT_INVOICE = 8;
	
	void createCheckXls(HSSFWorkbook workbook, HSSFSheet sheet, List<ProjectCheck> projectChecks);
	
	void createSettlementXls(HSSFWorkbook workbook, HSSFSheet sheet, List<ProjectSettlement> settlements);
	
	void createOutertubesXls(HSSFWorkbook workbook, HSSFSheet sheet, List<ProjectOutertube> projectOutertubes);
	
	void importProjectCheck(String filename, CrmAdminUser user) throws InvalidFormatException, IOException;
	
	void importProjectSettlement(String filename)throws FileNotFoundException, IOException;
	
	void importProjectOuteube(String filename) throws FileNotFoundException, IOException ;
}
