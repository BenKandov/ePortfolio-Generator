/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileManager;


import components.headerComponent;
import components.imageComponent;
import components.listComponent;
import components.paragraphComponent;
import components.slideshowComponent;
import components.videoComponent;
import java.io.IOException;
import java.io.StringWriter;
import java.math.BigDecimal;
import javax.json.Json;
import javax.json.JsonObject;
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
    
    
    public void saveEPortfolio(ePortfolioModel portfolioToSave) throws IOException {
        StringWriter sw = new StringWriter();
        ///JsonArray sitesJsonArray 
        //JsonArray 
        
    }
    
    private JsonObject makePageJsonObject(Page page){
                JsonObject jso = Json.createObjectBuilder()
		.add("title", page.getTitle())
                .add("bannerImg","TODO")
                .add("bannerText","<h1>"+ "TODO" +"</h1")
		.add("navBar", "TODO")
		.add("components", "TODO")
             
		.build();
	return jso;
    }
    private JsonObject makeParagraphComponentJsonObject(paragraphComponent para){
        JsonObject jso = Json.createObjectBuilder()
                .add("content",para.getContent())
                .add("font",para.getFont())
                .build();
        return jso;
    }
     private JsonObject makeHeaderComponentJsonObject(headerComponent header){
         JsonObject jso = Json.createObjectBuilder()
                 .add("content",header.getContent())
                 .add("font", header.getFont())
                 .build();
        return jso;
    } 
     private JsonObject makeListComponentJsonObject(listComponent list){
        JsonObject jso = Json.createObjectBuilder()
                
                
                .build();
        return null;
    }
     private JsonObject makeImageComponentJsonObject(imageComponent image){
         JsonObject jso = Json.createObjectBuilder()
                 .add("src",image.getSource())
                 .add("float", image.getFloatValue())
                 .add("caption", image.getCaption()) 
                .build();
        return jso;
    } 
     private JsonObject makeVideoComponentJsonObject(videoComponent video){
            JsonObject jso = Json.createObjectBuilder()
                 .add("src",video.getSource())
                 .add("width", video.getWidth())
                 .add("height", video.getHeight()) 
                .build();
        return null;
    }
     private JsonObject makeSlideshowComponentJsonObject(slideshowComponent slideshow){
        return null;
    }
    
        
}
