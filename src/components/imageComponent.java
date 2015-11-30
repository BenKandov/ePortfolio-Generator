/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

/**
 *
 * @author benkandov
 */
public class imageComponent extends component {
    private String source;
    private String floatVal;
    private String caption;
    
    
    
    public imageComponent(String src,String fl,String c){
        this.source=src;   
        this.floatVal=fl;
        this.caption=c;
    }
    
    public void setSource(String src){
        this.source=src;
    }
    
    public String getSource(){
        return this.source;
    }
    public String getCaption(){
        return this.caption;
    }
    public void setCaption(String c){
        this.caption = c;
    }
    public String getFloatValue(){
        return this.floatVal; 
    }
    public void setFloatValue(String fl){
        this.floatVal=fl;
    }
    @Override
      public String getType(){
        return "Image Component";
    }
    
}
