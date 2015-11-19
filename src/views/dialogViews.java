/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.image.BufferedImage;
import java.io.File;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 *
 * @author benkandov
 */
public class dialogViews {
    
    Stage primaryStage;
    Scene primaryScene;
    Screen screen = Screen.getPrimary();
    Rectangle2D bounds = screen.getVisualBounds();
    public dialogViews(){
        primaryStage = new Stage();
        primaryStage.setX(bounds.getMinX()+bounds.getHeight()/2);
	primaryStage.setY(bounds.getMinY()+bounds.getWidth()/4);
	primaryStage.setWidth(bounds.getWidth()/6);
	primaryStage.setHeight(bounds.getHeight()/7); 
    }
    public void selectLayoutTemplate(){
        

        VBox body = new VBox();
        Text t = new Text("Choose a layout template:");
        Button a = new Button("A");
        Button b = new Button("B");
        Button c = new Button("C");
        Button d = new Button("D");
        Button e = new Button("E");
        FlowPane dummy = new FlowPane(a,b,c,d,e);

        body.getChildren().add(t);
        body.getChildren().add(dummy);
        primaryScene = new Scene(body);  
       
        primaryStage.setScene(primaryScene);
          
        primaryStage.show();      
    }
    public void selectColorTemplate(){
         

        VBox body = new VBox();
        Text t = new Text("Choose a color template:");
        Button a = new Button("A");
        Button b = new Button("B");
        Button c = new Button("C");
        Button d = new Button("D");
        Button e = new Button("E");
        FlowPane dummy = new FlowPane(a,b,c,d,e);
             
        body.getChildren().add(t);  
        body.getChildren().add(dummy);
        primaryScene = new Scene(body);
        primaryStage.setScene(primaryScene);
        primaryStage.show(); 
    }
    public void selectBannerImage(){
        Button g = new Button("Okay");
        VBox body = new VBox();
        Text t = new Text("Select a banner image:");
        Button choose = new Button("Choose");
        body.getChildren().add(t);
        body.getChildren().add(g);
        primaryScene = new Scene(body);
        primaryStage.setScene(primaryScene);
        primaryStage.show();
    }
   ;
    public void chooseComponentFont(){
        primaryStage.setWidth(bounds.getWidth()/5);
	primaryStage.setHeight(bounds.getHeight()/6); 
        VBox body = new VBox();
        Text t = new Text("Choose a font for this component:");
        Button a = new Button("Font A");
        a.getStylesheets().add("https://fonts.googleapis.com/css?family=Architects+Daughter");
        a.setStyle("-fx-font-family: 'Architects Daughter' ;");
        Button b = new Button("Font B");
        b.getStylesheets().add("https://fonts.googleapis.com/css?family=Shadows+Into+Light");
        b.setStyle("-fx-font-family: 'Shadows Into Light' ;");
        Button c = new Button("Font C");
        c.getStylesheets().add("https://fonts.googleapis.com/css?family=Indie+Flower");
        c.setStyle("-fx-font-family: 'Indie Flower' ;");
        Button d = new Button("Font D");
        d.getStylesheets().add("https://fonts.googleapis.com/css?family=Poiret+One");
        d.setStyle("-fx-font-family: 'Poiret One' ;");
        Button e = new Button("Font E");
        e.getStylesheets().add("https://fonts.googleapis.com/css?family=Ubuntu+Condensed");
        e.setStyle("-fx-font-family: 'Ubuntu Condensed'; ");
        FlowPane dummy = new FlowPane(a,b,c,d,e);
             
        body.getChildren().add(t);  
        body.getChildren().add(dummy);
        primaryScene = new Scene(body);
        primaryStage.setScene(primaryScene);
        primaryStage.show(); 
    }
    public void updatePageTitle(){
        Text t = new Text("Enter a new page title:");
        TextArea b = new TextArea();
        Button g = new Button("Okay");
        VBox body = new VBox(t,b,g);
        primaryScene = new Scene(body);
        primaryStage.setScene(primaryScene);
        primaryStage.show();
    }
    public void updateStudentName(){
        Text t = new Text("Enter a new student name:");
        TextArea b = new TextArea();
        Button g = new Button("Okay");
        VBox body = new VBox(t,b,g);
        
        primaryScene = new Scene(body);
        primaryStage.setScene(primaryScene);
        primaryStage.show();
    }
    public void updateFooter(){
        Text t = new Text("Enter new footer text content:");
        TextArea b = new TextArea();
        Button g = new Button("Okay");
        VBox body = new VBox(t,b,g);
        primaryScene = new Scene(body);
        primaryStage.setScene(primaryScene);
        primaryStage.show();
    }
    public void addTextComponent(){
        primaryStage.setWidth(bounds.getWidth()/4);
	primaryStage.setHeight(bounds.getHeight()/6); 
        Text t = new Text("What kind of text component would you like to create?");
        Button a = new Button("Paragraph");
        Button b = new Button("List");
        Button c = new Button("Header");
        FlowPane dummy = new FlowPane(a,b,c);
       
        VBox body = new VBox(t,dummy);
        primaryScene = new Scene(body);
        primaryStage.setScene(primaryScene);
        primaryStage.show();
        a.setOnAction(e -> {
	   this.createParagraph();
	});
         b.setOnAction(e -> {
	   this.listItems();
	});
        c.setOnAction(e -> {
	   this.createHeader();
	});
    }
    public void createParagraph(){
        primaryStage.setWidth(bounds.getWidth()/4);
	primaryStage.setHeight(bounds.getHeight()/6);
        Text t = new Text("Write paragraph:");
        TextArea r = new TextArea();
        VBox body = new VBox(t,r);
        primaryScene = new Scene(body);
        primaryStage.setScene(primaryScene);
        primaryStage.show();
    }
    public void createHeader(){
        primaryStage.setWidth(bounds.getWidth()/4);
	primaryStage.setHeight(bounds.getHeight()/6); 
        Text t = new Text("Write Header:");
        TextArea r = new TextArea();
        Button g = new Button("Okay");
        VBox body = new VBox(t,r,g);
        primaryScene = new Scene(body);
        primaryStage.setScene(primaryScene);
        primaryStage.show();
    }
    public void listItems(){
        Text t = new Text("How many items?");
        TextArea n = new TextArea();
        Button g = new Button("Okay");
        VBox body = new VBox(t,n,g);
        primaryScene = new Scene(body);
        primaryStage.setScene(primaryScene);
        primaryStage.show();
         g.setOnAction(e -> {
	   this.createList(5);
	});
    }
    public void createList(int num){
        primaryStage.setWidth(bounds.getWidth()/4);
	primaryStage.setHeight(bounds.getHeight()/4); 
        VBox body = new VBox();
        for(int i = 0;i<num;i++){
            TextField a = new TextField("List Item " + i+1);
            body.getChildren().add(a);
        }
        Button g = new Button("Okay");
        body.getChildren().add(g);
        primaryScene = new Scene(body);
        primaryStage.setScene(primaryScene);
        primaryStage.show();
    }
    public void addImageComponent(){
        Text t = new Text("Select Image to add:");
        Button g = new Button("Okay");
        VBox body = new VBox(t,g);
        primaryScene = new Scene(body);
        primaryStage.setScene(primaryScene);
        primaryStage.show();
        /**
         * TODO add file chooser functionality to this and banner image chooser
         */
    }
    public void addSlideshowComponent(){
        
        
    }
    public void addVideoComponent(){
          Text t = new Text("Select Video to add:");
        
        Button g = new Button("Okay");
        Text r = new Text("Input width: ");
        TextArea q = new TextArea();
        Text s = new Text("Input height: ");
        TextArea f = new TextArea();
        VBox body = new VBox(t,g,r,q,s,f);
        primaryScene = new Scene(body);
        primaryStage.setScene(primaryScene);
        primaryStage.show();
        /**
         * TODO add file chooser functionality to this 
         */
    }
    public void removeComponent(){
         primaryStage.setWidth(bounds.getWidth()/4);
	primaryStage.setHeight(bounds.getHeight()/4); 
        Text t = new Text("Are you sure you wish to remove this component?");
        Button yes = new Button("Yes");
        Button no =  new Button("No");
        FlowPane dummy = new FlowPane(yes,no);
        VBox body = new VBox(t,dummy);
        primaryScene = new Scene(body);
        primaryStage.setScene(primaryScene);
        primaryStage.show();
    }
    public void editTextComponent(){
        
    }
    public void editImageComponent(){
        
    }
    public void editSlideshowComponent(){
        
    }
    public void editVideoComponent(){
        
    }
    public void addTextHyperlink(){
        
    }
    public void editTextHyperlink(){
        
    }
}
