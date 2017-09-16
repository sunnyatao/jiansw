package com.jianan.software.service;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.jianan.software.pojo.HouseContract;
import com.jianan.software.pojo.HouseContractTaxInfo;
import com.jianan.software.pojo.ProjectCheckFile;
import com.jianan.software.pojo.SearchCondition;
import com.jianan.software.util.Page;

public interface IHouseContractService {

	int getHouseContractCount(String name);

	List<HouseContract> getHouseContracts(Page page, String name);

	void createProjectCheck(HouseContract houseContract);

	HouseContract getHouseConstractBy(int id);

	public List<HouseContract> search(String keyword);

	void delete(String serialNum);

	HouseContractTaxInfo getHouseConstractTaxInfo(int houseContractId);

	void createTaxInfo(HouseContractTaxInfo taxInfo);
	
	List<HouseContract> searchContract(SearchCondition condition, Page page);
	
	void createHouseContractXls(HSSFWorkbook workbook, HSSFSheet sheet, List<HouseContract> houseContracts);
	
	public void createFiles(List<ProjectCheckFile> checkFiles);

	public void createInvoiceFiles(List<ProjectCheckFile> checkFiles);

	public List<ProjectCheckFile> getInvoiceFiles(int id); 
}
