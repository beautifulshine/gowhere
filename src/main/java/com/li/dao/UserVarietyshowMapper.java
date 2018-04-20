package com.li.dao;

import java.util.List;
import java.util.Map;

import com.li.model.UserVarietyshow;

public interface UserVarietyshowMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserVarietyshow record);

    int insertSelective(UserVarietyshow record);
/**
 * 显示节目详情
 * @param id
 * @return
 */
    UserVarietyshow selectByPrimaryKey(Long id);
/**
 * 获得总的记录数
 * @return
 */
    int getVarietyshowCount();
    
    /**
    * 显示节目列表
    * @return
    */
       List<UserVarietyshow> loadVarietyshowList(Map<String, Object> map);
       
    
    int updateByPrimaryKeySelective(UserVarietyshow record);

    int updateByPrimaryKey(UserVarietyshow record);
}