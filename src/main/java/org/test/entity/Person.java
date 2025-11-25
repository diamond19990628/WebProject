package org.test.entity;

import org.springframework.stereotype.Controller;

@Controller
public class Person {
	private Integer id;
	private String username;
	private String sex;
	private int salary;
	private String telep;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getTelep() {
		return telep;
	}
	public void setTelep(String telep) {
		this.telep = telep;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", salary=" + salary + ", sex=" + sex
				+ ", telep=" + telep + ", username=" + username + "]";
	}
	
}
