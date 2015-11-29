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
    private String font;
    
    public paragraphComponent(String content,String font){
        this.content=content;
        this.font = font;
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
     public String getFont(){
         return this.font;
     }
     public void setFont(String font){
         this.font = font;
     }
}
