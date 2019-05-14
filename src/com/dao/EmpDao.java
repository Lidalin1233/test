package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.entry.Emp;


public class EmpDao extends BaseDao {
	Emp emp = new Emp();

	public Emp add(Emp em) {
		try {
			Connection conn = getConn();
			Statement st = conn.createStatement();
			String sql = "insert into emp(number,tel,addr,zw,name)values('" + em.getNumber() + "'" + "," + "'" + em.getTel() + "'"
					+ "," + "'" + em.getAddr()+"','"+em.getZw()+"','"+em.getName() + "')";
			st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = st.getGeneratedKeys();
			while (rs.next()) {
				em.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return em;
	}

	public void update(Emp em) {
		try {
			Connection conn = getConn();
			Statement st = conn.createStatement();
			String sql = "update emp set tel='" + em.getTel() + "',addr='" +em.getAddr() +"',number='"+em.getNumber()+"',name='"+em.getName()+ "' where number='"
					+ em.getNumber() + "';";
			st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void delect(String number) {
		try {
			Statement st = getConn().createStatement();
			String sql = "delete  from emp where number='"+number+"';";
			st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Emp query(String number) {
		try {
			Connection conn = getConn();
			Statement st = conn.createStatement();
			String sql = "select * from emp where number='" +number+ "'; ";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				emp.setAddr(rs.getString(4));
				emp.setName(rs.getString(2));
				emp.setTel(rs.getString(3));
				emp.setZw(rs.getString(5));
				emp.setNumber(rs.getString(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
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
	public List<Emp>queryAll(String sname,String pageNowStr,int pageSize){
		int pageNow=Integer.parseInt(pageNowStr);
		try {
			Statement st = getConn().createStatement();
			String sql="select * from emp WHERE 1=1 ";
			if(sname!=null) {
				sql+="and name like '%"+sname+"%'"; 
			}
			sql+=" limit "+(pageNow-1)*pageSize+","+pageSize;
			ResultSet rs=st.executeQuery(sql);
			List<Emp>dataList=new ArrayList<>();
			while(rs.next()) {
				Emp t=new Emp();
				t.setAddr(rs.getString(4));
				t.setName(rs.getString(2));
				t.setTel(rs.getString(3));
				t.setZw(rs.getString(5));
				t.setNumber(rs.getString(6));
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
	public int getTotal(String sname) {
		int rowCount=0;
		try {
			Statement st = getConn().createStatement();
			String sql="select count(*) from emp where 1=1 ";
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
