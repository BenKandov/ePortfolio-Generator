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
    
    
}
