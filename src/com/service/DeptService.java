package com.service;

import java.util.List;

import com.dao.DeptDao;
import com.entry.Dept;

public class DeptService {
	DeptDao deptDao = new DeptDao();
	/**
	 * 根据name删除部门
	 * @param name 部门名称
	 */
	public void delete(String name) {
		deptDao.delete(name);
	}
	public void add(Dept dept) {
		deptDao.add(dept);
	}
	public void update(Dept dept) {
		deptDao.update(dept);
	}
	public Dept query(String name) {
		return deptDao.query(name);
	}
	/**
	 * 得到总页数
	 * 
	 * @param pageSizeStr
	 *            每页多少条数据
	 * @return
	 */
	public Integer getCount(String sname,int pageSize) {
		int pageCount = 0;
		int rowCount = deptDao.getTotal(sname);
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
		public List<Dept> queryAll(String sname,String pageNowStr, int pageSize) {
		try {
			return deptDao.queryAll(sname,pageNowStr, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	} 
	
}
