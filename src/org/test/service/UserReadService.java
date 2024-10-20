package org.test.service;

import org.springframework.stereotype.Service;
import org.test.entity.Resultmsg;

@Service
public interface UserReadService {
	public Resultmsg UserRead();
}
