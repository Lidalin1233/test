<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page import="java.sql.*"%>
<%@page import=" java.util.List"%>
<%@page import="com.dao.*"%>
<%@page import="com.service.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="mytag" uri="WEB-INF/myTld/myTld.tld"%>
<html>
<head>
<title>添加学生信息</title>
</head>
<body bgcolor=#BBFFFF>
	<form action="StudentAddServlet"method="post">
		添加新的学生名:<input type="text" name="name" id="nameId" /><br />
		添加新的地址:<input type="text" name="addr" id="addrId" /><br />
		添加新的电话:<input type="text" name="tel" id="telId" /><br />
		添加新的班级:<mytag:studentSel name="studentname" id="aa" onchangeFun="yy();" /><br />
		<script type="text/javascript">
		function yy(){
			var r=document.getElementById("aa").value;
		}
		</script>
		添加新的学号:<input type="text" name="code" id="codeId" /><br />
		<input type="submit" value="添加"> <input type="reset"
			value="重置">
	</form>
</body>
</html>