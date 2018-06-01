package com.li.vo;

import java.util.Date;
import java.util.List;

import com.li.model.Family;
import com.li.model.User;
import com.li.model.UserVarietyshow;

public class UserVarietyshowVo {
	/**
	 * 节目id
	 */
	private Long id;

	/**
	 * 节目名称
	 */
	private String name;
	 /**
     * 节目区域
     */
    private String area;
    
    private Integer status;
    
    private Long familyId;
	/**
	 * 节目开播时间
	 */
	private Date createTime;
	/**
	 * 节目参与用户
	 */
	private List<Family> familyList;
	
	/**
	 * 节目参与用户人数
	 */
	private Integer userCnt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getFamilyId() {
		return familyId;
	}

	public void setFamilyId(Long familyId) {
		this.familyId = familyId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public List<Family> getFamilyList() {
		return familyList;
	}

	public void setFamilyList(List<Family> familyList) {
		this.familyList = familyList;
	}

	public Integer getUserCnt() {
		return userCnt;
	}

	public void setUserCnt(Integer userCnt) {
		this.userCnt = userCnt;
	}
}
