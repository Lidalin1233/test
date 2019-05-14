package com.service;

import java.util.List;

import com.dao.EmpDao;
import com.entry.Emp;

public class EmpService {
	EmpDao EmpDao = new EmpDao();
	/**
	 * 根据number删除职工
	 * @param number 职工编号
	 */
	public void delete(String number) {
		EmpDao.delect(number);
	}
	public void add(Emp t) {
		EmpDao.add(t);
	}
	public void update(Emp t) {
		EmpDao.update(t);
	}
	public Emp query(String number) {
		return EmpDao.query(number);
	}
	/**
	 * 得到总页数
	 * 
	 * @param pageSizeStr
	 *            每页多少条数据
	 * @return
	 */
EmpDao teacherD=new EmpDao();
	public Integer getCount(String sname,int pageSize) {
		int pageCount = 0;
		int rowCount = teacherD.getTotal(sname);
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
		public List<Emp> queryAll(String sname,String pageNowStr, int pageSize) {
		try {
			return EmpDao.queryAll(sname,pageNowStr, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	} 
	
}
