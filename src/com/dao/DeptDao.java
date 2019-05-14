package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.entry.Dept;

public class DeptDao extends BaseDao {
	Dept dept = new Dept();

	public Dept add(Dept d) {
		try {
			Connection conn = getConn();
			Statement st = conn.createStatement();
			String sql = "insert into dept(name,addr,tel)values('" + d.getName() + "'" + "," + "'" + d.getAddr() + "'"
					+ "," + "'" + d.getTel() + "')";
			st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = st.getGeneratedKeys();
			while (rs.next()) {
				dept.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dept;
	}

	public void delete(String name) {
		try {
			Statement st = getConn().createStatement();
			String sql = "delete  from dept where name='"+name+"';";
			st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void update(Dept d) {
		try {
			Connection conn = getConn();
			Statement st = conn.createStatement();
			String sql = "update dept set addr='" + d.getAddr() + "',tel=' " + d.getTel() + "' where name='"
					+ d.getName() + "';";
			st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Dept query(String name) {
		try {
			Connection conn = getConn();
			Statement st = conn.createStatement();
			String sql = "select * from dept where name='" +name+ "'; ";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				dept.setName(rs.getString(2));
				dept.setAddr(rs.getString(3));
				dept.setTel(rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dept;
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
	public List<Dept>queryAll(String sname,String pageNowStr,int pageSize){
		int pageNow=Integer.parseInt(pageNowStr);
		try {
			Statement st = getConn().createStatement();
			String sql="select * from dept WHERE 1=1 ";
			if(sname!=null) {
				sql+="and name like '%"+sname+"%'"; 
			}
			sql+=" limit "+(pageNow-1)*pageSize+","+pageSize;
			ResultSet rs=st.executeQuery(sql);
			List<Dept>dataList=new ArrayList<>();
			while(rs.next()) {
				Dept s=new Dept();
				s.setName(rs.getString(2));
				s.setAddr(rs.getString(3));
				s.setTel(rs.getString(4));
				dataList.add(s);
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
	public int getTotal(String sname) {
		int rowCount=0;
		try {
			Statement st = getConn().createStatement();
			String sql="select count(*) from dept where 1=1 ";
			if(sname!=null) {
				sql+="and name like '%"+sname+"%'";
			}
			ResultSet countRs = st.executeQuery(sql);
			if(countRs.next()) {
				rowCount=countRs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowCount;
	}
}
