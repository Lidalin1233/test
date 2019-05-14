package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.entry.Classs;

public class ClassDao extends BaseDao {
	Classs cls = new Classs();

	public Classs add(String code, String name, String classteacher) {
		try {
			Connection conn = getConn();
			Statement st = conn.createStatement();
			String sql = "insert into classs(code,name,classteacher)values('" + code + "'" + "," + "'" + name + "'"
					+ "," + "'" + classteacher + "')";
			st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = st.getGeneratedKeys();
			while (rs.next()) {
				cls.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cls;
	}
	public void update(String code, String newname, String newclassteacher) {
		try {
			Connection conn = getConn();
			Statement st = conn.createStatement();
			String sql = "update classs set name='" + newname + "',classteacher=' " + newclassteacher + "' where code='"
					+ code + "';";
			st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Classs query(String code) {
		try {
			Connection conn = getConn();
			Statement st = conn.createStatement();
			String sql = "select * from classs where code='" +code+ "'";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				cls.setCode(rs.getString(2));
				cls.setName(rs.getString(3));
				cls.setClassteacher(rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cls;
	}
	public List<Classs> qq() {
		try {
			Connection conn = getConn();
			Statement st = conn.createStatement();
			String sql = "select * from classs ";
			ResultSet rs = st.executeQuery(sql);
			List<Classs>dataList=new ArrayList<>();
			while (rs.next()) {
				Classs s=new Classs();
				s.setCode(rs.getString(2));
				s.setName(rs.getString(3));
				s.setClassteacher(rs.getString(4));
				dataList.add(s);
			}
			return dataList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
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
	public List<Classs>queryAll(String sname,String pageNowStr,int pageSize){
		int pageNow=Integer.parseInt(pageNowStr);
		try {
			Statement st = getConn().createStatement();
			String sql="select * from classs WHERE 1=1 ";
			if(sname!=null) {
				sql+="and name like '%"+sname+"%'"; 
			}
			sql+=" limit "+(pageNow-1)*pageSize+","+pageSize;
			ResultSet rs=st.executeQuery(sql);
			List<Classs>dataList=new ArrayList<>();
			while(rs.next()) {
				Classs s=new Classs();
				s.setName(rs.getString(3));
				s.setClassteacher(rs.getString(4));
				s.setCode(rs.getString(2));	
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
			String sql="select count(*) from classs where 1=1 ";
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