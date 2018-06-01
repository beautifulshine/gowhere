package com.li.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.li.dao.VarietyshowMapper;
import com.li.model.Varietyshow;
import com.li.service.VarietyshowService;
import com.li.vo.Page;
import com.li.vo.UserVarietyshowVo;
import com.li.vo.VarietyShowQuery;
@Service("varietyshowService")
public class VarietyshowServiceImpl implements VarietyshowService {
@Resource
private VarietyshowMapper varietyshowMapper;


	@Override
	public Varietyshow selectByPrimaryKey(Long id) {
		return varietyshowMapper.selectByPrimaryKey(id);
	}
	@Override
	public Page<UserVarietyshowVo> getUserVarietyshowList(VarietyShowQuery query) {
		
		Page<UserVarietyshowVo> page = new Page<>(query.getPage(), query.getPageSize());//java.lang.NullPointerException
		query.setStartNum(page.getStartNum());
		
		int total = varietyshowMapper.getUserVarietyshowCount(query);
		List<UserVarietyshowVo> userVarietyshowList = varietyshowMapper.getUserVarietyshowList(query);
		
		page.setItemTotal(total);
        page.setPageTotal(page.getPageTotal());
        page.setPageSize(query.getPageSize());
        page.setList(userVarietyshowList);
        
        return page;
	}
	@Override
	public int getUserVarietyshowCount(VarietyShowQuery query) {
		
		return varietyshowMapper.getUserVarietyshowCount(query);
	}

}
