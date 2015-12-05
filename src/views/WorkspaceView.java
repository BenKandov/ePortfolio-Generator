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
import components.videoComponent;
import controller.dialogController;
import controller.exportController;
import controller.fileController;
import fileManager.ePortfolioFileManager;
import java.awt.Component;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import javafx.stage.Screen;
import javafx.stage.Stage;
import model.Page;
import model.ePortfolioModel;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author benkandov
 */
public class WorkspaceView {
    
    Stage removePageStage;
    Scene removePageScene;
    
    ListView componentList;
    
    Text colorTemplate;
    Text layoutTemplate;
    Text pageFont;
    FlowPane templates;
    ImageView bannerImage;
    
    Text pageTitle;
    Text studentName;
    Text footerText;
    Tab currentTab;
    
    Boolean homie = false;
    
    Stage primaryStage;
    Scene primaryScene;
    
    BorderPane mainPane;
    
    //Page Editor Pane
    BorderPane pageEditorPane;
    FlowPane pageEditorToolbar;
    
    Button selectLayoutTemplate;
    Button selectColorTemplate;
    Button selectBannerImage;
    Button selectComponent;
    Button chooseComponentFont;
    Button updatePageTitle;
    Button updateStudentName;
    Button updateFooter;
    Button addTextComponent;
    Button addImageComponent;
    Button addSlideshowComponent;
    Button addVideoComponent;
  
    
  

    //Page Editor Pane
    
    
    WebView siteViewerPane;
    
    //Workspace Mode Toolbar
    FlowPane workspaceModeToolbar;
    Button selectPageEditorWorkspace;
    Button selectSiteViewerWorkspace;
    //Workspace Mode Toolbar
    
    //File toolbar
    FlowPane FileToolbar;
    Button newPortfolio;
    Button loadPortfolio;
    Button savePortfolio;
    Button saveAsPortfolio;
    Button exportPortfolio;
    Button exitPortfolio;
    //File toolbar
    
    //Site Toolbar
    TabPane siteToolbar;
    //Site toolbar
    
    
    //controllers and things
    private dialogController DialogController;
    private ePortfolioFileManager fileManager;
    ePortfolioModel ePortfolio;
    //controllers and things
    
    public void changeStudentName(){
       Tab currentTab = ePortfolio.getSelectedPage().getTab();
        
        studentName.setText(ePortfolio.getStudentName());
    }
    public void changePageTitle(String t){
        pageTitle.setText(t);
    }
   
   
    public WorkspaceView(ePortfolioFileManager initFileManager){
        ePortfolio = new ePortfolioModel(this);
        fileManager = initFileManager;
        
        this.newPortfolio = new Button();
        this.loadPortfolio = new Button();
        this.savePortfolio = new Button();
        this.saveAsPortfolio = new Button();   
        this.exportPortfolio = new Button();
        this.exitPortfolio = new Button();
        
        this.selectPageEditorWorkspace = new Button();
        this.selectSiteViewerWorkspace = new Button();
        
        selectLayoutTemplate = new Button(); 
        selectColorTemplate = new Button();
        selectBannerImage = new Button();
        selectComponent = new Button();
        chooseComponentFont = new Button();
        updatePageTitle = new Button();
        updateStudentName = new Button();
        updateFooter = new Button();
        addTextComponent = new Button();
        addImageComponent = new Button();
        addSlideshowComponent = new Button();
        addVideoComponent = new Button();
       
     
       
        
        
      
    }
    public ePortfolioModel getEPortfolio(){
        return this.ePortfolio;
    }
    public void setCurrentTab(Tab tab){
        this.currentTab = tab;
    }
    
    public void loadSelectedPage(){
       
       
        Tab currentTab = ePortfolio.getSelectedPage().getTab();             
      
      //siteToolbar.getSelectionModel().getSelectedItem();
        FlowPane pageHead = new FlowPane();
       pageTitle = new Text(ePortfolio.getSelectedPage().getTitle());
       studentName = new Text(ePortfolio.getStudentName());
       pageHead.getChildren().add(pageTitle);
       pageHead.getChildren().add(studentName);
       pageHead.setAlignment(Pos.CENTER);
       pageHead.setHgap(30);
       
       //templates
          templates = new FlowPane(Orientation.VERTICAL);
          
          Text bannerImageText = new Text("Banner Image:");
          
          Image bannerImg = new Image(ePortfolio.getSelectedPage().getBannerImage());
              double scaledWidth = 100;
            double perc = scaledWidth / bannerImg.getWidth();
            double scaledHeight = bannerImg.getHeight() * perc;
             bannerImage = new ImageView(bannerImg);
             bannerImage.setFitWidth(scaledWidth);
            bannerImage.setFitHeight(scaledHeight);
         layoutTemplate = new Text(ePortfolio.getSelectedPage().getLayoutTemplate());
         colorTemplate = new Text(ePortfolio.getSelectedPage().getColorTemplate());
         pageFont = new Text(ePortfolio.getSelectedPage().getFont());
         templates.getChildren().add(bannerImageText);
         templates.getChildren().add(bannerImage);
         templates.getChildren().add(layoutTemplate);
         templates.getChildren().add(colorTemplate);
         templates.getChildren().add(pageFont);
           pageEditorPane.setRight(templates);
         templates.getStyleClass().add("dialog_box");
         layoutTemplate.getStyleClass().add("dialog_text");
         colorTemplate.getStyleClass().add("dialog_text");
         pageFont.getStyleClass().add("dialog_text");
         bannerImageText.getStyleClass().add("dialog_text");
         
       //templates
       
       componentList = new ListView(ePortfolio.getSelectedPage().getComponents());
       componentList.getStylesheets().add("css/style.css");
       componentList.getSelectionModel().getSelectedItem();
       BorderPane body = new BorderPane();
       body.getStylesheets().add("css/style.css");
       pageHead.getStyleClass().add("dialog_box");
       pageTitle.getStyleClass().add("dialog_text");
       studentName.getStyleClass().add("dialog_text");
       body.setRight(templates);
       body.setTop(pageHead);
       body.setCenter(componentList);
       FlowPane footer = new FlowPane();
       footer.setAlignment(Pos.CENTER);
       
       footerText = new Text(ePortfolio.getSelectedPage().getFooter());
       footer.getChildren().add(footerText);
       body.setBottom(footer);
       footer.getStyleClass().add("dialog_box");
       footerText.getStyleClass().add("dialog_text");
       
       currentTab.setContent(body);
       
       dialogViews dum = new dialogViews();
       componentList.setOnMouseClicked((MouseEvent event) -> {
          // char index = componentList.getSelectionModel().getSelectedItem().toString().charAt(componentList.getSelectionModel().getSelectedItem().toString().length()-1);
           //Character.getNumericValue(index);
           int intex = componentList.getSelectionModel().getSelectedIndex();
           component selected = ePortfolio.getSelectedPage().findComponent(intex);
           if(selected.getType().equals("Paragraph Component")){
               dum.editParagraphComponent((paragraphComponent) selected,ePortfolio);
           }
           else if(selected.getType().equals("Header Component")){
               dum.editHeaderComponent((headerComponent) selected,ePortfolio);
           }
           else if(selected.getType().equals("List Component")){
               dum.editListComponent((listComponent) selected,ePortfolio);
           }
           else if(selected.getType().equals("Image Component")){
               dum.editImageComponent((imageComponent) selected,ePortfolio);
           }
           else if(selected.getType().equals("Video Component")){
               dum.editVideoComponent((videoComponent) selected,ePortfolio);
           }
           ePortfolio.setSaved(false);
           this.updateDisabledButtons(ePortfolio.isSaved());
           
        });
        
        
        Page actualPage = ePortfolio.getSelectedPage();
        pageTitle.setText(actualPage.getTitle());
        
        actualPage.getTab().setText(actualPage.getTitle());
        studentName.setText(ePortfolio.getStudentName());
        footerText.setText(actualPage.getFooter());
    }
    public void initWindow(){
        this.mainPane = new BorderPane();
        mainPane.setTop(FileToolbar);
        mainPane.setCenter(pageEditorPane);
       
        this.primaryScene = new Scene(mainPane);
        primaryScene.getStylesheets().add("css/style.css");
        FileToolbar.getStyleClass().add("toolbar");
        pageEditorToolbar.getStyleClass().add("toolbar");
        siteToolbar.getStyleClass().add("tabPane");
        
         
        
        this.primaryStage = new Stage();
        
        Screen screen = Screen.getPrimary();
	Rectangle2D bounds = screen.getVisualBounds();

	
	primaryStage.setX(bounds.getMinX());
	primaryStage.setY(bounds.getMinY());
	primaryStage.setWidth(bounds.getWidth());
	primaryStage.setHeight(bounds.getHeight());
        
        primaryStage.setScene(primaryScene);
        primaryStage.show();
        
    }
    public Stage getWindow() {
	return primaryStage;
    }
    
    public void startUI() throws MalformedURLException, IOException{
        initWorkspaceModeToolbar();
        
        initFileToolbar();
        
        setEventHandlers();
        
        initPageEditorWorkspace();
        
        initSiteViewerWorkspace();
        
        
        initWindow();
    }
   public Tab createAndSelectNewTab(final TabPane tabPane, final String title) {
        Tab tab = new Tab(title);
        final ObservableList<Tab> tabs = tabPane.getTabs();
        // tab.closableProperty().bind(Bindings.size(tabs).greaterThan(1));
        tabs.add(tabs.size(), tab);
        tabPane.getSelectionModel().select(tab);
        
        
        Page page = new Page("untitled" + ePortfolio.getPages().size());
        page.setUI(this);
        ePortfolio.addPage(page);
        ePortfolio.selectPage(page);
        page.setTab(tab);
        
        
        Button removeTab = new Button("Remove Page");
       
       
       
      
        
         currentTab = tab;
         tab.setOnCloseRequest(new EventHandler<Event>(){
                @Override
                public void handle(Event t){
                     ePortfolio.remove(ePortfolio.pageByTab(tab));
                     ePortfolio.selectPage(ePortfolio.getPage(0));
                     currentTab = ePortfolio.getSelectedPage().getTab();
                     tabPane.getSelectionModel().select(currentTab);
                     ePortfolio.setSaved(false);
                     ePortfolio.getUI().updateDisabledButtons(false);
                }
        });
         removeTab.setOnAction(e -> {
             tab.getTabPane().getTabs().remove(tab);
             ePortfolio.remove(ePortfolio.pageByTab(tab));
             
             
         });
         tabPane.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {

            @Override
            public void changed(ObservableValue<? extends Tab> arg0,
                    Tab arg1, Tab arg2) {
                  
                   // 
                     
                    if(arg2.getText().equals("HomePage")){
                        ePortfolio.selectPage(ePortfolio.getPages().get(0));
                        currentTab = ePortfolio.getSelectedPage().getTab();
                       ePortfolio.getUI().loadSelectedPage();
                         
                    }else{
                          ePortfolio.selectPage(ePortfolio.pageByTab(arg2));
                          currentTab = ePortfolio.getSelectedPage().getTab();
                           ePortfolio.getUI().loadSelectedPage();
                    }
                 
            }
        });
         
         this.loadSelectedPage();
        return tab;
  }
   
    public void initPageEditorWorkspace(){
         pageEditorPane = new BorderPane();
         pageEditorToolbar = new FlowPane();
         pageEditorToolbar.setHgap(20);
         pageEditorToolbar.setVgap(25);
         pageEditorToolbar.setAlignment(Pos.CENTER);
         pageEditorToolbar.setPadding(new Insets(20,40,20,40));
         siteToolbar = new TabPane();
         
       
         Tab addTab = new Tab("+");
         addTab.setClosable(false);
          siteToolbar.getTabs().add(addTab);
     //    createAndSelectNewTab(siteToolbar,"HomePage");
          Tab tab = new Tab("HomePage");
          final ObservableList<Tab> tabs = siteToolbar.getTabs();
        // tab.closableProperty().bind(Bindings.size(tabs).greaterThan(1));
           tabs.add(tabs.size(), tab);
          siteToolbar.getSelectionModel().select(tab); 
          ePortfolio.getSelectedPage().setTab(tab);
          ePortfolio.getSelectedPage().setUI(this);
          tab.setClosable(false);
         this.loadSelectedPage();
         currentTab =tab;
         
         
      
         
          siteToolbar.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {
            @Override
                public void changed(ObservableValue<? extends Tab> observable,
                     Tab oldSelectedTab, Tab newSelectedTab) {
                    if (newSelectedTab == addTab) {
                          createAndSelectNewTab(siteToolbar, "Untitled");
                     }
             }
    });
     //Buttons
         pageEditorToolbar.getChildren().add(selectLayoutTemplate);
         pageEditorToolbar.getChildren().add(selectColorTemplate);
         pageEditorToolbar.getChildren().add(selectBannerImage);
        // pageEditorToolbar.getChildren().add(selectComponent);
         pageEditorToolbar.getChildren().add(chooseComponentFont);
         pageEditorToolbar.getChildren().add(updatePageTitle);
         pageEditorToolbar.getChildren().add(updateStudentName);
         pageEditorToolbar.getChildren().add(updateFooter);
         pageEditorToolbar.getChildren().add(addTextComponent);
         pageEditorToolbar.getChildren().add(addImageComponent);
         pageEditorToolbar.getChildren().add(addSlideshowComponent);
         pageEditorToolbar.getChildren().add(addVideoComponent);
        
         setButtonImage(selectLayoutTemplate,"Icons/selectLayoutTemplate.png");
         selectLayoutTemplate.setTooltip(new Tooltip("Select layout template"));
         setButtonImage(selectBannerImage,"Icons/selectBannerImage.png");
         selectBannerImage.setTooltip(new Tooltip("Select Banner Image"));
         setButtonImage(selectColorTemplate,"Icons/selectColorTemplate.png");
         selectColorTemplate.setTooltip(new Tooltip("Select Color Template"));
         setButtonImage(chooseComponentFont,"Icons/chooseComponentFont.png");
         chooseComponentFont.setTooltip(new Tooltip("Select Component Font"));
         setButtonImage(updatePageTitle,"Icons/UpdatePageTitle.png");
         updatePageTitle.setTooltip(new Tooltip("Update Page Title"));
         setButtonImage(updateStudentName,"Icons/updateStudentName.png");
         updateStudentName.setTooltip(new Tooltip("Update Student Name"));
         setButtonImage(updateFooter,"Icons/updateFooter.png");
         updateFooter.setTooltip(new Tooltip("Update Footer"));
         setButtonImage(addTextComponent,"Icons/addTextComponent.png");
         addTextComponent.setTooltip(new Tooltip("Add Text Component"));
         setButtonImage(addImageComponent,"Icons/addImageComponent.png");
         addImageComponent.setTooltip(new Tooltip("Add Image Component"));
         setButtonImage(addSlideshowComponent,"Icons/addSlideshowComponent.png");
         addSlideshowComponent.setTooltip(new Tooltip("Add Slideshow Component"));
         setButtonImage(addVideoComponent,"Icons/addVideoComponent.png");
         addVideoComponent.setTooltip(new Tooltip("Add Video Component"));

         //Buttons
         
         
         
           pageEditorPane.setTop(siteToolbar);
         pageEditorPane.setCenter(currentTab.getContent());
         pageEditorPane.setBottom(pageEditorToolbar);
       
         pageEditorPane.getStylesheets().add("css/style.css");
         pageEditorPane.getStyleClass().add("page_editor");
         
   
    }
    public void initSiteViewerWorkspace() throws MalformedURLException, IOException{
         siteViewerPane = new WebView();
         
    //    siteViewerPane.getStylesheets().add("css/style.css");
      //  siteViewerPane.getStyleClass().add("site_viewer");
   //      File dir = new File("sites");
     //    File source = new File("sites/index.html");
    //      URL urlHello = getClass().getResource("sites/index.html");
        
        
     //  siteViewerPane.getEngine().load(source.toURI().toURL().toString());
        //  siteViewerPane.getEngine().load("https://www.ic.sunysb.edu/Stu/bkandov/Layouts/index.html");
     //   siteViewerPane.getEngine().load("file:///"+"/sites/index.html");
     //  siteViewerPane.getEngine().load(urlHello.toExternalForm());
     
        
    }
    public void initFileToolbar(){
        FileToolbar = new FlowPane();
        FileToolbar.setHgap(20);
        FileToolbar.setVgap(20);
        //Button initialization
        setButtonImage(newPortfolio,"Icons/NewPortfolio.png");
        newPortfolio.setTooltip(new Tooltip("New Portfolio"));
        setButtonImage(loadPortfolio,"Icons/LoadPortfolio.png");
        loadPortfolio.setTooltip(new Tooltip("Load Portfolio"));
        setButtonImage(savePortfolio,"Icons/SavePortfolio.png");
        savePortfolio.setTooltip(new Tooltip("Save Portfolio"));
        setButtonImage(saveAsPortfolio,"Icons/SaveAsPortfolio.png");
        saveAsPortfolio.setTooltip(new Tooltip("Save As Portfolio"));
        setButtonImage(exportPortfolio,"Icons/ExportPortfolio.png");
        exportPortfolio.setTooltip(new Tooltip("Export Portfolio"));
        setButtonImage(exitPortfolio,"Icons/ExitPortfolio.png");
        exitPortfolio.setTooltip(new Tooltip("Exit Portfolio"));
        
        FileToolbar.getChildren().add(newPortfolio);
        FileToolbar.getChildren().add(loadPortfolio);
        FileToolbar.getChildren().add(savePortfolio);
        FileToolbar.getChildren().add(saveAsPortfolio);
        FileToolbar.getChildren().add(exportPortfolio);
        FileToolbar.getChildren().add(exitPortfolio);
        FileToolbar.getChildren().add(workspaceModeToolbar);
    }
    
    public void initWorkspaceModeToolbar(){
        workspaceModeToolbar = new FlowPane();
        setButtonImage(selectSiteViewerWorkspace,"Icons/SiteViewer.png");
        selectSiteViewerWorkspace.setTooltip(new Tooltip("Select Site Viewer Workspace"));
        setButtonImage(selectPageEditorWorkspace,"Icons/PageEditor.png");
        selectPageEditorWorkspace.setTooltip(new Tooltip("Select Page Editor Workspace"));
        workspaceModeToolbar.getChildren().add(selectSiteViewerWorkspace);
    }
    public void setButtonImage(Button butt,String img){
        Image buttonImage = new Image(img);
	butt.setGraphic(new ImageView(buttonImage));
    }
    public void setEventHandlers(){
       fileController fileControl = new fileController(this,fileManager);
       dialogViews dialogs = new dialogViews();
      
       DialogController = new dialogController(this,dialogs);
       
       selectSiteViewerWorkspace.setOnAction(e -> {
           try {
               workspaceModeToolbar.getChildren().remove(selectSiteViewerWorkspace);
               workspaceModeToolbar.getChildren().add(selectPageEditorWorkspace);
               
               mainPane.setCenter(siteViewerPane);
              
               
               File oldDir = new File("tempSite","tempProject");
               if(oldDir.isDirectory()){
                   FileUtils.cleanDirectory(oldDir);
               }
               
               exportController ec = new exportController();
               ePortfolioFileManager em = new ePortfolioFileManager();
               
              
               
               em.makeTemporaryJsonOfProject(ePortfolio);
               ec.exportTempPortfolio(ePortfolio);
               File source;
               source = new File("tempSite/tempProject/"+ ePortfolio.getSelectedPage().getTitle() +"/index.html");
               
               
    //      URL urlHello = getClass().getResource("sites/index.html");
              //  
              
               
              siteViewerPane.getEngine().load(source.toURI().toURL().toString());
               //siteViewerPane.getEngine().reload();
             
                
              
                
               
           } catch (IOException ex) {
               Logger.getLogger(WorkspaceView.class.getName()).log(Level.SEVERE, null, ex);
           }
	});
        selectPageEditorWorkspace.setOnAction(e -> {
	    workspaceModeToolbar.getChildren().remove(selectPageEditorWorkspace);
            workspaceModeToolbar.getChildren().add(selectSiteViewerWorkspace);
               siteViewerPane.getEngine().load(null);
               File oldDir = new File("tempSite","tempProject");
               if(oldDir.isDirectory()){
                try {
                    FileUtils.cleanDirectory(oldDir);
                } catch (IOException ex) {
                    Logger.getLogger(WorkspaceView.class.getName()).log(Level.SEVERE, null, ex);
                }
               }
              // siteViewerPane.getEngine().reload();
              mainPane.setCenter(pageEditorPane);
	});
           selectLayoutTemplate.setOnAction(e -> {
            
	    DialogController.selectLayoutTemplate(ePortfolio);
           
	});
           selectColorTemplate.setOnAction(e -> {
            
	    DialogController.selectColorTemplate(ePortfolio);
          
	});
           selectBannerImage.setOnAction(e -> {
            
	    DialogController.selectBannerImage(ePortfolio);
            
	});
        chooseComponentFont.setOnAction(e -> {
          
	    DialogController.chooseComponentFont(ePortfolio);
          
	});
        updatePageTitle.setOnAction(e -> {
            if(ePortfolio.getSelectedPage().getTitle().equals("HomePage")){
                
            }else{
                DialogController.updatePageTitle(ePortfolio);
               
            }
	    
          
	});
        updateStudentName.setOnAction(e -> {
          
           
	   DialogController.updateStudentName(ePortfolio);
           studentName.setText(ePortfolio.getSelectedPage().getStudentName());
          
	});
        updateFooter.setOnAction(e -> {
         
	   DialogController.updateFooter(ePortfolio);
      
	});
      
        addTextComponent.setOnAction(e -> {
          
                 
	   DialogController.addTextComponent(ePortfolio);
         
	});
        
        addImageComponent.setOnAction(e -> {
           
	   DialogController.addImageComponent(ePortfolio);
          
	});
        addSlideshowComponent.setOnAction(e -> {
           
	   DialogController.addSlideShowComponent(ePortfolio);
         
	});
        addVideoComponent.setOnAction(e -> {
        
	   DialogController.addVideoComponent(ePortfolio);
          
	});
       
        
        
        newPortfolio.setOnAction(e -> {
          
           fileControl.handleNewEportfolioRequest();
           try {
               DialogController.newPortfolio(ePortfolio);
           } catch (MalformedURLException ex) {
               Logger.getLogger(WorkspaceView.class.getName()).log(Level.SEVERE, null, ex);
           } catch (IOException ex) {
               Logger.getLogger(WorkspaceView.class.getName()).log(Level.SEVERE, null, ex);
           }
         
           
	});
        loadPortfolio.setOnAction(e -> {
           
	   DialogController.loadPortfolio(ePortfolio);
    
	});
        savePortfolio.setOnAction(e -> {
           if(ePortfolio.getSaveAsTitle()!=null){
           try {
                 File f = new File("projects/" + ePortfolio.getSaveAsTitle()); 
                for(File fe: f.listFiles()){
                      fe.delete();
                }
                f.delete();
               DialogController.savePortfolio(ePortfolio);
             
           } catch (IOException ex) {
               Logger.getLogger(WorkspaceView.class.getName()).log(Level.SEVERE, null, ex);
           }
           }else{
               DialogController.saveAsPortfolio(ePortfolio);
                
           }
	});
        saveAsPortfolio.setOnAction(e -> {
          
	   DialogController.saveAsPortfolio(ePortfolio);
          
         
	});
        exportPortfolio.setOnAction(e -> {
           
          
           try {
               DialogController.exportPortfolio(ePortfolio);
           } catch (IOException ex) {
               Logger.getLogger(WorkspaceView.class.getName()).log(Level.SEVERE, null, ex);
           }
          
	});
        exitPortfolio.setOnAction(e -> {
          
	   DialogController.exitPortfolio(ePortfolio);
        
	});
    }
    
    public void updateDisabledButtons(Boolean isSaved){
        if(isSaved){
            savePortfolio.setDisable(true);
           
            
        }
        else{
            savePortfolio.setDisable(false);
            
            
        }
    }
    
    public void removePageDialog(Page page,Tab tab,TabPane tabs){
        VBox dialog = new VBox();
        dialog.setAlignment(Pos.CENTER);
        Text text = new Text("Are you sure you want to delete this page?");
        dialog.getChildren().add(text);
        FlowPane buttonHolder = new FlowPane();
        buttonHolder.setAlignment(Pos.CENTER);
        Button Yes = new Button("Yes");
        Button No = new Button("No");
        buttonHolder.getChildren().add(Yes);
        buttonHolder.getChildren().add(No);
        dialog.getChildren().add(buttonHolder);
        dialog.getStylesheets().add("css/style.css");
        dialog.getStyleClass().add("dialog_box");
        text.getStyleClass().add("dialog_text");
        Yes.getStyleClass().add("dialog_button");
        No.getStyleClass().add("dialog_button");
        removePageScene = new Scene(dialog);
        removePageStage = new Stage();
        removePageStage.setScene(removePageScene);
        Yes.setOnAction(e -> {
            
	});
         No.setOnAction(e -> {
          
	});
        
        
    }
    
    
  
    
    
}
