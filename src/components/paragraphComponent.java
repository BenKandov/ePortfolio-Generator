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
public class paragraphComponent extends textComponent {
    private String content;
    
    public paragraphComponent(String content){
        this.content=content;
    }
    
    public void setContent(String c){
        this.content=c;
    }
    public String getContent(){
        return this.content;
    }
    @Override
     public String getType(){
        return "Paragraph Component";
    }
}
