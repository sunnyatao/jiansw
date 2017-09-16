package com.jianan.software.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jianan.software.dao.IDutyManagerDao;
import com.jianan.software.pojo.DutyUser;
import com.jianan.software.pojo.BureauLeader;

@Repository("dutyUserManagerDao")
public class DutyUserManagerDaoImpl implements IDutyManagerDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	@Override
	public List<DutyUser> getDutyUsers() {
		
		return sqlSession.selectList("com.jianan.software.dao.impl.dutyUserManagerDao.getDutyUsers");
	}


	@Override
	public List<BureauLeader> getBureauLeaders() {
		return sqlSession.selectList("com.jianan.software.dao.impl.dutyUserManagerDao.getBureauLeaders");
	}


	@Override
	public void deleteBureauLeader(int bureauLeaderId) {
		sqlSession.update("com.jianan.software.dao.impl.dutyUserManagerDao.deleteBureauLeader", bureauLeaderId);
	}


	@Override
	public void deleteDutyUser(int dutyUserId) {
		sqlSession.update("com.jianan.software.dao.impl.dutyUserManagerDao.deleteDutyUser", dutyUserId);
	}


	@Override
	public void insertBureauLeader(BureauLeader leader) {
		sqlSession.insert("com.jianan.software.dao.impl.dutyUserManagerDao.insertBureauLeader", leader);
	}


	@Override
	public void insertDutyUser(DutyUser dutyUser) {
		sqlSession.insert("com.jianan.software.dao.impl.dutyUserManagerDao.insertDutyUser", dutyUser);
	}

}
