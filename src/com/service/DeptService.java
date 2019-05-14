package com.service;

import java.util.List;

import com.dao.DeptDao;
import com.entry.Dept;

public class DeptService {
	DeptDao deptDao = new DeptDao();
	/**
	 * ����nameɾ������
	 * @param name ��������
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
	 * �õ���ҳ��
	 * 
	 * @param pageSizeStr
	 *            ÿҳ����������
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
	 * ��ȡ���е�����(��ҳ)
	 * 
	 * @param pageNowStr
	 *            ��ǰҳ��
	 * @param pageSize
	 *            ÿҳ��������
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
