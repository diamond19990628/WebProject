package org.test.service;

import org.springframework.stereotype.Service;
import org.test.entity.Admin;
import org.test.entity.Resultmsg;
@Service
public interface RegisterService {
	public Resultmsg getResultmsg(String username,String password);
}
