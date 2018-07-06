package com.qa.training.BingTranslator;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SwapBtn {
	WebDriver driver;
	 JavascriptExecutor js;
	 private String translateFromBefore, translateToBefore;
	 private String translateFromAfter, translateToAfter;
	 
	 public SwapBtn(WebDriver driver) {
		 this.driver = driver;
		  js = (JavascriptExecutor)driver;
		  PageFactory.initElements(driver, this);
	 }

	 public boolean swap () throws InterruptedException {
		 Select selectFrom = new Select((WebElement)js.executeScript("return document.querySelector('select[id=t_sl]');"));
		 Select selectTo = new Select((WebElement)js.executeScript("return document.querySelector('select[id=t_tl]');"));
		 
		 translateFromBefore = selectFrom.getFirstSelectedOption().getText().trim();
		 translateToBefore = selectTo.getFirstSelectedOption().getText().trim();
		 
		    driver.findElement(By.cssSelector("textarea#t_sv")).sendKeys("Calidad");
		 
		 Thread.sleep(2000);
		 js.executeScript("document.querySelector('a[id=t_revIcon]').click()");
		 
		 translateFromAfter = selectFrom.getFirstSelectedOption().getText().trim();
		 translateToAfter = selectTo.getFirstSelectedOption().getText().trim();
		 
		 System.out.println(translateFromBefore + " " + translateToAfter +" " + translateToBefore + " " + translateFromAfter);
		 
         return (translateFromBefore.equals(translateToAfter) && translateToBefore.equals(translateFromAfter))	;	
       
	 }
}
