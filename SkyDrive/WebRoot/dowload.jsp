<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>下载</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css">
<link rel="stylesheet" href="<%=basePath%>css/cover.css">

</head>

<body>
	<div class="site-wrapper">

		<div class="site-wrapper-inner">

			<div class="cover-container">

				<div class="masthead clearfix">
					<div class="inner">
						<h3 class="masthead-brand">喵盘</h3>
						<nav>
						<ul class="nav masthead-nav" id="title">
							<li onmouseover="mo(this)" onmouseout="left(this)"><a
								href="<%=basePath%>upload.jsp">上传</a></li>
							<li onmouseover="mo(this)" onmouseout="left(this)" class="active"><a
								href="<%=basePath%>showServlet">下载</a></li>
						</ul>
						</nav>
					</div>
				</div>

				<div class="inner cover">
					<c:if test="${empty rList}">
              		没有上传过东西
                </c:if>
					<c:if test="${not empty rList}">
              		<table class="table table-bordered table-hover">
	              		<tr>
							<td>随机文件名</td>
							<td>原本文件名</td>
							<td>位置</td>
							<td>存入时间</td>
							<td>描述</td>
							<td>操作</td>
						</tr>
              		<tbody>
              		<c:forEach items="${rList }" var="r">
              			<tr>
							<td>${r.uuidname }</td>
							<td>${r.realname }</td>
							<td>/upload${r.savepath}</td>
							<td>${r.uploadtime }</td>
							<td>${r.description }</td>
							<td><a href="<%=basePath%>dowloadServlet?filename=${r.realname}&savepath=${r.savepath}" class="btn btn-default">下载</a></td>
						</tr>
              		</c:forEach>
              		
              		</tbody>
              		</table>
                </c:if>
				</div>
			</div>

		</div>

	</div>

	<script>
		function over(self) {
			self.style.class = "active";
		}
		function left(self) {
			self.style.class = "";
		}

		</body>
		</html>
	