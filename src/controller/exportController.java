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
    
    public void exportProject(ePortfolioModel ePortfolio) throws IOException{
        File sitesDir = new File("sites");
        
        
        File websiteDirectory = new File(sitesDir,ePortfolio.getSaveAsTitle());
        for(Page page : ePortfolio.getPages()){
            exportPage(page,websiteDirectory);
        }
             
    }
    
    public void exportPage(Page page, File websiteDirectory) throws IOException{
       File templatesDir = new File("templates");
        File pageFont;
        File layoutTemplate;
        File colorTemplate;
        File htmlTemplate = new File(websiteDirectory,"index.html");
        
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
        
        File newHtml = new File(websiteDirectory,"index.html");
        File newLayout = new File(websiteDirectory,"layout.css");
        File newColor = new File(websiteDirectory,"color.css");
        File newFont = new File(websiteDirectory,"font.css");
        
        FileUtils.writeStringToFile(newLayout, layoutText);
        FileUtils.writeStringToFile(newColor, colorText);
        FileUtils.writeStringToFile(newFont, fontText);
        FileUtils.writeStringToFile(newHtml, htmlText);
        
        
        
    }
    
}
