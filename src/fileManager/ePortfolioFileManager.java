/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileManager;


import components.component;
import components.headerComponent;
import components.imageComponent;
import components.listComponent;
import components.paragraphComponent;
import components.slideshowComponent;
import components.videoComponent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import javax.json.JsonWriter;
import javax.json.JsonWriterFactory;
import javax.json.stream.JsonGenerator;
import model.ePortfolioModel;
import model.Page;
import views.WorkspaceView;

/**
 *
 * @author benkandov
 */
public class ePortfolioFileManager {
        
    public static String JSON_TITLE = "title";
    public static String JSON_PAGES = "pages";
    public static String JSON_IMAGE_FILE_NAME = "image_file_name";
    public static String JSON_IMAGE_PATH = "image_path";
    public static String JSON_CAPTION = "caption";
    public static String JSON_EXT = ".json";
    public static String SLASH = "/";
    
  
    
    public ePortfolioFileManager(){
        
    }
    
    public void makeJsonOfProject(ePortfolioModel ePortfolio) throws IOException{
        String dir = "projects";
        File websiteDirectory = new File(dir,ePortfolio.getSaveAsTitle());
        websiteDirectory.mkdir();
        String path= websiteDirectory.getPath();
        for(Page page:ePortfolio.getPages() ){
            savePage(page,path,ePortfolio);
        }
        
    }
    
    public void savePage(Page pageToSave,String path,ePortfolioModel ePortfolio) throws IOException {
        StringWriter sw = new StringWriter();
        
        JsonArray componentsJsonArray = makeComponentsJsonArray(pageToSave.getContent());
        
              JsonObject pageJsonObject = Json.createObjectBuilder()
		.add("title", pageToSave.getTitle())   
                .add("layoutTemplate", pageToSave.getLayoutTemplate())   
                .add("colorTemplate", pageToSave.getColorTemplate())   
                .add("pageFont", pageToSave.getFont())   
                .add("footer", pageToSave.getFooter())   
                .add("bannerImg", pageToSave.getBannerImage())
                .add("bannerText", pageToSave.getTitle())
		.add("navBar", this.makeNavBarJsonArray(ePortfolio.getPages()))
		.add("components", componentsJsonArray)
		.build();
              
        Map<String, Object> properties = new HashMap<>(1);
	properties.put(JsonGenerator.PRETTY_PRINTING, true);      
              
        JsonWriterFactory writerFactory = Json.createWriterFactory(properties);
        JsonWriter jsonWriter = writerFactory.createWriter(sw);
        jsonWriter.writeObject(pageJsonObject);
        jsonWriter.close();
        
        String pageTitle = "" + pageToSave.getTitle();
        
        String jsonFilePath = path + SLASH + pageToSave.getTitle() + JSON_EXT;
        OutputStream os = new FileOutputStream(jsonFilePath);
        JsonWriter jsonFileWriter = Json.createWriter(os);
        jsonFileWriter.writeObject(pageJsonObject);
        String prettyPrinted = sw.toString();
        PrintWriter pw = new PrintWriter(jsonFilePath);
        pw.write(prettyPrinted);
        pw.close();
        System.out.println(prettyPrinted);
    }
    
    
    private JsonObject makeParagraphComponentJsonObject(paragraphComponent para){
        JsonObject jso = Json.createObjectBuilder()
                .add("type","text")
                .add("content",para.getContent())
                .add("font",para.getFont())
                .build();
        return jso;
    }
     private JsonObject makeHeaderComponentJsonObject(headerComponent header){
         JsonObject jso = Json.createObjectBuilder()
                 .add("type","header")
                 .add("content",header.getContent())
                 .add("font", header.getFont())
                 .build();
        return jso;
    } 
     private JsonObject makeListComponentJsonObject(listComponent list){
         JsonObject jso = Json.createObjectBuilder()
                 .add("type","list")
                 .add("content",makeListComponentJsonArray(list))
                 .build();
         return jso;
     }
     private JsonArray makeListComponentJsonArray(listComponent list){
        JsonArrayBuilder jsb = Json.createArrayBuilder();
        for(String s : list.getList()){
            JsonObject jso = makeListItemJsonObject(s);
            jsb.add(jso);
        }
                
        JsonArray jA =   jsb.build();
        return jA;
    }
    private JsonObject makeListItemJsonObject(String s){
        JsonObject jso = Json.createObjectBuilder()
                .add("content",s)
                .build();
        return jso;
    }
     private JsonObject makeImageComponentJsonObject(imageComponent image){
         JsonObject jso = Json.createObjectBuilder()
                 .add("type","image")
                 .add("width", image.getWidth())
                 .add("height", image.getHeight()) 
                 .add("src",image.getSource())
                 .add("float", image.getFloatValue())
                 .add("caption", image.getCaption()) 
                .build();
        return jso;
    } 
     private JsonObject makeVideoComponentJsonObject(videoComponent video){
            JsonObject jso = Json.createObjectBuilder()
                 .add("type","video")
                 .add("caption", video.getCaption())
                 .add("src",video.getSource())
                 .add("width", video.getWidth())
                 .add("height", video.getHeight()) 
                .build();
        return jso;
    }
     private JsonArray makeNavBarJsonArray(ObservableList<Page> pages){
        JsonArrayBuilder jsb = Json.createArrayBuilder();
        for(Page p: pages){
            JsonObject jso = makeNavItemJsonObject(p);
            jsb.add(jso);
        }
         
         JsonArray jA = jsb.build();
         return jA;
     }
     private JsonObject makeNavItemJsonObject(Page page){
             String newStr = page.getTitle().replaceAll(" ","%20");
            JsonObject jso = Json.createObjectBuilder()
                    //TODO if page title has spaces, make appropriate accomodations with that % sign bullshit
                    .add("name",page.getTitle() )
                    
                    .add("dest", newStr+"/index.html")
                    .build();
            return jso; 
     }
     private JsonObject makeSlideshowComponentJsonObject(slideshowComponent slideshow){
        return null;
    }
     private JsonArray makeComponentsJsonArray(ArrayList<component> components){
         JsonArrayBuilder jsb = Json.createArrayBuilder();
         for(component c: components ){
             if(c.getType().equals("Paragraph Component")){
                 JsonObject jso = makeParagraphComponentJsonObject((paragraphComponent) c);
                 jsb.add(jso);
             }else if(c.getType().equals("Header Component")){
                 JsonObject jso = makeHeaderComponentJsonObject((headerComponent) c);
                jsb.add(jso);
             }else if(c.getType().equals("List Component")){
                 JsonObject jso = makeListComponentJsonObject((listComponent) c);
                    jsb.add(jso);
             }else if(c.getType().equals("Image Component")){
                 JsonObject jso = makeImageComponentJsonObject((imageComponent) c);
                  jsb.add(jso);
             }else if(c.getType().equals("Video Component")){
                 JsonObject jso = makeVideoComponentJsonObject((videoComponent) c);
                  jsb.add(jso);
             }
         }
         JsonArray jA = jsb.build();
         return jA;
     }
     public void loadEPortfolio(ePortfolioModel ePortfolioToLoad,String folderFilePath,TabPane siteToolbar,WorkspaceView ui) throws IOException{
        File file = new File(folderFilePath);
        file.mkdir();
       
     //, 
        
        //Let's get that navBar
        JsonObject HomePage = loadJSONFile(folderFilePath+"/HomePage.json");
       // JsonObject HomePage = loadJSONFile("projects/BenjaminKandov/HomePage.json");
        JsonArray navBarArray = HomePage.getJsonArray("navBar");
        ArrayList<String> names = new ArrayList();
        for(int i =0;i<navBarArray.size();i++){
            JsonObject navJso = navBarArray.getJsonObject(i);
            names.add(navJso.getString("name"));
        }
        //Let's get that navBar
        
        ePortfolioToLoad.reset();
        
        ePortfolioToLoad.setSaveAsTitle(folderFilePath.substring(9));
        int ee = siteToolbar.getTabs().size();
        siteToolbar.getTabs().remove(0, ee);
        
        Tab addTab = new Tab("+");
        addTab.setClosable(false);
        siteToolbar.getTabs().add(addTab);
        
        
          siteToolbar.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {
            @Override
                public void changed(ObservableValue<? extends Tab> observable,
                     Tab oldSelectedTab, Tab newSelectedTab) {
                    if (newSelectedTab == addTab) {
                          ePortfolioToLoad.getUI().createAndSelectNewTab(siteToolbar, "Untitled");
                     }
             }
             });
        for(String name:names){
                
                Page page = new Page("blank");
                Tab tab = new Tab("untitled");
                page.setTab(tab);
                siteToolbar.getTabs().add(tab);
                siteToolbar.getSelectionModel().select(tab);
                if(name.equals("HomePage")){
                    tab.setClosable(false);
                }
               tab.setOnCloseRequest(new EventHandler<Event>(){
                @Override
                public void handle(Event t){
                     ePortfolioToLoad.remove(ePortfolioToLoad.pageByTab(tab));
                }
               });
                 siteToolbar.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {

                 @Override
                public void changed(ObservableValue<? extends Tab> arg0,
                    Tab arg1, Tab arg2) {
                    
                    
                    
                     if(arg2.getText().equals("HomePage")){
                        ePortfolioToLoad.selectPage(ePortfolioToLoad.getPages().get(0));
                      //  ePortfolioToLoad.getUI().currentTab = ePortfolioToLoad.getSelectedPage().getTab();
                       ePortfolioToLoad.getUI().loadSelectedPage();
                         
                    }else{
                          ePortfolioToLoad.selectPage(ePortfolioToLoad.pageByTab(arg2));
                       //   currentTab = ePortfolioToLoad.getSelectedPage().getTab();
                           ePortfolioToLoad.getUI().loadSelectedPage();
                    }
                 
                     }
                 });
                loadPage(page,folderFilePath + SLASH+ name,tab);
                tab.setText(page.getTitle());
              //  ui.changePageTitle(page.getTitle());
                ui.setCurrentTab(tab);
                ePortfolioToLoad.selectPage(page);
                ui.loadSelectedPage();
              
                ePortfolioToLoad.addPage(page);
                
           
        }
        
         
       
         
         
     }
     public void loadPage(Page page,String jsonFilePath,Tab tab) throws IOException{
        JsonObject json = loadJSONFile(jsonFilePath + ".json");
        page.setTitle(json.getString("title"));
        page.setBannerImage(json.getString("bannerImg"));
        page.setLayoutTemplate(json.getString("layoutTemplate"));
        page.setColorTemplate(json.getString("colorTemplate"));
        page.setFont(json.getString("pageFont"));
        page.setFooter(json.getString("footer"));
        
        tab.setText(json.getString("title"));
        JsonArray jsonComponentsArray = json.getJsonArray("components");
        for(int i =0;i<jsonComponentsArray.size();i++){
            JsonObject componentJso = jsonComponentsArray.getJsonObject(i);
            if(componentJso.getString("type").equals("text")){
                paragraphComponent para = new paragraphComponent(componentJso.getString("content"),componentJso.getString("font")); 
                page.addComponent(para);
            }
            else if(componentJso.getString("type").equals("image")){
                imageComponent image = new imageComponent(componentJso.getString("src"),componentJso.getString("float"),componentJso.getString("caption"),componentJso.getInt("width"),componentJso.getInt("height"));
                page.addComponent(image);
            }
            else if(componentJso.getString("type").equals("header")){
                headerComponent header = new headerComponent(componentJso.getString("content"),componentJso.getString("font"));
                page.addComponent(header);
            }
            else if(componentJso.getString("type").equals("video")){
                videoComponent video = new videoComponent(componentJso.getString("caption"),componentJso.getString("src"),componentJso.getInt("width"),componentJso.getInt("height"));
                page.addComponent(video);
            }
            else if(componentJso.getString("type").equals("list")){
                JsonArray listItemsArray = componentJso.getJsonArray("content");
                
                //
                ArrayList<String> listItems = new ArrayList();
                for(int j = 0;j<listItemsArray.size();j++){
                    JsonObject js = listItemsArray.getJsonObject(j);
                    listItems.add(js.getString("content"));
                }
                listComponent list = new listComponent(listItems);
                page.addComponent(list);
            }
        }
        
        
     }
     public paragraphComponent loadParagraphComponent(component c){
         return null;
     }
     
     private JsonObject loadJSONFile(String jsonFilePath) throws IOException{
         InputStream is = new FileInputStream(jsonFilePath);
         JsonReader jsonReader = Json.createReader(is);
         JsonObject json = jsonReader.readObject();
         jsonReader.close();
         is.close();
         return json;
     }
       private ArrayList<String> loadArrayFromJSONFile(String jsonFilePath, String arrayName) throws IOException {
	JsonObject json = loadJSONFile(jsonFilePath);
	ArrayList<String> items = new ArrayList();
	JsonArray jsonArray = json.getJsonArray(arrayName);
	for (JsonValue jsV : jsonArray) {
	    items.add(jsV.toString());
	}
	return items;
    }
       
      
    
        
}
