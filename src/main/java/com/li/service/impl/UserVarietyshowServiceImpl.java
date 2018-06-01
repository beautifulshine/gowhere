package com.li.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.li.dao.UserVarietyshowMapper;
import com.li.model.UserVarietyshow;
import com.li.service.UserVarietyshowService;
@Service("userVarietyshowService")
public class UserVarietyshowServiceImpl implements UserVarietyshowService {
	@Resource
	private UserVarietyshowMapper userVarietyshowDao;

	@Override
	public List<UserVarietyshow> loadVarietyshowList(Map<String, Object> map) {
		
		return userVarietyshowDao.loadVarietyshowList(map);
	}

	public UserVarietyshow selectByPrimaryKey(Long id) {
		return userVarietyshowDao.selectByPrimaryKey(id);
	}

	@Override
	public int getVarietyshowCount (){
		return userVarietyshowDao.getVarietyshowCount();
	}
	@Override
	public List<Long> getFamilyIdByShowId(Long showId) {
		return userVarietyshowDao.getFamilyIdByShowId(showId);
	}

}
