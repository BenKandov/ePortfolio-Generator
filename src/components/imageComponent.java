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
    private int width;
    private int height;
    
    
    public imageComponent(String src,String fl,String c,int width, int height){
        this.source=src;   
        this.floatVal=fl;
        this.caption=c;
        this.width=width;
        this.height=height;
    }
    public void setWidth(int w){
        this.width=w;
    }
    
    public void setHeight(int h){
        this.height=h;
    }
    public int getWidth(){
        return this.width;
    }
    public int getHeight(){
        return this.height;
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
