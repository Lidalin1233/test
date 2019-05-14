package com.service;

import java.util.List;

import com.dao.TeacherDao;
import com.entry.Teacher;

public class TeacherService {
	TeacherDao teacherDao = new TeacherDao();
	/**
	 * ����codeɾ��ѧ��
	 * @param code ѧ�����
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
	 * �õ���ҳ��
	 * 
	 * @param pageSizeStr
	 *            ÿҳ����������
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
	 * ��ȡ���е�����(��ҳ)
	 * 
	 * @param pageNowStr
	 *            ��ǰҳ��
	 * @param pageSize
	 *            ÿҳ��������
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
