var slide = document.getElementById("slide");
var next = document.getElementById("next");
var prev = document.getElementById("prev");
var startStop = document.getElementById("startStop");
var dummy;
var started = false;

var ImageArray = ["imgs/Slide1.jpg","imgs/Slide2.jpg","imgs/Slide3.jpg"];

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

function slideShow(){
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
   slideShow();
  
},false);