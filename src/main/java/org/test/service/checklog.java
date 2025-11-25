package org.test.service;

import org.springframework.stereotype.Service;
import org.test.entity.Resultmsg;
@Service
public interface checklog {
	public Resultmsg getresultmsg(String username,String password);
	
	public Resultmsg getAdmin(String username);
}
