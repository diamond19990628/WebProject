package org.test.entity;

public class UserPreductInfo {
	private Integer id;
	private String username;
	private String age;
	private String sex;
	private String idcard;
	private String telep;
	private String address;
	private String phone;
	private Integer amount;
	private Integer basic;
	private String handletime;
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
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Integer getBasic() {
		return basic;
	}
	public void setBasic(Integer basic) {
		this.basic = basic;
	}
	public String getHandletime() {
		return handletime;
	}
	public void setHandletime(String handletime) {
		this.handletime = handletime;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTelep() {
		return telep;
	}
	public void setTelep(String telep) {
		this.telep = telep;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "UserPreductInfo [id=" + id + ", username=" + username
				+ ", age=" + age + ", sex=" + sex + ", idcard=" + idcard
				+ ", telep=" + telep + ", address=" + address + ", phone="
				+ phone + ", amount=" + amount + ", basic=" + basic
				+ ", handletime=" + handletime + "]";
	}
	
	
	
	
}
