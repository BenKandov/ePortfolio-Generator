/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.IOException;
import model.Page;
import model.ePortfolioModel;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author benkandov
 */
public class exportController {
    
    public exportController(){
        
    }
    public void exportTempPortfolio(ePortfolioModel ePortfolio) throws IOException{
        File sitesDir = new File("tempSite");
        
        //File f = new File("tempSite/"+ePortfolio.getSaveAsTitle());
        
        File websiteDirectory = new File(sitesDir,"tempProject");
      
        
        for(Page page : ePortfolio.getPages()){
            exportTempPage(ePortfolio,page,websiteDirectory);
        }
    }
    
    public void exportProject(ePortfolioModel ePortfolio) throws IOException{
        File sitesDir = new File("sites");
        
         File f = new File("sites/" + ePortfolio.getSaveAsTitle()); 
         if(f.isDirectory()){
                for(File fe: f.listFiles()){
                fe.delete();
                  }
             f.delete(); 
         }
        
        
        
        
        File websiteDirectory = new File(sitesDir,ePortfolio.getSaveAsTitle());
      
        
        for(Page page : ePortfolio.getPages()){
            exportTempPage(ePortfolio,page,websiteDirectory);
        }
             
    }
    public void exportPage(ePortfolioModel ePortfolio,Page page, File websiteDirectory) throws IOException{
       File templatesDir = new File("templates");
        File pageFont;
        File layoutTemplate;
        File colorTemplate;
        File jsonFile = new File("projects/"+ePortfolio.getSaveAsTitle()+"/",page.getTitle()+".json");
        File htmlTemplate = new File("templates/","index.html");
        
        pageFont = new File("blah");
        if(page.getFont().equals("Font A")){
            pageFont = new File(templatesDir+"/fontTemplates","fontA.css");
        }
        else if(page.getFont().equals("Font B")){
            pageFont = new File(templatesDir+"/fontTemplates","fontB.css");
        }
        else if(page.getFont().equals("Font C")){
            pageFont = new File(templatesDir+"/fontTemplates","fontC.css");
        }
        else if(page.getFont().equals("Font D")){
            pageFont = new File(templatesDir+"/fontTemplates","fontD.css");
        }
        else if(page.getFont().equals("Font E")){
            pageFont = new File(templatesDir+"/fontTemplates","fontE.css");
        }
        layoutTemplate = new File("blah");
        if(page.getLayoutTemplate().equals("Layout A")){
            layoutTemplate = new File(templatesDir + "/layoutTemplates","layoutA.css");
        }
        else if(page.getLayoutTemplate().equals("Layout B")){
            layoutTemplate = new File(templatesDir + "/layoutTemplates","layoutB.css");
        }
        else if(page.getLayoutTemplate().equals("Layout C")){
            layoutTemplate = new File(templatesDir + "/layoutTemplates","layoutC.css");
        }
        else if(page.getLayoutTemplate().equals("Layout D")){
            layoutTemplate = new File(templatesDir + "/layoutTemplates","layoutD.css");
        }
        else if(page.getLayoutTemplate().equals("Layout E")){
            layoutTemplate = new File(templatesDir + "/layoutTemplates","layoutE.css");
        }
        
        colorTemplate = new File("blah");
        if(page.getColorTemplate().equals("Color A")){
            colorTemplate = new File(templatesDir + "/colorTemplates","colorA.css");
        }
        else if(page.getColorTemplate().equals("Color B")){
            colorTemplate = new File(templatesDir + "/colorTemplates","colorB.css");
        }
        else if(page.getColorTemplate().equals("Color C")){
            colorTemplate = new File(templatesDir + "/colorTemplates","colorC.css");
        }
        else if(page.getColorTemplate().equals("Color D")){
            colorTemplate = new File(templatesDir + "/colorTemplates","colorD.css");
        }
        else if(page.getColorTemplate().equals("Color E")){
            colorTemplate = new File(templatesDir + "/colorTemplates","colorE.css");
        }
        
        String layoutText = FileUtils.readFileToString(layoutTemplate);
        String colorText = FileUtils.readFileToString(colorTemplate);
        String fontText = FileUtils.readFileToString(pageFont);
        String htmlText = FileUtils.readFileToString(htmlTemplate);
        String jsonText = FileUtils.readFileToString(jsonFile);
        
        File pageDirectory = new File(websiteDirectory,page.getTitle());
        pageDirectory.mkdir();
        
        File newHtml = new File(pageDirectory,"index.html");
        File newLayout = new File(pageDirectory,"layout.css");
        File newColor = new File(pageDirectory,"color.css");
        File newFont = new File(pageDirectory,"font.css");
        File newJson = new File(pageDirectory,"file.json");
        File d = new File(pageDirectory,"imgs"); 
        File oldImgs = new File("imgs");
        FileUtils.copyDirectory(oldImgs,d);
        
        FileUtils.writeStringToFile(newLayout, layoutText);
        FileUtils.writeStringToFile(newColor, colorText);
        FileUtils.writeStringToFile(newFont, fontText);
        FileUtils.writeStringToFile(newHtml, htmlText);
        FileUtils.writeStringToFile(newJson ,jsonText);
        
        
        
    }
    
    public void exportTempPage(ePortfolioModel ePortfolio,Page page, File websiteDirectory) throws IOException{
       File templatesDir = new File("templates");
        File pageFont;
        File layoutTemplate;
        File colorTemplate;
        File jQuery = new File("sites/js","jquery-2.1.4.min.js");
        File jsonLoader = new File("sites/js","jsonLoader.js");
        File jsonFile = new File("tempSite/"+"tempProject"+"/",page.getTitle()+".json");
        File htmlTemplate = new File("templates/","index.html");
        
        pageFont = new File("blah");
        if(page.getFont().equals("Font A")){
            pageFont = new File(templatesDir+"/fontTemplates","fontA.css");
        }
        else if(page.getFont().equals("Font B")){
            pageFont = new File(templatesDir+"/fontTemplates","fontB.css");
        }
        else if(page.getFont().equals("Font C")){
            pageFont = new File(templatesDir+"/fontTemplates","fontC.css");
        }
        else if(page.getFont().equals("Font D")){
            pageFont = new File(templatesDir+"/fontTemplates","fontD.css");
        }
        else if(page.getFont().equals("Font E")){
            pageFont = new File(templatesDir+"/fontTemplates","fontE.css");
        }
        layoutTemplate = new File("blah");
        if(page.getLayoutTemplate().equals("Layout A")){
            layoutTemplate = new File(templatesDir + "/layoutTemplates","layoutA.css");
        }
        else if(page.getLayoutTemplate().equals("Layout B")){
            layoutTemplate = new File(templatesDir + "/layoutTemplates","layoutB.css");
        }
        else if(page.getLayoutTemplate().equals("Layout C")){
            layoutTemplate = new File(templatesDir + "/layoutTemplates","layoutC.css");
        }
        else if(page.getLayoutTemplate().equals("Layout D")){
            layoutTemplate = new File(templatesDir + "/layoutTemplates","layoutD.css");
        }
        else if(page.getLayoutTemplate().equals("Layout E")){
            layoutTemplate = new File(templatesDir + "/layoutTemplates","layoutE.css");
        }
        
        colorTemplate = new File("blah");
        if(page.getColorTemplate().equals("Color A")){
            colorTemplate = new File(templatesDir + "/colorTemplates","colorA.css");
        }
        else if(page.getColorTemplate().equals("Color B")){
            colorTemplate = new File(templatesDir + "/colorTemplates","colorB.css");
        }
        else if(page.getColorTemplate().equals("Color C")){
            colorTemplate = new File(templatesDir + "/colorTemplates","colorC.css");
        }
        else if(page.getColorTemplate().equals("Color D")){
            colorTemplate = new File(templatesDir + "/colorTemplates","colorD.css");
        }
        else if(page.getColorTemplate().equals("Color E")){
            colorTemplate = new File(templatesDir + "/colorTemplates","colorE.css");
        }
        
        String layoutText = FileUtils.readFileToString(layoutTemplate);
        String colorText = FileUtils.readFileToString(colorTemplate);
        String fontText = FileUtils.readFileToString(pageFont);
        String htmlText = FileUtils.readFileToString(htmlTemplate);
        String jsonText = FileUtils.readFileToString(jsonFile);
        String jsonLoaderText = FileUtils.readFileToString(jsonLoader);
        String jqueryText = FileUtils.readFileToString(jQuery);
        
        File pageDirectory = new File(websiteDirectory,page.getTitle());
        pageDirectory.mkdir();
        File jsDirectory = new File("tempSite","js");
        jsDirectory.mkdir();
        
        File newJsonLoader = new File(jsDirectory,"jsonLoader.js");
        File newJquery = new File(jsDirectory,"jquery-2.1.4.min.js");
        File newHtml = new File(pageDirectory,"index.html");
        File newLayout = new File(pageDirectory,"layout.css");
        File newColor = new File(pageDirectory,"color.css");
        File newFont = new File(pageDirectory,"font.css");
        File newJson = new File(pageDirectory,"file.json");
        File d = new File(pageDirectory,"imgs"); 
        File oldImgs = new File("imgs");
        FileUtils.copyDirectory(oldImgs,d);
        
        FileUtils.writeStringToFile(newJsonLoader, jsonLoaderText);
        FileUtils.writeStringToFile(newJquery, jqueryText);
        FileUtils.writeStringToFile(newLayout, layoutText);
        FileUtils.writeStringToFile(newColor, colorText);
        FileUtils.writeStringToFile(newFont, fontText);
        FileUtils.writeStringToFile(newHtml, htmlText);
        FileUtils.writeStringToFile(newJson ,jsonText);
        
        
        
    }
    
}
