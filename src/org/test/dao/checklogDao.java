package org.test.dao;

import org.springframework.stereotype.Repository;
import org.test.entity.Admin;

@Repository
public interface checklogDao {
	public Admin checklog(Admin admin);
	
	public String checklevel(Admin admin);
}
