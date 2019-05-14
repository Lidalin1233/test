<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page import="java.sql.*"%>
<%@page import=" java.util.List"%>
<%@page import="com.dao.*"%>
<%@page import="com.service.*"%>
<html>
<head>
<title>添加教师信息</title>
</head>
<body bgcolor=#BBFFFF>
	<form action="TeacherAddServlet"method="post">
		添加新的编号名:<input type="text" name="code" id="codeId" /><br />
		添加新的教师名:<input type="text" name="name" id="nameId" /><br />
		添加新的电话:<input type="text" name="tel" id="telId" /><br />
		<input type="submit" value="添加"> <input type="reset"
			value="重置">
	</form>
</body>
</html>