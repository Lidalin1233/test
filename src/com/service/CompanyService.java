package com.service;

import java.util.List;

import com.dao.CompanyDao;
import com.entry.Company;

public class CompanyService {
	CompanyDao companyDao = new CompanyDao();
	/**
	 * ����numberɾ��ְ��
	 * @param number ְ�����
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
	 * �õ���ҳ��
	 * 
	 * @param pageSizeStr
	 *            ÿҳ����������
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
	 * ��ȡ���е�����(��ҳ)
	 * 
	 * @param pageNowStr
	 *            ��ǰҳ��
	 * @param pageSize
	 *            ÿҳ��������
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
