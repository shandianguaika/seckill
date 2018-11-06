<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <title>秒杀商品详情展示</title>
    <!-- 静态包含：直接加载过来，一块编译 -->
	<%@include file="common/head.jsp" %>
  </head>
  <body>
	<!-- 页面显示部分 -->
  	<div class="container">
  	<div class="panel-heading text-center"><h2>秒杀商品详细信息</h2></div>
  		<div class="panel panel-default">
  			<div class="panel-heading text-center">${seckill.name}</div>
  			<div class="panel-body text-center">
				<h2 class="text-danger">
					<span class = "glyphicon glyphicon-time"></span>
					<span class = "glyphicon" id="seckill-box"></span>
				</h2>
			</div>
  		</div>
  	
  	</div>

  </body>
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
</html>