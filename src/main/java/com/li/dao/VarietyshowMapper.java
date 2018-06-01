package com.li.dao;

import java.util.List;

import com.li.model.Varietyshow;
import com.li.vo.UserVarietyshowVo;
import com.li.vo.VarietyShowQuery;


public interface VarietyshowMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Varietyshow record);

    int insertSelective(Varietyshow record);
//根据id获取节目详情
    Varietyshow selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Varietyshow record);

    int updateByPrimaryKey(Varietyshow record);
    /**
     * 根据查询条件获取节目列表
     * @param query
     * @return
     */
    List<UserVarietyshowVo> getUserVarietyshowList(VarietyShowQuery query);
  
    /**
     * 根据查询条件获取总记录数
     * @param query
     * @return
     */
    int getUserVarietyshowCount(VarietyShowQuery query);
}