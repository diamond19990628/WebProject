package org.test.dao;

import org.test.entity.Admin;

public interface RegisterDao {
	public void UserRegister(Admin admin);
	
	public Admin UsernameRead(Admin admin);
}
