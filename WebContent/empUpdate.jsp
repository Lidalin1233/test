<%@ page language="java" contentType="text/html; charset=utf-8"
    %>
<html>
<head>
<title>修改</title>
</head>
<body bgcolor=#BBFFFF>

<form action="empUpdate1"method="post">
<input type="hidden" name="number"  value="${emp.number} ">
		添加新的职工名:<input type="text" name="newname" id="nameId" value="${emp.name}"/><br />
		添加新的地址:<input type="text" name="newaddr" id="addrId" value="${emp.addr}" /><br />
		添加新的电话:<input type="text" name="newtel" id="telId" value="${emp.tel}" /><br />
		添加新的职位:<input type="text" name="newzw" id="zwId" value="${emp.zw}"/><br />
		添加新的身份证号:<input type="text" name="newnumber" id="numberId"  value="${emp.number}"/><br />
	<button id="save">修改</button>
<input type="reset"value="重置">
</form> 
</body>
</html>