<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>首页</title>
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
                            <li onmouseover="mo(this)" onmouseout="left(this)"><a href="<%=basePath%>upload.jsp">上传</a></li>
                            <li onmouseover="mo(this)" onmouseout="left(this)"><a href="<%=basePath%>showServlet">下载</a></li>
                        </ul>
                    </nav>
                </div>
            </div>

            <div class="inner cover">
                <h1 class="cover-heading">Nothing in there</h1>
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
</script>
  </body>
</html>
