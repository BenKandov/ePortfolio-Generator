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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.json.JsonWriterFactory;
import javax.json.stream.JsonGenerator;
import model.ePortfolioModel;
import model.Page;

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
         String dir = "projects";
        File websiteDirectory = new File(dir,"TestWebsite");
        websiteDirectory.mkdir();
    }
    
    public void makeJsonOfProject(ePortfolioModel ePortfolio){
        String dir = "projects";
        File websiteDirectory = new File(dir,"TestWebsite");
        websiteDirectory.mkdir();
        
    }
    
    public void savePage(Page pageToSave) throws IOException {
        StringWriter sw = new StringWriter();
        
        JsonArray componentsJsonArray = makeComponentsJsonArray(pageToSave.getContent());
        System.out.println(pageToSave.getContent().get(0).getType());
              JsonObject pageJsonObject = Json.createObjectBuilder()
		.add("title", pageToSave.getTitle())
                .add("bannerImg","TODO")
                .add("bannerText","<h1>"+ "TODO" +"</h1")
		.add("navBar", "TODO")
		.add("components", componentsJsonArray)
		.build();
              
        Map<String, Object> properties = new HashMap<>(1);
	properties.put(JsonGenerator.PRETTY_PRINTING, true);      
              
        JsonWriterFactory writerFactory = Json.createWriterFactory(properties);
        JsonWriter jsonWriter = writerFactory.createWriter(sw);
        jsonWriter.writeObject(pageJsonObject);
        jsonWriter.close();
        
        String pageTitle = "" + pageToSave.getTitle();
        
        String jsonFilePath = "projects/TestWebsite" + SLASH + pageToSave.getTitle() + JSON_EXT;
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
        JsonArrayBuilder jsb = Json.createArrayBuilder();
        for(String s : list.getList()){
            //JsonObject jso = make
        }
                
        JsonArray jA =   jsb.build();
        return null;
    }
     private JsonObject makeImageComponentJsonObject(imageComponent image){
         JsonObject jso = Json.createObjectBuilder()
                 .add("type","image")
                 .add("src",image.getSource())
                 .add("float", image.getFloatValue())
                 .add("caption", image.getCaption()) 
                .build();
        return jso;
    } 
     private JsonObject makeVideoComponentJsonObject(videoComponent video){
            JsonObject jso = Json.createObjectBuilder()
                 .add("type","video")
                 .add("src",video.getSource())
                 .add("width", video.getWidth())
                 .add("height", video.getHeight()) 
                .build();
        return null;
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
        //         JsonObject jso = makeListComponentJsonObject((listComponent) c);
        //            jsb.add(jso);
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
    
        
}
