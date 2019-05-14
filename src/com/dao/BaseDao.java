package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseDao {
	/**
	 * Á´½ÓÊý¾Ý¿â
	 */
	private static Connection conn = null;
	//private BaseDao() { }
	public static Connection getConn() {
		if (null == conn) {
			conn = buliderConn();
			return conn;
		}
		return conn;
	}
	private static Connection buliderConn () {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection coon = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test1", "root",
					"root");
			return coon;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
