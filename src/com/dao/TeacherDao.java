package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.entry.Teacher;


public class TeacherDao extends BaseDao {
	Teacher teacher = new Teacher();

	public Teacher add(Teacher t) {
		try {
			Connection conn = getConn();
			Statement st = conn.createStatement();
			String sql = "insert into teacher(code,tel,name)values('" + t.getCode() + "'" + "," + "'" + t.getTel() + "'"
					+ "," + "'" + t.getName()+ "')";
			st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = st.getGeneratedKeys();
			while (rs.next()) {
				teacher.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teacher;
	}

	public void update(Teacher t) {
		try {
			Connection conn = getConn();
			Statement st = conn.createStatement();
			String sql = "update teacher set tel='" + t.getTel() + "',name='" + t.getName()+ "' where code='"
					+ t.getCode() + "';";
			st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void delect(String code) {
		try {
			Statement st = getConn().createStatement();
			String sql = "delete  from teacher where code='"+code+"';";
			st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Teacher query(String code) {
		try {
			Connection conn = getConn();
			Statement st = conn.createStatement();
			String sql = "select * from teacher where code='" +code+ "'; ";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				teacher.setCode(rs.getString(2));
				teacher.setName(rs.getString(3));
				teacher.setTel(rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return teacher;
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
	public List<Teacher>queryAll(String sname,String pageNowStr,int pageSize){
		int pageNow=Integer.parseInt(pageNowStr);
		try {
			Statement st = getConn().createStatement();
			String sql="select * from teacher WHERE 1=1 ";
			if(sname!=null) {
				sql+="and name like '%"+sname+"%'"; 
			}
			sql+=" limit "+(pageNow-1)*pageSize+","+pageSize;
			ResultSet rs=st.executeQuery(sql);
			List<Teacher>dataList=new ArrayList<>();
			while(rs.next()) {
				Teacher t=new Teacher();
				t.setCode(rs.getString(2));
				t.setName(rs.getString(3));
				t.setTel(rs.getString(4));
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
			String sql="select count(*) from teacher where 1=1 ";
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
