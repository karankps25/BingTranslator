package com.qa.training.BingTranslator;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class TranslationBoundary {
    WebDriver driver;
    JavascriptExecutor js ;
    String chars5001 = "";
    FileInputStream fin ;
    
    public TranslationBoundary(WebDriver driver) {
    	this.driver = driver;
    	PageFactory.initElements(driver, this);
    	js = (JavascriptExecutor)driver;
    }
	
    public boolean translationBoundaryCheck() {
    	try{    
            fin=new FileInputStream("C:\\Users\\DeadpooL\\Documents\\5001chars.txt");    
            int i=0;    
            while((i=fin.read())!=-1){    
             //System.out.print((char)i);  
            	chars5001 += (char)i;
            }    
            fin.close();    
          }catch(Exception e){System.out.println(e);}    
      //  System.out.println(chars5001);
    	js.executeScript("history.go(0)");
    	driver.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS);
	    driver.findElement(By.cssSelector("textarea#t_sv")).sendKeys(chars5001);
	    WebElement translateStatus = (WebElement)js.executeScript("return document.querySelector('.t_long.b_secondaryFocus')");
        return (translateStatus!=null);
    }    
      
    }
