package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.entry.Student;


public class StudentDao extends BaseDao {
	Student cls = new Student();

	public Student add(Student s) {
		try {
			Connection conn = getConn();
			Statement st = conn.createStatement();
			String sql = "insert into student(code,tel,addr,forclass,name)values('" + s.getCode() + "'" + "," + "'" + s.getTel() + "'"
					+ "," + "'" + s.getAddr()+"','"+s.getForclass()+"','"+s.getName() + "')";
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

	public void update(Student s) {
		try {
			Connection conn = getConn();
			Statement st = conn.createStatement();
			String sql = "update student set tel='" + s.getTel() + "',addr='" + s.getAddr() +"',forclass='"+s.getForclass()+"',name='"+s.getName()+ "' where code='"
					+ s.getCode() + "';";
			st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void delect(String code) {
		try {
			Statement st = getConn().createStatement();
			String sql = "delete  from student where code='"+code+"';";
			st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Student query(String code) {
		try {
			Connection conn = getConn();
			Statement st = conn.createStatement();
			String sql = "select * from student where code='" +code+ "'; ";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				cls.setCode(rs.getString(2));
				cls.setForclass(rs.getString(5));
				cls.setName(rs.getString(6));
				cls.setAddr(rs.getString(4));
				cls.setTel(rs.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cls;
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
	public List<Student>queryAll(String sname,String pageNowStr,int pageSize){
		int pageNow=Integer.parseInt(pageNowStr);
		try {
			Statement st = getConn().createStatement();
			String sql="select * from student WHERE 1=1 ";
			if(sname!=null) {
				sql+="and name like '%"+sname+"%'"; 
			}
			sql+=" limit "+(pageNow-1)*pageSize+","+pageSize;
			ResultSet rs=st.executeQuery(sql);
			List<Student>dataList=new ArrayList<>();
			while(rs.next()) {
				Student s=new Student();
				s.setCode(rs.getString(2));
				s.setForclass(rs.getString(5));
				s.setName(rs.getString(6));
				s.setAddr(rs.getString(4));
				s.setTel(rs.getString(3));
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
			String sql="select count(*) from student where 1=1 ";
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
