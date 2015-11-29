/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import components.listComponent;
import components.paragraphComponent;
import model.ePortfolioModel;
import views.WorkspaceView;
import views.dialogViews;

/**
 *
 * @author benkandov
 */
public class dialogController {
    
    private WorkspaceView ui;
    private dialogViews dV;
 
    
    public dialogController(WorkspaceView u, dialogViews d){
        this.ui = u;
        this.dV = d;
    }   
    public void selectLayoutTemplate(ePortfolioModel e){
        dV.selectLayoutTemplate(e);
    }
    public void selectColorTemplate(ePortfolioModel e){
        dV.selectColorTemplate(e);
    }
    public void selectBannerImage(ePortfolioModel e){
        dV.selectBannerImage(e);
    }
    public void chooseComponentFont(ePortfolioModel e){
        dV.chooseComponentFont(e);
    }
    public void updatePageTitle(ePortfolioModel e){
        dV.updatePageTitle(e);
    }
    public void updateStudentName(ePortfolioModel e){
        dV.updateStudentName(e);
    }
    public void updateFooter(ePortfolioModel e){
        dV.updateFooter(e);
    }
    public void addTextComponent(ePortfolioModel e){
        dV.addTextComponent(e);
    }
    public void addImageComponent(ePortfolioModel e){
        dV.addImageComponent(e);
    }
    public void addSlideShowComponent(ePortfolioModel e){
        dV.addSlideshowComponent(e);
    }
    public void addVideoComponent(ePortfolioModel e){
        dV.addVideoComponent("");
    }
    public void removeComponent(ePortfolioModel e){
        dV.removeComponent(e);
    }
    public void editParagraphComponent(paragraphComponent p){
        dV.editParagraphComponent(p);
    }
    public void editImageComponent(ePortfolioModel e){
        dV.addImageComponent(e);
    }
    public void editVideoComponent(String url,ePortfolioModel e){
        dV.addVideoComponent(url);
    }
    public void addTextHyperlink(ePortfolioModel e){
        dV.addTextHyperlink(e);
    }
    public void editListComponent(listComponent list){
        dV.editListComponent(list);
    }
  
    public void newPortfolio(ePortfolioModel e){
        dV.newPortfolio(e);
    }
    public void loadPortfolio(ePortfolioModel e){
        dV.loadPortfolio(e);
    }
    public void savePortfolio(ePortfolioModel e){
        dV.savePortfolio(e);
    }
    public void saveAsPortfolio(ePortfolioModel e){
        dV.saveAsPortfolio(e);
    }
    public void exportPortfolio(ePortfolioModel e){
        dV.exportPortfolio(e);
    }
    public void exitPortfolio(ePortfolioModel e){
        dV.exitPortfolio(e);
    }
}
