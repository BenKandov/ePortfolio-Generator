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
public class listComponent extends textComponent{
    private ArrayList<String> content;
    
    public listComponent(ArrayList<String> c){
        this.content = c;
    }
    
    public ArrayList<String> getList(){
        return this.content;
    }
    
    @Override
    public String getItem(int i){
        return this.content.get(i);
    }
    
    public void removeItem(int i){
        this.content.remove(i);
    }
    
    public void addItem(int position,String item){
        this.content.add(position, item);
    }
    @Override
  public String getType(){
        return "List Component";
    }    
  public void removeItem(String item){
      this.content.remove(item);
  }
    
    
}
