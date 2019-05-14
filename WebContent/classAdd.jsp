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
<title>添加班级信息</title>
</head>
<body bgcolor=#BBFFFF>
	<form action="AddServlet" method="post">
		添加新的班级名:<input type="text" name="name" id="nameId" /><br />
		添加新的班级编号:<input type="text" name="code" id="codeId" /><br />
		添加新的班主任:<input type="text" name="classteacher" id="classteacherId" /><br />
		<input type="submit" value="添加"> <input type="reset"
			value="重置">
	</form>
</body>
</html>