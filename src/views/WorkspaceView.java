/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author benkandov
 */
public class WorkspaceView {
    Stage primaryStage;
    Scene primaryScene;
    
    BorderPane mainPane;
    
    BorderPane pageEditorPane;
    BorderPane siteViewerPane;
    
    
    //File toolbar
    FlowPane FileToolbar;
    Button newPortfolio;
    Button loadPortfolio;
    Button savePortfolio;
    Button saveAsPortfolio;
    Button exportPortfolio;
    Button exitPortfolio;
    //File toolbar
    
    GridPane SiteToolbar;
   
    public WorkspaceView(){
        this.newPortfolio = new Button();
        this.loadPortfolio = new Button();
        this.savePortfolio = new Button();
        this.saveAsPortfolio = new Button();   
        this.exportPortfolio = new Button();
        this.exitPortfolio = new Button();
        
        this.mainPane = new BorderPane();
        this.primaryScene = new Scene(mainPane);
        this.primaryStage = new Stage();
        primaryStage.setScene(primaryScene);
    }
    
    public Stage getWindow() {
	return primaryStage;
    }
    
    public void startUI(){
        
    }
    public void initFileToolbar(){
        FileToolbar = new FlowPane();
        
        //Button initialization
        setButtonImage(newPortfolio,"Icons/NewPortfolio.png");
        setButtonImage(loadPortfolio,"Icons/LoadPortfolio.png");
        setButtonImage(savePortfolio,"Icons/SavePortfolio.png");
        setButtonImage(saveAsPortfolio,"Icons/SaveAsPortfolio.png");
        setButtonImage(exportPortfolio,"Icons/ExportPortfolio.png");
        setButtonImage(exitPortfolio,"Icons/ExitPortfolio.png");
        
        FileToolbar.getChildren().add(newPortfolio);
        FileToolbar.getChildren().add(loadPortfolio);
        FileToolbar.getChildren().add(savePortfolio);
        FileToolbar.getChildren().add(saveAsPortfolio);
        FileToolbar.getChildren().add(exportPortfolio);
        FileToolbar.getChildren().add(exitPortfolio);
    }
    public void setButtonImage(Button butt,String img){
        Image buttonImage = new Image(img);
	butt.setGraphic(new ImageView(buttonImage));
    }
    
  
    
    
}
