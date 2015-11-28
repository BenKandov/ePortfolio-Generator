/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import components.paragraphComponent;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

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
import model.ePortfolioModel;

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
      
	fileChooserStage.setWidth(bounds.getWidth()/6);
	fileChooserStage.setHeight(bounds.getHeight()/7); 
        
        
        primaryStage = new Stage();
      
	primaryStage.setWidth(bounds.getWidth()/6);
	primaryStage.setHeight(bounds.getHeight()/7); 
    }
    public void selectLayoutTemplate(ePortfolioModel ePortfolio){
       
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
    public void selectColorTemplate(ePortfolioModel ePortfolio){
        
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
    public void selectBannerImage(ePortfolioModel ePortfolio){
  
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
    public void chooseComponentFont(ePortfolioModel ePortfolio){
      
	
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
    public void updatePageTitle(ePortfolioModel ePortfolio){
    
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
    public void updateStudentName(ePortfolioModel ePortfolio){
      
	
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
    public void updateFooter(ePortfolioModel ePortfolio){
 
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
    public void addTextComponent(ePortfolioModel ePortfolio){
    
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
	   this.createParagraph(ePortfolio);
	});
         b.setOnAction(e -> {
	   this.createList(ePortfolio);
	});
        c.setOnAction(e -> {
	   this.createHeader(ePortfolio);
	});
    }
    public void createParagraph(ePortfolioModel ePortfolio){
    
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
         g.setOnAction(e1 -> {
             paragraphComponent para = new paragraphComponent(r.getText());
             ePortfolio.getSelectedPage().addComponent(para);
             primaryStage.close();
	});
        
    }
    public void createHeader(ePortfolioModel ePortfolio){
    
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
    /**
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
    * **/
    public void createList(ePortfolioModel ePortfolio){
 
        primaryStage.setWidth(300);
	primaryStage.setHeight(500); 
        VBox body = new VBox();
       
        ScrollPane scrollPane = new ScrollPane(body);
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);
        Button add = new Button("Add Item");
       
        Button g = new Button("Finished");
      
        FlowPane rand = new FlowPane(add,g);
        rand.setHgap(60);
        body.getChildren().add(rand);
       TextField a = new TextField("List Item");
       
       
       Button r1 = new Button("X");    
        
       
         FlowPane dummy = new FlowPane(a,r1);
         
        body.getChildren().add(dummy);
        r1.setOnAction(e1 -> {
          
            body.getChildren().remove(dummy);
        });
        body.getStylesheets().add("css/style.css");
        body.setAlignment(Pos.TOP_CENTER);
        body.getStyleClass().add("dialog_box");
        g.getStyleClass().add("dialog_button");
        add.getStyleClass().add("dialog_button");
        r1.getStyleClass().add("dialog_button");
        body.setSpacing(20);
        primaryScene = new Scene(scrollPane);
        primaryStage.setScene(primaryScene);
        primaryStage.show();
        
        add.setOnAction(e -> {
            TextField b = new TextField("List Item");
            body.getChildren().add(b);
            Button r2 = new Button("X");
            FlowPane stupid = new FlowPane(b,r2);
            body.getChildren().add(stupid);
            r2.getStyleClass().add("dialog_button");
                 r2.setOnAction(e3 -> {
          
                     body.getChildren().remove(stupid);
                 });
        });
    }
    public void addImageComponent(ePortfolioModel ePortfolio){

        primaryStage.setWidth(600);
	primaryStage.setHeight(600); 
       ImageView comp = new ImageView();
       Image d = new Image("Icons/question.png");
       comp.setImage(d);
       double scaledHeight = 200;
      double perc = scaledHeight / d.getHeight();
       double scaledWidth = d.getWidth() * perc;
        comp.setFitWidth(scaledWidth);
         comp.setFitHeight(scaledHeight);
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
                             
                             
                                 double scaledHeight = 200;
                                 double perc = scaledHeight / slideImage.getHeight();
                                  double scaledWidth = slideImage.getWidth() * perc;
                                  comp.setFitWidth(scaledWidth);
                                  comp.setFitHeight(scaledHeight);
                        } catch (MalformedURLException ex) {
                            Logger.getLogger(dialogViews.class.getName()).log(Level.SEVERE, null, ex);
                        }
                      
	    
	 

                    }
                }
            });
    }
    public void addSlideshowComponent(ePortfolioModel ePortfolio){
        
        FileChooser fileChooser = new FileChooser();
        primaryStage.setWidth(900);
	primaryStage.setHeight(1000); 
        primaryStage.setX(bounds.getMinX()+bounds.getWidth()/3);
	primaryStage.setY(bounds.getMinY()+bounds.getHeight()/3);
     
        
        ArrayList<ImageView> images = new ArrayList();
        ArrayList<Text> captions = new ArrayList();
        ArrayList<Button> buttons = new ArrayList();
        ArrayList<Button> removes = new ArrayList();
        
        VBox body = new VBox(15);
        ScrollPane scrollPane = new ScrollPane(body);
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);
        
        
        body.getStylesheets().add("css/style.css");
        
        body.getStyleClass().add("dialog_box");
        
  
 
 
        Button g = new Button("Finished");
        Button newSlide = new Button("Add Slide");
        newSlide.getStyleClass().add("dialog_button");
        body.getChildren().add(newSlide);
        body.getChildren().add(g);
        g.getStyleClass().add("dialog_button");
        body.setSpacing(10);
        newSlide.setOnAction(e -> {
            counter++;
            FlowPane dummy = new FlowPane();
            Button bt = new Button("Choose...");
            Button r = new Button("Remove");
            buttons.add(bt);
            removes.add(r);
           ImageView img = new ImageView();
            images.add(img);
            Image d = new Image("Icons/question.png");
             img.setImage(d);
              double scaledWidth = 300;
          double perc = scaledWidth / d.getWidth();
          double scaledHeight = d.getHeight() * perc;
          img.setFitWidth(scaledWidth);
          img.setFitHeight(scaledHeight);
            
            Text txt = new Text();
            captions.add(txt);
            Text c = new Text("Caption:");
            TextField cap = new TextField();
            dummy.getChildren().add(bt);
            dummy.getChildren().add(img);
            dummy.getChildren().add(c);
            dummy.getChildren().add(cap);
            dummy.getChildren().add(r);
            
            dummy.setHgap(20);
            body.getChildren().add(dummy);
            c.getStyleClass().add("dialog_text");
            bt.getStyleClass().add("dialog_button");
            r.getStyleClass().add("dialog_button");
            
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
            r.setOnAction(e2 -> {
                images.remove(counter-1);
                removes.remove(counter-1);
                buttons.remove(counter-1);
                captions.remove(counter-1);
                counter--;
                body.getChildren().remove(dummy);
            });
                
            
            
	});
        
 
        primaryScene = new Scene(scrollPane);
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
    public void addVideoComponent(String tot){
        FileChooser fileChooser = new FileChooser();
        TextField comp = new TextField(tot);
       
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
    public void removeComponent(ePortfolioModel ePortfolio){
        
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
    public void editTextComponent(ePortfolioModel ePortfolio){
        primaryStage.setWidth(450);
	primaryStage.setHeight(300); 
        Text t = new Text("Edit text content:");
        TextArea a = new TextArea("Sample paragraph content");
        Button g = new Button("Finished");
        Button hyper = new Button("Begin adding hyperlink");
        Button hyper2 = new Button("Finish adding hyperlink");
        TextField url = new TextField("url");
        FlowPane dummy = new FlowPane(hyper,hyper2,url);
        VBox body = new VBox(20);
        body.getChildren().add(t);
        body.getChildren().add(a);
        body.getChildren().add(g);
        body.getChildren().add(dummy);
        dummy.setHgap(10);
        dummy.setAlignment(Pos.CENTER);
        body.getStylesheets().add("css/style.css");
        body.getStyleClass().add("dialog_box");
        t.getStyleClass().add("dialog_text");
        g.getStyleClass().add("dialog_button");
        hyper.getStyleClass().add("dialog_button");
        hyper2.getStyleClass().add("dialog_button");
        body.setAlignment(Pos.CENTER);
        
        primaryScene = new Scene(body);
        primaryStage.setScene(primaryScene);
        primaryStage.show();
        
    }
    public void editListComponent(ePortfolioModel ePortfolio){
        primaryStage.setWidth(300);
	primaryStage.setHeight(500); 
        VBox body = new VBox();
       
        ScrollPane scrollPane = new ScrollPane(body);
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);
        Button add = new Button("Add Item");
       
        Button g = new Button("Finished");
      
        FlowPane rand = new FlowPane(add,g);
        rand.setHgap(60);
        body.getChildren().add(rand);
       TextField a = new TextField("Sample list item");
       
       
       Button r1 = new Button("X");    
        
       
         FlowPane dummy = new FlowPane(a,r1);
         
        body.getChildren().add(dummy);
        r1.setOnAction(e1 -> {
          
            body.getChildren().remove(dummy);
        });
        body.getStylesheets().add("css/style.css");
        body.setAlignment(Pos.TOP_CENTER);
        body.getStyleClass().add("dialog_box");
        g.getStyleClass().add("dialog_button");
        add.getStyleClass().add("dialog_button");
        r1.getStyleClass().add("dialog_button");
        body.setSpacing(20);
        primaryScene = new Scene(scrollPane);
        primaryStage.setScene(primaryScene);
        primaryStage.show();
        
        add.setOnAction(e -> {
            TextField b = new TextField("List Item");
            body.getChildren().add(b);
            Button r2 = new Button("X");
            FlowPane stupid = new FlowPane(b,r2);
            body.getChildren().add(stupid);
            r2.getStyleClass().add("dialog_button");
                 r2.setOnAction(e3 -> {
          
                     body.getChildren().remove(stupid);
                 });
        });
    }
    
    public void editSlideshowComponent(ePortfolioModel ePortfolio){
        
    }
   
    public void addTextHyperlink(ePortfolioModel ePortfolio){
        
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
  
    public void newPortfolio(ePortfolioModel ePortfolio){
      
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
         g.setOnAction(e -> {
           primaryStage.close();
          
	});
    }
    public void loadPortfolio(ePortfolioModel ePortfolio){
        
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
    public void savePortfolio(ePortfolioModel ePortfolio){
         
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
    public void saveAsPortfolio(ePortfolioModel ePortfolio){
        
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
	   this.savePortfolio(ePortfolio);
	});
    }
    public void exportPortfolio(ePortfolioModel ePortfolio){
           
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
    public void exitPortfolio(ePortfolioModel ePortfolio){

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
