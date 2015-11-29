/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import views.WorkspaceView;

/**
 *
 * @author benkandov
 */
public class ePortfolioModel {
    ObservableList<Page> pages = FXCollections.observableArrayList();
    Page selectedPage;
    WorkspaceView ui;
     
    public ePortfolioModel(WorkspaceView ui){
       this.ui=ui;
       Page HomePage = new Page();
       pages.add(HomePage);
       this.selectedPage=HomePage;
    }
    
    public void addPage(Page p){
        pages.add(p);
    }
    public void getPage(int position){
        pages.get(position);
    }
    public void selectPage(int position){
        this.selectedPage=pages.get(position);
    }
    public Page getSelectedPage(){
        return this.selectedPage;
    }
    public void reset(){
        selectedPage= null;
        pages.clear();
    }
    public WorkspaceView getUI(){
        return this.ui;
    }

    
    
}
