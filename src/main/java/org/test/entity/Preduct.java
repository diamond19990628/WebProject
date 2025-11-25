package org.test.entity;

import java.io.Serializable;

public class Preduct implements Serializable{
	private Integer id;
	private String pnumber;
	private Integer prestore;
	private Integer basic;
	private String status;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPnumber() {
		return pnumber;
	}

	public void setPnumber(String pnumber) {
		this.pnumber = pnumber;
	}

	public Integer getPrestore() {
		return prestore;
	}

	public void setPrestore(Integer prestore) {
		this.prestore = prestore;
	}

	public Integer getBasic() {
		return basic;
	}

	public void setBasic(Integer basic) {
		this.basic = basic;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Preduct [id=" + id + ", pnumber=" + pnumber + ", prestore="
				+ prestore + ", basic=" + basic + ", status=" + status + "]";
	}
	
	
	
}
