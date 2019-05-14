package com.service;

import java.util.List;

import com.dao.CompanyDao;
import com.entry.Company;

public class CompanyService {
	CompanyDao companyDao = new CompanyDao();
	/**
	 * 根据number删除职工
	 * @param number 职工编号
	 */
	public void delete(String id) {
		companyDao.delete(id);
	}
	public void add(Company t) {
		companyDao.add(t);
	}
	public void update(Company t) {
		companyDao.update(t);
	}
	public Company query(String id) {
		return companyDao.query(id);
	}
	/**
	 * 得到总页数
	 * 
	 * @param pageSizeStr
	 *            每页多少条数据
	 * @return
	 */
CompanyDao cd=new CompanyDao();
	public Integer getCount(Company c,int pageSize) {
		int pageCount = 0;
		int rowCount = cd.getTotal(c);
		if ((rowCount % pageSize) == 0) {
			pageCount = rowCount / pageSize;
		} else {
			pageCount = rowCount / pageSize + 1;
		}
		return pageCount;
	}
	/**
	 * 获取所有的数据(分页)
	 * 
	 * @param pageNowStr
	 *            当前页数
	 * @param pageSize
	 *            每页数据条数
	 * @return
	 */
		public List<Company> queryAll(Company c,int pageNowStr, int pageSize) {
		try {
			return companyDao.queryAll(c,pageNowStr, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	} 
	
}
