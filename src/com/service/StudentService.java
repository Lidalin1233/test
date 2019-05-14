package com.service;

import java.util.List;

import com.dao.StudentDao;
import com.entry.Student;

public class StudentService {
	StudentDao studentDao = new StudentDao();
	/**
	 * 根据code删除学生
	 * @param code 学生编号
	 */
	public void delete(String code) {
		studentDao.delect(code);
	}
	public void add(Student s) {
		studentDao.add(s);
	}
	public void update(Student s) {
		studentDao.update(s);
	}
	public Student query(String code) {
		return studentDao.query(code);
	}
	/**
	 * 得到总页数
	 * 
	 * @param pageSizeStr
	 *            每页多少条数据
	 * @return
	 */
StudentDao cps=new StudentDao();
	public Integer getCount(String sname,int pageSize) {
		int pageCount = 0;
		int rowCount = cps.getTotal(sname);
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
		public List<Student> queryAll(String sname,String pageNowStr, int pageSize) {
		try {
			return cps.queryAll(sname,pageNowStr, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	} 
	
}
