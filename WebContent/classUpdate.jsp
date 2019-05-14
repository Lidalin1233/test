<%@ page language="java" contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>修改</title>
</head>
<body bgcolor=#BBFFFF>

	<form action="updateClass1" method="post">
		<input type="hidden" name="code" value="${classs.code} ">
		输入新的班级名:<input type="text" name="newname" id="accountId"value="${classs.name}" /><br />
		 输入新的班主任:<input type="text" name="newclassteacher" id="passId" value="${classs.classteacher}" /><br />
		<button id="save">修改</button>
		<input type="reset" value="重置">
	</form>
</body>
</html>