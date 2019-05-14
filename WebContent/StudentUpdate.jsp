<%@ page language="java" contentType="text/html; charset=utf-8"
    %>
<html>
<head>
<title>修改</title>
</head>
<body bgcolor=#BBFFFF>

<form action="updateStudent1"method="post">
<input type="hidden" name="code"  value="${student.code} ">
添加新的学生名:<input type="text" name="newname" id="nameId" /><br />
		添加新的地址:<input type="text" name="newaddr" id="addrId" value="${student.addr}" /><br />
		添加新的电话:<input type="text" name="newtel" id="telId" value="${student.tel}" /><br />
		添加新的班级:<input type="text" name="newforclass" id="forclassId" value="${student.forclass}"/><br />
		添加新的学号:<input type="text" name="code" id="codeId"  value="${student.code}"/><br />
	<button id="save">修改</button>
<input type="reset"value="重置">
</form> 
</body>
</html>