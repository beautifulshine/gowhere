package com.li.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Page<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 当前页码
	 */
	private int pageNum;
	/**
	 * 页面大小
	 */
	private int pageSize = 20;
	/**
	 * mysql分页记录开始的index(limit startNmu,pageSize)
	 */
	private int startNum;
	/**
	 * 总页数
	 */
	private int pageTotal;
	/**
	 * 总记录数
	 */
	private int itemTotal;
	/**
	 * 结果集
	 */
	private List<T> list;
	
	public Page(){};
	
	public Page(int pageNum,int pageSize){
		this.pageNum=pageNum>=1 ? pageNum : 1;
		if(pageSize > 0){
			this.pageSize = pageSize;
		}
		this.startNum = (pageNum-1)*pageSize;
		
		this.list = new ArrayList<T>();
		
		this.pageTotal = 0;
		this.itemTotal = 0;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		if (pageSize > 0) {//
			this.pageSize = pageSize;
		}
	}

	public int getStartNum() {
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	public int getPageTotal() {
	if (pageSize <= 0) {
			pageTotal = 1;
			return pageTotal ;
		}else{
			pageTotal = (itemTotal + pageSize -1)/pageSize;
			return pageTotal >= 0 ? pageTotal : 1;
		}
	
	}

	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}

	public int getItemTotal() {
		return itemTotal;
	}

	public void setItemTotal(int itemTotal) {
		this.itemTotal = itemTotal >=0 ? itemTotal : 0;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
	
}
