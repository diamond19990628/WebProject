package org.test.entity;

public class UserPreduct {
	private Integer id;
	private String username;
	private String idcard;
	private String phone;
	private String amount;
	private String basic;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getBasic() {
		return basic;
	}
	public void setBasic(String basic) {
		this.basic = basic;
	}
	@Override
	public String toString() {
		return "UserPreduct [id=" + id + ", username=" + username + ", idcard="
				+ idcard + ", phone=" + phone + ", amount=" + amount
				+ ", basic=" + basic + "]";
	}
	
	
}
