package com.li.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.li.dao.FamilyMapper;
import com.li.model.Family;
import com.li.service.FamilyService;
@Service("familyService")
public class FamilyServiceImpl implements FamilyService{
/**
 * 
 */
	private FamilyMapper familyMapper;

public FamilyMapper getFamilyMapper() {
	return familyMapper;
}
@Autowired
public void setFamilyMapper(FamilyMapper familyMapper) {
	this.familyMapper = familyMapper;
}

@Override
public Family selectByPrimaryKey(Long id) {
	return familyMapper.selectByPrimaryKey(id);
}
	
	

}
