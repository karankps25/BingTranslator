package com.qa.training.BingTranslator;

import java.io.File;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CheckTranslate {
	WebDriver driver;
	 JavascriptExecutor js;
	String translateQuery, actualTranslateResult, expectedTranslateResult;
	 
	 public CheckTranslate(WebDriver driver) {
		 this.driver = driver;
		  js = (JavascriptExecutor)driver;
		  PageFactory.initElements(driver, this);
	 }
	
	public boolean translateCheck(String filePath,String fileName,String sheetName) throws IOException, InterruptedException{


	    File file =    new File(filePath+"\\"+fileName);
	    FileInputStream inputStream = new FileInputStream(file);
	    Workbook workbookName = null;
	    String fileExtensionName = fileName.substring(fileName.indexOf("."));


	    if(fileExtensionName.equals(".xls")){

	    	workbookName = new HSSFWorkbook(inputStream);
	    }


	    Sheet sheetname = workbookName.getSheet(sheetName);

	    int rowCount = sheetname.getLastRowNum()-sheetname.getFirstRowNum();
	    
	    
	    for (int i = 0; i < rowCount+1; i++) {

	        Row row = sheetname.getRow(i);

	        for (int j = 0; j < row.getLastCellNum(); j++) {
	        	
//System.out.println(row.getLastCellNum() + " " + row.getPhysicalNumberOfCells());
	        	if(j==0)
	        		translateQuery = row.getCell(j).getStringCellValue();
	        	if(j==1)
	        		expectedTranslateResult = row.getCell(j).getStringCellValue();
              System.out.print(row.getCell(j).getStringCellValue()+"|| ");

	        }

	        System.out.println();

	    }

	    driver.findElement(By.cssSelector("textarea#t_sv")).clear();
	    driver.findElement(By.cssSelector("textarea#t_sv")).sendKeys(translateQuery);
	    Thread.sleep(1000);
	    actualTranslateResult = (String)js.executeScript("return document.getElementById('t_dummydiv').textContent");
	    System.out.println(actualTranslateResult + " " + expectedTranslateResult);
	    return (actualTranslateResult.equalsIgnoreCase(expectedTranslateResult));
	    }


}

