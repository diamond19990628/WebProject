package org.test.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.test.entity.Page;

@Repository
public interface UserReadDao {
	public List UserRead();
	
	public List UserReadPage(Page page);
	public int UserCount();
}
