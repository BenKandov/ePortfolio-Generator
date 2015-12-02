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
public class videoComponent extends component {
    
    private String caption;
    private String source;
    private int width;
    private int height;
    
    public videoComponent(String caption,String src,int w,int h){
        this.caption=caption;
        this.source = src;
        this.width = w;
        this.height = h;
    }
    
    public void setCaption(String c){
        this.caption=c;
    }
    
    public String getCaption(){
        return this.caption;
    }
    
    public void setSource(String src){
        this.source = src;
    }
    public String getSource(){
        return this.source;
    }
    public void setWidth(int w){
        this.width=w;
    }
    public int getWidth(){
        return this.width;
    }
    public void setHeight(int h){
        this.height=h;
    }
    public int getHeight(){
        return this.height;
    }
            @Override
      public String getType(){
        return "Video Component";
    }
}
