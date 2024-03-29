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
    
    <title>nyupinterest</title>
	
	<link href="css/bundle-desktop-1_a3436a78.css" rel="stylesheet" type="text/css">
	<link href="css/bundle-desktop-2_994eb744.css" rel="stylesheet" type="text/css"> 
	<link href="css/bundle-desktop-2_5c6c6f50.css" rel="stylesheet" type="text/css"> 
	<link href="css/bundle-desktop-2_442c9884.css" rel="stylesheet" type="text/css">
	<!-- <link href="css/bundle-desktop-1_7e764a10.css" rel="stylesheet" type="text/css"> -->
    <link href="css/bundle-desktop-main_db38bc94.css" rel="stylesheet" type="text/css">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<!-- <link href="css/bootstrap.css" rel="stylesheet"> -->
	<link href="css/dbcommon.css" rel="stylesheet" type="text/css">
   	<script src="js/jquery.min.js"></script>
   	<script src="js/bootstrap.js"></script>
   	 <%-- <script src="js/common.js"></script> --%>
   	<%-- <script src="js/jquery.masonry.min.js"></script>
    <script src="js/modernizr-transitions.js"></script> --%>
    <script src="js/imagesUploaded.min.js"></script>
    <script src="js/jquery.isotope.min.js"></script>
    <script type="text/javascript">
    	$(function(){
    		var $lastPinid = $("#lastPinid").val();
    		$.ajax({
				type:"GET",
				dataType:"json",
				url:'queryLatestPinSummaries.action',
				data:{lastPinid:$lastPinid},
				success: function(data, textStatus) {
					$lastPinid = data.lastPinid;
					var $container = $("#masonryContainer");
					$container.children().remove();
					$.each(data.pinList, function()
					{				
						var $pinid = this.pinid;
						var $url = this.picture.url; 
						var $note = this.note;
						var $picnum = this.picture.picnum;
						var $bname = this.board.bname;
						var $bid = this.board.bid;
						//var $author = this.board.user.username;
						var $element = $(
"<div class='masonryItem  ui-draggable ui-draggable-disabled ui-state-disabled' aria-disabled='true' style='margin-bottom: 10px;'>" + 
   " <p class='picsort' style='display:none'> " + $picnum + "</p>"+
    "<div class='Module Pin summary' data-component-type='0'>" + 
        "<div class='pinWrapper'>" + 
            "<div class='bulkEditPinWrapper'></div>" + 
            "<div class='pinImageActionButtonWrapper'>" + 
                "<div class='repinSendButtonWrapper'>" + 
                    "<button id='repin_" + $pinid + "' class='repinButton Button Module ShowModalButton btn primary primaryOnHover repinSmall rounded' data-element-type='0' type='button'" + 
                    	"style='height:33px'>" +
                        "<span class='glyphicon glyphicon-pushpin'></span>" +
                        "<span class='buttonText'>Pin it</span>" +
                    "</button>" +
                    "<button class='Button DropdownButton Module btn hasText rounded sendSmall sendPinGrid' data-element-type='98' type='button'" +
                    	"style='height:33px'>" +
                        "<span class='glyphicon glyphicon-send'></span>" +
                        "<span class='buttonText'>Send</span>" +
                    "</button>" +
                "</div>" +
                "<div class='likeEditButtonWrapper Unlike pinItem_" + $pinid +"' id='lw_" + $picnum + "'>" +                                                                            
                    "<button class='Button LikeButton Module PinLikeButton btn likeSmall rounded' data-element-type='1' data-source-interest-id='945391946569'" +
                   "data-text-like='Like' data-text-unlike='Unlike' type='button'  style='height:33px'>" +
                        "<span class='glyphicon glyphicon-heart-empty hs_" + $pinid + "' id='hs_" + $picnum + "'></span>" +
                    "</button>" +
                "</div>" +
                "<a class='Button Module NavigateButton borderless hasText pinNavLink navLinkOverlay' data-element-type='162' " +
                    "href='http://havsandlabs.wordpress.com/havanese/' rel='nofollow' type='button'>" +        
                    "<em class='glyphicon glyphicon-leaf' style='color:white'></em>" +
                    "<span class='buttonText'>" + $note + "</span>" +        
                "</a>" +                                                                                                       
                "<div class='pinHolder'>" +
                    //"<a href='/pinDetail.jsp?pinid=" + $pinid +"&url=" + $url + "&author=" + $author + "' class='pinImageWrapper draggable' data-element-type='35' style='background: #5a1321;'>" +
                      "<a href='pinDetail.jsp?pinid=" + $pinid + "&bid=" + $bid + "&bname=" + $bname + "'class='pinImageWrapper draggable' data-element-type='35' style='background: #5a1321;'>" +                  
                        "<div class='pinDomain'>rosasenaturezas.tumblr.com></div>" +
                        "<div class='fadeContainer'>" +
                            "<div class='pinImageDim'>" +
                                "<div class='dimOverlay'></div>" +
                                "<div class='dimGradient'></div>" +
                            "</div>" +
                            "<div class='Image Module pinUiImage'>" +
                                "<div>" +
                                    "<img id='img_" + $picnum + "'src='" + $url + "' class='pinImg fullBleed loaded fade' style='' onload='' alt=''>" +
                                "</div>" +
                            "</div>" +
          				"</div>" +
                    "</a>" +
                "</div>" +
            "</div>" +

            "<div class='pinMeta '>" +
                "<p class='pinDescription'></p>" +
                "<div class='Module SocialIconsCounts'>" +
                    "<div class='pinSocialMeta'>" +
                    "<a class='socialItem' href='repin.jsp' data-element-type='174'>" +
                        "<em class='glyphicon glyphicon-share-alt'></em><em></em>" +
                        "<em class='socialMetaCount repinCountSmall' id='rcem_" + $pinid + "'></em>" +
                    "</a>" +
                    "<a class='socialItem likes' href='/pin/338895940687224815/likes/' data-element-type='175'>" +
                        "<em class='glyphicon glyphicon-heart'></em><em></em>" +
                        "<em class='socialMetaCount likeCountSmall' id='lcem_" + $pinid+  "'></em>" +
                    "</a>" +
                    "</div>" +
                "</div>" +
            "</div>" +

            "<div class='pinCredits'>" +
                "<div class='creditItem '>" +
                    "<a href='boardDetail.jsp?bname=" + $bname + "&bid=" + $bid + "&info=" + this.info + "'>" +
                        "<div class='Image Module creditImg'>" +
                            "<div>" +
                                "<img src='https://s-media-cache-ak0.pinimg.com/30x30/55/6f/9a/556f9afacbd32e1528c3b4d068324b59.jpg' style='' alt='Dresses' data-src='https://s-media-cache-ak0.pinimg.com/30x30/55/6f/9a/556f9afacbd32e1528c3b4d068324b59.jpg'>" +
                            "</div>" +
                        "</div>" +
                        "<div class='creditName'>Found in</div> " +
                        "<div class='creditTitle' id='bid_" + $bid + "'>" + $bname + "</div>" +
                    "</a>" +
                "</div>" +
            "</div>" 
						);					
						//$("#repin_" + $pinid).bind("click", function(){
											
						$container.append($element);
						//console.log( $("#repin_"+$pinid).text() );
						
						$("#repin_"+$pinid).bind("click", function(){	
							var repin = (this.id).substr(6);
							window.location.href="repin.jsp?picnum=" + $picnum + "&repin=" + $pinid + "&url=" + $url + "&note=";
							/* $.ajax({
								type:"GET",
								dataType:"json",
								url:'repin.action',
								data:{picnum:$picnum, repin:$pinid, note:$note },
								success: function(data, textStatus) {
									alert("Repin complete!");
								},
								error: function(XMLHttpRequest, textStatus, errorThrown) {
									console.error("repin error!");
								},
							}); */
						});	
						//$("#lw_" + $picnum).bind("click", itemChoose($picnum));
						$("#lw_" + $picnum).bind("click", itemChoose);										
					});	
					
					$.each(data.pinStatList, function(){
						//console.log(this);
						var $pinid = this.pinid;
						var $rc = this.repinCount;
						var $lc = this.likeCount;
						var $isLiked = this.isLikedByCurUser;					
						$("#rcem_" + $pinid).text(($rc)>0 ? $rc : "");
						$("#lcem_" + $pinid).text(($lc)>0 ? $rc : "");
						
						//console.log($isLiked);
						if ($isLiked == "Like") {							
							$("div.pinItem_" + $pinid).removeClass("Unlike");
							$("div.pinItem_" + $pinid).addClass("Like");
							var $heartSpan = $(".hs_" + $pinid);
							$heartSpan.removeClass("glyphicon-heart-empty");
							$heartSpan.addClass("glyphicon-heart");
							$heartSpan.css("color", "red");					
						} 
						
					});	
					
					/* $container.imagesLoaded( function(){
						$container.masonry({
					        itemSelector : '.masonryItem',
					        columnWidth:236,
					        gutterWidth:10,
					        isFitWidth:true
				//        	isAnimated:true
			      		});	
					});  */
					/* var $container2 = $('#masonryContainer').imagesLoaded( function() {
  						$container2.isotope({ */
					$container.imagesLoaded( function(){
					$container.isotope({ 
					        itemSelector : '.masonryItem',
					        masonry: {
 							columnWidth:236,
					        gutter:10,
					        isFitWidth:true
				//        	isAnimated:true
							}
							//sortBy: '.picsort',	  
			      		});
			      	}); 				
					$('#headerContainer').width($('#gridItemModule').width());	
				},
				error: function(XMLHttpRequest, textStatus, errorThrown) {
					console.error("index take pins error!");
				},
			});
			
			/* $.ajax({
				type:"GET",
				dataType:"json",
				url:'queryLatestPinSummaries.action',
				data:{lastPinid:$lastPinid},
				success: function(data, textStatus) {
					
				},
			}); */

		    $("#addPinMenuButton").click(function(){
		        $("#addPinMenuContent").slideToggle();
		    });
    	
    	})
    	
    	$(window).resize(function() {
			$('#headerContainer').width($('#headerBackground').width());
		})
    	
		function showCreatePinForm(bid, pic, note) {
			alert('showCreatePinForm!');
		}
		
		//function itemChoose(picnum) {		
		function itemChoose() {
			$id = this.id;
			$picnum = ($id + "").substr(3);
			//console.log("itemChoose: picnum = " + $picnum);
			var $ifLiked = $(this).hasClass("Like");
			if ($ifLiked) {
				$.ajax({
					type:"GET",
					dataType:"json",
					url:'deleteLikes.action',
					data:{picnum:$picnum},
					success: function(data, textStatus) {					
						var $heartSpan = $("#hs_" + $picnum);
						$heartSpan.removeClass("glyphicon-heart");
						$heartSpan.addClass("glyphicon-heart-empty");
						$heartSpan.css("color", "gray");
						this.removeClass("Like");
						this.addClass("Unlike");
					},
					error: function(XMLHttpRequest, textStatus, errorThrown) {
						console.error("delete likes error!");
					},
				});
			} else {
				$.ajax({
					type:"GET",
					dataType:"json",
					url:'addLikes.action',
					data:{picnum:$picnum},
					success: function(data, textStatus) {
						var $heartSpan = $("#hs_" + $picnum);
						$heartSpan.removeClass("glyphicon-heart-empty");
						$heartSpan.addClass("glyphicon-heart");
						$heartSpan.css("color", "red");
						$("#lw_" + $picnum).removeClass("Unlike");
						$("#lw_" + $picnum).addClass("Like");
					},
					error: function(XMLHttpRequest, textStatus, errorThrown) {
						console.error("add likes error!");
					},
				});
			}
			
		}
		
		
		function pictureFirst() {
			//alert("picture First");
			$("#sortListDiv").modal("hide");
			//var $container = $('#container').imagesLoaded( function() {
			  $("#masonryContainer").isotope({
			    itemSelector : '.masonryItem',
			    getSortData: {
      				picsort: function( itemElem ) {
				        var $weight = $( itemElem ).find('.picsort').text();
				        return parseInt( $weight.replace( /[\(\)]/g, '') );
				        },
				},      
				masonry: {
 					columnWidth:236,
					gutter:10,
					isFitWidth:true
				},
				sortBy : 'picsort',
				sortAscending : false	        
				
			  });
			//}); 
		}
		
		
		    	
    </script>
	
  </head>  
  <body>
  	<jsp:include page="./modules/header.jsp" />
	<jsp:include page="./modules/footer.jsp"/>	
	<input type="hidden" name="lastPinid" id="lastPinid"/>
	<div class="appContent">
		<div class="mainContainer" style="background-color:#e9e9e9">
			<div class="Module Nags centeredWithinWrapper" style="height:54px"></div>
			<div class="HomePage Module" style="min-height:624px">
				<div class="AuthHomePage Module">
					<div class="HeroBasicWrapper Module"></div>
					<div class="Grid Module hasFooter" style="background-color:#e9e9e9">
						<div class="GridItems Module centeredWithinWrapper padItems variableHeightLayout" id="masonryContainer">
							<!-- The height is not static. It seems to related to the screen condition. -->
							<jsp:include page="./pinSummary.jsp" />
						</div>
						<div class="GridFooter Module centeredWithinWrapper showGridLoading" style="display:block">
							<div class="gridError" style="display:none">
								<button class="Button btn rounded large">
									<span>Whoops! Something went wrong</span>
									"Try again."
								</button>
							</div>
							<div class="gridLoading">
								<span class="gridFooterLogoIcon"></span>
								<span class="gridFooterSpinner"></span>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="appendedContainer"></div>
			<div class="Module Toasts"></div>
		</div>
	</div>
    
  </body>
</html>
