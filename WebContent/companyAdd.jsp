<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page import=" java.util.List"%>
<%@page import="com.dao.*"%>
<%@page import="com.service.*"%>
<%@include file="common.jsp"%>
<html>
<head>
<title>添加公司信息</title>
</head>
<body>
	<div class="wrapper">
		<%@include file="menu.jsp"%>
		<div class="main-panel">
			<div class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12">
							<div class="card">
								<div class="card-header">
									<div class="card-title">公司添加</div>
								</div>
								<form action="companyAdd" method="post">
									<div class="card-body">
										<div class="form-group">
											<label for="squareInput">公司名称</label> <input type="text"
												class="inputclass" name="name" id="name"> <label
												for="squareInput">输入电话</label> <input type="text"
												class="inputclass" name="tel" id="tel">
										</div>
										<div class="card-action"></div>
										<button class="btn btn-success">添加</button>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
</body>
</html>