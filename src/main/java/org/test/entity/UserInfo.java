package org.test.entity;

import org.springframework.stereotype.Controller;

@Controller
public class UserInfo {
	private Integer id;
	private String username;
	private String account;
	private String idCard;
	private String age;
	private String sex;
	private String telep;
	private String address;
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
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
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
		return "UserInfo [account=" + account + ", address=" + address
				+ ", age=" + age + ", id=" + id + ", idCard=" + idCard
				+ ", sex=" + sex + ", telep=" + telep + ", username="
				+ username + "]";
	}
	
	
}
