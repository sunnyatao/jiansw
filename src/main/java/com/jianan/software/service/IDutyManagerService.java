package com.jianan.software.service;

import java.util.List;

import com.jianan.software.pojo.DutyUser;
import com.jianan.software.pojo.BureauLeader;

public interface IDutyManagerService {

	List<DutyUser> getDutyUsers();

	List<BureauLeader> getBureauLeaders();
	
	void insertDutyUser(DutyUser dutyUser);
	
	void insertBureauLeader(BureauLeader leader);
	
	void deleteDutyUser(int dutyUserId);

	void deleteBureauLeader(int bureauLeaderId);
}
