package com.li.service;

import java.util.List;

import com.li.model.Family;

public interface FamilyService {
	/**
	 * 根据id获取某个家庭组
	 */
	  Family selectByPrimaryKey(Long id);
	  
	  /**
	   * 根据家庭id获得家庭组列表
	   * @param familyIds
	   * @return
	   */
	  List<Family> batchGetFamilyListByIds(List<Long> familyIds);
}
