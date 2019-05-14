<%@ page language="java" contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>修改</title>
</head>
<body bgcolor=#BBFFFF>

	<form action="teacherUpdate1" method="post">
		<input type="hidden" name="code" value="${teacher.code} ">
		添加新的教师名:<input type="text" name="newname" id="nameId"
			value="${teacher.name}" /><br /> 添加新的电话:<input type="text"
			name="newtel" id="telId" value="${teacher.tel}" /><br />
		<button id="save">修改</button>
		<input type="reset" value="重置">
	</form>
</body>
</html>