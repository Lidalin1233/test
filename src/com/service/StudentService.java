package com.service;

import java.util.List;

import com.dao.StudentDao;
import com.entry.Student;

public class StudentService {
	StudentDao studentDao = new StudentDao();
	/**
	 * ����codeɾ��ѧ��
	 * @param code ѧ�����
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
	 * �õ���ҳ��
	 * 
	 * @param pageSizeStr
	 *            ÿҳ����������
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
	 * ��ȡ���е�����(��ҳ)
	 * 
	 * @param pageNowStr
	 *            ��ǰҳ��
	 * @param pageSize
	 *            ÿҳ��������
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
