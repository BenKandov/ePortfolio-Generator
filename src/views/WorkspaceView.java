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
import controller.dialogController;
import controller.fileController;
import fileManager.ePortfolioFileManager;
import java.awt.Component;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

/**
 *
 * @author benkandov
 */
public class WorkspaceView {
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
    
    public void loadSelectedPage(){
       
       
        Tab currentTab = siteToolbar.getSelectionModel().getSelectedItem();
        FlowPane pageHead = new FlowPane();
       pageTitle = new Text(ePortfolio.getSelectedPage().getTitle());
       studentName = new Text(ePortfolio.getSelectedPage().getStudentName());
       pageHead.getChildren().add(pageTitle);
       pageHead.getChildren().add(studentName);
       pageHead.setAlignment(Pos.CENTER);
       pageHead.setHgap(30);
       
       ListView page = new ListView(ePortfolio.getSelectedPage().getComponents());
       page.getStylesheets().add("css/style.css");
       page.getSelectionModel().getSelectedItem();
       BorderPane body = new BorderPane();
       body.getStylesheets().add("css/style.css");
       pageHead.getStyleClass().add("dialog_box");
       pageTitle.getStyleClass().add("dialog_text");
       studentName.getStyleClass().add("dialog_text");
       body.setTop(pageHead);
       body.setCenter(page);
       FlowPane footer = new FlowPane();
       footer.setAlignment(Pos.CENTER);
       
       footerText = new Text(ePortfolio.getSelectedPage().getFooter());
       footer.getChildren().add(footerText);
       body.setBottom(footer);
       footer.getStyleClass().add("dialog_box");
       footerText.getStyleClass().add("dialog_text");
       
       currentTab.setContent(body);
       
       dialogViews dum = new dialogViews();
       page.setOnMouseClicked((MouseEvent event) -> {
           char index = page.getSelectionModel().getSelectedItem().toString().charAt(page.getSelectionModel().getSelectedItem().toString().length()-1);
           int intex = Character.getNumericValue(index);
           component selected = ePortfolio.getSelectedPage().findComponent(intex-1);
           if(selected.getType().equals("Paragraph Component")){
               dum.editParagraphComponent((paragraphComponent) selected);
           }
           else if(selected.getType().equals("Header Component")){
               dum.editHeaderComponent((headerComponent) selected);
           }
           else if(selected.getType().equals("List Component")){
               dum.editListComponent((listComponent) selected);
           }
           else if(selected.getType().equals("Image Component")){
               dum.editImageComponent((imageComponent) selected);
           }
           System.out.println(index);
        });
        
        
        Page actualPage = ePortfolio.getSelectedPage();
        pageTitle.setText(actualPage.getTitle());
        actualPage.getTab().setText(actualPage.getTitle());
        studentName.setText(actualPage.getStudentName());
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
    
    public void startUI() throws MalformedURLException{
        initWorkspaceModeToolbar();
        
        initFileToolbar();
        
        setEventHandlers();
        
        initPageEditorWorkspace();
        
        initSiteViewerWorkspace();
        
        
        initWindow();
    }
   private Tab createAndSelectNewTab(final TabPane tabPane, final String title) {
        Tab tab = new Tab(title);
        final ObservableList<Tab> tabs = tabPane.getTabs();
        // tab.closableProperty().bind(Bindings.size(tabs).greaterThan(1));
        tabs.add(tabs.size(), tab);
        tabPane.getSelectionModel().select(tab);
        Page page = new Page("untitled");
        ePortfolio.addPage(page);
        ePortfolio.selectPage(page);
        page.setTab(tab);
        
        
        Button removeTab = new Button("Remove Page");
       
       
       
      
        
         currentTab = tab;
         removeTab.setOnAction(e -> {
             tab.getTabPane().getTabs().remove(tab);
             ePortfolio.remove(ePortfolio.pageByTab(tab));
             
             
         });
         tabPane.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {

            @Override
            public void changed(ObservableValue<? extends Tab> arg0,
                    Tab arg1, Tab arg2) {
                    ePortfolio.selectPage(ePortfolio.pageByTab(arg2));
                 
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
          tab.setClosable(false);
         this.loadSelectedPage();
         currentTab =tab;
         
         siteToolbar.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {

            @Override
            public void changed(ObservableValue<? extends Tab> arg0,
                    Tab arg1, Tab arg2) {
                    if(arg2.equals(tab)){
                        ePortfolio.selectPage(ePortfolio.getPages().get(0));
                        currentTab=arg2;
                        siteToolbar.getSelectionModel().select(arg2);
                        
                        System.out.println("swag" + ePortfolio.getSelectedPage().getTitle());
                        System.out.println(arg2.getText());
                        homie = true;
                        loadSelectedPage();
                    }
                    
                 
                 
            }
        });
      
         
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
         selectBannerImage.setTooltip(new Tooltip("Select Button Image"));
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
    public void initSiteViewerWorkspace() throws MalformedURLException{
         siteViewerPane = new WebView();
    //    siteViewerPane.getStylesheets().add("css/style.css");
      //  siteViewerPane.getStyleClass().add("site_viewer");
         File dir = new File("sites");
         File source = new File("sites/index.html");
    //      URL urlHello = getClass().getResource("sites/index.html");
        
       siteViewerPane.getEngine().load(source.toURI().toURL().toString());
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
	    workspaceModeToolbar.getChildren().remove(selectSiteViewerWorkspace);
            workspaceModeToolbar.getChildren().add(selectPageEditorWorkspace);
         
            mainPane.setCenter(siteViewerPane);
             System.out.println("Hello");
	});
        selectPageEditorWorkspace.setOnAction(e -> {
	    workspaceModeToolbar.getChildren().remove(selectPageEditorWorkspace);
            workspaceModeToolbar.getChildren().add(selectSiteViewerWorkspace);
            
              mainPane.setCenter(pageEditorPane);
	});
           selectLayoutTemplate.setOnAction(e -> {
               if(homie){
                     ePortfolio.selectPage(ePortfolio.getPages().get(0));
              
                     homie=false;
                }
	    DialogController.selectLayoutTemplate(ePortfolio);
	});
           selectColorTemplate.setOnAction(e -> {
               if(homie){
                     ePortfolio.selectPage(ePortfolio.getPages().get(0));
              
                     homie=false;
                }
	    DialogController.selectColorTemplate(ePortfolio);
	});
           selectBannerImage.setOnAction(e -> {
               if(homie){
                     ePortfolio.selectPage(ePortfolio.getPages().get(0));
              
                     homie=false;
                }
	    DialogController.selectBannerImage(ePortfolio);
	});
        chooseComponentFont.setOnAction(e -> {
            if(homie){
                     ePortfolio.selectPage(ePortfolio.getPages().get(0));
              
                     homie=false;
                }
	    DialogController.chooseComponentFont(ePortfolio);
	});
        updatePageTitle.setOnAction(e -> {
            if(homie){
                     ePortfolio.selectPage(ePortfolio.getPages().get(0));
              
                     homie=false;
                }
	    DialogController.updatePageTitle(ePortfolio);
            pageTitle.setText(ePortfolio.getSelectedPage().getTitle());
	});
        updateStudentName.setOnAction(e -> {
            if(homie){
                     ePortfolio.selectPage(ePortfolio.getPages().get(0));
              
                     homie=false;
                }
	   DialogController.updateStudentName(ePortfolio);
           studentName.setText(ePortfolio.getSelectedPage().getStudentName());
	});
        updateFooter.setOnAction(e -> {
            if(homie){
                     ePortfolio.selectPage(ePortfolio.getPages().get(0));
              
                     homie=false;
                }
	   DialogController.updateFooter(ePortfolio);
	});
      
        addTextComponent.setOnAction(e -> {
              if(homie){
                     ePortfolio.selectPage(ePortfolio.getPages().get(0));
              
                     homie=false;
                }
                 
	   DialogController.addTextComponent(ePortfolio);
	});
        
        addImageComponent.setOnAction(e -> {
            if(homie){
                     ePortfolio.selectPage(ePortfolio.getPages().get(0));
                     homie=false;
                }
	   DialogController.addImageComponent(ePortfolio);
	});
        addSlideshowComponent.setOnAction(e -> {
            if(homie){
                     ePortfolio.selectPage(ePortfolio.getPages().get(0));
              
                     homie=false;
                }
	   DialogController.addSlideShowComponent(ePortfolio);
	});
        addVideoComponent.setOnAction(e -> {
            if(homie){
                     ePortfolio.selectPage(ePortfolio.getPages().get(0));
              
                     homie=false;
                }
	   DialogController.addVideoComponent(ePortfolio);
	});
       
        
        
        newPortfolio.setOnAction(e -> {
            if(homie){
                     ePortfolio.selectPage(ePortfolio.getPages().get(0));
              
                     homie=false;
                }
           fileControl.handleNewEportfolioRequest();
	   DialogController.newPortfolio(ePortfolio);
	});
        loadPortfolio.setOnAction(e -> {
            if(homie){
                     ePortfolio.selectPage(ePortfolio.getPages().get(0));
              
                     homie=false;
                }
	   DialogController.loadPortfolio(ePortfolio);
	});
        savePortfolio.setOnAction(e -> {
            if(homie){
                     ePortfolio.selectPage(ePortfolio.getPages().get(0));
              
                     homie=false;
                }
	   DialogController.savePortfolio(ePortfolio);
	});
        saveAsPortfolio.setOnAction(e -> {
            if(homie){
                     ePortfolio.selectPage(ePortfolio.getPages().get(0));
              
                     homie=false;
                }
	   DialogController.saveAsPortfolio(ePortfolio);
	});
        exportPortfolio.setOnAction(e -> {
            if(homie){
                     ePortfolio.selectPage(ePortfolio.getPages().get(0));
              
                     homie=false;
                }
	   DialogController.exportPortfolio(ePortfolio);
	});
        exitPortfolio.setOnAction(e -> {
            if(homie){
                     ePortfolio.selectPage(ePortfolio.getPages().get(0));
              
                     homie=false;
                }
	   DialogController.exitPortfolio(ePortfolio);
	});
    }
    public void dummyComponents(){
        
    }
    
  
    
    
}
