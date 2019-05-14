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
<title>班级管理</title>
</head>
<script src="js/jquery-2.2.4.js"></script>
		<script>
			$(function (){ //表示页面节点(元素,dom,标签) 加载完成,自动会执行这里面的内容
				$.ajax({
					type:"POST",//请求方式为post
					url:"/jsp/classesqueryservlet",//请求url
					dataType:'JSON',//数据格式为json
					async:false,//是否同步，false表示为异步
					data:{"a":1},
					success : function(data){ //function为一个回调函数，data表示为请求servlet后，servlet中返回回来的值
						var cont='';
						$.each(data,function(i,obj){
							cont=cont+'<tr>';
							cont=cont+'<td>'+obj.code+'</td>';
							cont=cont+'<td>'+obj.name+'</td>';
							cont=cont+'<td>'+obj.classteacher+'</td>';
							cont=cont+'</tr>';
					});
						$("#tbodyId").html(cont);
					}
				});
			});
			
		</script>
<body bgcolor=#BBFFFF>
	<h1 align="center">
		<font size="6">欢迎使用班级管理:</font>
	</h1>
	<form action="classesqueryservlet" method="post">
		<h1 align="center">
			<font size="4">输入班级姓名</font><input type="text" name="sname"
				id="accountId" value="${ss}" /><input type="submit" value="搜索" />
			<input type="reset" value="重置" />
		</h1>
	</form>
	<h1 align="center">
		<a href="classAdd.jsp">添加信息</a>
	</h1>
	<table border="3"align="center" width="300" height="150">
		<tr>
			<td>编号</td>
			<td>班级名</td>
			<td>班主任</td>
			<td>修改</td>
		</tr>
			<tr>
				<tbody id="tbodyId"></tbody>
				<td><a href='updateclass?code=${a.code}'>修改信息</a></td>
			</tr>
	</table>
	<a href="ClassPageServlet?pageNow=1">首页</a>
	<c:if test="${pageNow>=2}" var="result">
		<a href="ClassPageServlet?pageNow=${pageNow-1}">上一页</a>
	</c:if>
	<c:if test="${pageNow+1<=pageCount}" var="result">
		<a href="ClassPageServlet?pageNow=${pageNow}">${pageNow}</a>
		<a href="ClassPageServlet?pageNow=${pageNow+1}">${pageNow+1}</a>
		<c:if test="${pageNow+2<=pageCount}" var="result">
			<a href="ClassPageServlet?pageNow=${pageNow+2}">${pageNow+2}</a>
		</c:if>
		<c:if test="${pageNow+3<=pageCount}" var="result">
			<a href="ClassPageServlet?pageNow=${pageNow+3}">${pageNow+3}</a>
		</c:if>
		<a href="ClassPageServlet?pageNow=${pageNow+1}">下一页</a>
	</c:if>
	<a href="ClassPageServlet?pageNow=${pageCount}">尾页</a>
</body>
</html>