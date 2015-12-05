/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epg;

import fileManager.ePortfolioFileManager;
import java.io.IOException;
import java.net.MalformedURLException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import views.WorkspaceView;

/**
 *
 * @author benkandov
 */
public class EPortfolioGenerator extends Application {
    ePortfolioFileManager fm = new ePortfolioFileManager();
    WorkspaceView workspaceView = new WorkspaceView(fm);
     public void start(Stage primaryStage) throws MalformedURLException, IOException {
         workspaceView.startUI();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
