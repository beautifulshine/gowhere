package com.li.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.li.dao.FamilyMapper;
import com.li.model.Family;
import com.li.service.FamilyService;
@Service("familyService")
public class FamilyServiceImpl implements FamilyService{
/**
 * 
 */
	@Resource
	private FamilyMapper familyMapper;


@Override
public Family selectByPrimaryKey(Long id) {
	return familyMapper.selectByPrimaryKey(id);
}
@Override
public List<Family> batchGetFamilyListByIds(List<Long> familyIds) {
	return familyMapper.batchGetFamilyListByIds(familyIds);
}
	
	

}
