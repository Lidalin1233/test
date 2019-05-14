<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>列表</title>
<script src="js/jquery-2.2.4.js"></script>
<%@include file="common.jsp"%>
</head>
<body>
	<script>
		$(function() {
			changPageSize();
		});

		function list(pageNow, pageSize) {
			$
					.ajax({
						type : "POST",
						url : "/jsp/companyList",
						dataType : 'JSON',
						async : false,
						data : {
							pageNow : pageNow,
							pageSize : pageSize,
							name : $('#nameId').val(),
							tel : $('#telId').val()
						},
						success : function(datas) {
							$("#comp").html('');
							var cont = '';
							$
									.each(
											datas.list,
											function(i, obj) {
												cont = cont + '<tr>';
												cont = cont + '<td>' + obj.id
														+ '</td>';
												cont = cont + '<td>' + obj.name
														+ '</td>';
												cont = cont + '<td>' + obj.tel
														+ '</td>';
												cont += '<td><a href="javascript:del('
														+ obj.id
														+ ');">删除</a>&nbsp;&nbsp;<a href="companyUpdate.jsp?id='
														+ obj.id
														+ '">修改</a></td>';
												cont = cont + '</tr>';
											});
							page(Number(datas.pageNow), Number(datas.pageCount));
							$("#comp").html(cont);
						}
					});
		}

		function page(pageNow, pageCount) {
			$("#pageNowSpanId").text(pageNow);
			$("#pageCountSpanId").text(pageCount);

			$("#pageCountId").val(pageCount);
			if (pageNow > 1) {
				$("#upPageId").val(pageNow - 1);
			} else {
				$("#upPageId").val(1);
			}
			if (pageNow == pageCount) {
				$("#downPageId").val(pageCount);
			} else {
				$("#downPageId").val(pageNow + 1);
			}
		}
		function del(ids) {
			$.ajax({
				type : "POST",
				url : "/jsp/companydel",
				async : false,
				data : {
					id : ids
				},
				success : function(data) {
					console.log(data.msg, data);
					changPageSize();
				}
			});
		}
		function lastPage() {
			list($("#pageCountId").val(), $("#pageSizeid").val());
		}
		function upPage() {
			list($("#upPageId").val(), $("#pageSizeid").val());
		}
		function downPage() {
			list($("#downPageId").val(), $("#pageSizeid").val());
		}
		function changPageSize() {
			list(1, $("#pageSizeid").val());
		}
		function search() {
			changPageSize();
		}
	</script>
	<div class="wrapper">
		<%@include file="menu.jsp"%>
		<div class="main-panel">
			<div class="content">
				<br />
				<div class="container-fluid">
					<div class="card">
						<font size="4"><a href="companyAdd.jsp">添加信息</a></font>
						<div class="card-header">
							<div class="card-title">公司列表</div>
							<br /> 搜索公司:<input name="name" id="nameId" />
							<button onclick="search();">搜索</button>
						</div>
						<div class="card-body">
							<table
								class="table table-bordered table-head-bg-info table-bordered-bd-info mt-4">
								<thead>
									<tr>
										<th scope="col">ID</th>
										<th scope="col">名字</th>
										<th scope="col">电话</th>
										<th scope="col">操作</th>
									</tr>
								</thead>
								<tbody id="comp"></tbody>
							</table>
							当前页面： <span id="pageNowSpanId"></span> 总页面： <span
								id="pageCountSpanId"></span> 每页显示:<select id="pageSizeid"
								onchange="changPageSize();">
								<option value="3">3</option>
								<option value="5">5</option>
								<option value="10">10</option>
							</select> <a href="javascript:changPageSize();">首页</a> <a
								href="javascript:upPage();"> <input type="hidden"
								id="upPageId" />上一页
							</a> <a href="javascript:downPage();"> <input type="hidden"
								id="downPageId" />下一页
							</a> <a href="javascript:lastPage();"> <input type="hidden"
								id="pageCountId" />尾页
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
