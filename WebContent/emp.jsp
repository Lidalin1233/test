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
<title>职工管理</title>
</head>
<body bgcolor=#BBFFFF>
	<h1 align="center">欢迎使用职工管理:</h1>
	<form action="empqueryservlet" method="post">
	<h1 align="center"><font size="4">输入职工姓名<input type="text" name="sname" id="accountId" value="${ss}"/><input type="submit" value="搜索" /> <input type="reset" value="重置" /></font></h1>
	</form>
	<h1 align="center"><font size="5"><a href="empAdd.jsp">添加信息</a></font></h1>
	<br>
	<table border="3" align="center" width="400" height="150">
				<tr>
					<td>身份证</td>
					<td>姓名</td>
					<td>电话</td>
					<td>地址</td>
					<td>职位</td>
					<td>修改</td>
					<td>删除</td>
				</tr>
			<c:forEach var="a" items="${list}" varStatus="u">
				<tr>
					<td><c:out value="${a.number}" /></td>
					<td><c:out value="${a.name}" /></td>
					<td><c:out value="${a.tel}" /></td>
					<td><c:out value="${a.addr}" /></td>
					<td><c:out value="${a.zw}" /></td>
					<td><a href='empUpdate?number=${a.number}'>修改信息</a></td>
					<td><a href='empdelectServlet?number=${a.number}'>删除信息</a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="EmpPageServlet?pageNow=1">首页</a>
		<c:if test="${pageNow>=2}" var="result">
			<a href="EmpPageServlet?pageNow=${pageNow-1}">上一页</a>
		</c:if>
		<c:if test="${pageNow+1<=pageCount}" var="result">
			<a href="EmpPageServlet?pageNow=${pageNow}">${pageNow}</a>
			<a href="EmpPageServlet?pageNow=${pageNow+1}">${pageNow+1}</a>
			<c:if test="${pageNow+2<=pageCount}" var="result">
				<a href="EmpPageServlet?pageNow=${pageNow+2}">${pageNow+2}</a>
			</c:if>
			<c:if test="${pageNow+3<=pageCount}" var="result">
				<a href="EmpPageServlet?pageNow=${pageNow+3}">${pageNow+3}</a>
			</c:if>
			<a href="EmpPageServlet?pageNow=${pageNow+1}">下一页</a>
		</c:if>
		<a href="EmpPageServlet?pageNow=${pageCount}">尾页</a>
</body>
</html>