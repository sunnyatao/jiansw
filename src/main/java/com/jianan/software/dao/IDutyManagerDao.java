package com.jianan.software.dao;

import java.util.List;

import com.jianan.software.pojo.DutyUser;
import com.jianan.software.pojo.BureauLeader;

public interface IDutyManagerDao {

	List<DutyUser> getDutyUsers();

	List<BureauLeader> getBureauLeaders();

	void deleteBureauLeader(int bureauLeaderId);

	void deleteDutyUser(int dutyUserId);

	void insertBureauLeader(BureauLeader leader);

	void insertDutyUser(DutyUser dutyUser);
}
