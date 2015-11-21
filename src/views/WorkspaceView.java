/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;


import controller.dialogController;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author benkandov
 */
public class WorkspaceView {
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
    Button removeComponent;
    Button editTextComponent;
    Button editImageComponent;
    Button editSlideshowComponent;
    Button editVideoComponent;
    Button addTextHyperlink;
    Button editTextHyperlink;
    //Page Editor Pane
    
    
    BorderPane siteViewerPane;
    
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
    
    
    //controllers
    private dialogController DialogController;
    //controllers
    
    
   
   
    public WorkspaceView(){
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
        removeComponent = new Button();
        editTextComponent = new Button();
        editImageComponent = new Button();
        editSlideshowComponent = new Button();
        editVideoComponent = new Button();
        addTextHyperlink = new Button();
        editTextHyperlink = new Button();
        
      
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
    
    public void startUI(){
        initWorkspaceModeToolbar();
        
        initFileToolbar();
        
        setEventHandlers();
        
        initPageEditorWorkspace();
        
        initSiteViewerWorkspace();
        
        
        initWindow();
    }
    public void initPageEditorWorkspace(){
         pageEditorPane = new BorderPane();
         pageEditorToolbar = new FlowPane(Orientation.VERTICAL);
         pageEditorToolbar.setHgap(15);
         pageEditorToolbar.setVgap(20);
       //  pageEditorToolbar.setAlignment(Pos.CENTER);
         pageEditorToolbar.setPadding(new Insets(10,40,10,40));
         siteToolbar = new TabPane();
         Tab tab = new Tab();
         tab.setText("example tab");
         siteToolbar.getTabs().add(tab);
        
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
         pageEditorToolbar.getChildren().add(removeComponent);
         pageEditorToolbar.getChildren().add(editTextComponent);
         pageEditorToolbar.getChildren().add(editSlideshowComponent);
         pageEditorToolbar.getChildren().add(editVideoComponent);
         pageEditorToolbar.getChildren().add(addTextHyperlink);
         pageEditorToolbar.getChildren().add(editTextHyperlink);
         
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
         setButtonImage(removeComponent,"Icons/removeComponent.png");
         removeComponent.setTooltip(new Tooltip("Add Remove Component"));
         setButtonImage(editTextComponent,"Icons/editTextComponent.png");
         editTextComponent.setTooltip(new Tooltip("Edit Text Component"));
         setButtonImage(editImageComponent,"Icons/editImageComponent.png");
         editImageComponent.setTooltip(new Tooltip("Edit Image Component"));
         setButtonImage(editSlideshowComponent,"Icons/editSlideshowComponent.png");
         editSlideshowComponent.setTooltip(new Tooltip("Edit Slideshow Component"));
         setButtonImage(editVideoComponent,"Icons/editVideoComponent.png");
         editVideoComponent.setTooltip(new Tooltip("Add Video Component"));
         setButtonImage(addTextHyperlink,"Icons/addTextHyperlink.png");
         addTextHyperlink.setTooltip(new Tooltip("Add Text Hyperlink"));
         setButtonImage(editTextHyperlink,"Icons/editTextHyperlink.png");
         editTextHyperlink.setTooltip(new Tooltip("Edit Text Hyperlink"));
         //Buttons
         
         
         pageEditorPane.setTop(siteToolbar);
         pageEditorPane.setRight(pageEditorToolbar);
         pageEditorPane.getStylesheets().add("css/style.css");
         pageEditorPane.getStyleClass().add("page_editor");
         
         
         
         
    }
    public void initSiteViewerWorkspace(){
        siteViewerPane = new BorderPane();
        siteViewerPane.getStylesheets().add("css/style.css");
        siteViewerPane.getStyleClass().add("site_viewer");
        
    }
    public void initFileToolbar(){
        FileToolbar = new FlowPane();
       
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
       dialogViews dialogs = new dialogViews();
       DialogController = new dialogController(this,dialogs);
       
       selectSiteViewerWorkspace.setOnAction(e -> {
	    workspaceModeToolbar.getChildren().remove(selectSiteViewerWorkspace);
            workspaceModeToolbar.getChildren().add(selectPageEditorWorkspace);
             mainPane.setCenter(siteViewerPane);
	});
        selectPageEditorWorkspace.setOnAction(e -> {
	    workspaceModeToolbar.getChildren().remove(selectPageEditorWorkspace);
            workspaceModeToolbar.getChildren().add(selectSiteViewerWorkspace);
            
              mainPane.setCenter(pageEditorPane);
	});
           selectLayoutTemplate.setOnAction(e -> {
	    DialogController.selectLayoutTemplate();
	});
           selectColorTemplate.setOnAction(e -> {
	    DialogController.selectColorTemplate();
	});
           selectBannerImage.setOnAction(e -> {
	    DialogController.selectBannerImage();
	});
        chooseComponentFont.setOnAction(e -> {
	    DialogController.chooseComponentFont();
	});
        updatePageTitle.setOnAction(e -> {
	    DialogController.updatePageTitle();
	});
        updateStudentName.setOnAction(e -> {
	   DialogController.updateStudentName();
	});
        updateFooter.setOnAction(e -> {
	   DialogController.updateFooter();
	});
        addTextComponent.setOnAction(e -> {
	   DialogController.addTextComponent();
	});
        addImageComponent.setOnAction(e -> {
	   DialogController.addImageComponent();
	});
        addSlideshowComponent.setOnAction(e -> {
	   DialogController.addSlideShowComponent();
	});
        addVideoComponent.setOnAction(e -> {
	   DialogController.addVideoComponent();
	});
        removeComponent.setOnAction(e -> {
	   DialogController.removeComponent();
	});
        addTextHyperlink.setOnAction(e -> {
	   DialogController.addTextHyperlink();
	});
        editTextHyperlink.setOnAction(e ->{
            
        });
        
        
        newPortfolio.setOnAction(e -> {
	   DialogController.newPortfolio();
	});
        loadPortfolio.setOnAction(e -> {
	   DialogController.loadPortfolio();
	});
        savePortfolio.setOnAction(e -> {
	   DialogController.savePortfolio();
	});
        saveAsPortfolio.setOnAction(e -> {
	   DialogController.saveAsPortfolio();
	});
        exportPortfolio.setOnAction(e -> {
	   DialogController.exportPortfolio();
	});
        exitPortfolio.setOnAction(e -> {
	   DialogController.exitPortfolio();
	});
    }
    
  
    
    
}
