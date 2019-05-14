<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page import="java.sql.*"%>
<%@page import=" java.util.List"%>
<%@page import="com.dao.*"%>
<%@page import="com.service.*"%>
<!-- User user=new User(); -->
<html>
<head>
<title>添加员工信息</title>
</head>
<body bgcolor=#BBFFFF>
	<form action="EmpAddServlet"method="post">
		添加新的员工名:<input type="text" name="name" id="nameId" /><br />
		添加新的地址:<input type="text" name="addr" id="addrId" /><br />
		添加新的电话:<input type="text" name="tel" id="telId" /><br />
		添加新的职位:<input type="text" name="zw" id="zwId" /><br />
		添加新的身份证号:<input type="text" name="number" id="numberId" /><br />
		<input type="submit" value="添加"><input type="reset"
			value="重置">
	</form>
</body>
</html>