package org.test.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.test.dao.UserReadDao;
import org.test.entity.Admin;
import org.test.entity.Page;
import org.test.entity.Resultmsg;
@Service
public class UserReadPageImpl implements UserReadPage {
	@Resource
	UserReadDao urd;
	public Resultmsg getReadPage(Integer currentPage) {
		int rows = urd.UserCount();
		Page page = new Page();
		Page page2 = new Page();
		page2.setRows(rows);
		page.setRows(rows);
		page.setCurrentPage(currentPage);
		Integer TotalPage = page2.getTotalPage();
		List<Admin> adminListPage = urd.UserReadPage(page);
		List<Admin> adminList = urd.UserReadPage(page);
		Resultmsg rt = new Resultmsg();
		rt.setData(adminListPage);
		rt.setMsg("yes");
		rt.setCurrentPage(TotalPage);
		return rt;
	}

}
