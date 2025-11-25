package org.test.entity;

public class Resultmsg {
	Object data;
	String msg;
	String status;
	Integer currentPage;
	
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Resultmsg [data=" + data + ", msg=" + msg + ", status="
				+ status + "]";
	}
	
	
	
}
