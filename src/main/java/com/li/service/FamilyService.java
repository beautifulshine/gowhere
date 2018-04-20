package com.li.service;

import com.li.model.Family;

public interface FamilyService {
	/**
	 * 根据id获取某个家庭组
	 */
	  Family selectByPrimaryKey(Long id);
}
