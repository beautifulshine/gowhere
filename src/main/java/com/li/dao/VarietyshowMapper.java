package com.li.dao;

import com.li.model.Varietyshow;

public interface VarietyshowMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Varietyshow record);

    int insertSelective(Varietyshow record);
//根据id获取节目详情
    Varietyshow selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Varietyshow record);

    int updateByPrimaryKey(Varietyshow record);
}