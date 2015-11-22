/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Desktop;
import static java.awt.SystemColor.desktop;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.Window;
import javax.imageio.ImageIO;

/**
 *
 * @author benkandov
 */
public class dialogViews {
    int counter=0;
    private Desktop desktop = Desktop.getDesktop();
    Stage fileChooserStage;
    Scene fileScene;
    Stage primaryStage;
    Scene primaryScene;
    Screen screen = Screen.getPrimary();
    Rectangle2D bounds = screen.getVisualBounds();
    public dialogViews(){
        fileChooserStage = new Stage();
        fileChooserStage.setX(bounds.getMinX()+bounds.getHeight()/2);
	fileChooserStage.setY(bounds.getMinY()+bounds.getWidth()/4);
	fileChooserStage.setWidth(bounds.getWidth()/6);
	fileChooserStage.setHeight(bounds.getHeight()/7); 
        
        
        primaryStage = new Stage();
        primaryStage.setX(bounds.getMinX()+bounds.getHeight()/2);
	primaryStage.setY(bounds.getMinY()+bounds.getWidth()/4);
	primaryStage.setWidth(bounds.getWidth()/6);
	primaryStage.setHeight(bounds.getHeight()/7); 
    }
    public void selectLayoutTemplate(){
        primaryStage.setX(bounds.getMinX()+bounds.getWidth()/2);
	primaryStage.setY(bounds.getMinY()+bounds.getHeight()/3);
	primaryStage.setWidth(300);
	primaryStage.setHeight(200); 

       VBox body = new VBox(20);
        Text t = new Text("Choose a layout template:");
        Button a = new Button("A");
        
        Button b = new Button("B");
        
        Button c = new Button("C");
        Button d = new Button("D");
        Button e = new Button("E");
        
        body.getStylesheets().add("css/style.css");
        a.getStyleClass().add("dialog_button");
        b.getStyleClass().add("dialog_button");
        c.getStyleClass().add("dialog_button");
        d.getStyleClass().add("dialog_button");
        e.getStyleClass().add("dialog_button");
        
       
        HBox dummy = new HBox(a,b,c,d,e);
        dummy.setSpacing(10);
        dummy.setAlignment(Pos.CENTER);
        body.setAlignment(Pos.TOP_CENTER);
         body.getStyleClass().add("dialog_box");
        t.getStyleClass().add("dialog_text");
        body.getChildren().add(t);

        body.getChildren().add(dummy);
        
        
        primaryScene = new Scene(body);  
        
        primaryStage.setScene(primaryScene);
          
        primaryStage.show();      
    }
    public void selectColorTemplate(){
           primaryStage.setX(bounds.getMinX()+bounds.getWidth()/2);
	primaryStage.setY(bounds.getMinY()+bounds.getHeight()/3);
	primaryStage.setWidth(350);
	primaryStage.setHeight(200); 

          VBox body = new VBox(20);
        Text t = new Text("Choose a color template:");
        
        Button a = new Button("A");
        Button b = new Button("B");
        Button c = new Button("C");
        Button d = new Button("D");
        Button e = new Button("E");
        body.getStylesheets().add("css/style.css");
        body.getStyleClass().add("dialog_box");
        a.getStyleClass().add("dialog_button");
        b.getStyleClass().add("dialog_button");
        c.getStyleClass().add("dialog_button");
        d.getStyleClass().add("dialog_button");
        e.getStyleClass().add("dialog_button");
        
        HBox dummy = new HBox(a,b,c,d,e);
        dummy.setSpacing(10);
        body.setAlignment(Pos.TOP_CENTER);
        body.getChildren().add(t);  
        dummy.setAlignment(Pos.CENTER);
        body.getChildren().add(dummy);
        t.getStyleClass().add("dialog_text");
        primaryScene = new Scene(body);
        primaryStage.setScene(primaryScene);
        primaryStage.show(); 
    }
    public void selectBannerImage(){
        primaryStage.setX(bounds.getMinX()+bounds.getWidth()/2);
	primaryStage.setY(bounds.getMinY()+bounds.getHeight()/3);
	primaryStage.setWidth(350);
	primaryStage.setHeight(200); 
        VBox body = new VBox(20);
        body.getStylesheets().add("css/style.css");
        body.getStyleClass().add("dialog_box");
        Text t = new Text("Select a banner image:");
       
        
        Button a = new Button("A");
        Button b = new Button("B");
        Button c = new Button("C");
        Button d = new Button("D");
        Button e = new Button("E");
        body.getStylesheets().add("css/style.css");
        body.getStyleClass().add("dialog_box");
        a.getStyleClass().add("dialog_button");
        b.getStyleClass().add("dialog_button");
        c.getStyleClass().add("dialog_button");
        d.getStyleClass().add("dialog_button");
        e.getStyleClass().add("dialog_button");
        
        HBox dummy = new HBox(a,b,c,d,e);
        dummy.setSpacing(10);
        
        dummy.setAlignment(Pos.CENTER);
        body.getChildren().add(t);
       
         body.getChildren().add(dummy);
         body.setAlignment(Pos.TOP_CENTER);
         t.getStyleClass().add("dialog_text");
        primaryScene = new Scene(body);
        primaryStage.setScene(primaryScene);
        primaryStage.show();
    }
   ;
    public void chooseComponentFont(){
        primaryStage.setX(bounds.getMinX()+bounds.getWidth()/2);
	primaryStage.setY(bounds.getMinY()+bounds.getHeight()/3);
	
        primaryStage.setWidth(bounds.getWidth()/3);
	primaryStage.setHeight(bounds.getHeight()/5); 
        VBox body = new VBox(20);
          body.getStylesheets().add("css/style.css");
        body.getStyleClass().add("dialog_box");
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
        
        a.getStyleClass().add("dialog_button");
        b.getStyleClass().add("dialog_button");
        c.getStyleClass().add("dialog_button");
        d.getStyleClass().add("dialog_button");
        e.getStyleClass().add("dialog_button");
        
        
        
        HBox dummy = new HBox(a,b,c,d,e);
        dummy.setSpacing(10);
        dummy.setAlignment(Pos.CENTER);
        body.setAlignment(Pos.TOP_CENTER);
        body.getChildren().add(t);  
        body.getChildren().add(dummy);
        t.getStyleClass().add("dialog_text");
        primaryScene = new Scene(body);
        primaryStage.setScene(primaryScene);
        primaryStage.show(); 
    }
    public void updatePageTitle(){
        primaryStage.setX(bounds.getMinX()+bounds.getWidth()/2);
	primaryStage.setY(bounds.getMinY()+bounds.getHeight()/3);
	primaryStage.setWidth(300);
	primaryStage.setHeight(250); 
        
        Text t = new Text("Enter a new page title:");
        TextArea b = new TextArea();
        
        Button g = new Button("Okay");
        VBox body = new VBox(t,b,g);
        body.getStylesheets().add("css/style.css");
        g.getStyleClass().add("dialog_button");
         body.setAlignment(Pos.TOP_CENTER);
         body.getStyleClass().add("dialog_box");
         t.getStyleClass().add("dialog_text");
           body.setSpacing(20);
        primaryScene = new Scene(body);
        primaryStage.setScene(primaryScene);
        primaryStage.show();
    }
    public void updateStudentName(){
        primaryStage.setX(bounds.getMinX()+bounds.getWidth()/2);
	primaryStage.setY(bounds.getMinY()+bounds.getHeight()/3);
	primaryStage.setWidth(300);
	primaryStage.setHeight(250); 
        Text t = new Text("Enter a new student name:");
        TextArea b = new TextArea();
        Button g = new Button("Okay");
        
        VBox body = new VBox(t,b,g);
           body.getStylesheets().add("css/style.css");
           g.getStyleClass().add("dialog_button");
         body.setAlignment(Pos.TOP_CENTER);
         body.getStyleClass().add("dialog_box");
         t.getStyleClass().add("dialog_text");
           body.setSpacing(20);
        primaryScene = new Scene(body);
        primaryStage.setScene(primaryScene);
        primaryStage.show();
    }
    public void updateFooter(){
        primaryStage.setX(bounds.getMinX()+bounds.getWidth()/2);
	primaryStage.setY(bounds.getMinY()+bounds.getHeight()/3);
	primaryStage.setWidth(300);
	primaryStage.setHeight(250); 
        Text t = new Text("Enter new footer text content:");
        TextArea b = new TextArea();
        Button g = new Button("Okay");
        VBox body = new VBox(t,b,g);
         body.getStylesheets().add("css/style.css");
           g.getStyleClass().add("dialog_button");
         body.setAlignment(Pos.TOP_CENTER);
         body.getStyleClass().add("dialog_box");
         t.getStyleClass().add("dialog_text");
           body.setSpacing(20);
        primaryScene = new Scene(body);
        primaryStage.setScene(primaryScene);
        primaryStage.show();
    }
    public void addTextComponent(){
        primaryStage.setX(bounds.getMinX()+bounds.getWidth()/2);
	primaryStage.setY(bounds.getMinY()+bounds.getHeight()/3);
        primaryStage.setWidth(450);
	primaryStage.setHeight(200); 
        Text t = new Text("What kind of text component would you like to create?");
        Button a = new Button("Paragraph");
        Button b = new Button("List");
        Button c = new Button("Header");
       HBox dummy = new HBox(a,b,c);
        dummy.setSpacing(10);
        dummy.setAlignment(Pos.CENTER);
       
        VBox body = new VBox(t,dummy);
            body.getStylesheets().add("css/style.css");
            body.setAlignment(Pos.TOP_CENTER);
         body.getStyleClass().add("dialog_box");
           a.getStyleClass().add("dialog_button");
           b.getStyleClass().add("dialog_button");
           c.getStyleClass().add("dialog_button");
           
        t.getStyleClass().add("dialog_text");
          body.setSpacing(20);
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
         primaryStage.setX(bounds.getMinX()+bounds.getWidth()/2);
	primaryStage.setY(bounds.getMinY()+bounds.getHeight()/3);
        primaryStage.setWidth(450);
	primaryStage.setHeight(400);
        
        Button g = new Button("Okay");
        Text t = new Text("Write paragraph:");
        TextArea r = new TextArea();
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
        
        a.getStyleClass().add("dialog_button");
        b.getStyleClass().add("dialog_button");
        c.getStyleClass().add("dialog_button");
        d.getStyleClass().add("dialog_button");
        e.getStyleClass().add("dialog_button");
        
        
        
        HBox dummy = new HBox(a,b,c,d,e);
        dummy.setSpacing(10);
        dummy.setAlignment(Pos.CENTER);
        
        VBox body = new VBox(t,r,dummy,g);
         body.getStylesheets().add("css/style.css");
         body.setAlignment(Pos.TOP_CENTER);
         body.getStyleClass().add("dialog_box");
           g.getStyleClass().add("dialog_button");
           t.getStyleClass().add("dialog_text");
             body.setSpacing(20);
        primaryScene = new Scene(body);
        primaryStage.setScene(primaryScene);
        primaryStage.show();
    }
    public void createHeader(){
         primaryStage.setX(bounds.getMinX()+bounds.getWidth()/2);
	primaryStage.setY(bounds.getMinY()+bounds.getHeight()/3);
        primaryStage.setWidth(450);
	primaryStage.setHeight(350); 
        Text t = new Text("Write Header:");
        TextField r = new TextField();
        Button g = new Button("Okay");
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
        
        a.getStyleClass().add("dialog_button");
        b.getStyleClass().add("dialog_button");
        c.getStyleClass().add("dialog_button");
        d.getStyleClass().add("dialog_button");
        e.getStyleClass().add("dialog_button");
        
        
        
        HBox dummy = new HBox(a,b,c,d,e);
        dummy.setSpacing(10);
        dummy.setAlignment(Pos.CENTER);
        VBox body = new VBox(t,r,dummy,g);
          body.getStylesheets().add("css/style.css");
            body.setAlignment(Pos.TOP_CENTER);
         body.getStyleClass().add("dialog_box");
           g.getStyleClass().add("dialog_button");
           t.getStyleClass().add("dialog_text");
             body.setSpacing(20);
        primaryScene = new Scene(body);
        primaryStage.setScene(primaryScene);
        primaryStage.show();
    }
    public void listItems(){
         primaryStage.setX(bounds.getMinX()+bounds.getWidth()/2);
	primaryStage.setY(300);
        Text t = new Text("How many items?");
        TextArea n = new TextArea();
        Button g = new Button("Okay");
        VBox body = new VBox(t,n,g);
         body.getStylesheets().add("css/style.css");
         body.setAlignment(Pos.TOP_CENTER);
         body.getStyleClass().add("dialog_box");
           g.getStyleClass().add("dialog_button");
          t.getStyleClass().add("dialog_text");
             body.setSpacing(20);
        primaryScene = new Scene(body);
        primaryStage.setScene(primaryScene);
        primaryStage.show();
         g.setOnAction(e -> {
	   this.createList(5);
	});
    }
    public void createList(int num){
         primaryStage.setX(bounds.getMinX()+bounds.getWidth()/2);
	primaryStage.setY(bounds.getMinY()+bounds.getHeight()/3);
        primaryStage.setWidth(bounds.getWidth()/4);
	primaryStage.setHeight(300); 
        VBox body = new VBox();
        for(int i = 0;i<num;i++){
            int du = i+1;
            TextField a = new TextField("List Item " + du);
            body.getChildren().add(a);
        }
        Button g = new Button("Okay");
        body.getChildren().add(g);
          body.getStylesheets().add("css/style.css");
            body.setAlignment(Pos.TOP_CENTER);
         body.getStyleClass().add("dialog_box");
         g.getStyleClass().add("dialog_button");
            body.setSpacing(20);
        primaryScene = new Scene(body);
        primaryStage.setScene(primaryScene);
        primaryStage.show();
    }
    public void addImageComponent(){
          primaryStage.setX(bounds.getMinX()+bounds.getWidth()/2);
	primaryStage.setY(bounds.getMinY()+bounds.getHeight()/3);
        primaryStage.setWidth(600);
	primaryStage.setHeight(600); 
       ImageView comp = new ImageView();
       Text c = new Text("Caption");
       TextField caption = new TextField();
        FileChooser fileChooser = new FileChooser();
        Button fileChoose = new Button("Select Image...");
        fileChooser.setTitle("Open Resource File");
     //   fileChooser.showOpenDialog(stage);
        
        Button left = new Button("Float Left");
        Button right = new Button("Float Right");
        Button neither = new Button("Neither");
        HBox dummy = new HBox(left,right,neither);
        dummy.setSpacing(10);
        dummy.setAlignment(Pos.CENTER);
        Button g = new Button("Okay");
        VBox body = new VBox(c,caption,comp,fileChoose,dummy,g);
        body.getStylesheets().add("css/style.css");
        body.setAlignment(Pos.TOP_CENTER);
         body.getStyleClass().add("dialog_box");
         c.getStyleClass().add("dialog_text");
         g.getStyleClass().add("dialog_button");
        fileChoose.getStyleClass().add("dialog_button");
         left.getStyleClass().add("dialog_button");
         right.getStyleClass().add("dialog_button");
         neither.getStyleClass().add("dialog_button");
           body.setSpacing(20);
        primaryScene = new Scene(body);
        primaryStage.setScene(primaryScene);
        primaryStage.show();
        
           fileChoose.setOnAction(
            new EventHandler<ActionEvent>() {
                @Override
                public void handle(final ActionEvent e) {
                    File file = fileChooser.showOpenDialog(fileChooserStage);
                    if (file != null) {
                        // GET AND SET THE IMAGE
                        URL fileURL;
                        try {
                            fileURL = file.toURI().toURL();
                             Image slideImage = new Image(fileURL.toExternalForm());
                             comp.setImage(slideImage);
                             
                             
                            double scaledWidth = 350;
                            double perc = scaledWidth / slideImage.getWidth();
                            double scaledHeight = slideImage.getHeight() * perc;
                            comp.setFitWidth(scaledWidth);
                            comp.setFitHeight(scaledHeight);
                        } catch (MalformedURLException ex) {
                            Logger.getLogger(dialogViews.class.getName()).log(Level.SEVERE, null, ex);
                        }
                      
	    
	 

                    }
                }
            });
    }
    public void addSlideshowComponent(){
        
        FileChooser fileChooser = new FileChooser();
       
        primaryStage.setX(bounds.getMinX()+bounds.getWidth()/2);
	primaryStage.setY(bounds.getMinY()+bounds.getHeight()/3);
     
        
        ArrayList<ImageView> images = new ArrayList();
        ArrayList<Text> captions = new ArrayList();
        ArrayList<Button> buttons = new ArrayList();
        
        VBox body = new VBox(15);
        ScrollPane scrollPane = new ScrollPane(body);
        scrollPane.setFitToHeight(true);
        body.getStylesheets().add("css/style.css");
        
        body.getStyleClass().add("dialog_box");
        
  
 
 
        
        Button newSlide = new Button("+");
        newSlide.getStyleClass().add("dialog_button");
        body.getChildren().add(newSlide);
        newSlide.setOnAction(e -> {
            counter++;
            FlowPane dummy = new FlowPane();
            Button bt = new Button("Choose...");
            buttons.add(bt);
            ImageView img = new ImageView();
            images.add(img);
            Text txt = new Text();
            captions.add(txt);
            Text c = new Text("Caption:");
            TextField cap = new TextField();
            dummy.getChildren().add(img);
            dummy.getChildren().add(c);
             dummy.getChildren().add(cap);
             
               dummy.getChildren().add(bt);
            body.getChildren().add(dummy);
            c.getStyleClass().add("dialog_text");
            bt.getStyleClass().add("dialog_button");
            
            buttons.get(counter-1).setOnAction((final ActionEvent e1) -> {
                File file = fileChooser.showOpenDialog(fileChooserStage);
                if (file != null) {
                    // GET AND SET THE IMAGE
                    URL fileURL = null;
                    
                    try {
                        imageFileToImageView(img,fileURL,file);
                    } catch (MalformedURLException ex) {
                        Logger.getLogger(dialogViews.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            
            
	});
        
 
        primaryScene = new Scene(body);
        primaryStage.setScene(primaryScene);
        primaryStage.show();
        
         
    }
    public void imageFileToImageView(ImageView view ,URL fileURL,File file) throws MalformedURLException{
        fileURL = file.toURI().toURL();
         Image slideImage = new Image(fileURL.toExternalForm());
          view.setImage(slideImage);                
          double scaledWidth = 350;
          double perc = scaledWidth / slideImage.getWidth();
          double scaledHeight = slideImage.getHeight() * perc;
          view.setFitWidth(scaledWidth);
          view.setFitHeight(scaledHeight);
    }
    public void addVideoComponent(){
        FileChooser fileChooser = new FileChooser();
        TextField comp = new TextField();
        primaryStage.setX(bounds.getMinX()+bounds.getWidth()/2);
	primaryStage.setY(bounds.getMinY()+bounds.getHeight()/3);
        primaryStage.setWidth(600);
	primaryStage.setHeight(600); 
        Text t = new Text("Caption:");
        
        Button g = new Button("Okay");
        Text r = new Text("Input width: ");
        TextField q = new TextField();
        Text s = new Text("Input height: ");
        
        TextField caption = new TextField();
        TextField f = new TextField();
        Button fileChoose = new Button("Choose:");
        VBox body = new VBox(t,caption,fileChoose,comp,g,r,q,s,f);
        
        body.getStylesheets().add("css/style.css");
        t.getStyleClass().add("dialog_text");
        body.setAlignment(Pos.TOP_CENTER);
         body.getStyleClass().add("dialog_box");
         g.getStyleClass().add("dialog_button");
        fileChoose.getStyleClass().add("dialog_button");
         
         r.getStyleClass().add("dialog_text");
         s.getStyleClass().add("dialog_text");
            body.setSpacing(20);
        primaryScene = new Scene(body);
        primaryStage.setScene(primaryScene);
        primaryStage.show();
       fileChoose.setOnAction(
            new EventHandler<ActionEvent>() {
                @Override
                public void handle(final ActionEvent e) {
                    File file = fileChooser.showOpenDialog(fileChooserStage);
                    if (file != null) {
                       comp.setText(file.getPath());
                             
                    }
                }
            });
    }
    public void removeComponent(){
        primaryStage.setX(bounds.getMinX()+bounds.getWidth()/2);
	primaryStage.setY(bounds.getMinY()+bounds.getHeight()/3);
        primaryStage.setWidth(450);
	primaryStage.setHeight(150); 
        Text t = new Text("Are you sure you wish to remove this component?");
        Button yes = new Button("Yes");
        Button no =  new Button("No");
          HBox dummy = new HBox(yes,no);
        dummy.setSpacing(10);
        dummy.setAlignment(Pos.CENTER);
       
        VBox body = new VBox(t,dummy);
        body.getStylesheets().add("css/style.css");
        body.setAlignment(Pos.TOP_CENTER);
         body.getStyleClass().add("dialog_box");
         yes.getStyleClass().add("dialog_button");      
         no.getStyleClass().add("dialog_button");
        t.getStyleClass().add("dialog_text");
           body.setSpacing(20);
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
           primaryStage.setX(bounds.getMinX()+bounds.getWidth()/2);
	primaryStage.setY(bounds.getMinY()+bounds.getHeight()/3);
        primaryStage.setWidth(300);
	primaryStage.setHeight(200); 
        Text t = new Text("Enter url of hyperlink:");
        TextField f = new TextField();
        Button g = new Button("Okay");
        VBox body = new VBox(t,f,g);
        body.getStylesheets().add("css/style.css");
        body.setAlignment(Pos.TOP_CENTER);
         body.getStyleClass().add("dialog_box");
         g.getStyleClass().add("dialog_button");
         t.getStyleClass().add("dialog_text");
            body.setSpacing(20);
        primaryScene = new Scene(body);
        primaryStage.setScene(primaryScene);
        primaryStage.show();
        
        g.setOnAction(e -> {
           body.getChildren().remove(t);
           body.getChildren().remove(f);
           body.getChildren().remove(g);
           Text s = new Text("Succesfully added hyperlink!");
           body.getChildren().add(s);
           Button r = new Button("Okay");
           body.getChildren().add(r);
	});
    }
    public void editTextHyperlink(){
   
        
    }
    public void newPortfolio(){
        primaryStage.setX(bounds.getMinX()+bounds.getWidth()/4);
	primaryStage.setY(bounds.getMinY()+bounds.getHeight()/3);
        primaryStage.setWidth(300);
	primaryStage.setHeight(150);
        Text t = new Text("New EPortfolio Created:");
        Button g = new Button("OK");
        VBox body = new VBox(t,g);
        body.getStylesheets().add("css/style.css");
        body.setAlignment(Pos.TOP_CENTER);
         body.getStyleClass().add("dialog_box");
         g.getStyleClass().add("dialog_button");
         t.getStyleClass().add("dialog_text");
            body.setSpacing(20);
        primaryScene = new Scene(body);
        primaryStage.setScene(primaryScene);
        primaryStage.show();
    }
    public void loadPortfolio(){
         primaryStage.setX(bounds.getMinX()+bounds.getWidth()/4);
	primaryStage.setY(bounds.getMinY()+bounds.getHeight()/3);
        primaryStage.setWidth(300);
	primaryStage.setHeight(150);
        Text t = new Text("Choose portfolio to load:");
        Button g = new Button("OK");
        VBox body = new VBox(t,g);
        primaryScene = new Scene(body);
          body.getStylesheets().add("css/style.css");
        body.setAlignment(Pos.TOP_CENTER);
         body.getStyleClass().add("dialog_box");
         g.getStyleClass().add("dialog_button");
         t.getStyleClass().add("dialog_text");
            body.setSpacing(20);
        primaryStage.setScene(primaryScene);
        primaryStage.show();
    }
    public void savePortfolio(){
           primaryStage.setX(bounds.getMinX()+bounds.getWidth()/4);
	primaryStage.setY(bounds.getMinY()+bounds.getHeight()/3);
        primaryStage.setWidth(300);
	primaryStage.setHeight(150);
        Text t = new Text("EPortfolio succesfully Saved:");
        Button g = new Button("OK");
        VBox body = new VBox(t,g);
          body.getStylesheets().add("css/style.css");
        body.setAlignment(Pos.TOP_CENTER);
         body.getStyleClass().add("dialog_box");
         g.getStyleClass().add("dialog_button");
         t.getStyleClass().add("dialog_text");
            body.setSpacing(20);
        primaryScene = new Scene(body);
        primaryStage.setScene(primaryScene);
        primaryStage.show();
    }
    public void saveAsPortfolio(){
           primaryStage.setX(bounds.getMinX()+bounds.getWidth()/4);
	primaryStage.setY(bounds.getMinY()+bounds.getHeight()/3);
        primaryStage.setWidth(300);
	primaryStage.setHeight(150);
        Text t = new Text("Select location for ePortfolio");
        Button g = new Button("Okay");
        VBox body = new VBox(t,g);
           body.getStylesheets().add("css/style.css");
        body.setAlignment(Pos.TOP_CENTER);
         body.getStyleClass().add("dialog_box");
         g.getStyleClass().add("dialog_button");
         t.getStyleClass().add("dialog_text");
            body.setSpacing(20);
        primaryScene = new Scene(body);
        primaryStage.setScene(primaryScene);
        primaryStage.show();
        g.setOnAction(e -> {
	   this.savePortfolio();
	});
    }
    public void exportPortfolio(){
           primaryStage.setX(bounds.getMinX()+bounds.getWidth()/4);
	primaryStage.setY(bounds.getMinY()+bounds.getHeight()/3);
        primaryStage.setWidth(300);
	primaryStage.setHeight(150);
        Text t = new Text("Portfolio succesfully exported");
        Button g = new Button("Okay");
        VBox body = new VBox(t,g);
           body.getStylesheets().add("css/style.css");
        body.setAlignment(Pos.TOP_CENTER);
         body.getStyleClass().add("dialog_box");
         g.getStyleClass().add("dialog_button");
        t.getStyleClass().add("dialog_text");
           body.setSpacing(20);
        primaryScene = new Scene(body);
        primaryStage.setScene(primaryScene);
        primaryStage.show();
    }
    public void exitPortfolio(){
           primaryStage.setX(bounds.getMinX()+bounds.getWidth()/4);
	primaryStage.setY(bounds.getMinY()+bounds.getHeight()/3);
        primaryStage.setWidth(300);
	primaryStage.setHeight(150);
        Text t = new Text("Do you wish to save before exiting?");
        Button yes = new Button("Yes");
        Button no = new Button("No");
           HBox dummy = new HBox(yes,no);
        
        dummy.setSpacing(10);
        dummy.setAlignment(Pos.CENTER);
        VBox body = new VBox(t,dummy);
       body.getStylesheets().add("css/style.css");
      body.setSpacing(20);
        body.setAlignment(Pos.TOP_CENTER);
         body.getStyleClass().add("dialog_box");
         yes.getStyleClass().add("dialog_button");
        no.getStyleClass().add("dialog_button");
        t.getStyleClass().add("dialog_text");
        primaryScene = new Scene(body);
        primaryStage.setScene(primaryScene);
        primaryStage.show();
        yes.setOnAction(e -> {
	   Text saved = new Text("Succesfully Saved!");
           body.getChildren().remove(t);
           body.getChildren().remove(dummy);
           body.getChildren().add(saved);
           System.exit(0);
	});
        no.setOnAction(e -> {
           System.exit(0);
	});
        
    }
     private void openFile(File file) {
        try {
            desktop.open(file);
        } catch (IOException ex) {
            Logger.getLogger(
                dialogViews.class.getName()).log(
                    Level.SEVERE, null, ex
                );
        }
    }
}
