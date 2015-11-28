/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import fileManager.ePortfolioFileManager;
import model.ePortfolioModel;
import views.WorkspaceView;

/**
 *
 * @author benkandov
 */
public class fileController {
    
 
       
    // WE WANT TO KEEP TRACK OF WHEN SOMETHING HAS NOT BEEN SAVED
    private boolean saved;

    // THE APP UI
    private WorkspaceView ui;
    
    // THIS GUY KNOWS HOW TO READ AND WRITE SLIDE SHOW DATA
    private ePortfolioFileManager ePortfolioIO;
       
       
       public fileController(WorkspaceView initUi,ePortfolioFileManager fm){
           this.ui=initUi;
           this.ePortfolioIO=fm;
           saved=true;
       }
       public void markAsEdited(){
           saved = false;
           //TODO updateToolbarcontrols
       }
       public void handleNewEportfolioRequest(){
           ePortfolioModel ePortfolio = ui.getEPortfolio();
           ePortfolio.reset();
           saved=false;
           //TODO update toolbar controls
           //TODO reload title controls
       }
       public void handleLoadSlideShowRequest(){
           //TODO this method
       }
       public void handleSaveSlideShowRequest(){
           //TODO
       }
    
}
