/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    jQuery('#bannerImage').bind('load', function() {
        jQuery('div').imagefit();
    });
    
var items = [];
var obj;
var navBar;
var components;
var numSlideShows=0;
$.getJSON("file.json",function(data){
    
    $.each(data, function( key, val ) {
        items.push(key + val);    
      
    });
  //  obj = data.sites;
    navBar = data.navBar;
    components = data.components;
    
    title.innerHTML = data.title;
    banner.innerHTML = data.bannerText;
    if(data.bannerImg == "Icons/question.png"){
    	bannerImg.setAttribute("src","imgs/blueBanner.jpg");
    }else{
    	bannerImg.setAttribute("src",data.bannerImg);
    }
   
    var i = 0;
    while(navBar[i]!=null){
        if(navBar[i].dest == "none"){
            $("#navBar").append("<div class=pageRef>" + navBar[i].name + "</div>");
        }else{
            $("#navBar").append("<div class=pageRef>     <a href="+ "../" + navBar[i].dest + ">" + navBar[i].name + "          </a> </div> ");
        }   
        i++;
    }
    i= 0;
    while(components[i]!=null){
    	if(components[i].type=="header"){
    		$("#content").append("<div style='padding-bottom:9%' class='text'> <h1>" + components[i].content + "</h2></div>");
    	}
        if(components[i].type=="text"){
            $("#content").append("<div style='padding-bottom:9%' class='text'>" + components[i].content + "</div>");
        }
    	if(components[i].type=="list"){
            list = components[i].content;
            $("#content").append("<div style='padding-bottom:9%' > <ol>");
            var j = 0;
            while(list[j]!=null){
                 $("#content").append("<li>" + list[j].content +"</li>");
                 j++;
            }
             $("#content").append("</ol> </div>");
        }
        if(components[i].type=="video"){
         //   var ext = components[i].ext;
            var src = components[i].src;
            $("#content").append("<div style='padding-bottom:9%; text-align:center'>"+ components[i].caption);
            $("#content").append("<video width='"+ components[i].width + "' height='" + components[i].height +"' controls> <source src='" + src +"' type='" +"video/mp4"+ "'> </video>");
           $("#content").append("</div>");
         
        }
        if(components[i].type=="image"){
        	$("#content").append("<div style='padding-bottom:9%; text-align:center'>"+ components[i].caption);
        	
        	if(components[i].float == "Float Right"){
        	$("#content").append("<img  style='float:right' width='"+ components[i].width + "' height='" + components[i].height +"' src='"+ components[i].src +"'/>");	
        	}else if(components[i].float == "Float Left"){
        	$("#content").append("<img style='float:left' width='"+ components[i].width + "' height='" + components[i].height +"' src='"+ components[i].src +"'/>");
        	}else{
            $("#content").append("<img width='"+ components[i].width + "' height='" + components[i].height +"' src='"+ components[i].src +"'/>");
       		
       		}
       		$("#content").append("</div>");
        }
        if(components[i].type=="slideshow"){
            var slides = [];
            var dummy2 = components[i].images;
            var k = 0;
            while(dummy2[k]!=null){
                slides[k]=dummy2[k].src;
                k++;
            }
            $("#content").append("<img class='prev' id='prev" + numSlideShows  + "'" + "src='imgs/Prev.png'/>");
            $("#content").append("<img class='slide' id='slide"+ numSlideShows  + "'" + "src='imgs/Slide1.jpg' />");
            $("#content").append(" <img class='next'  id='next"+ numSlideShows  + "'" + "src='imgs/Next.png'/>");
            $("#content").append("<img class='startStop' id='startStop"+ numSlideShows  + "'" + "src='imgs/start.png' />");
            var prev = "prev"+numSlideShows;
            var slide = "slide"+numSlideShows;
            var next= "next"+numSlideShows;
            var startStop = "startStop"+numSlideShows;  
            slideshow(slides,prev,slide,next,startStop);
            numSlideShows++;
        }
        i++;
    }
    $("#content").append("<p style='padding-top:10%; position:relative'>" + data.footer + "</p>");
    
    
    
 });
 
function slideshow(ImageArray,prev,slide,next,startStop){
    var slide = document.getElementById(slide.toString());
    var next = document.getElementById(next.toString());
    var prev = document.getElementById(prev.toString());
    var startStop = document.getElementById(startStop.toString());
    var dummy;
    var started = false;



    var imageIndex = 0;

    function nextImage(){
        imageIndex++;
        if(imageIndex>=ImageArray.length){
            imageIndex=0;
        }
        slide.setAttribute("src",ImageArray[imageIndex]);

    }

    function prevImage(){
        imageIndex--;
        if(imageIndex<0){
            imageIndex=ImageArray.length-1;
        }
        slide.setAttribute("src",ImageArray[imageIndex]);

    }

    function auto(){
        if(!started){
            startStop.setAttribute("src","imgs/stop.png");
            dummy = setInterval(nextImage,3000);
            started=true;
        }else{    
            clearInterval(dummy);
            started=false;
            startStop.setAttribute("src","imgs/start.png");
        }



    }

    next.addEventListener("click",function(){
        nextImage();

    },false);
    prev.addEventListener("click",function(){
        prevImage();

    },false);
    startStop.addEventListener("click",function(){
       auto();

    },false);

}
