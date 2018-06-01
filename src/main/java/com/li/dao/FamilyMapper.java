package com.li.dao;

import java.util.List;
import java.util.Map;

import com.li.model.Family;

public interface FamilyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Family record);

    int insertSelective(Family record);
    //单个家庭组
    Family selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Family record);

    int updateByPrimaryKey(Family record);
    // 家庭组列表
    List<Family> loadFamilyList(Map<String, Object> map);
   /**
    *根据家庭组id得到家庭组列表
    * @param familyIds
    * @return
    */
    public List<Family> batchGetFamilyListByIds(List<Long> familyIds);
}