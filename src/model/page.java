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
public class page {
    private ArrayList<component> content = new ArrayList(); 
    private ObservableList<String> components = FXCollections.observableArrayList();
    public page(){
        
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
    
    
    
}
