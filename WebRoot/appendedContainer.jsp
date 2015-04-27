<%@ page language="java" import="java.util.*" pageEncoding="US-ASCII"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE>
<html>
  <head>
    <base href="<%=basePath%>">
    <link href="css/bundle-desktop-1_a3436a78.css" rel="stylesheet" type="text/css">
	<link href="css/bundle-desktop-2_994eb744.css" rel="stylesheet" type="text/css"> 
	<link href="css/bundle-desktop-2_5c6c6f50.css" rel="stylesheet" type="text/css"> 
	<link href="css/bundle-desktop-2_442c9884.css" rel="stylesheet" type="text/css">	
	<link href="css/bundle-desktop1_9f130f1f.css" rel="stylesheet" type="text/css">
	<link href="css/bundle-desktop-main_db38bc94.css" rel="stylesheet" type="text/css">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/dbcommon.css" rel="stylesheet" type="text/css">
   	<script src="js/jquery.min.js"></script>
   	<script src="js/bootstrap.js"></script>
   	<script src="js/common.js"></script>
   	<script src="js/jquery.masonry.min.js"></script>
    <script src="js/modernizr-transitions.js"></script>

  </head>
  
  <body>
<div class="appendedContainer">
	<div class="Module Closeup canClose" style="min-height:624px;">
		<button class="Button borderless close visible" style="right: 14px;">
			<em></em>&nbsp;
		</button>
		<div class="closeupActionBarContainer" data-component-type="4">
			<div class="Module PinActionBar" style="top:0px;">
				<div class="repinLike">
					<button class="Button Module ShowModalButton btn medium primary primaryOnHover repin pinActionBarButton rounded" data-element-type="0" type="button">
						<!-- <em class="glyphicon glyphicon-pushpin"></em> -->						
						<!-- <span class="accessibilityText">Pin it</span> -->
						<!-- <em class="glyphicon glyphicon-pushpin"></em> -->
						<span class="glyphicon glyphicon-pushpin"></span>
                        <span class="buttonText">Pin it</span>
					</button>
					<button class="Button IncrementingNavigateButton Module NavigateButton btn hidden medium primary repinLikeNavigateButton pinActionBarButton rounded" data-element-type="174" type="button">&nbsp;
					</button>
					<button class="Button LikeButton Module PinLikeButton btn hasText like pinActionBarButton medium rounded" data-element-type="1" data-source-interest-id="" data-text-like="Like" data-text-unlike="Unlike" type="button">
						<em class="glyphicon glyphicon-heart"></em>
						<span class="buttonText">Like</span>        
    				</button>
					<button class="Button IncrementingNavigateButton Module NavigateButton btn hidden medium repinLikeNavigateButton like pinActionBarButton rounded" data-element-type="175" type="button">&nbsp;
					</button>
					<a class="Button Module NavigateButton btn hasText medium rounded website pinActionBarButton" data-element-type="162" href="http://www.barbaragateau.com/" rel="nofollow" type="button">
						<em class="glyphicon glyphicon-globe"></em>
						<span class="buttonText">Visit Site</span>
					</a>
				</div>
				<div class="shareGear">
					<button class="Button DropdownButton Module btn hasText medium rounded send pinActionBarButton" data-element-type="98" type="button">
						<!-- <em></em>
						<span class="buttonText">Send</span> -->
						<span class="glyphicon glyphicon-send"></span>
                        <!-- <em></em>  -->
                        <!-- <span class="accessibilityText">Pin it</span>  -->
                        <span class="buttonText">Send</span>
					</button>
					<!-- <button class="Button FacebookShareButton Module btn facebookShare pinActionBarButton hasText medium rounded" type="button">
						<em  class="glyphicon glyphicon-facebook"></em>
						<span class="buttonText">Share</span>
					</button> -->
    			</div>
				
			</div>
		</div>
		<div class="closeupContainer">
			<jsp:include page="modules/closeupContent.html" />
			<jsp:include page="modules/closeupSidebar.html" />
		</div>
		<jsp:include page="modules/closeupBottom.html" />
		
	</div>	
</div>

  </body>
</html>
