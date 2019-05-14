package com.service;

import java.util.List;

import com.dao.TeacherDao;
import com.entry.Teacher;

public class TeacherService {
	TeacherDao teacherDao = new TeacherDao();
	/**
	 * 根据code删除学生
	 * @param code 学生编号
	 */
	public void delete(String code) {
		teacherDao.delect(code);
	}
	public void add(Teacher t) {
		teacherDao.add(t);
	}
	public void update(Teacher t) {
		teacherDao.update(t);
	}
	public Teacher query(String code) {
		return teacherDao.query(code);
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
		int rowCount = teacherDao.getTotal(sname);
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
		public List<Teacher> queryAll(String sname,String pageNowStr, int pageSize) {
		try {
			return teacherDao.queryAll(sname,pageNowStr, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	} 
	
}
