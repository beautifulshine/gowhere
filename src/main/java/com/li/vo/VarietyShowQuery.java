package com.li.vo;

import java.util.Date;

public class VarietyShowQuery {
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
    /**
     * 家庭id
     */
    private Long familyId;
    /**
     * 节目开播时间
     */
    private Date createTime;
    
    /**
     * 页码
     */
    private Integer page;
    
    /**
     * 页面大小，默认10条
     */
    private Integer pageSize = 10;
    
    /**
     * 开始查询的位置
     */
    private Integer startNum;
    
    
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
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getStartNum() {
		return startNum;
	}
	public void setStartNum(Integer startNum) {
		this.startNum = startNum;
	}
    
}
