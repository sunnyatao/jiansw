package com.jianan.software.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jianan.software.dao.IDutyManagerDao;
import com.jianan.software.pojo.DutyUser;
import com.jianan.software.pojo.BureauLeader;
import com.jianan.software.service.IDutyManagerService;

@Service("dutyManagerService")
public class DutyManagerServiceImpl implements IDutyManagerService {

	@Autowired
	private IDutyManagerDao dutyUserManagerDao;
	
	@Override
	public List<DutyUser> getDutyUsers() {
		return dutyUserManagerDao.getDutyUsers();
	}

	@Override
	public List<BureauLeader> getBureauLeaders() {
		return dutyUserManagerDao.getBureauLeaders();
	}

	@Override
	public void insertDutyUser(DutyUser dutyUser) {
		dutyUserManagerDao.insertDutyUser(dutyUser);
	}

	@Override
	public void insertBureauLeader(BureauLeader leader) {
		dutyUserManagerDao.insertBureauLeader(leader);
	}

	@Override
	public void deleteDutyUser(int dutyUserId) {
		dutyUserManagerDao.deleteDutyUser(dutyUserId);
	}

	@Override
	public void deleteBureauLeader(int bureauLeaderId) {
		dutyUserManagerDao.deleteBureauLeader(bureauLeaderId);
	}

}
