package com.qa.training.BingTranslator;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AutoDetect {
 WebDriver driver;
 JavascriptExecutor js;
 
  public AutoDetect(WebDriver driver) {
	  this.driver = driver;
	  js = (JavascriptExecutor)driver;
	  PageFactory.initElements(driver, this);
  }
  	
  public String check() throws InterruptedException {
	
	  js.executeScript(" document.querySelector('textarea[id=t_sv]').value='HELLO';");
	  Thread.sleep(2000);
	  return (String)js.executeScript("return document.querySelector('option[value=auto-detect]').textContent;");
  }
}
