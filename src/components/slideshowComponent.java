/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import java.util.ArrayList;

/**
 *
 * @author benkandov
 */
public class slideshowComponent extends component {
    ArrayList<String> captions;
    ArrayList<String> imageSources;
   
    
    public slideshowComponent(ArrayList<String> captions,ArrayList<String> imageSources){
        this.captions=captions;
        this.imageSources=imageSources;
    }
    
    
    @Override
      public String getType(){
        return "Slideshow Component";
    }
      
     public void setCaptions(ArrayList<String> captions){
         this.captions=captions;
     }
     public ArrayList<String> getCaptions(){
         return this.captions;
     }
     public void setImageSources( ArrayList<String> imageSources){
         this.imageSources=imageSources;
     }
     public ArrayList<String> getImageSources(){
         return this.imageSources;
     }
      
      
      
}
