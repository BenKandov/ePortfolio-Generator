/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
    public void selectLayoutTemplate(){
        dV.selectLayoutTemplate();
    }
    public void selectColorTemplate(){
        dV.selectColorTemplate();
    }
    public void selectBannerImage(){
        dV.selectBannerImage();
    }
    public void chooseComponentFont(){
        dV.chooseComponentFont();
    }
    public void updatePageTitle(){
        dV.updatePageTitle();
    }
    public void updateStudentName(){
        dV.updateStudentName();
    }
    public void updateFooter(){
        dV.updateFooter();
    }
    public void addTextComponent(){
        dV.addTextComponent();
    }
    public void addImageComponent(){
        dV.addImageComponent();
    }
    public void addSlideShowComponent(){
        dV.addSlideshowComponent();
    }
    public void addVideoComponent(){
        dV.addVideoComponent();
    }
    public void removeComponent(){
        dV.removeComponent();
    }
    public void editTextComponent(){
        dV.editTextComponent();
    }
    public void editImageComponent(){
        dV.editImageComponent();
    }
    public void editVideoComponent(){
        dV.editVideoComponent();
    }
    public void addTextHyperlink(){
        dV.addTextHyperlink();
    }
    public void editTextHyperlink(){
        dV.editTextHyperlink();
    }
    public void newPortfolio(){
        dV.newPortfolio();
    }
    public void loadPortfolio(){
        dV.loadPortfolio();
    }
    public void savePortfolio(){
        dV.savePortfolio();
    }
    public void saveAsPortfolio(){
        dV.saveAsPortfolio();
    }
    public void exportPortfolio(){
        dV.exportPortfolio();
    }
    public void exitPortfolio(){
        dV.exitPortfolio();
    }
}
