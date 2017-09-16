package com.jianan.software.dao;

import java.util.List;

import com.jianan.software.pojo.HouseContract;
import com.jianan.software.pojo.HouseContractTaxInfo;
import com.jianan.software.pojo.ProjectCheck;
import com.jianan.software.pojo.ProjectCheckFile;
import com.jianan.software.pojo.SearchCondition;
import com.jianan.software.util.Page;

public interface IHouseContractDao {

	int getHouseContractCount(String name);

	List<HouseContract> getHouseContracts(Page page, String name);

	void createProjectCheck(HouseContract houseContract);

	HouseContract getHouseConstractBy(int id);

	List<HouseContract> search(String keyword);

	void delete(String serialNum);

	HouseContractTaxInfo getHouseConstractTaxInfo(int houseContractId);

	void createTaxInfo(HouseContractTaxInfo taxInfo);

	List<HouseContract> searchContract(SearchCondition condition, Page page);

	void createProjectCheckFiles(List<ProjectCheckFile> checkFiles);

	void createInvoiceFiles(List<ProjectCheckFile> checkFiles);

	List<ProjectCheckFile> getInvoiceFiles(int id);

}
