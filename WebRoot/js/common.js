$(document).ready(function(){
    $("#addPinMenuButton").click(function(){
        $("#addPinMenuContent").slideToggle();
    });
});

//$('#masonryContainer').masonry({
//	columnWidth: 236,
//	itemSelector: '.masonryItem',
//	gotter: 10
//})

$(function(){

    $('#masonryContainer').imagesLoaded( function(){
    	$('#masonryContainer').masonry({
        itemSelector : '.masonryItem',
        columnWidth:236,
        gutterWidth:10,
        isFitWidth:true
//        isAnimated:true
      });
    });

    $('#headerContainer').width($('#headerBackground').width());

    $('#masonrySmall').imagesLoaded( function(){
    	$('#masonrySmall').masonry({
        itemSelector : '.masonrySmallItem',
        columnWidth:70,
        gutterWidth:2,
        isFitWidth:true
//        isAnimated:true
      });
    });
    
    $('#uploadPinForm').ajaxForm({
		url:'script',
		type:'POST',
		dataType:'json',
		success:function(data) {
			showCreatePinForm(0,0,0);
		}
	})
    
    $('#imgUpload').fileupload({
    	dataType:'json',
//    	done: fuction(e, data) {
//    		showCreatePinForm(0, 0, 0);    		
//    	}
    	done:function() {
    		alert('file uploaded!');
    		console.log("file uploaded");
    	}
    });
    
});

$(window).resize(function() {
	$('#headerContainer').width($('#headerBackground').width());
});

function showCreatePinForm(bid, pic, note) {
	alert('showCreatePinForm!');
}


