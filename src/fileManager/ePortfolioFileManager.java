/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileManager;


import java.io.IOException;
import java.io.StringWriter;
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
    
        
}
