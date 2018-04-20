package com.li.service;

import java.util.List;
import java.util.Map;

import com.li.model.UserVarietyshow;



public interface UserVarietyshowService {

	/**
     * 加载全部的节目列表
     * @return
     */
    List<UserVarietyshow> loadVarietyshowList(Map<String, Object> map);
    /**
     * 获得总的记录数
     * @return
     */
        int getVarietyshowCount();
    /**
     * 显示节目详情
     * @param id
     * @return
     */
        UserVarietyshow selectByPrimaryKey(Long id);
}
