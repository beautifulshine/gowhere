package com.li.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.li.dao.VarietyshowMapper;
import com.li.model.Varietyshow;
import com.li.service.VarietyshowService;
@Service("varietyshowService")
public class VarietyshowServiceImpl implements VarietyshowService {
private VarietyshowMapper varietyshowMapper;

	public VarietyshowMapper getVarietyshowMapper() {
	return varietyshowMapper;
}
	 @Autowired
public void setVarietyshowMapper(VarietyshowMapper varietyshowMapper) {
	this.varietyshowMapper = varietyshowMapper;
}

	@Override
	public Varietyshow selectByPrimaryKey(Long id) {
		return varietyshowMapper.selectByPrimaryKey(id);
	}

}
