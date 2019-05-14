<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page import="java.sql.*"%>
<%@page import="com.entry.*"%>
<%@page import=" java.util.List"%>
<%@page import="com.dao.*"%>
<%@page import="com.service.*"%>
<%@include file="common.jsp"%>
<html>
<head>
<title>修改页面</title>
<script src="js/jquery-2.2.4.js"></script>
	<script type="text/javascript">
		$(function() {
			var id = getUrlParam("id");
			get(id);
		});
		function get(id){
			$.ajax({
				type : "POST",
				url : "/jsp/companyupd",
				dataType : 'JSON',
				async : false,
				data : {
					 id : id
				},
				success : function(datas) {
					$("#id").val(datas.id);
					$("#name").val(datas.name);
					$("#tel").val(datas.tel);
				}
			});
		}
		function getUrlParam(name) {
            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
            var r = window.location.search.substr(1).match(reg);  //匹配目标参数
            if (r != null) return unescape(r[2]); return null; //返回参数值
        }
	</script>
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
									<div class="card-title">公司修改</div>
								</div>
								<form action="companyupdSave" method="post">
								<div class="card-body">
									<div class="form-group">
										<label for="squareInput">公司名称</label> 
										<input type="hidden" name="id" id="id">
										<input type="text" class="inputclass" name="name"
											id="name" >
										<label for="squareInput">输入新电话</label> 
										<input type="text" class="inputclass" name="tel"
											id="tel" >
									</div>
								</div>
								<div class="card-action">
									<button class="btn btn-success">修改</button>
								</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
</body>
</html>