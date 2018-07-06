package com.qa.training.BingTranslator;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TranslateToBtn {
	WebDriver driver;
	 JavascriptExecutor js;
	 
	 public TranslateToBtn(WebDriver driver) {
		 this.driver = driver;
		  js = (JavascriptExecutor)driver;
		  PageFactory.initElements(driver, this);
	 }

	 public String check() {
		 //js.executeScript("history.go(0)");
		 Select select = new Select((WebElement)js.executeScript("return document.querySelector('select[id=t_tl]');"));
		 select.selectByVisibleText("French");
		 return select.getFirstSelectedOption().getText();
	 }
}

