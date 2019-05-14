<%@ page language="java" contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>Insert title here</title>
<script src="js/jquery-2.2.4.js"></script>
		<script>
			$(function (){ //表示页面节点(元素,dom,标签) 加载完成,自动会执行这里面的内容
				$.ajax({
					type:"POST",//请求方式为post
					url:"/jsp/ajaxs",//请求url
					dataType:'JSON',//数据格式为json
					async:false,//是否同步，false表示为异步
					data:{name:"李思",code:'1001'},
					success : function(data){ //function为一个回调函数，data表示为请求servlet后，servlet中返回回来的值
						console.log("------",data); //将内容打印到控制台(浏览器)
					}
				});
			});
			function ff(){
				var d=[11,22,33,44];
				$.each(d,function(i,v){
					console.log('index=',i,"v=",v);
				});
			}
		</script>
	</head>
	<body>
		账户:<input type="text" id="aa" name="cc" />
 		 <button onclick="ff();" >anan</button>
	</body>