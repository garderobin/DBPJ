<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

		<title>My JSP 'index.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<script type="text/javascript" src="js/jquery-1.8.1.min.js"></script>
		<script type="text/javascript" src="js/jquery.uploadifive.min.js"></script>
		<link rel="stylesheet" type="text/css" href="css/uploadifive.css">

	</head>

	<body>
		<form class="standardForm" method="post">
    	<div class="Button Module btn hasText large leftRounded primary" type="button" style="position: relative; overflow: hidden; direction: ltr;">
			<span class="buttonText" id="chooseImageSpan">Choose Image</span>
			<input id="file_upload" type="file" name="file" style="position: absolute; right:0px; top: 0px; font-family: Arial; font-size: 118px; margin: 0px; padding: 0px; cursor: pointer; opacity: 0;"/>
			<div id="tip-queue"></div>
			<div class="uploaderProgress"></div>
		</div>
    			<h1 class="pinFormHeader">Pick a board</h1>
				<ul>
					<li class="boardWrapper">
            			<h3><label>Board</label></h3>
            			<div class="Module PinPreview">
            				<img src="images/add.png" class="pinPreviewImg" id="pinPreviewImg">
            			</div>
            			<div>
                			<button class=" BoardPickerDropdownButton Button DropdownButton Module btn primary rounded" type="button">
								<span class="downArrow"></span>
								<div class="BoardLabel Module compact">
									<span class="nameAndIcons">
    									<div class="BoardIcons Module pinCreate3"></div>
    									<div class="name">Select a board</div>
									</span>
								</div>
							</button>
            			</div>
       				</li>
       				<li>
            			<h3><label for="pinFormDescription">Description</label></h3>
            			<div>
                			<div class="Field Module TextField">
								<textarea id="pinFormDescription" name="description" class="content " placeholder="What's this Pin all about?"></textarea>
							</div>
            			</div>
       	 			</li>
					<li>
                		<h3><label for="pinFormLink">Source</label></h3>
                		<div>
                    		<input type="url" name="link" id="pinFormLink" value="">
                		</div>
            		</li>
				</ul>
				<div class="formFooter">
					<div class="socialShareWrapper"></div>
					<div class="formFooterButtons">
						<button class=" Button Module btn cancelButton hasText rounded" type="button">
							<span class="buttonText">Close</span>
						</button>
						<button class="Button Module btn primary repinSmall pinIt rounded disabled" type="submit" disabled="">
							<em></em>
							<span class="accessibilityText">Pin it</span>
						</button>
        			</div>
    			</div>
		</form>
	</body>
<script type="text/javascript">
  	$(function(){
  		 $('#file_upload').uploadifive({
  			 //'auto' : false,   //取消自动上传 
  	        'uploadScript' : 'fileUploadAction.action',  //处理上传文件Action路径 
  	        'fileObjName' : 'file',        //文件对象
	  	    'buttonText'   : '选择文件',   //按钮显示文字 
	  	    'queueID'      : 'tip-queue', //提示信息放置目标 
	  	    'fileType'     : 'image/*',   //允许上传文件类型 
	  	    'onUploadComplete' : function(file, data) { //文件上传成功后执行 
	  	    	console.info('The file ' + file.path + ' uploaded successfully.');
	  	    	/* $('#pinPreviewImg').attr("src", "images/" + file.name); */
	         }
  	    });
	})
</script>
</html>
