package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.entry.Company;

public class CompanyDao extends BaseDao {
	Company company = new Company();

	public Company add(Company com) {
		try {
			Connection conn = getConn();
			Statement st = conn.createStatement();
			String sql = "insert into company(name,tel)values('" + com.getName() + "'" + "," + "'" + com.getTel()
					+ "')";
			st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = st.getGeneratedKeys();
			while (rs.next()) {
				com.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return com;
	}

	public void update(Company em) {
		try {
			Connection conn = getConn();
			Statement st = conn.createStatement();
			String sql = "update company set name='" + em.getName() + "',tel=' " + em.getTel() + "' where id='"
					+ em.getId() + "';";
			st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(String id) {
		try {
			Statement st = getConn().createStatement();
			String sql = "delete  from company where id='" + id + "';";
			st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Company query(String id) {
		try {
			Connection conn = getConn();
			Statement st = conn.createStatement();
			String sql = "select * from company where id='" + id + "'; ";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				company.setId(rs.getInt(1));
				company.setName(rs.getString(2));
				company.setTel(rs.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return company;
	}

	/**
	 * 获取所有的数据(分页)
	 * 
	 * @param pageNowStr 当前页数
	 * @param pageSize   每页数据条数
	 * @return
	 */
	public List<Company> queryAll(Company c, int pageNowStr, int pageSize) {
		int pageNow = pageNowStr;
		try {
			Statement st = getConn().createStatement();
			String sql = "select * from company WHERE 1=1 ";
			if (c.getName() != null) {
				sql += "and name like '%" + c.getName() + "%'";
			}
			sql += " limit " + (pageNow - 1) * pageSize + "," + pageSize;
			ResultSet rs = st.executeQuery(sql);
			List<Company> dataList = new ArrayList<>();
			while (rs.next()) {
				Company t = new Company();
				t.setId(rs.getInt(1));
				t.setName(rs.getString(2));
				t.setTel(rs.getString(3));
				dataList.add(t);
			}
			return dataList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 得到总数据条数
	 * 
	 * @return
	 */
	public int getTotal(Company c) {
		int rowCount = 0;
		try {
			Statement st = getConn().createStatement();
			String sql = "select count(*) from company where 1=1 ";
			if (c.getName() != null) {
				sql += "and name like '%" + c.getName() + "%'";
			}
			ResultSet countRs = st.executeQuery(sql);
			if (countRs.next()) {
				rowCount = countRs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowCount;
	}
}
