package org.test.entity;

import org.springframework.stereotype.Controller;

@Controller
public class Admin {
	private Integer id;
	private String username;
	private String password;
	private String leve;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getLeve() {
		return leve;
	}
	public void setLeve(String leve) {
		this.leve = leve;
	}
	public String getTelep() {
		return telep;
	}
	public void setTelep(String telep) {
		this.telep = telep;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", leve=" + leve + ", password=" + password
				+ ", telep=" + telep + ", username=" + username + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
