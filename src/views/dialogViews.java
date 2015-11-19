/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

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
        VBox body = new VBox();
        Text t = new Text("Select a banner image:");
        body.getChildren().add(t);
        primaryScene = new Scene(body);
        primaryStage.setScene(primaryScene);
        primaryStage.show();
    }
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
    
    
}
