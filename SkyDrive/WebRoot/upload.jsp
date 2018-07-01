<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<title>上传</title>

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
                            <li onmouseover="mo(this)" onmouseout="left(this)" class="active"><a href="<%=basePath%>upload.jsp">上传</a></li>
                            <li onmouseover="mo(this)" onmouseout="left(this)"><a href="<%=basePath%>showServlet">下载</a></li>
                        </ul>
                    </nav>
                </div>
            </div>

            <div class="inner cover">
                <input type="button" value="add File" onclick="addFile();" class="btn btn-default">
                <form role="form" method="post" action="<%=basePath%>uploadServlet" enctype="multipart/form-data">
                    <div class="form-group" id="content">
                        <input type="text" value="描述" name="des" class="form-control">
                        <input id="file" type="file" class="form-control  btn btn-default" name="filename">
                        <button type="submit" class="btn btn-default">上传</button>
                    </div>
                </form>
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
	function addFile() {
		var div = document.getElementById("content");

		div.innerHTML += "<div class=\"form-group\" id=\"content\">\n"
				+ "<input type=\"text\" value=\"描述\" name=\"dec\" class=\"form-control\">\n"
				+ "<input id=\"file\"type=\"file\" class=\"form-control  btn btn-default\" name=\"filename\">\n"
				+ "<button type=\"submit\" class=\"btn btn-default\">上传</button>\n"
				+ " <input type='button' value='取消' onclick='removeFile(this)' class=\"btn btn-default\"></div>";
	}

	function removeFile(btn) {

		document.getElementById("content").removeChild(btn.parentNode);

	}
</script>
  </body>
</html>
