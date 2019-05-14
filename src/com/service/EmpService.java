package com.service;

import java.util.List;

import com.dao.EmpDao;
import com.entry.Emp;

public class EmpService {
	EmpDao EmpDao = new EmpDao();
	/**
	 * ����numberɾ��ְ��
	 * @param number ְ�����
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
	 * �õ���ҳ��
	 * 
	 * @param pageSizeStr
	 *            ÿҳ����������
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
	 * ��ȡ���е�����(��ҳ)
	 * 
	 * @param pageNowStr
	 *            ��ǰҳ��
	 * @param pageSize
	 *            ÿҳ��������
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
