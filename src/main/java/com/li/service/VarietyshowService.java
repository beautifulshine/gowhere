package com.li.service;

import com.li.model.Varietyshow;
import com.li.vo.Page;
import com.li.vo.UserVarietyshowVo;
import com.li.vo.VarietyShowQuery;

public interface VarietyshowService {
	//根据id获取节目详情
	 Varietyshow selectByPrimaryKey(Long id);
	 /**
		 * 查询节目列表
		 * @param query
		 * @return
		 */
		 Page<UserVarietyshowVo> getUserVarietyshowList(VarietyShowQuery query);
		 int getUserVarietyshowCount(VarietyShowQuery query);
}
