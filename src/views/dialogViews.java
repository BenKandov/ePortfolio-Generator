/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import components.component;
import components.headerComponent;
import components.imageComponent;
import components.listComponent;
import components.paragraphComponent;
import components.slideshowComponent;
import components.videoComponent;
import controller.exportController;
import fileManager.ePortfolioFileManager;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;

import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.Window;
import javax.imageio.ImageIO;
import static javax.imageio.ImageIO.getReaderFileSuffixes;
import model.Page;
import model.ePortfolioModel;

/**
 *
 * @author benkandov
 */
public class dialogViews {
    int counter=0;
    
static ArrayList<ImageView> images = new ArrayList();
    static        ArrayList<String> imageSources = new ArrayList();
     static    ArrayList<Text> captions = new ArrayList();
    static        ArrayList<String> captionText = new ArrayList();
       static   ArrayList<TextField> caps = new ArrayList();
    static     ArrayList<Button> buttons = new ArrayList();
   static      ArrayList<Button> removes = new ArrayList();
    
    private String url;
    private listComponent du;
    private imageComponent dv;
    private Desktop desktop = Desktop.getDesktop();
    Stage fileChooserStage;
    Scene fileScene;
    Stage primaryStage;
    Scene primaryScene;
    Stage secondaryStage;
    Scene secondaryScene;
    Screen screen = Screen.getPrimary();
    Rectangle2D bounds = screen.getVisualBounds();
    public dialogViews(){
        fileChooserStage = new Stage();
      
	fileChooserStage.setWidth(bounds.getWidth()/6);
	fileChooserStage.setHeight(bounds.getHeight()/7); 
        
        secondaryStage = new Stage();
        primaryStage = new Stage();
      
	primaryStage.setWidth(bounds.getWidth()/6);
	primaryStage.setHeight(bounds.getHeight()/7); 
    }
    public void selectLayoutTemplate(ePortfolioModel ePortfolio){
       
	primaryStage.setWidth(600);
	primaryStage.setHeight(200); 

       VBox body = new VBox(20);
        Text t = new Text("Choose a layout template:");
        Button a = new Button("Layout A");
        
        Button b = new Button("Layout B");
        
        Button c = new Button("Layout C");
        Button d = new Button("Layout D");
        Button e = new Button("Layout E");
        
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
        a.setOnAction(e1 -> {
            ePortfolio.getSelectedPage().setLayoutTemplate("Layout A");
            primaryStage.close();
            ePortfolio.getUI().loadSelectedPage();
                 ePortfolio.setSaved(false);
                ePortfolio.getUI().updateDisabledButtons(ePortfolio.isSaved());
	});
        b.setOnAction(e2 -> {
            ePortfolio.getSelectedPage().setLayoutTemplate("Layout B");
            primaryStage.close();
            ePortfolio.getUI().loadSelectedPage();
                 ePortfolio.setSaved(false);
                ePortfolio.getUI().updateDisabledButtons(ePortfolio.isSaved());
	});
        c.setOnAction(e3 -> {
            ePortfolio.getSelectedPage().setLayoutTemplate("Layout C");
            primaryStage.close();
            ePortfolio.getUI().loadSelectedPage();
                 ePortfolio.setSaved(false);
                ePortfolio.getUI().updateDisabledButtons(ePortfolio.isSaved());
	});
        d.setOnAction(e4 -> {
            ePortfolio.getSelectedPage().setLayoutTemplate("Layout D");
            primaryStage.close();
            ePortfolio.getUI().loadSelectedPage();
                 ePortfolio.setSaved(false);
                ePortfolio.getUI().updateDisabledButtons(ePortfolio.isSaved());
	});
        e.setOnAction(e5 -> {
            ePortfolio.getSelectedPage().setLayoutTemplate("Layout E");
            primaryStage.close();
            ePortfolio.getUI().loadSelectedPage();
                 ePortfolio.setSaved(false);
                ePortfolio.getUI().updateDisabledButtons(ePortfolio.isSaved());
	});
    }
    public void selectColorTemplate(ePortfolioModel ePortfolio){
        
	primaryStage.setWidth(700);
	primaryStage.setHeight(200); 

          VBox body = new VBox(20);
        Text t = new Text("Choose a color template:");
        
        Button a = new Button("Color A");
        Button b = new Button("Color B");
        Button c = new Button("Color C");
        Button d = new Button("Color D");
        Button e = new Button("Color E");
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
         a.setOnAction(e1 -> {
             ePortfolio.getSelectedPage().setColorTemplate("Color A");
             primaryStage.close();  
             ePortfolio.getUI().loadSelectedPage();
                  ePortfolio.setSaved(false);
                ePortfolio.getUI().updateDisabledButtons(ePortfolio.isSaved());
	});
        b.setOnAction(e2 -> {
            ePortfolio.getSelectedPage().setColorTemplate("Color B");
            primaryStage.close();
            ePortfolio.getUI().loadSelectedPage();
                 ePortfolio.setSaved(false);
                ePortfolio.getUI().updateDisabledButtons(ePortfolio.isSaved());
	});
        c.setOnAction(e3 -> {
            ePortfolio.getSelectedPage().setColorTemplate("Color C");
            primaryStage.close();
            
            ePortfolio.getUI().loadSelectedPage();
                 ePortfolio.setSaved(false);
                ePortfolio.getUI().updateDisabledButtons(ePortfolio.isSaved());
	});
        d.setOnAction(e4 -> {
            ePortfolio.getSelectedPage().setColorTemplate("Color D");
            primaryStage.close();
            ePortfolio.getUI().loadSelectedPage();
                 ePortfolio.setSaved(false);
                ePortfolio.getUI().updateDisabledButtons(ePortfolio.isSaved());
	});
        e.setOnAction(e5 -> {
            ePortfolio.getSelectedPage().setColorTemplate("Color E");
            primaryStage.close();
            ePortfolio.getUI().loadSelectedPage();
                 ePortfolio.setSaved(false);
                ePortfolio.getUI().updateDisabledButtons(ePortfolio.isSaved());
	});
    }
    public void selectBannerImage(ePortfolioModel ePortfolio){
  
	primaryStage.setWidth(600);
	primaryStage.setHeight(400); 
       ImageView comp = new ImageView();
        Image d = new Image("imgs/question.png");
       if(ePortfolio.getSelectedPage().getBannerImage().equals("imgs/question.png")){
           comp.setImage(d);
       }else{
           
           Image oldImage = new Image(ePortfolio.getSelectedPage().getBannerImage());
           comp.setImage(oldImage);
       }
      
       
       double scaledHeight = 200;
      double perc = scaledHeight / d.getHeight();
       double scaledWidth = d.getWidth() * perc;
        comp.setFitWidth(scaledWidth);
         comp.setFitHeight(scaledHeight);
       
        FileChooser fileChooser = new FileChooser();
        Button fileChoose = new Button("Select Image...");
        fileChooser.setTitle("Open Resource File");
     //   fileChooser.showOpenDialog(stage);
        Button g = new Button("Okay");
        VBox body = new VBox(comp,fileChoose,g);
        body.getStylesheets().add("css/style.css");
        body.setAlignment(Pos.TOP_CENTER);
         body.getStyleClass().add("dialog_box");
         g.getStyleClass().add("dialog_button");
        fileChoose.getStyleClass().add("dialog_button");
        
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
                             
                             File imgToCopy = new File(file.getPath());
                             String name = imgToCopy.getName();
                       //      File dest = new File("Icons",name);
                             
                             FileInputStream fis = new FileInputStream(imgToCopy);
                             FileOutputStream fos = new FileOutputStream("imgs/"+name);
                             byte[] buff = new byte[fis.available()];
                             fis.read(buff);
                             fos.write(buff);
                             File dummy = new File("imgs/"+name);
                             
                             Image slideImage = new Image(dummy.toURI().toURL().toExternalForm());
                             url = dummy.toURI().toURL().toExternalForm();
                             comp.setImage(slideImage);
                             
                             
                                 double scaledHeight = 200;
                                 double perc = scaledHeight / slideImage.getHeight();
                                  double scaledWidth = slideImage.getWidth() * perc;
                                  comp.setFitWidth(scaledWidth);
                                  comp.setFitHeight(scaledHeight);
                        } catch (MalformedURLException ex) {
                            Logger.getLogger(dialogViews.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(dialogViews.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(dialogViews.class.getName()).log(Level.SEVERE, null, ex);
                        }
                      
	    
	 

                    }
                }
            });
        g.setOnAction(e1 -> {
            if(comp.getImage().equals(d)){
                primaryStage.close();
                ePortfolio.getUI().loadSelectedPage();
                     ePortfolio.setSaved(false);
                ePortfolio.getUI().updateDisabledButtons(ePortfolio.isSaved());
            }else{
            
           
                 ePortfolio.getSelectedPage().setBannerImage(url);
                 primaryStage.close();
                 ePortfolio.getUI().loadSelectedPage();
                      ePortfolio.setSaved(false);
                ePortfolio.getUI().updateDisabledButtons(ePortfolio.isSaved());
            }
	});
    }
   
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
         a.setOnAction(e1 -> {
            ePortfolio.getSelectedPage().setFont("Font A");
            primaryStage.close();
            ePortfolio.getUI().loadSelectedPage();
                 ePortfolio.setSaved(false);
                ePortfolio.getUI().updateDisabledButtons(ePortfolio.isSaved());
	});
        b.setOnAction(e2 -> {
            ePortfolio.getSelectedPage().setFont("Font B");
            primaryStage.close();
            ePortfolio.getUI().loadSelectedPage();
                 ePortfolio.setSaved(false);
                ePortfolio.getUI().updateDisabledButtons(ePortfolio.isSaved());
	});
        c.setOnAction(e3 -> {
            ePortfolio.getSelectedPage().setFont("Font C");
            primaryStage.close();
            ePortfolio.getUI().loadSelectedPage();
                 ePortfolio.setSaved(false);
                ePortfolio.getUI().updateDisabledButtons(ePortfolio.isSaved());
	});
        d.setOnAction(e4 -> {
            ePortfolio.getSelectedPage().setFont("Font D");
            primaryStage.close();
            ePortfolio.getUI().loadSelectedPage();
                 ePortfolio.setSaved(false);
                ePortfolio.getUI().updateDisabledButtons(ePortfolio.isSaved());
	});
        e.setOnAction(e5 -> {
            ePortfolio.getSelectedPage().setFont("Font E"); 
            primaryStage.close();
            ePortfolio.getUI().loadSelectedPage();
                 ePortfolio.setSaved(false);
                ePortfolio.getUI().updateDisabledButtons(ePortfolio.isSaved());
	});
    }
    public void updatePageTitle(ePortfolioModel ePortfolio){
    
	primaryStage.setWidth(300);
	primaryStage.setHeight(250); 
        
        Text t = new Text("Enter a new page title:");
        TextField b = new TextField();
        
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
         g.setOnAction(e -> {
             boolean proceed = true;
           if(b.getText().equals("")){
               proceed=false;
           }
           for(Page page:ePortfolio.getPages()){
               if(page.getTitle().equals(b.getText())){
                   proceed=false;
               }
           }
           if(proceed){
            ePortfolio.getSelectedPage().setTitle(b.getText());
           
	  
           primaryStage.close();
           
           
           ePortfolio.getUI().loadSelectedPage();
               ePortfolio.setSaved(false);
                ePortfolio.getUI().updateDisabledButtons(ePortfolio.isSaved());
           }
	});
    }
    public void updateStudentName(ePortfolioModel ePortfolio){
      
	
	primaryStage.setWidth(300);
	primaryStage.setHeight(250); 
        Text t = new Text("Enter a new student name:");
        TextField b = new TextField();
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
        g.setOnAction(e -> {
	   ePortfolio.setStudentName(b.getText());
          Page placeholder = ePortfolio.getSelectedPage();
           for(Page page:ePortfolio.getPages()){
             
               ePortfolio.selectPage(page);
               ePortfolio.getUI().loadSelectedPage();
           }
           ePortfolio.selectPage(placeholder);
           primaryStage.close();
          ePortfolio.getUI().loadSelectedPage();
               ePortfolio.setSaved(false);
                ePortfolio.getUI().updateDisabledButtons(ePortfolio.isSaved());
           
	});
    }
    public void updateFooter(ePortfolioModel ePortfolio){
 
	primaryStage.setWidth(300);
	primaryStage.setHeight(250); 
        Text t = new Text("Enter new footer text content:");
        TextArea b = new TextArea();
        b.setText(ePortfolio.getSelectedPage().getFooter());
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
        g.setOnAction(e -> {
	   ePortfolio.getSelectedPage().setFooter(b.getText());
           primaryStage.close();
          ePortfolio.getUI().loadSelectedPage();
               ePortfolio.setSaved(false);
                ePortfolio.getUI().updateDisabledButtons(ePortfolio.isSaved());
           
	});
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
    
        primaryStage.setWidth(600);
	primaryStage.setHeight(400);
        ToggleGroup fonts = new ToggleGroup();
        Button g = new Button("Okay");
        Text t = new Text("Write paragraph:");
        TextArea r = new TextArea();
        RadioButton a = new RadioButton("Font A");
        a.getStylesheets().add("https://fonts.googleapis.com/css?family=Architects+Daughter");
        a.setStyle("-fx-font-family: 'Architects Daughter' ;");
        a.setSelected(true);
        a.setToggleGroup(fonts);
        RadioButton b = new RadioButton("Font B");
        b.getStylesheets().add("https://fonts.googleapis.com/css?family=Shadows+Into+Light");
        b.setStyle("-fx-font-family: 'Shadows Into Light' ;");
        b.setToggleGroup(fonts);
        RadioButton c = new RadioButton("Font C");
        c.getStylesheets().add("https://fonts.googleapis.com/css?family=Indie+Flower");
        c.setStyle("-fx-font-family: 'Indie Flower' ;");
        c.setToggleGroup(fonts);
        RadioButton d = new RadioButton("Font D");
        d.getStylesheets().add("https://fonts.googleapis.com/css?family=Poiret+One");
        d.setStyle("-fx-font-family: 'Poiret One' ;");
        d.setToggleGroup(fonts);
        RadioButton e = new RadioButton("Font E");
        e.getStylesheets().add("https://fonts.googleapis.com/css?family=Ubuntu+Condensed");
        e.setStyle("-fx-font-family: 'Ubuntu Condensed'; ");
        e.setToggleGroup(fonts);
        
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
        String font = "";
         g.setOnAction(e1 -> {
             RadioButton qw = (RadioButton) fonts.getSelectedToggle();
             paragraphComponent para = new paragraphComponent(r.getText(),qw.getText());
             ePortfolio.getSelectedPage().addComponent(para);
             primaryStage.close();
                  ePortfolio.setSaved(false);
                ePortfolio.getUI().updateDisabledButtons(ePortfolio.isSaved());
	});
        
    }
    public void createHeader(ePortfolioModel ePortfolio){
    
        primaryStage.setWidth(600);
	primaryStage.setHeight(350); 
        Text t = new Text("Write Header:");
        TextField r = new TextField();
         ToggleGroup fonts = new ToggleGroup();
        Button g = new Button("Okay");
       
        RadioButton a = new RadioButton("Font A");
        a.getStylesheets().add("https://fonts.googleapis.com/css?family=Architects+Daughter");
        a.setStyle("-fx-font-family: 'Architects Daughter' ;");
        a.setSelected(true);
        a.setToggleGroup(fonts);
        RadioButton b = new RadioButton("Font B");
        b.getStylesheets().add("https://fonts.googleapis.com/css?family=Shadows+Into+Light");
        b.setStyle("-fx-font-family: 'Shadows Into Light' ;");
        b.setToggleGroup(fonts);
        RadioButton c = new RadioButton("Font C");
        c.getStylesheets().add("https://fonts.googleapis.com/css?family=Indie+Flower");
        c.setStyle("-fx-font-family: 'Indie Flower' ;");
        c.setToggleGroup(fonts);
        RadioButton d = new RadioButton("Font D");
        d.getStylesheets().add("https://fonts.googleapis.com/css?family=Poiret+One");
        d.setStyle("-fx-font-family: 'Poiret One' ;");
        d.setToggleGroup(fonts);
        RadioButton e = new RadioButton("Font E");
        e.getStylesheets().add("https://fonts.googleapis.com/css?family=Ubuntu+Condensed");
        e.setStyle("-fx-font-family: 'Ubuntu Condensed'; ");
        e.setToggleGroup(fonts);
        
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
             RadioButton clown = (RadioButton) fonts.getSelectedToggle();
             headerComponent header = new headerComponent(r.getText(),clown.getText());
             ePortfolio.getSelectedPage().addComponent(header);
             primaryStage.close();
                  ePortfolio.setSaved(false);
                ePortfolio.getUI().updateDisabledButtons(ePortfolio.isSaved());
	});
    }
   
    public void createList(ePortfolioModel ePortfolio){
 
        primaryStage.setWidth(300);
	primaryStage.setHeight(500); 
        VBox body = new VBox();
        ArrayList<TextField> contents = new ArrayList();
        
        ScrollPane scrollPane = new ScrollPane(body);
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);
        Button add = new Button("Add Item");
       
        Button g = new Button("Finished");
      
        FlowPane rand = new FlowPane(add,g);
        rand.setHgap(60);
        body.getChildren().add(rand);
       TextField a = new TextField("List Item");
       contents.add(a);
       
       Button r1 = new Button("X");    
        
       
         FlowPane dummy = new FlowPane(a,r1);
         
        body.getChildren().add(dummy);
        r1.setOnAction(e1 -> {
           contents.remove(a);
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
            contents.add(b);
            body.getChildren().add(b);
            Button r2 = new Button("X");
            FlowPane stupid = new FlowPane(b,r2);
            body.getChildren().add(stupid);
            r2.getStyleClass().add("dialog_button");
                 r2.setOnAction(e3 -> {
                    contents.remove(b);
                     body.getChildren().remove(stupid);
                 });
        });
        g.setOnAction(e1 -> {
            ArrayList<String> lists = new ArrayList();
            for(int i = 0;i<contents.size();i++){
                lists.add(contents.get(i).getText());
            }
            listComponent l = new listComponent(lists);
            System.out.println(l.getItem(0));
            ePortfolio.getSelectedPage().addComponent(l);
            primaryStage.close();
                 ePortfolio.setSaved(false);
                ePortfolio.getUI().updateDisabledButtons(ePortfolio.isSaved());
	});
    }
    public void addImageComponent(ePortfolioModel ePortfolio){

        primaryStage.setWidth(600);
	primaryStage.setHeight(800); 
       ImageView comp = new ImageView();
       Image d = new Image("Icons/question.png");
       comp.setImage(d);
        Text r = new Text("Input width: ");
        TextField q = new TextField();
        Text s = new Text("Input height: ");
        TextField f = new TextField();
       double scaledHeight = 200;
      double perc = scaledHeight / d.getHeight();
       double scaledWidth = d.getWidth() * perc;
        comp.setFitWidth(scaledWidth);
         comp.setFitHeight(scaledHeight);
       Text c = new Text("Caption");
       TextField caption = new TextField();
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Image Files","*.png","*.jpg","*.jpeg","*.gif");
        fileChooser.getExtensionFilters().add(extFilter);
        Button fileChoose = new Button("Select Image...");
        fileChooser.setTitle("Open Resource File");
     //   fileChooser.showOpenDialog(stage);
        ToggleGroup floats = new ToggleGroup();
        
        RadioButton left = new RadioButton("Float Left");
        left.setSelected(true);
        left.setToggleGroup(floats);
        RadioButton right = new RadioButton("Float Right");
        right.setToggleGroup(floats);
        RadioButton neither = new RadioButton("Neither");
        neither.setToggleGroup(floats);
        HBox dummy = new HBox(left,right,neither);
        dummy.setSpacing(10);
        dummy.setAlignment(Pos.CENTER);
        Button g = new Button("Okay");
        VBox body = new VBox(c,caption,comp,fileChoose,dummy,r,q,s,f,g);
        body.getStylesheets().add("css/style.css");
        body.setAlignment(Pos.TOP_CENTER);
         body.getStyleClass().add("dialog_box");
         c.getStyleClass().add("dialog_text");
         g.getStyleClass().add("dialog_button");
        fileChoose.getStyleClass().add("dialog_button");
         left.getStyleClass().add("dialog_button");
         right.getStyleClass().add("dialog_button");
         neither.getStyleClass().add("dialog_button");
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
                        // GET AND SET THE IMAGE
                        URL fileURL;
                        try {
                            fileURL = file.toURI().toURL();
                                  File imgToCopy = new File(file.getPath());
                             String name = imgToCopy.getName();
                       //      File dest = new File("Icons",name);
                             
                             FileInputStream fis = new FileInputStream(imgToCopy);
                             FileOutputStream fos = new FileOutputStream("imgs/"+name);
                             byte[] buff = new byte[fis.available()];
                             fis.read(buff);
                             fos.write(buff);
                             File dummy = new File("imgs/"+name);
                             
                             Image slideImage = new Image(dummy.toURI().toURL().toExternalForm());
                             url = "imgs/"+name;
                             comp.setImage(slideImage);
                             comp.setImage(slideImage);
                             
                             
                                 double scaledHeight = 200;
                                 double perc = scaledHeight / slideImage.getHeight();
                                  double scaledWidth = slideImage.getWidth() * perc;
                                  comp.setFitWidth(scaledWidth);
                                  comp.setFitHeight(scaledHeight);
                        } catch (MalformedURLException ex) {
                            Logger.getLogger(dialogViews.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(dialogViews.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(dialogViews.class.getName()).log(Level.SEVERE, null, ex);
                        }
                      
	    
	 

                    }
                }
            });
        g.setOnAction(e1 -> {
            if(comp.getImage().equals(d)){
                
            }else{
             if(q.getText().equals("")){
                  q.setText("100");
            }
            if(f.getText().equals("")){
                  f.setText("100");
            }
            RadioButton aq =  (RadioButton) floats.getSelectedToggle();
           imageComponent img = new imageComponent(url,aq.getText(),caption.getText(),Integer.parseInt(q.getText()),Integer.parseInt(f.getText()));
           ePortfolio.getSelectedPage().addComponent(img);
           primaryStage.close();
                ePortfolio.setSaved(false);
                ePortfolio.getUI().updateDisabledButtons(ePortfolio.isSaved());
            }
	});
           
    }
        public void editImageComponent(imageComponent image,ePortfolioModel ePortfolio){

        primaryStage.setWidth(600);
	primaryStage.setHeight(800); 
       ImageView comp = new ImageView();
       Button remove = new Button("Remove");
         Text r = new Text("Input width: ");
        TextField q = new TextField();
        q.setText(Integer.toString(image.getWidth()));
        Text s = new Text("Input height: ");
        TextField f = new TextField();
        f.setText(Integer.toString(image.getHeight()));
       Image d = new Image(image.getSource());
       comp.setImage(d);
       double scaledHeight = 200;
      double perc = scaledHeight / d.getHeight();
       double scaledWidth = d.getWidth() * perc;
        comp.setFitWidth(scaledWidth);
         comp.setFitHeight(scaledHeight);
       Text c = new Text("Caption");
       TextField caption = new TextField();
       caption.setText(image.getCaption());
        FileChooser fileChooser = new FileChooser();
         FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Image Files","*.png","*.jpg","*.jpeg","*.gif");
        fileChooser.getExtensionFilters().add(extFilter);
        Button fileChoose = new Button("Select Image...");
        fileChooser.setTitle("Open Resource File");
     //   fileChooser.showOpenDialog(stage);
        ToggleGroup floats = new ToggleGroup();
        
        RadioButton left = new RadioButton("Float Left");
        if(image.getFloatValue().equals("Float Left")){
            left.setSelected(true);
        }
        
        left.setToggleGroup(floats);
        RadioButton right = new RadioButton("Float Right");
        right.setToggleGroup(floats);
        if(image.getFloatValue().equals("Float Right")){
            right.setSelected(true);
        }
        RadioButton neither = new RadioButton("Neither");
        if(image.getFloatValue().equals("Neither")){
            neither.setSelected(true);
        }
        neither.setToggleGroup(floats);
        HBox dummy = new HBox(left,right,neither);
        dummy.setSpacing(10);
        dummy.setAlignment(Pos.CENTER);
        Button g = new Button("Okay");
        VBox body = new VBox(remove,c,caption,comp,fileChoose,dummy,r,q,s,f,g);
        body.getStylesheets().add("css/style.css");
        body.setAlignment(Pos.TOP_CENTER);
         body.getStyleClass().add("dialog_box");
         c.getStyleClass().add("dialog_text");
         g.getStyleClass().add("dialog_button");
        fileChoose.getStyleClass().add("dialog_button");
         left.getStyleClass().add("dialog_button");
         right.getStyleClass().add("dialog_button");
         neither.getStyleClass().add("dialog_button");
         r.getStyleClass().add("dialog_text");
         s.getStyleClass().add("dialog_text");
         remove.getStyleClass().add("dialog_button");
           body.setSpacing(10);
        primaryScene = new Scene(body);
        primaryStage.setScene(primaryScene);
        primaryStage.show();
         url = image.getSource();
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
                                  File imgToCopy = new File(file.getPath());
                             String name = imgToCopy.getName();
                       //      File dest = new File("Icons",name);
                             
                             FileInputStream fis = new FileInputStream(imgToCopy);
                             FileOutputStream fos = new FileOutputStream("imgs/"+name);
                             byte[] buff = new byte[fis.available()];
                             fis.read(buff);
                             fos.write(buff);
                             File dummy = new File("imgs/"+name);
                             
                             Image slideImage = new Image(dummy.toURI().toURL().toExternalForm());
                             url = "imgs/"+name;
                             comp.setImage(slideImage);
                             comp.setImage(slideImage);
                             
                             
                                 double scaledHeight = 200;
                                 double perc = scaledHeight / slideImage.getHeight();
                                  double scaledWidth = slideImage.getWidth() * perc;
                                  comp.setFitWidth(scaledWidth);
                                  comp.setFitHeight(scaledHeight);
                        } catch (MalformedURLException ex) {
                            Logger.getLogger(dialogViews.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(dialogViews.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(dialogViews.class.getName()).log(Level.SEVERE, null, ex);
                        }
                      
	    
	 

                    }
                }
            });
        g.setOnAction(e1 -> {
            
                  
              
              if(q.getText().equals("")){
                  q.setText("100");
              }
              if(f.getText().equals("")){
                  f.setText("100");
              }
            RadioButton aq = (RadioButton) floats.getSelectedToggle();
           imageComponent dv= new imageComponent(url,aq.getText(),caption.getText(),Integer.parseInt(q.getText()),Integer.parseInt(f.getText()));
           image.setCaption(dv.getCaption());
           image.setSource(dv.getSource());
           image.setFloatValue(dv.getFloatValue());
           image.setWidth(dv.getWidth());
           image.setHeight(dv.getHeight());
         //  System.out.println(dv.getFloatValue());
           primaryStage.close();
                ePortfolio.setSaved(false);
                ePortfolio.getUI().updateDisabledButtons(ePortfolio.isSaved());
            
	});
         remove.setOnAction(e2 -> {
            ePortfolio.getSelectedPage().removeComponent(image);
            primaryStage.close();
          
            ePortfolio.getUI().componentList.getItems().remove(ePortfolio.getUI().componentList.getSelectionModel().getSelectedItem());
                 ePortfolio.setSaved(false);
                ePortfolio.getUI().updateDisabledButtons(ePortfolio.isSaved());
         });
           
    }
        /*
        static ArrayList<ImageView> images = new ArrayList();
         static        ArrayList<String> imageSources = new ArrayList();
     static    ArrayList<Text> captions = new ArrayList();
    static        ArrayList<String> captionText = new ArrayList();
       static   ArrayList<TextField> caps = new ArrayList();
    static     ArrayList<Button> buttons = new ArrayList();
   static      ArrayList<Button> removes = new ArrayList();
        */
        
    public void addImageView(ImageView o){
        images.add(o);
    }  
    public int getImageViewIndex(ImageView o){
        return images.indexOf(o);
    }
    public void addImageSource(String o){
        imageSources.add(o);
    }  
    public void addImageSource(int i,String o){
        imageSources.add(i,o);
    }  
    public void replaceImageSource(int index,String o){
        imageSources.set(index, o);
    }
    public void addCaption(TextField o){
        caps.add(o);
    }  
    public void addCaptionText(String o){
        captionText.add(o);
    }  
    public void removeFromImageView(int o){
        images.remove(o);
    }
     public void removeFromCaption(int o){
        caps.remove(o);
    }
     public void removeFromImageSrc(int o){
         imageSources.remove(o);
     }
  
    public void addSlideshowComponent(ePortfolioModel ePortfolio){
        counter = 0;
           
        
        FileChooser fileChooser = new FileChooser();
         FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Image Files","*.png","*.jpg","*.jpeg","*.gif");
        fileChooser.getExtensionFilters().add(extFilter);
        primaryStage.setWidth(900);
	primaryStage.setHeight(1000); 
        primaryStage.setX(bounds.getMinX()+bounds.getWidth()/3);
	primaryStage.setY(bounds.getMinY()+bounds.getHeight()/3);
     
  
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
           this.addImageView(img);
           
            Image d = new Image("imgs/question.png");
            this.addImageSource("imgs/question.png");
            
             img.setImage(d);
              double scaledWidth = 300;
          double perc = scaledWidth / d.getWidth();
          double scaledHeight = d.getHeight() * perc;
          img.setFitWidth(scaledWidth);
          img.setFitHeight(scaledHeight);
            
            Text txt = new Text();
           // this.addCaption(txt);
            
            Text c = new Text("Caption:");
            TextField cap = new TextField();
            this.addCaption(cap);
            //caps.add(cap);
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
            
            bt.setOnAction((final ActionEvent e1) -> {
                File file = fileChooser.showOpenDialog(fileChooserStage);
                if (file != null) {
                    // GET AND SET THE IMAGE
                    URL fileURL = null;
                    
                    try {
                                          
                        fileURL = file.toURI().toURL();
                                  File imgToCopy = new File(file.getPath());
                        String name = imgToCopy.getName();
                       //      File dest = new File("Icons",name);
                             
                        FileInputStream fis = new FileInputStream(imgToCopy);
                        FileOutputStream fos = new FileOutputStream("imgs/"+name);
                        byte[] buff = new byte[fis.available()];
                        fis.read(buff);
                        fos.write(buff);
                        File dum = new File("imgs/"+name);
                             
                             Image slideImage = new Image(dum.toURI().toURL().toExternalForm());
                        url = dum.toURI().toURL().toExternalForm();
                        
                        
                        
                        
                       
                             
                         
                        img.setImage(slideImage);
                        
                       
                        this.replaceImageSource(this.getImageViewIndex(img), "imgs/"+name);
                        
                        // System.out.println(imageSources.get(0));
                         
                         img.setFitWidth(scaledWidth);
                         img.setFitHeight(scaledHeight);
                        
                        
                    } catch (MalformedURLException ex) {
                        Logger.getLogger(dialogViews.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(dialogViews.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            r.setOnAction(e2 -> {
                this.removeFromCaption(counter-1);
                this.removeFromImageView(counter-1);
                this.removeFromImageSrc(counter-1);
               // imageSources.remove(counter-1);
                removes.remove(counter-1);
                buttons.remove(counter-1);
                
                //captionText.remove(counter-1);
                counter--;
                body.getChildren().remove(dummy);
            });
                
            
            
	});
        
 
        primaryScene = new Scene(scrollPane);
        primaryStage.setScene(primaryScene);
        primaryStage.show();
        
        g.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                for (TextField t : caps) {
                    dialogViews.this.addCaptionText(t.getText());
                    //   captionText.add(t.getText());
                }
                for(ImageView i: images){
                    //  this.addImageSource(i.getImage();
                    //  imageSources.add( i.getImage().toString());
                   
                }
                dialogViews.makeSlideshow(imageSources,captionText,ePortfolio);
                //  slideshowComponent slideshow = new slideshowComponent(imageSources,captionText);
                //   ePortfolio.getSelectedPage().addComponent(slideshow);
                //    System.out.println( slideshow.getImageSources().get(0));
                ePortfolio.setSaved(false);
                ePortfolio.getUI().updateDisabledButtons(ePortfolio.isSaved());
                primaryStage.close();
            }
        });
        
         
    }
    public static void makeSlideshow(ArrayList<String> i,ArrayList<String> c,ePortfolioModel ePortfolio){
        ArrayList<String> dummy = (ArrayList<String>) i.clone();
        ArrayList<String> dum = (ArrayList<String>) c.clone();
        slideshowComponent slideshow = new slideshowComponent(dummy,dum);
        slideshow.setImageSources(dummy);
        
        slideshow.setCaptions(dum);
        ePortfolio.getSelectedPage().addComponent(slideshow);
        
        imageSources.clear();
        captionText.clear();
        images.clear();
        captions.clear();
       //  System.out.println(slideshow.getImageSources().get(0));
    }
       public void editSlideshowComponent(slideshowComponent slideshow,ePortfolioModel ePortfolio){
        counter = 0;
           
        
        FileChooser fileChooser = new FileChooser();
         FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Image Files","*.png","*.jpg","*.jpeg","*.gif");
        fileChooser.getExtensionFilters().add(extFilter);
        primaryStage.setWidth(900);
	primaryStage.setHeight(1000); 
        primaryStage.setX(bounds.getMinX()+bounds.getWidth()/3);
	primaryStage.setY(bounds.getMinY()+bounds.getHeight()/3);
     
        Button remove = new Button("Remove");
        
        
        VBox body = new VBox(15);
        ScrollPane scrollPane = new ScrollPane(body);
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);
        
        
        body.getStylesheets().add("css/style.css");
        
        body.getStyleClass().add("dialog_box");
        
  
 
 
   
        body.getChildren().add(remove);
        remove.getStyleClass().add("dialog_button");
        remove.setOnAction(e2 -> {
            ePortfolio.getSelectedPage().removeComponent(slideshow);
            primaryStage.close();
           imageSources.clear();
        captionText.clear();
        images.clear();
        captions.clear();
            ePortfolio.getUI().componentList.getItems().remove(ePortfolio.getUI().componentList.getSelectionModel().getSelectedItem());
                 ePortfolio.setSaved(false);
                ePortfolio.getUI().updateDisabledButtons(ePortfolio.isSaved());
         });
        
        
 
        primaryScene = new Scene(scrollPane);
        primaryStage.setScene(primaryScene);
        primaryStage.show();
        
       
        
         
    }
    
    
    
    
     
    
    public void imageFileToImageView(ImageView view ,URL fileURL,File file) throws MalformedURLException, FileNotFoundException, IOException{
        fileURL = file.toURI().toURL();
         Image slideImage = new Image(fileURL.toExternalForm());
          view.setImage(slideImage);      
          
          File imgToCopy = new File(file.getPath());
                             String name = imgToCopy.getName();
                       //      File dest = new File("Icons",name);
                             
            FileInputStream fis = new FileInputStream(imgToCopy);
             FileOutputStream fos = new FileOutputStream("imgs/"+name);
              byte[] buff = new byte[fis.available()];
               fis.read(buff);
             fos.write(buff);
             File dummy = new File("imgs/"+name);
                             
                             
             url = dummy.toURI().toURL().toExternalForm();
          
           
          
          
          
          double scaledWidth = 350;
          double perc = scaledWidth / slideImage.getWidth();
          double scaledHeight = slideImage.getHeight() * perc;
          view.setFitWidth(scaledWidth);
          view.setFitHeight(scaledHeight);
    }
    public void addVideoComponent(ePortfolioModel ePortfolio){
        FileChooser fileChooser = new FileChooser();
        TextField comp = new TextField();
       
        primaryStage.setWidth(600);
	primaryStage.setHeight(600); 
        Text t = new Text("Caption:");
        
        Button g = new Button("Okay");
        Text r = new Text("Input width: ");
        TextField q = new TextField();
        Text s = new Text("Input height: ");
        TextField f = new TextField();
        TextField caption = new TextField();
        
        Button fileChoose = new Button("Choose:");
         FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Video Files","*.mp4");
        fileChooser.getExtensionFilters().add(extFilter);
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
                    FileInputStream fis = null;
                    try {
                        File file = fileChooser.showOpenDialog(fileChooserStage);
                        File imgToCopy = new File(file.getPath());
                        String name = imgToCopy.getName();
                        //      File dest = new File("Icons",name);
                        fis = new FileInputStream(imgToCopy);
                        FileOutputStream fos = new FileOutputStream("imgs/"+name);
                        byte[] buff = new byte[fis.available()];
                        fis.read(buff);
                        fos.write(buff);
                        File dummy = new File("imgs/"+name);
                     //   Image slideImage = new Image(dummy.toURI().toURL().toExternalForm());
                        url = dummy.toURI().toURL().toExternalForm();
                      
                            comp.setText(dummy.getPath());
                            
                        
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(dialogViews.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(dialogViews.class.getName()).log(Level.SEVERE, null, ex);
                    } finally {
                        try {
                            fis.close();
                        } catch (IOException ex) {
                            Logger.getLogger(dialogViews.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
           });
          g.setOnAction(e1 -> {
            
              if(comp.getText().equals("")){
                  
              }else{
              if(q.getText().equals("")){
                  q.setText("100");
              }
              if(f.getText().equals("")){
                  f.setText("100");
              }
             videoComponent video = new videoComponent(caption.getText(),comp.getText(),Integer.parseInt(q.getText()),Integer.parseInt(f.getText()));
             int index = 0;
             index = ePortfolio.getUI().componentList.getSelectionModel().getSelectedIndex();
             
            // ePortfolio.getUI().componentList.getSelectionModel().getSelectedIndex();
             ePortfolio.getSelectedPage().addComponent(video);
             primaryStage.close();
                  ePortfolio.setSaved(false);
                ePortfolio.getUI().updateDisabledButtons(ePortfolio.isSaved());
              }
	});
       
    }
      public void editVideoComponent(videoComponent video,ePortfolioModel ePortfolio){
        FileChooser fileChooser = new FileChooser();
        TextField comp = new TextField(video.getSource());
       
        primaryStage.setWidth(600);
	primaryStage.setHeight(600); 
        Text t = new Text("Caption:");
        
        Button remove = new Button("Remove");
        
        FlowPane topPane = new FlowPane(remove,t);
        topPane.setHgap(180);
        Button g = new Button("Okay");
        Text r = new Text("Input width: ");
        TextField q = new TextField(Integer.toString(video.getWidth()));
        Text s = new Text("Input height: ");
        TextField f = new TextField(Integer.toString(video.getHeight()));
        TextField caption = new TextField(video.getCaption());
        
        Button fileChoose = new Button("Choose:");
         FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Video Files","*.mp4");
         fileChooser.getExtensionFilters().add(extFilter);
        VBox body = new VBox(topPane,caption,fileChoose,comp,g,r,q,s,f);
        
        body.getStylesheets().add("css/style.css");
        t.getStyleClass().add("dialog_text");
        body.setAlignment(Pos.TOP_CENTER);
         body.getStyleClass().add("dialog_box");
         g.getStyleClass().add("dialog_button");
        fileChoose.getStyleClass().add("dialog_button");
         
         r.getStyleClass().add("dialog_text");
         s.getStyleClass().add("dialog_text");
         remove.getStyleClass().add("dialog_button");
            body.setSpacing(20);
        primaryScene = new Scene(body);
        primaryStage.setScene(primaryScene);
        primaryStage.show();
       fileChoose.setOnAction(
            new EventHandler<ActionEvent>() {
                @Override
                public void handle(final ActionEvent e) {
                    FileInputStream fis = null;
                    try {
                        File file = fileChooser.showOpenDialog(fileChooserStage);
                        File imgToCopy = new File(file.getPath());
                        String name = imgToCopy.getName();
                        //      File dest = new File("Icons",name);
                        fis = new FileInputStream(imgToCopy);
                        FileOutputStream fos = new FileOutputStream("imgs/"+name);
                        byte[] buff = new byte[fis.available()];
                        fis.read(buff);
                        fos.write(buff);
                        File dummy = new File("imgs/"+name);
                        Image slideImage = new Image(dummy.toURI().toURL().toExternalForm());
                        if (file != null) {
                            comp.setText(dummy.getPath());
                            
                        }
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(dialogViews.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(dialogViews.class.getName()).log(Level.SEVERE, null, ex);
                    } finally {
                        try {
                            fis.close();
                        } catch (IOException ex) {
                            Logger.getLogger(dialogViews.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
           });
          g.setOnAction(e1 -> {
            
              if(comp.getText().equals("")){
                  
              }else{
              if(q.getText().equals("")){
                  q.setText(Integer.toString(video.getWidth()));
              }
              if(f.getText().equals("")){
                  f.setText(Integer.toString(video.getHeight()));
              }
             videoComponent dummy = new videoComponent(caption.getText(),comp.getText(),Integer.parseInt(q.getText()),Integer.parseInt(f.getText()));
             video.setHeight(dummy.getHeight());
             video.setWidth(dummy.getWidth());
             video.setSource(dummy.getSource());
             video.setCaption(dummy.getCaption());
             primaryStage.close();
                  ePortfolio.setSaved(false);
                ePortfolio.getUI().updateDisabledButtons(ePortfolio.isSaved());
              }
	});
         remove.setOnAction(e2 -> {
            ePortfolio.getSelectedPage().removeComponent(video);
            primaryStage.close();
          
            ePortfolio.getUI().componentList.getItems().remove(ePortfolio.getUI().componentList.getSelectionModel().getSelectedItem());
                   ePortfolio.getUI().loadSelectedPage();
                        ePortfolio.setSaved(false);
                ePortfolio.getUI().updateDisabledButtons(ePortfolio.isSaved());
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
    public void editParagraphComponent(paragraphComponent para,ePortfolioModel ePortfolio){
       primaryStage.setWidth(600);
	primaryStage.setHeight(450);
        /*
        Button addHyperLink = new Button("Add Hyperlink");
     */
        ToggleGroup fonts = new ToggleGroup();
        Button g = new Button("Okay");
        Button remove = new Button("Remove");
        Text t = new Text("Write paragraph:");
       
        TextArea r = new TextArea();
        r.setText(para.getContent());
        /**
        addHyperLink.setOnAction(e2 -> {
            this.addHyperLink(r.getSelectedText(),para);
            r.replaceSelection("<html><font color=\\\"red\\\">"+ r.getSelectedText() + "</font></html>\"");
           
        });
        * **/
        RadioButton a = new RadioButton("Font A");
        a.getStylesheets().add("https://fonts.googleapis.com/css?family=Architects+Daughter");
        a.setStyle("-fx-font-family: 'Architects Daughter' ;");
        if(para.getFont().equals("Font A")){
            a.setSelected(true);
        }
        
        a.setToggleGroup(fonts);
        RadioButton b = new RadioButton("Font B");
        b.getStylesheets().add("https://fonts.googleapis.com/css?family=Shadows+Into+Light");
        b.setStyle("-fx-font-family: 'Shadows Into Light' ;");       
        b.setToggleGroup(fonts);
         if(para.getFont().equals("Font B")){
            b.setSelected(true);
        }
        RadioButton c = new RadioButton("Font C");
        c.getStylesheets().add("https://fonts.googleapis.com/css?family=Indie+Flower");
        c.setStyle("-fx-font-family: 'Indie Flower' ;");
        c.setToggleGroup(fonts);
        if(para.getFont().equals("Font C")){
            c.setSelected(true);
        }
        RadioButton d = new RadioButton("Font D");
        d.getStylesheets().add("https://fonts.googleapis.com/css?family=Poiret+One");
        d.setStyle("-fx-font-family: 'Poiret One' ;");
        d.setToggleGroup(fonts);
        if(para.getFont().equals("Font D")){
            d.setSelected(true);
        }
        RadioButton e = new RadioButton("Font E");
        e.getStylesheets().add("https://fonts.googleapis.com/css?family=Ubuntu+Condensed");
        e.setStyle("-fx-font-family: 'Ubuntu Condensed'; ");
        e.setToggleGroup(fonts);
        if(para.getFont().equals("Font E")){
            e.setSelected(true);
        }
        
        a.getStyleClass().add("dialog_button");
        b.getStyleClass().add("dialog_button");
        c.getStyleClass().add("dialog_button");
        d.getStyleClass().add("dialog_button");
        e.getStyleClass().add("dialog_button");
        
        
        
        HBox dummy = new HBox(a,b,c,d,e);
        dummy.setSpacing(10);
        dummy.setAlignment(Pos.CENTER);
        
        VBox body = new VBox(remove,t,r,dummy,g);
         body.getStylesheets().add("css/style.css");
         body.setAlignment(Pos.TOP_CENTER);
         body.getStyleClass().add("dialog_box");
           g.getStyleClass().add("dialog_button");
           t.getStyleClass().add("dialog_text");
         remove.getStyleClass().add("dialog_button");
       // addHyperLink.getStyleClass().add("dialog_button");
             body.setSpacing(20);
        primaryScene = new Scene(body);
        primaryStage.setScene(primaryScene);
        primaryStage.show();
        String font = "";
         g.setOnAction(e1 -> {
             RadioButton qw = (RadioButton) fonts.getSelectedToggle();
             para.setFont(qw.getText());
             para.setContent(r.getText());
             primaryStage.close();
                  ePortfolio.setSaved(false);
                ePortfolio.getUI().updateDisabledButtons(ePortfolio.isSaved());
	});
          remove.setOnAction(e2 -> {
            ePortfolio.getSelectedPage().removeComponent(para);
            primaryStage.close();
          
            ePortfolio.getUI().componentList.getItems().remove(ePortfolio.getUI().componentList.getSelectionModel().getSelectedItem());
            ePortfolio.getUI().loadSelectedPage();
                 ePortfolio.setSaved(false);
                ePortfolio.getUI().updateDisabledButtons(ePortfolio.isSaved());
          });
        
    }
    
    public void editHeaderComponent(headerComponent header, ePortfolioModel ePortfolio){
    
        primaryStage.setWidth(600);
	primaryStage.setHeight(350); 
        Text t = new Text("Write Header:");
        TextField r = new TextField();
        r.setText(header.getContent());
         ToggleGroup fonts = new ToggleGroup();
        Button g = new Button("Okay");
        Button remove = new Button("Remove");
        RadioButton a = new RadioButton("Font A");
        a.getStylesheets().add("https://fonts.googleapis.com/css?family=Architects+Daughter");
        a.setStyle("-fx-font-family: 'Architects Daughter' ;");
        if(header.getFont().equals("Font A")){
             a.setSelected(true);
        }
       
        a.setToggleGroup(fonts);
        RadioButton b = new RadioButton("Font B");
        b.getStylesheets().add("https://fonts.googleapis.com/css?family=Shadows+Into+Light");
        b.setStyle("-fx-font-family: 'Shadows Into Light' ;");
        b.setToggleGroup(fonts);
         if(header.getFont().equals("Font B")){
             b.setSelected(true);
        }
        RadioButton c = new RadioButton("Font C");
        c.getStylesheets().add("https://fonts.googleapis.com/css?family=Indie+Flower");
        c.setStyle("-fx-font-family: 'Indie Flower' ;");
        c.setToggleGroup(fonts);
         if(header.getFont().equals("Font C")){
             c.setSelected(true);
        }
        RadioButton d = new RadioButton("Font D");
        d.getStylesheets().add("https://fonts.googleapis.com/css?family=Poiret+One");
        d.setStyle("-fx-font-family: 'Poiret One' ;");
        d.setToggleGroup(fonts);
         if(header.getFont().equals("Font D")){
             d.setSelected(true);
        }
        RadioButton e = new RadioButton("Font E");
        e.getStylesheets().add("https://fonts.googleapis.com/css?family=Ubuntu+Condensed");
        e.setStyle("-fx-font-family: 'Ubuntu Condensed'; ");
        e.setToggleGroup(fonts);
         if(header.getFont().equals("Font E")){
             e.setSelected(true);
        }
        
        a.getStyleClass().add("dialog_button");
        b.getStyleClass().add("dialog_button");
        c.getStyleClass().add("dialog_button");
        d.getStyleClass().add("dialog_button");
        e.getStyleClass().add("dialog_button");
        
        
        
        HBox dummy = new HBox(a,b,c,d,e);
        dummy.setSpacing(10);
        dummy.setAlignment(Pos.CENTER);
        VBox body = new VBox(remove,t,r,dummy,g);
        remove.getStyleClass().add("dialog_button");
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
             RadioButton clown = (RadioButton) fonts.getSelectedToggle();
             header.setFont(clown.getText());
             header.setContent(r.getText());
             primaryStage.close();
                  ePortfolio.setSaved(false);
                ePortfolio.getUI().updateDisabledButtons(ePortfolio.isSaved());
	});
         remove.setOnAction(e2 -> {
            ePortfolio.getSelectedPage().removeComponent(header);
            primaryStage.close();
          
            ePortfolio.getUI().componentList.getItems().remove(ePortfolio.getUI().componentList.getSelectionModel().getSelectedItem());
            ePortfolio.getUI().loadSelectedPage();
              ePortfolio.setSaved(false);
                ePortfolio.getUI().updateDisabledButtons(ePortfolio.isSaved());
         });
    }
    
    public void editListComponent(listComponent list, ePortfolioModel ePortfolio){
        primaryStage.setWidth(300);
	primaryStage.setHeight(500); 
        VBox body = new VBox();
        ArrayList<TextField> contents = new ArrayList();
        
        Button removeComponent = new Button("Remove Component");
        
        ScrollPane scrollPane = new ScrollPane(body);
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);
             Button add = new Button("Add Item");
       
        Button g = new Button("Finished");
      
        FlowPane rand = new FlowPane(removeComponent,add,g);
        rand.setHgap(60);
        body.getChildren().add(rand);
        for(int i =0;i<list.getList().size();i++){
             TextField a = new TextField(list.getItem(i));
             contents.add(a);
             Button r1 = new Button("X");    
             FlowPane dummy = new FlowPane(a,r1);
             body.getChildren().add(dummy);
             r1.setOnAction(e1 -> {
                 contents.remove(a);
                body.getChildren().remove(dummy);
                
          });
              r1.getStylesheets().add("css/style.css");
              r1.getStyleClass().add("dialog_button");
        }
        
   
      
        
        body.getStylesheets().add("css/style.css");
        body.setAlignment(Pos.TOP_CENTER);
        body.getStyleClass().add("dialog_box");
        g.getStyleClass().add("dialog_button");
        add.getStyleClass().add("dialog_button");
        removeComponent.getStyleClass().add("dialog_button");
        body.setSpacing(20);
        primaryScene = new Scene(scrollPane);
        primaryStage.setScene(primaryScene);
        primaryStage.show();
        
        add.setOnAction(e -> {
            TextField b = new TextField("List Item");
            contents.add(b);
            System.out.println(b.getText());
            body.getChildren().add(b);
            Button r2 = new Button("X");
            FlowPane stupid = new FlowPane(b,r2);
            body.getChildren().add(stupid);
            r2.getStyleClass().add("dialog_button");
                 r2.setOnAction(e3 -> {
                    contents.remove(b);
                     body.getChildren().remove(stupid);
                 });
        });
        g.setOnAction(e1 -> {
            ArrayList<String> lists = new ArrayList();
            
            for(int i = 0;i<contents.size();i++){
                lists.add(contents.get(i).getText());
            }
            du = new listComponent(lists);
            System.out.print(du.getItem(0));
            //System.out.println(l.getItem(0));
            
            list.getList().clear();
            for(int i =0;i<du.getList().size();i++){
                list.addItem(i, du.getItem(i));
            }
            primaryStage.close();
                 ePortfolio.setSaved(false);
                ePortfolio.getUI().updateDisabledButtons(ePortfolio.isSaved());
            
	});
         removeComponent.setOnAction(e2 -> {
            ePortfolio.getSelectedPage().removeComponent(list);
            primaryStage.close();
          
            ePortfolio.getUI().componentList.getItems().remove(ePortfolio.getUI().componentList.getSelectionModel().getSelectedItem());
            ePortfolio.getUI().loadSelectedPage();
                 ePortfolio.setSaved(false);
                ePortfolio.getUI().updateDisabledButtons(ePortfolio.isSaved());
	});
        
        //return du;
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
             ePortfolio.setSaved(true);
                ePortfolio.getUI().updateDisabledButtons(ePortfolio.isSaved());
	});
    }
  
    public void newPortfolio(ePortfolioModel ePortfolio) throws MalformedURLException, IOException{
      
        primaryStage.setWidth(300);
	primaryStage.setHeight(150);
        if(ePortfolio.isSaved()){
              this.resetEPortfolio(ePortfolio);
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
        }else{
             Text areYouSure = new Text("Would you like to save first?");
             Button yes = new Button("Yes");
             Button no = new Button("No");
             FlowPane choice = new FlowPane(yes,no);
             choice.setAlignment(Pos.CENTER);
             choice.setHgap(20);
             VBox body = new VBox(areYouSure,choice);
             body.getStylesheets().add("css/style.css");
              body.setAlignment(Pos.TOP_CENTER);
              body.getStyleClass().add("dialog_box");
              yes.getStyleClass().add("dialog_button");
              no.getStyleClass().add("dialog_button");
              areYouSure.getStyleClass().add("dialog_text");
              primaryScene = new Scene(body);
              primaryStage.setScene(primaryScene);
              primaryStage.show();
              
              yes.setOnAction(e -> {
                primaryStage.close();
                if(ePortfolio.getSaveAsTitle()!=null){
                  try {
                      this.savePortfolio(ePortfolio);
                  } catch (IOException ex) {
                      Logger.getLogger(dialogViews.class.getName()).log(Level.SEVERE, null, ex);
                  }
                }else{
                    this.saveAsPortfolio(ePortfolio);
                }
              });
              no.setOnAction(e -> {
                 try {
                     this.resetEPortfolio(ePortfolio);
                 } catch (MalformedURLException ex) {
                     Logger.getLogger(dialogViews.class.getName()).log(Level.SEVERE, null, ex);
                 } catch (IOException ex) {
                     Logger.getLogger(dialogViews.class.getName()).log(Level.SEVERE, null, ex);
                 }
              });
             
        }
       
      
    }
    public void resetEPortfolio(ePortfolioModel ePortfolio) throws MalformedURLException, IOException{
            ePortfolio.reset();
              ePortfolioFileManager fileManager = new ePortfolioFileManager();
              int ee = ePortfolio.getUI().siteToolbar.getTabs().size();
              
              ePortfolio.getUI().siteToolbar.getTabs().remove(0, ee);
              ePortfolio.getUI().primaryStage.close();
              WorkspaceView ui = new WorkspaceView(fileManager);
              ePortfolioModel ePort = new ePortfolioModel(ui);
              ePortfolio = ePort;
              ePortfolio.setUI(ui);
              ePortfolio.getUI().startUI();
              ePortfolio.getUI().loadSelectedPage();
    }
    public void loadPortfolio(ePortfolioModel ePortfolio){
        ePortfolioFileManager fm = new ePortfolioFileManager();
        DirectoryChooser chooser = new DirectoryChooser();
        File file = new File("projects");
        file.mkdir();
        chooser.setInitialDirectory(file);
        Button fileChoose = new Button("Choose portfolio to load");
        
        primaryStage.setWidth(300);
	primaryStage.setHeight(100);
        
    //    Button g = new Button("OK");
        VBox body = new VBox(fileChoose);
        primaryScene = new Scene(body);
          body.getStylesheets().add("css/style.css");
        body.setAlignment(Pos.TOP_CENTER);
         body.getStyleClass().add("dialog_box");
     //    g.getStyleClass().add("dialog_button");
         fileChoose.getStyleClass().add("dialog_button");
            body.setSpacing(20);
        primaryStage.setScene(primaryScene);
        primaryStage.show();
        
        fileChoose.setOnAction(
            new EventHandler<ActionEvent>() {
                @Override
                public void handle(final ActionEvent e) {
                    //File file = chooser.showOpenDialog(fileChooserStage);
                    File file = chooser.showDialog(fileChooserStage);
                    if (file != null) {
                        // GET AND SET THE IMAGE
                        URL fileURL;
                        try {
                         //   fileURL = file.toURI().toURL();
                            
                           //  url = fileURL.toExternalForm();
                         //    url = fileURL.getPath();
                           url = file.getName();
                            fm.loadEPortfolio(ePortfolio, "projects"+"/"+url,ePortfolio.getUI().siteToolbar,ePortfolio.getUI());
                               ePortfolio.setSaved(true);
                              ePortfolio.getUI().updateDisabledButtons(ePortfolio.isSaved());
                             primaryStage.close();
                        } catch (MalformedURLException ex) {
                            Logger.getLogger(dialogViews.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(dialogViews.class.getName()).log(Level.SEVERE, null, ex);
                        }
                      
	    
	 

                    }
                }
            });
    }
    public void savePortfolio(ePortfolioModel ePortfolio) throws IOException{
      
        
        primaryStage.setWidth(300);
	primaryStage.setHeight(150);
        ePortfolioFileManager fm = new ePortfolioFileManager();
        fm.makeJsonOfProject(ePortfolio);
          ePortfolio.setSaved(true);
       ePortfolio.getUI().updateDisabledButtons(ePortfolio.isSaved());
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
        g.setOnAction(e -> {
           primaryStage.close();
	});
        
    }
    public void saveAsPortfolio(ePortfolioModel ePortfolio){
        
        primaryStage.setWidth(300);
	primaryStage.setHeight(190);
        Text t = new Text("Select name for ePortfolio");
        TextField saveAsName = new TextField();
        Button g = new Button("Okay");
        VBox body = new VBox(t,saveAsName,g);
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
            if(saveAsName.getText().equals("")){
                
            }else{
            try {
                ePortfolio.setSaveAsTitle(saveAsName.getText());
                this.savePortfolio(ePortfolio);
                ePortfolio.setSaved(true);
                ePortfolio.getUI().updateDisabledButtons(ePortfolio.isSaved());
            } catch (IOException ex) {
                Logger.getLogger(dialogViews.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
	});
    }
    public void exportPortfolio(ePortfolioModel ePortfolio) throws IOException{
        exportController eC = new exportController();
        eC.exportProject(ePortfolio);
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
        g.setOnAction(e -> {
             primaryStage.close();
        });
    }
    public void exitPortfolio(ePortfolioModel ePortfolio){
        if(ePortfolio.isSaved()){
            System.exit(0);
        }
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
        if(ePortfolio.isSaved()){
            t.setText("Are you sure you want to exit?");
               yes.setOnAction(e -> {
	  
               System.exit(0);
             });
             no.setOnAction(e -> {
                 primaryStage.close();
            });
        }else{
               yes.setOnAction(e -> {
               if(ePortfolio.getSaveAsTitle()==null){
                   this.saveAsPortfolio(ePortfolio);
                   
               }else{
                   try {
                       this.savePortfolio(ePortfolio);
                       
                   } catch (IOException ex) {
                       Logger.getLogger(dialogViews.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               Text saved = new Text("Succesfully Saved!");
               body.getChildren().remove(t);
               body.getChildren().remove(dummy);
               body.getChildren().add(saved);
               Button g = new Button("Okay");
               body.getChildren().add(g);
               g.getStyleClass().add("dialog_button");
               saved.getStyleClass().add("dialog_text");
               
               g.setOnAction(e1 -> {
                      System.exit(0);
                });
               
            });
             no.setOnAction(e -> {
             System.exit(0);
            });
        }
           
        
        
        primaryScene = new Scene(body);
        primaryStage.setScene(primaryScene);
        primaryStage.show();
       
        
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
    public void addHyperLink(String s, paragraphComponent para){
        
        secondaryStage.setWidth(300);
	secondaryStage.setHeight(150);
        
        Text link = new Text("url");
        TextField linkSpace = new TextField();
       Button finished = new Button("Finished");
        FlowPane f = new FlowPane(link,linkSpace);
        f.setAlignment(Pos.CENTER);
        VBox body = new VBox();
        body.setAlignment(Pos.CENTER);
        body.getStylesheets().add("css/style.css");
        body.getStyleClass().add("dialog_box");
        body.getChildren().add(f);
        body.getChildren().add(finished);
        link.getStyleClass().add("dialog_text");
        finished.getStyleClass().add("dialog_button");
        
        secondaryScene = new Scene(body);
        secondaryStage.setScene(secondaryScene);
        secondaryStage.show();
        
           finished.setOnAction(e -> {
             secondaryStage.close();
             para.addHyperLink(s, linkSpace.getText());
            });
    }
    
}
