package com.qa.training.BingTranslator;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BingTest {
	WebDriver driver;
	String url = "https://www.bing.com/translator";
	
	
	@BeforeTest
	public void LaunchBingtranslator() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\DeadpooL\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}
	

    @Test(priority=0)
    public void checkAutoDetect() throws InterruptedException{
    	AutoDetect obj = new AutoDetect(driver);
    	//obj.check();
    	Assert.assertTrue(obj.check().equals("English (detected)"));
    }
    
    @Test(priority=1)
    public void checkTransalteFrom() {
    	TranslateFromBtn obj = new TranslateFromBtn(driver);
    	//obj.check();
    Assert.assertTrue(obj.check().equals("Spanish"));
    	
    }
    	

    @Test(priority=2)
    public void checkTransalteTo() {
    	TranslateToBtn obj = new TranslateToBtn(driver);
    	//obj.check();
    Assert.assertTrue(obj.check().equals("French"));
    	
    }
    
    @Test(priority=3)
    public void checkSwapBtn() throws InterruptedException {
    	SwapBtn obj = new SwapBtn(driver);
    	//System.out.println(obj.swap());
    	Assert.assertTrue(obj.swap());
    }

   @Test(priority=4)
	public void getData() throws IOException, InterruptedException {
    	CheckTranslate obj = new CheckTranslate(driver);
		String filePath = "C:\\Users\\DeadpooL\\Documents";
		Assert.assertTrue(obj.translateCheck(filePath, "testbing.xls", "Sheet1"));
	}
    
   @Test(priority=5)
   public void translationBoundaryValueCheck() {
	   TranslationBoundary obj = new TranslationBoundary(driver);
	   Assert.assertTrue(obj.translationBoundaryCheck());
   }
   
	@AfterTest
	   public void close() throws InterruptedException {
		  // Thread.sleep(2500);
		  // driver.close();
	   }
}
