package org.test.service;

import org.springframework.stereotype.Service;
import org.test.entity.Page;
import org.test.entity.Resultmsg;
@Service
public interface UserReadPage {
	public Resultmsg getReadPage(Integer currentPage);
}
