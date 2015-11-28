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
    ObservableList<page> pages = FXCollections.observableArrayList();
    page selectedPage;
     
    public ePortfolioModel(WorkspaceView ui){
       page HomePage = new page();
       pages.add(HomePage);
       this.selectedPage=HomePage;
    }
    
    public void addPage(page p){
        pages.add(p);
    }
    public void getPage(int position){
        pages.get(position);
    }
    public void selectPage(int position){
        this.selectedPage=pages.get(position);
    }
    public page getSelectedPage(){
        return this.selectedPage;
    }
    public void reset(){
        selectedPage= null;
        pages.clear();
    }

    
    
}
