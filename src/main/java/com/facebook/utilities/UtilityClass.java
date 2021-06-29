package com.facebook.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

import com.facebook.base.BaseClass;

public class UtilityClass extends BaseClass
{
	File src;
	File dest;
	Sheet sheet;
	Cell field;
	FileInputStream file;
	DecimalFormat convert;
	String str;
	Logger log;
	
	public void Screenshot(WebDriver driver, String TCID) throws IOException
	{
		src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		dest=new File(prop.getProperty("screenshot")+TCID+".jpeg");
		FileHandler.copy(src, dest);		
	}
	
	public String readWorkbook(String sheetName, int row, int cell) throws EncryptedDocumentException, IOException
	{
		file= new FileInputStream(prop.getProperty("testData"));
		sheet = WorkbookFactory.create(file).getSheet(sheetName);
		field = sheet.getRow(row).getCell(cell);
		
		if(field.getCellType()==CellType.NUMERIC)
		{
			convert=new DecimalFormat("#");
			str=convert.format(field.getNumericCellValue()).toString();
			return str;
		}
		else
		{
			String str=field.getStringCellValue();
			return str;
		}
	}
	public void logging(String str) throws FileNotFoundException
	{
		log=Logger.getLogger(UtilityClass.class);
		file=new FileInputStream(prop.getProperty("log4j"));
		PropertyConfigurator.configure(file);
		log.info(str);
	}
	
	public Actions action(WebDriver driver)
	{
		Actions act=new Actions(driver);
		return act;
	}
	

}
