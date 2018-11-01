<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="common/tag.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <title>秒杀列表</title>
    <!-- 静态包含：直接加载过来，一块编译 -->
	<%@include file="common/head.jsp" %>
  </head>
  <body>
  	<!-- 页面显示部分 -->
  	<div class="container">
  		<div class="panel panel-default">
  			<div class="panel-heading text-center"><h2>秒杀列表</h2></div>
  			<div class="panel-body text-center">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>名称</th>
							<th>库存</th>
							<th>开始时间</th>
							<th>结束时间</th>
							<th>创建时间</th>
							<th>详情页</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="sk" items="${lists }">
							<tr>
								<th>sk.name</th>
								<th>sk.number</th>
								<th><fmt:formatDate value="${sk.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/></th>
								<th><fmt:formatDate value="${sk.endTime }" pattern="yyyy-MM-dd HH:mm:ss"/></th>
								<th><fmt:formatDate value="${sk.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/></th>
								<th><a class="btn btn-info" href="/seckill/${sk.seckill_id }/getdetail" target="_blank">查看</a></th>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
  		</div>
  	
  	</div>

  </body>
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
</html>