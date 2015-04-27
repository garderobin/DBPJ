<%@ page language="java" import="java.util.*" pageEncoding="US-ASCII"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'home.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="./css/bundle-desktop-1_a3436a78.css" rel="stylesheet" type="text/css">
	<link href="./css/bundle-desktop-2_994eb744.css" rel="stylesheet" type="text/css">
	<link href="./css/bundle-desktop-2_5c6c6f50.css" rel="stylesheet" type="text/css">
	<link href="./css/bootstrap.min.css" rel="stylesheet">
	<link href="./css/bootstrap.css" rel="stylesheet">
   	<script src="./js/jquery.min.js"></script>
   	<script src="./js/bootstrap.js"></script>
   	<script src="../js/navbar.js"></script>

  </head>  
  <body>
  	<jsp:include page="./modules/header.html" />
	<jsp:include page="./modules/footer.html"/>
	<jsp:include page="./modules/addPin.html"/>
	<div class="appContent">
		<div class="mainContainer">
			<div class="HomePage Module">
				
			</div>
		</div>
	</div>
    
  </body>
</html>
