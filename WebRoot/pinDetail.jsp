<%@ page language="java" import="java.util.*" pageEncoding="US-ASCII"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE>
<html>
  <head>
    <base href="<%=basePath%>">
<%--     <link href="css/bundle-desktop-1_a3436a78.css" rel="stylesheet" type="text/css">
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
    <script src="js/modernizr-transitions.js"></script> --%>
    <script src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/jquery.uploadifive.min.js"></script>
		<!-- <link rel="stylesheet" type="text/css" href="css/uploadifive.css"> -->
		<link href="css/bundle-desktop-1_a3436a78.css" rel="stylesheet" type="text/css">
		<link href="css/bundle-desktop-2_994eb744.css" rel="stylesheet" type="text/css"> 
		<link href="css/bundle-desktop-2_5c6c6f50.css" rel="stylesheet" type="text/css"> 
		<link href="css/bundle-desktop-2_442c9884.css" rel="stylesheet" type="text/css">
		<!-- <link href="css/bundle-desktop-1_7e764a10.css" rel="stylesheet" type="text/css"> -->
	    <link href="css/bundle-desktop-main_db38bc94.css" rel="stylesheet" type="text/css">
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<!-- <link href="css/bootstrap.css" rel="stylesheet"> -->
		<link href="css/dbcommon.css" rel="stylesheet" type="text/css">	   	
	   	<script src="js/bootstrap.min.js"></script>
	   	<script src="js/common.js"></script>
	   	<script src="js/jquery.masonry.min.js"></script>
	    <script src="js/modernizr-transitions.js"></script>
	    <script src="js/jquery.form.min.js"></script>
    <script type="text/javascript">
	    $(function(){
	    	var $pinid = $("#pinid").val();
	    	console.log("pinid=" + $pinid);
	    	$("#editPinSelectSpan").text($("#bname").text());
	    	//$("#changeBoard").click(getBoardList()); 
	    	getBoardList();
	    	$.ajax({
				type:"GET",
				dataType:"json",
				url:'queryPinSummaryByPinid.action',
				data:{pinid:$pinid},
				success: function(data, textStatus) {
					console.log("url:");
					console.log(data.pin.picture.url);
					$(".pinImage").attr("src", data.pin.picture.url);
					$("#editPinPreviewImg").attr("src", data.pin.picture.url);
					$("#picnum").val(data.pin.picture.picnum);
				},
				error: function(XMLHttpRequest, textStatus, errorThrown) {
					console.error("queryPinSummaryByPinid error!");
				},
			});
			
			/* $("#editPinForm").ajaxForm({
				url: 'editPin.action',
				type: 'GET',
				dataType: 'json',
				success: function(data){
					
				},
				error: function(XMLHttpRequest, textStatus, errorThrown){
					console.error(errorThrown);
				}
			}); */
	    })
	    
	    function getBoardList() {
			$.ajax({
				type:"GET",
				dataType:"json",
				url:'queryBoardsByUsername.action',
				success: function(data, textStatus) {
					var $menuSelect = $('#changeBoard');
					$.each(data.boardList, function() {
						var $bid  = this.bid;
						var $bname = this.bname;
						var $element = $("<li class='item' id=" + $bid + "><a>" + $bname + "</a></li>"); 
						//还没有跳转连接！
						$menuSelect.append($element);
						$element.bind("click", itemChoose); 
					});
				},
			});
			
		}
		
		function itemChoose() {
			//alert("itemChoose = " + this.id);
			//console.log(this.id);
			$("#selectedBoardNameDiv").text($("#" + this.id).text());
			$("#bid").val(this.id);
			//console.log(">>>>>>>>>>> In jsp, bid = " + $("#bid").val());
		}
    </script>

  </head>
  
  <body>
  <div id="username" style="display:none"><s:property value='#session.username'></s:property></div>
  <div id="bname" style="display:none"><%= request.getParameter("bname")%></div>
  
<div class="appendedContainer">
	<div class="Module Closeup canClose" style="min-height:624px;">
		<button class="Button borderless close visible" style="right: 14px;">
			<em class="glyphicon glyphicon-remove"></em>&nbsp;
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
					<button id="editPinButton" class="Button EditButton Module btn facebookShare pinActionBarButton hasText medium rounded" type="button">
						<em  class="glyphicon glyphicon-pencil"></em>
						<span class="buttonText">Edit</span>
					</button>
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
	    <form class="standardForm" method="post" action="editPin" id="editPinForm">
	    	<input type="hidden" name="pinid" id="pinid" value=<%= request.getParameter("pinid")%>>
    		<input type="hidden" name="bid" id="bid" value=<%= request.getParameter("bid")%>>  
    		<input type="hidden" name="picnum" id="picnum">  
    		
    		<h1 class="pinFormHeader">Edit Pin</h1>
			<div class="Module PinPreview" align="center"
    				style="width:145px;height:145px;float:right;margin-right:20px;overflow-x:hidden; overflow-y:hidden;position:relative;
    				margin-bottom:0px;margin-left:0px;margin-top:25px;max-width:180px;max-height:250px;
    				border:2px gray solid;background-color:#eee;border-radius:3px">
            		<img class="pinPreviewImg pinImage" style="max-height:145px;max-width:145px;margin-left:auto auto" id="editPinPreviewImg">
            	</div>
			<ul>
                <%-- <li class="boardWrapper" >
            		<h3><label>Board</label></h3>
              		<div class="dropdown">
                		<button class=" BoardPickerDropdownButton Button DropdownButton Module btn primary rounded dropdown-toggle"  type="button" 
                			data-toogle="dropdown" aria-expanded="true" id="editPinChangeBoardButton" >
							<!-- <span class="downArrow"></span> -->        
							<div class="BoardLabel Module compact">
								<span class="nameAndIcons">
    								<div class="BoardIcons Module pinCreate3"></div>
    								<div class="name" id="selectedBoardNameDiv"><%= request.getParameter("bname")%></div>
								</span>
							</div>
						</button>
						<ul class="dropdown-menu" role="menu" aria-labelledby="editPinChangeBoardButton" id="changeBoard" style="position:relative;float:left;width:318px; min-height:300px" ></ul>            			
            		</div>
        		</li> --%>
        		<li class="boardWrapper" style="height:auto">
            			<h3 style="width:140px"><label>Board</label></h3>            			
            			<div class="dropdown" style="margin-top:15px;margin-bottom:10px;margin-left:0px">
                			<button class="  BoardPickerDropdownButton Button DropdownButton Module btn rounded dropdown-toggle" type="button"
                			 id="editPinPickBoardButton" data-toggle="dropdown" aria-expanded="true" >
								<%-- <span class="downArrow"></span> --%>
								<div class="BoardLabel Module compact">
									<span class="nameAndIcons">
    									<div class="name" id="editPinSelectSpan" style="height:16px;width:350px">Board name</div>
									</span>
								</div>
							</button>
							<ul class="dropdown-menu selectBoard" role="menu" aria-labelledby="editPinPickBoardButton" id="changeBoard" style="position:relative;float:left;width:318px"></ul>
            			</div>
       				</li>
        		<li>
            		<h3 style="width:140px"><label for="noteEdit">Description</label></h3>
            		<div style="margin-left:140px">
                		<div class="Field Module TextField">
							<textarea id="noteEdit" name="note" id="note" class="content     " placeholder="What's this Pin all about?">test</textarea>
						</div>
            		</div>
        		</li>
				<!-- <li>
                	<h3 style="width:140px"><label for="sourceUrlEdit">Source</label></h3>
                	<div>
                    	<input type="url" name="sourceUrl" id="sourceUrlEdit" value="">
                	</div>
            	</li> -->
			</ul>
			<div class="formFooter">
            	<div class="formFooterDelete">
                	<button class="Button Module btn deleteButton hasText rounded" type="button">    
						<span class="buttonText">Delete Pin</span>
        			</button>
            	</div>
				<div class="formFooterButtons">
                	<button class=" Button Module btn cancelButton hasText rounded" type="button">    
						<span class="buttonText">Cancel</span>
        			</button>
					<button class="Button Module btn hasText primary rounded savePinButton" type="submit">    
						<span class="buttonText">Save Changes</span>
        			</button>
        		</div>
    		</div>
		</form>
  </body>
</html>
