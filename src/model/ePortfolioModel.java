/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Tab;
import views.WorkspaceView;

/**
 *
 * @author benkandov
 */
public class ePortfolioModel {
    ObservableList<Page> pages = FXCollections.observableArrayList();
    Page selectedPage;
    WorkspaceView ui;
    private String studentName;
    private String saveAsTitle;
     
    public ePortfolioModel(WorkspaceView ui){
       this.ui=ui;
       Page HomePage = new Page("HomePage");
       pages.add(HomePage);
       this.selectedPage=HomePage;
       this.studentName = "Student Name";
    }
    
    public void addPage(Page p){
        pages.add(p);
    }
    public void getPage(int position){
        pages.get(position);
    }
    public void selectPage(Page page){
        this.selectedPage=page;
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
    public ObservableList<Page> getPages(){
        return this.pages;
    }
    public Page pageByTab(Tab tab){
        for(int i = 1;i<pages.size();i++){
            if(pages.get(i).getTab().equals(tab)){
                return pages.get(i);
            }
        }
        return null;
    }
    public void remove(Page page){
        pages.remove(page);
    }
    public void setStudentName(String s){
        this.studentName=s;
    }
    public String getStudentName(){
        return this.studentName;
    }

    
    
}
