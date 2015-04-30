<%@ page language="java" import="java.util.*" pageEncoding="US-ASCII"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
  <head>
    <title>creatBoardForm.html</title>
	
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=US-ASCII">
    <link href="../../css/bundle-desktop-1_a3436a78.css" rel="stylesheet" type="text/css">
	<link href="../../css/bundle-desktop-2_994eb744.css" rel="stylesheet" type="text/css"> 
	<link href="../../css/bundle-desktop-2_5c6c6f50.css" rel="stylesheet" type="text/css"> 
	<link href="../../css/bundle-desktop-2_442c9884.css" rel="stylesheet" type="text/css">
	<!-- <link href="css/bundle-desktop-1_7e764a10.css" rel="stylesheet" type="text/css"> -->
    <link href="../../css/bundle-desktop-main_db38bc94.css" rel="stylesheet" type="text/css">
	<link href="../../css/bootstrap.min.css" rel="stylesheet">
	<!-- <link href="css/bootstrap.css" rel="stylesheet"> -->
	<link href="../../css/dbcommon.css" rel="stylesheet" type="text/css">
   	<script src="../../js/jquery.min.js"></script>
   	<script src="../../js/bootstrap.js"></script>
   	<script src="../../js/common.js"></script>
   	<script src="../../js/jquery.masonry.min.js"></script>
    <script src="../../js/modernizr-transitions.js"></script>
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
    
    <link rel="stylesheet" type="text/css" href="../../css/bundle-desktop-main_db38bc94.css">

  </head>
  
  <body>
    <form class="standardForm" method="post">
    
    <h1 class="createTitle">
        Create a Board
    </h1>


    <ul>
        
            <li>
                <h3><label for="boardEditName">Name</label></h3>
                
                <div>
                    <input id="boardEditName" name="name" type="text" autofocus="" placeholder="Like “Places to Go” or “Recipes to Make.”" value="">
                </div>
            </li>
            <li class="descriptionWrapper">
                <h3><label for="boardEditDescription">Description</label></h3>
                <div>
                    
                    <textarea id="boardEditDescription" class="boardEditDescription" placeholder="What's your board about?" name="description"></textarea>
                </div>
            </li>
            <li class="categoryWrapper">
                <h3><label for="boardEditCategory">Category</label></h3>
                <div>
                    <select class="CategoriesSelect Module Select" name="category">






    






    



    
    <option value="other">
        What kind of board is it?
        
    </option>

    
    <option value="animals">
        Animals &amp; Pets
        
    </option>

    
    <option value="architecture">
        Architecture
        
    </option>

    
    <option value="art">
        Art
        
    </option>

    
    <option value="cars_motorcycles">
        Cars &amp; Motorcycles
        
    </option>

    
    <option value="celebrities">
        Celebrities
        
    </option>

    
    <option value="design">
        Design
        
    </option>

    
    <option value="diy_crafts">
        DIY &amp; Crafts
        
    </option>

    
    <option value="education">
        Education
        
    </option>

    
    <option value="film_music_books">
        Film, Music &amp; Books
        
    </option>

    
    <option value="food_drink">
        Food &amp; Drink
        
    </option>

    
    <option value="gardening">
        Gardening
        
    </option>

    
    <option value="geek">
        Geek
        
    </option>

    
    <option value="hair_beauty">
        Hair &amp; Beauty
        
    </option>

    
    <option value="health_fitness">
        Health &amp; Fitness
        
    </option>

    
    <option value="history">
        History
        
    </option>

    
    <option value="holidays_events">
        Holidays &amp; Events
        
    </option>

    
    <option value="home_decor">
        Home Decor
        
    </option>

    
    <option value="humor">
        Humor
        
    </option>

    
    <option value="illustrations_posters">
        Illustrations &amp; Posters
        
    </option>

    
    <option value="kids">
        Kids &amp; Parenting
        
    </option>

    
    <option value="mens_fashion">
        Men's Fashion
        
    </option>

    
    <option value="outdoors">
        Outdoors
        
    </option>

    
    <option value="photography">
        Photography
        
    </option>

    
    <option value="products">
        Products
        
    </option>

    
    <option value="quotes">
        Quotes
        
    </option>

    
    <option value="science_nature">
        Science &amp; Nature
        
    </option>

    
    <option value="sports">
        Sports
        
    </option>

    
    <option value="tattoos">
        Tattoos
        
    </option>

    
    <option value="technology">
        Technology
        
    </option>

    
    <option value="travel">
        Travel
        
    </option>

    
    <option value="weddings">
        Weddings
        
    </option>

    
    <option value="womens_fashion">
        Women's Fashion
        
    </option>

    
    <option value="other">
        Other
        
    </option>

</select>
                </div>
            </li>
            
            
                <li class="mapToggleWrapper">
                    <h3><label for="place">Add a map?</label></h3>
                    <div>
                        <div class="Checkbox Module fancyToggle styledToggle">







    
        
    

    
        
    

    

<div class="slider"></div>
    <p class="onText status">Yes</p>
    <p class="offText status">No</p>
    <input class="Checkbox Module" name="layout" type="checkbox">









    
    
    
</div>
                    </div>
                </li>
            
            
                <li class="secretToggleWrapper">
                    <h3><label for="secret">Keep it secret?</label></h3>
                    <div>
                        <div class="Checkbox Module fancyToggle styledToggle">







    
        
    

    
        
    

    

<div class="slider"></div>
    <p class="onText status">Yes</p>
    <p class="offText status">No</p>
    <input class="Checkbox Module" name="secret" type="checkbox">









    
    
    
</div>
                        
                            <a href="https://www.pinterest.com/_/_/help/entries/22277603/?source=secret_create" class="external learnMore">
                                Learn more
                            </a>
                        
                    </div>
                </li>
            
        
        
        
        
        
            
        
        
        <li class="boardCollaboratorsWrapper">
            <h3>
                <label>Who can add Pins?</label>
                
                    <a href="https://www.pinterest.com/_/_/help/entries/22997543" class="external learnMore learnAboutBoardInvites">
                        Learn more
                    </a>
                
            </h3>
            <div class="fieldWrapper">
                
                    
                    
    <div class="BoardInviteForm Module">




    



    <div class="inviteWrapper">

        <button class="Button Module btn hasText inviteButton rounded" type="button">




    




<span class="buttonText">Add</span>
        
</button>

        

        
          <div class="fillWidth">
        
        <div class="Module SocialTypeaheadField TypeaheadField userSelect">
















    
    
    
    <input autocomplete="off" class="Input Module field" name="invite" placeholder="Type a name or email" type="text">


    

    

    

    

    












    

    
    

    
    

    
    

    
    

    
    

    
    
        
    

    
    

    
    
        
    

    
    

    
    

    
    

    
    
        
    

    
    

    <div class="Module Typeahead userSelect">


    






    <ul class="results" data-component-type="35"></ul>

</div>

</div>
        
          </div>
        

    </div>



</div>

                

                <div class="boardEditCollaborators">
                    
                    
                    
                        <div class="Module User hasText small thumb">


























    
    
    
    
    

    
    
    
    
    
    
    
    

    
    
    
        <a href="/liupenghuigarde/" data-element-type="64">
    

    
    
    
    
    
    
    
    

    
        
    

    
    
        <div class="thumbImageWrapper">
            
            <img src="https://s-passets-cache-ak0.pinimg.com/images/user/default_30.png" alt="Jasmine Liu" title="More from Jasmine Liu">
        </div>
    
    
    
        <h4 class="fullname">
            Jasmine Liu
        </h4>
    
    
        <div class="subtitle">you created this board</div>
    
    
    

    
        </a>
    


</div>
                    

                    
                    <div class="BoardInvites Module">




<div class="Module PagedCollection PagedGrid">


    <div class="Grid Module">







<div class="GridItems Module fixedHeightLayout">



    















    


    










</div>






</div>


<div class="moreItemsContainer ">
    <button class="Button Module btn hasText moreItems rounded hide" data-element-type="179" type="button">




    




<span class="buttonText">More Invites</span>
        
</button>
</div>
</div>
</div>
                </div>
            </div>
        </li>

        
        

        
        
    </ul>

    
    <div class="formFooter">
        <div class="formFooterButtons">
            <button class=" Button Module btn cancelButton hasText rounded" type="button">




    




<span class="buttonText">Cancel</span>
        
</button>
            <button class="Button Module btn hasText primary rounded saveBoardButton" type="submit">




    




<span class="buttonText">Create Board</span>
        
</button>
        </div>
    </div>

</form>
  </body>
</html>
