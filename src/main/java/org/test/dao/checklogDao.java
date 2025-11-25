package org.test.dao;

import org.springframework.stereotype.Repository;
import org.test.entity.Admin;

@Repository
public interface checklogDao {
	public Admin checklog(Admin admin);
	
	public String checklevel(Admin admin);
	
	public void changestatus(String username);
	
	public Admin getAdmin(String username);
	
	public String StatusRead(Admin admin);
}
