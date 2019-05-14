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
<title>教师管理</title>
</head>
<body bgcolor=#BBFFFF>
	<h1 align="center">欢迎使用教师管理:</h1>
	<form action="teacherqueryservlet" method="post">
	<h1 align="center"><font size="4">输入教师姓名<input type="text" name="sname" id="accountId" value="${ss}"/><input type="submit" value="搜索" /> <input type="reset" value="重置" /></font></h1>
	</form>
	<h1 align="center"><font size="5"><a href="teacherAdd.jsp">添加信息</a></font></h1>
	<br>
	<table border="1"align="center" width="300" height="150">
				<tr>
					<td>编号</td>
					<td>教师名</td>
					<td>电话</td>
					<td>修改</td>
					<td>删除</td>
				</tr>
			<c:forEach var="a" items="${list}" varStatus="u">
				<tr>
					<td><c:out value="${a.code}" /></td>
					<td><c:out value="${a.name}" /></td>
					<td><c:out value="${a.tel}" /></td>
					<td><a href='teacherupdate?code=${a.code}'>修改信息</a></td>
					<td><a href='teacherdelete?code=${a.code}'>删除信息</a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="TeacherPageServlet?pageNow=1">首页</a>
		<c:if test="${pageNow>=2}" var="result">
			<a href="TeacherPageServlet?pageNow=${pageNow-1}">上一页</a>
		</c:if>
		<c:if test="${pageNow+1<=pageCount}" var="result">
			<a href="TeacherPageServlet?pageNow=${pageNow}">${pageNow}</a>
			<a href="TeacherPageServlet?pageNow=${pageNow+1}">${pageNow+1}</a>
			<c:if test="${pageNow+2<=pageCount}" var="result">
				<a href="TeacherPageServlet?pageNow=${pageNow+2}">${pageNow+2}</a>
			</c:if>
			<c:if test="${pageNow+3<=pageCount}" var="result">
				<a href="TeacherPageServlet?pageNow=${pageNow+3}">${pageNow+3}</a>
			</c:if>
			<a href="TeacherPageServlet?pageNow=${pageNow+1}">下一页</a>
		</c:if>
		<a href="TeacherPageServlet?pageNow=${pageCount}">尾页</a>
</body>
</html>