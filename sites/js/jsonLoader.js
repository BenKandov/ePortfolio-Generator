/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var items = [];
var obj;
var navBar;
var components;
var numSlideShows=0;
$.getJSON("json/SampleSite.json",function(data){
    
    $.each(data, function( key, val ) {
        items.push(key + val);    
      
    });
    obj = data.sites;
    navBar = obj[0].navBar;
    components = obj[0].components;
    
    title.innerHTML = obj[0].title;
    banner.innerHTML = obj[0].bannerText;
    bannerImg.setAttribute("src",obj[0].bannerImg);
    var i = 0;
    while(navBar[i]!=null){
        if(navBar[i].dest == "none"){
            $("#navBar").append("<div class=pageRef>" + navBar[i].name + "</div>");
        }else{
            $("#navBar").append("<div class=pageRef> <a href="+ navBar[i].dest + ">" + navBar[i].name + "</a> </div> ");
        }   
        i++;
    }
    i= 0;
    while(components[i]!=null){
        if(components[i].type=="text"){
            $("#content").append("<div class='component' class='text'>" + components[i].contents + "</div>");
        }
                if(components[i].type=="ordered list"){
            list = components[i].items;
            $("#content").append("<ol>");
            var j = 0;
            while(list[j]!=null){
                 $("#content").append("<li>" + list[j].contents +"</li>");
                 j++;
            }
             $("#content").append("</ol>");
        }
        if(components[i].type=="video"){
            var ext = components[i].ext;
            var src = components[i].src;
            $("#content").append("<video width='320' height='240' controls> <source src='" + src +"' type='" + ext+ "'> </video>");
           
         
        }
        if(components[i].type=="image"){
            $("#content").append("<img src='"+ components[i].src +"'/>");
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
