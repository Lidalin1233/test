package com.service;

import java.util.List;

import com.dao.ClassDao;
import com.entry.Classs;

public class ClassService {
	ClassDao classDao = new ClassDao();

	public void add(String code, String name, String classteacher) {
		classDao.add(code, name, classteacher);
	}

	public void update(String code, String newname, String newclassteacher) {
		classDao.update(code, newname, newclassteacher);
	}

	public Classs query(String code) {
		return classDao.query(code);
	}

	public List<Classs> qq() {
		return classDao.qq();
	}

	/**
	 * �õ���ҳ��
	 * 
	 * @param pageSizeStr ÿҳ����������
	 * @return
	 */

	public Integer getCount(String sname, int pageSize) {
		int pageCount = 0;
		int rowCount = classDao.getTotal(sname);
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
	 * @param pageNowStr ��ǰҳ��
	 * @param pageSize   ÿҳ��������
	 * @return
	 */
	public List<Classs> queryAll(String sname, String pageNowStr, int pageSize) {
		try {
			return classDao.queryAll(sname, pageNowStr, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
