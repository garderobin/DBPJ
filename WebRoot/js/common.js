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

    var $container = $('#masonryContainer');
  
    $container.imagesLoaded( function(){
      $container.masonry({
        itemSelector : '.masonryItem',
        columnWidth:236,
        gutterWidth:10,
        isFitWidth:true
//        isAnimated:true
      });
    });
  
//    var $container2 = $('.#masonryBoard');
//    
//    $container2.imagesLoaded( function(){
//      $container2.masonry({
//        itemSelector : '.masonryItem',
//        columnWidth:236,
//        gutterWidth:10,
//        isFitWidth:true
////        isAnimated:true
//      });
//    });
    
    //$('#headerContainer').width($container.width());
    $('#headerContainer').width($('#headerBackground').width());
    
    //masonryBoard
    
});

$(window).resize(function() {
	$('#headerContainer').width($('#headerBackground').width());
});

$(function(){

    var $smallContainer = $('#masonrySmall');
  
    $smallContainer.imagesLoaded( function(){
    	$smallContainer.masonry({
        itemSelector : '.masonrySmallItem',
        columnWidth:70,
        gutterWidth:2,
        isFitWidth:true
//        isAnimated:true
      });
    });
    
});

//$(function() {
//
//	// Do our DOM lookups beforehand
//	var nav_container = $(".nav-container");
//	var nav = $("nav");
//	
//	var top_spacing = 15;
//	var waypoint_offset = 50;
//
//	nav_container.waypoint({
//		handler: function(event, direction) {
//			
//			if (direction == 'down') {
//			
//				nav_container.css({ 'height':nav.outerHeight() });		
//				nav.stop().addClass("sticky").css("top",-nav.outerHeight()).animate({"top":top_spacing});
//				
//			} else {
//			
//				nav_container.css({ 'height':'auto' });
//				nav.stop().removeClass("sticky").css("top",nav.outerHeight()+waypoint_offset).animate({"top":""});
//				
//			}
//			
//		},
//		offset: function() {
//			return -nav.outerHeight()-waypoint_offset;
//		}
//	});
//	
//	var sections = $("section");
//	var navigation_links = $("nav a");
//	
//	sections.waypoint({
//		handler: function(event, direction) {
//		
//			var active_section;
//			active_section = $(this);
//			if (direction === "up") active_section = active_section.prev();
//
//			var active_link = $('nav a[href="#' + active_section.attr("id") + '"]');
//			navigation_links.removeClass("selected");
//			active_link.addClass("selected");
//
//		},
//		offset: '25%'
//	})
//	
//	
//	navigation_links.click( function(event) {
//
//		$.scrollTo(
//			$(this).attr("href"),
//			{
//				duration: 400,
//				offset: { 'left':0, 'top':-0.08*$(window).height() }
//			}
//		);
//	});
//
//
//});

