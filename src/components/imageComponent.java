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
    
    
    public imageComponent(String src,String fl){
        this.source=src;   
        this.floatVal=fl;
    }
    
    public void setSource(String src){
        this.source=src;
    }
    
    public String getSource(){
        return this.source;
    }
    public String getFloatValue(){
        return this.floatVal; 
    }
    public void setFloatValue(String fl){
        this.floatVal=fl;
    }
    
    
}
