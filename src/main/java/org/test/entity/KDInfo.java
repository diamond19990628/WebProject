package org.test.entity;

public class KDInfo {
	private Integer id;
	private String username;
	private String idcard;
	private String phonenumber;
	private String kdspeed;
	private String kdfy;
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
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getKdspeed() {
		return kdspeed;
	}
	public void setKdspeed(String kdspeed) {
		this.kdspeed = kdspeed;
	}
	public String getKdfy() {
		return kdfy;
	}
	public void setKdfy(String kdfy) {
		this.kdfy = kdfy;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "KDInfo [id=" + id + ", username=" + username + ", idcard="
				+ idcard + ", phonenumber=" + phonenumber + ", kdspeed="
				+ kdspeed + ", kdfy=" + kdfy + ", address=" + address + "]";
	}
	
}
