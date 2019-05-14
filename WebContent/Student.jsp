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
<title>学生管理</title>
</head>
<body bgcolor=#BBFFFF>
	欢迎使用学生管理:
	<form action="studentqueryservlet" method="post">
	输入学生姓名<input type="text" name="sname" id="accountId" value="${ss}"/>
	<input type="submit" value="搜索" /> <input type="reset" value="重置" />
	</form>
	<a href="StudentAdd.jsp">添加信息</a>
	<br>
	<table border="1">
				<tr>
					<td>编号</td>
					<td>姓名</td>
					<td>所在班级</td>
					<td>电话</td>
					<td>地址</td>
					<td>修改</td>
					<td>删除</td>
				</tr>
			<c:forEach var="a" items="${list}" varStatus="u">
				<tr>
					<td><c:out value="${a.code}" /></td>
					<td><c:out value="${a.name}" /></td>
					<td><c:out value="${a.forclass}" /></td>
					<td><c:out value="${a.tel}" /></td>
					<td><c:out value="${a.addr}" /></td>
					<td><a href='updateStudent?code=${a.code}'>修改信息</a></td>
					<td><a href='studelectServlet?code=${a.code}'>删除信息</a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="StudentPageServlet?pageNow=1">首页</a>
		<c:if test="${pageNow>=2}" var="result">
			<a href="StudentPageServlet?pageNow=${pageNow-1}">上一页</a>
		</c:if>
		<c:if test="${pageNow+1<=pageCount}" var="result">
			<a href="StudentPageServlet?pageNow=${pageNow}">${pageNow}</a>
			<a href="StudentPageServlet?pageNow=${pageNow+1}">${pageNow+1}</a>
			<c:if test="${pageNow+2<=pageCount}" var="result">
				<a href="StudentPageServlet?pageNow=${pageNow+2}">${pageNow+2}</a>
			</c:if>
			<c:if test="${pageNow+3<=pageCount}" var="result">
				<a href="StudentPageServlet?pageNow=${pageNow+3}">${pageNow+3}</a>
			</c:if>
			<a href="StudentPageServlet?pageNow=${pageNow+1}">下一页</a>
		</c:if>
		<a href="StudentPageServlet?pageNow=${pageCount}">尾页</a>
</body>
</html>