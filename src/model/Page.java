/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import components.component;
import java.awt.Component;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author benkandov
 */
public class Page {
    private ArrayList<component> content = new ArrayList(); 
    private ObservableList<String> components = FXCollections.observableArrayList();
    private String title;
    private String studentName;
    private String layoutTemplate;
    private String colorTemplate;
    private String bannerImage;
    
    public Page(){
        
    }
    
    public void addComponent(component c){
        content.add(c);
        components.add(c.getType() + content.size());
    }
    public component findComponent(int position){
        return content.get(position);
    }
    public void removeComponent(int position){
        content.remove(position);
    }
    public ObservableList<String> getComponents(){
        return components;
    }
    public String getTitle(){
        return this.title;
    }
    public void setTitle(String t){
        this.title = t;
    }
    public String getStudentName(){
        return this.studentName;
    }
    public void setStudentName(String s){
        this.studentName=s;
    }
    public String getLayoutTemplate(){
        return this.layoutTemplate;
    }
    public void setLayoutTemplate(String l){
        this.layoutTemplate=l;
    }
    public String getColorTemplate(){
        return this.colorTemplate;
    }
    public void setColorTemplate(String c){
        this.colorTemplate=c;
    }
    public String getBannerImage(){
        return this.bannerImage;
    }
    public void setBannerImage(String src){
        this.bannerImage=src;
    }
            
      
}
