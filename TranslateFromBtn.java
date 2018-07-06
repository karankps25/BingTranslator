package com.qa.training.BingTranslator;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TranslateFromBtn {
	WebDriver driver;
	 JavascriptExecutor js;
	 
	 public TranslateFromBtn(WebDriver driver) {
		 this.driver = driver;
		  js = (JavascriptExecutor)driver;
		  PageFactory.initElements(driver, this);
	 }

	 public String check() {
		 js.executeScript("history.go(0)");
		 Select select = new Select((WebElement)js.executeScript("return document.querySelector('select[id=t_sl]');"));
		 select.selectByValue("es");
		 return select.getFirstSelectedOption().getText();
	 }
}
