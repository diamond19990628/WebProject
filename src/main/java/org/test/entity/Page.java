package org.test.entity;

public class Page {
	
	private Integer currentPage=1;
	private Integer pageSize=5;
	private Integer begin;
	private Integer end;
	private Integer rows;
	private Integer totalPage;
	
	
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	
	public Integer getTotalPage() {
		if(rows%pageSize==0){
			totalPage = rows/pageSize;
		}else{
			totalPage = rows/pageSize+1;
		}
		return totalPage;
	}
	
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	public Integer getBegin() {
		begin=(currentPage-1)*pageSize;
		return begin;
	}
	public void setBegin(Integer begin) {
		this.begin = begin;
	}
	
	public Integer getEnd() {
		end=currentPage*pageSize+1;
		return end;
	}
	public void setEnd(Integer end) {
		this.end = end;
	}
	
	
}
